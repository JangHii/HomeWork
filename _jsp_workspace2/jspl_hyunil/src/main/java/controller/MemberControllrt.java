package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/memb/*")
public class MemberControllrt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(MemberControllrt.class);
	private RequestDispatcher rdp;
	private String destpage;
	private int isOk;
	private MemberService msv;

	public MemberControllrt() {
		msv = new MemberServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 모든 서비스 처리 경로
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/http; charset=UTF-8");

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>> path >>>" + path);

		switch (path) {

		case "join":
			// index의 /member/join 경로
			destpage = "/member/join.jsp";
			break;

		case "register":

			try {

				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));

				MemberVO mvo = new MemberVO(id, pwd, email, age);
				log.info("join check 1>>>> {}" + mvo);

				int isOk = msv.register(mvo);
				log.info("join >>>>> " + (isOk > 0 ? "통과" : "다시해"));

				destpage = "/index.jsp";

			} catch (Exception e) {
				log.info(">>> join error");
				e.printStackTrace();
			}
			break;

		case "login":

			try {

				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				MemberVO mvo = new MemberVO(id, pwd);
				log.info(">>> login check 1");

				MemberVO loginMvo = msv.login(mvo);
				log.info("login mvo >>>> {}" + loginMvo);

				if (loginMvo != null) {
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);
					ses.setMaxInactiveInterval(10 * 60);
					request.setAttribute("msg_login", 2);

				}else {
					request.setAttribute("msg_login", -1);
				}
				destpage = "/index.jsp";

			} catch (Exception e) {
				log.info(">>> login error");
				e.printStackTrace();
			}
			break;

		case "logout" :
			
			try {
				
				HttpSession ses = request.getSession();
				
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				log.info("ses에서 추출한 mvo >>>>>> {}" + mvo);
				
				int isOk = msv.lastLogin(mvo.getId());
				log.info("lastLogin >>>> " + (isOk > 0 ? "햅격!!!!" : "다시해라"));
				ses.invalidate();
				
				destpage = "/index.jsp";
				
			} catch (Exception e) {
				log.info(">>> logout error");
				e.printStackTrace();
			}
			break;
			
			
		case "list" :
			
			try {
				
				log.info("list check 1");
				
				List<MemberVO> list = msv.getList();
				log.info("list >>>>>> {}" + list);
				
				request.setAttribute("list", list);
				destpage = "/member/list.jsp";
				
			
			} catch (Exception e) {
				log.info(">>> list error");
				e.printStackTrace();
			}
			break;
			
		case "detail" :
			
			try {
				
				
				destpage = "/member/detail.jsp";
				
			} catch (Exception e) {
				log.info(">>> detail error");
				e.printStackTrace();
			}
			break;
			
		
		case "modify" :
			
			try {
				// id , pwd , email , age
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				int age = Integer.parseInt(request.getParameter("age"));
				MemberVO mvo = new MemberVO(id, pwd, email, age);
				System.out.println("asd"+mvo);
				isOk = msv.modify(mvo);
				log.info("modify >>>>>>>{}" + (isOk > 0 ? "햅격~~~" : "다시해라~~~"));
				
				HttpSession ses = request.getSession();
				ses.invalidate();
				
				destpage = "/index.jsp";
				
				
			} catch (Exception e) {
				log.info(">>> modify error");
				e.printStackTrace();
			}
			break;
			
			
		case "remove" :
			
			try {
				
				// 로그인객체를 가져온다
				HttpSession ses = request.getSession();
				// 가져온 객체를 MemberVO에 넣는다
				MemberVO mvo = (MemberVO)ses.getAttribute("ses");
				// 기준이되는 id를 소환
				String id = mvo.getId();
				// 변수의값에 넣는다
				isOk = msv.remove(id);
				if(isOk > 0) {
					request.setAttribute("msg_remove", -1);
				}
				// 확인한다
				log.info("remove >>>>>> {}" + (isOk > 0 ? "햅격!!" : "다시해라"));
				// 어디로갈지 등록한다
				ses.invalidate();
				destpage = "/index.jsp";
			} catch (Exception e) {
				log.info(">>> remove error");
				e.printStackTrace();
			}
			
			
			break;
			
		}

		// 목적지 주소 값 설정
		rdp = request.getRequestDispatcher(destpage);
		// 목적지 주소로 전송. (정보 싣어서 보내기)
		rdp.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
