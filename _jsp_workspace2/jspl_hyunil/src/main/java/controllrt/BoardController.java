package controllrt;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 로그 기록 객체 생성
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	// jsp에서 받은 요청을 처리 , 처리결과를 다른 jsp로 보내는 역할을 하는 객체
	private RequestDispatcher rdp ;
	private String destPage ; // 목적지 주소를 저장하는 변수
	private int isOk ; // DM 구문의 체크값 저장변수 
	
	// controller <-> service
	private BoardService bsv ; // interface로 생성
	
    public BoardController() {
        // 생성자
    	bsv = new BoardServiceImpl(); // class로 생성 , bsv를 구현할 객체
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 실제 처리 메서드
		log.info("필요한 로그 띄우기 가능.");

		request.setCharacterEncoding("utf-8"); // 요청
		response.setCharacterEncoding("utf-8"); // 응답
		response.setContentType("text/hrml; charset=UTF-8");
		
		String uri = request.getRequestURI(); // jsp에서 오는 요청 주소를 받는 설정
		System.out.println("sysout을 통한 로그 >>> " + uri);
		log.info("log를 통한 로그 >>> " + uri);
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		log.info("실 요청 경로 >>> " + uri);
		
		
		
		switch(path) {
		
		case "register" :
			
			destPage = "/board/register.jsp";
			
			break;
		
			
		case "insert" :
			
			try {
				
				// jsp에서 데이터를 입력된건 => controller로 전송이된다.
				// DB에 등록한 후 => index.jsp로 이동
				
				// jsp에서 가져온 title , writer , content를 꺼내오기.
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				log.info(">>>>>> insert check 1 <<<<<<");
				
				// 꺼내온 title , writer , content 를 BoardVO에게 저장
				BoardVO bvo = new BoardVO(title, writer, content);
				log.info(">>>>>> insert bvo " + bvo + "<<<<<<");
				
				// 만들어진 bvo를 db에 저장
				isOk = bsv.register(bvo);
				log.info("bvo가 제대로 db로 가는중~~" + (isOk > 0 ? "다행이다" : "다시해라"));
				
				// insert가 가야할 주소
				destPage = "/index.jsp";
				
			} catch (Exception e) {
				log.info("insert error~~!!");
				e.printStackTrace();
			}
			break;
			
			
			
		case "list" :
			
			try {
				
				// index에서 list 버튼을 클릭하면
				// 컨트롤러에서 DB로 전체 리스트 요청
				// 전체리스트를 가지고 list.jsp에 뿌리기
				
				log.info(">>>>>> list check 1 <<<<<<");
				List<BoardVO> list = bsv.getList();
				
				log.info("list >>>>>>" + list);
				
				// list를 jsp로 전송
				request.setAttribute("list", list);
				destPage = "/board/list.jsp";
				
			} catch (Exception e) {
				log.info("list error~~!!");
				e.printStackTrace();
			}
			break;
			
			
		case "detail" :
			
			try {
				
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info(">>>>>> detail check 1 <<<<<<");
				
				BoardVO bvo = bsv.getDetail(bno);
				log.info("detail >>>>>>> {}" + bno);
				request.setAttribute("bvo", bvo);
				
				destPage = "/board/detail.jsp";
				
			} catch (Exception e) {
				log.info("detail error~~!!");
				e.printStackTrace();
			}
			break;
			
			
		case "modify" :
			
			try {
				
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info(">>>>>> modify check 1 <<<<<<");
				
				BoardVO bvo = bsv.getDetail(bno);
				log.info("modify >>>>>>> {}" + bno);
				
				request.setAttribute("bvo", bvo);

				destPage = "/board/modify.jsp";
				
			} catch (Exception e) {
				log.info("modify error~~!!");
				e.printStackTrace();
			}
			break;
			
			
		case "edit" : 
			
			try {

				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				BoardVO bvo = new BoardVO(bno, title, content);
				log.info("edit check 1");
				log.info("deit >>> {}" + bvo);
				
				int isOk = bsv.modify(bvo);
				
				log.info("edit >>>>>>> {}" + (isOk > 0 ? "통과잇!!!!" : "다시해라잇!!!!"));
				destPage = "list";
				
			} catch (Exception e) {
				log.info("edit error~~!!");
				e.printStackTrace();
			}
			break;
			
			
		case "remove" :
			
			try {
				
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("remove check 1");
				
				int isOk = bsv.remove(bno);
				log.info("remove >>>>>>>>>>>{}" + (isOk > 0 ? "통과잇!!!!!!!!!!!!!" : "다시해라잇!!!!!!!!!!!"));
				
				destPage = "list";
				
			} catch (Exception e) {
				log.info("remove error~~!!");
				e.printStackTrace();
			}
			
			
			break;
			
			
			
		}
		// 목적지 주소로 데이터를 전달(RequestDispatcher)
		
			rdp = request.getRequestDispatcher(destPage);
			rdp.forward(request, response); // 요청에 필요한 객체를 가지고 경로로전송
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get으로 오는 요청 처리
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post로 오는 요청을 처리
		service(request, response);
	}

}
