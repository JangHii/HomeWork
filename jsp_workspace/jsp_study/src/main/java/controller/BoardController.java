package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import handler.FileRemoveHandler;
import handler.PagingHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 로그 기록 객체 생성
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	// jsp에서 받은 요청을 처리 , 처리결과를 다른 jsp로 보내는 역할을 하는 객체
	private RequestDispatcher rdp;
	private String destPage; // 목적지 주소를 저장하는 변수
	private int isOk; // DM 구문 체크 값 저장변수
	private String savePath; // 파일 저장경로

	// controller <-> service
	private BoardService bsv; // interface로 생성

	public BoardController() {
		// 생성자
		bsv = new BoardServiceImpl(); // class로 생성 bsv를 구현할 객체
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제 처리 메서드
		log.info("필요한 로그 띄우기 가능.");
		// 매개변수의 객체의 인코딩 설정
		request.setCharacterEncoding("utf-8"); // 요청
		response.setCharacterEncoding("utf-8"); // 응답
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI(); // jsp에서 오는 요청주소를 받는 설정
		System.out.println("sysout을 총한 로그 >> " + uri);
		log.info("log객체를 통한 로그 >> " + uri); // brd/register
		String path = uri.substring(uri.lastIndexOf("/") + 1); // register

		log.info("실 요청 경로 >>>" + path);

		switch (path) {
		case "register":
			destPage = "/board/register.jsp";
			break;
			
			
		case "insert":
			try {
				
				// 파일을 업로드할 물리적인 경로 설정
				// getServletContext 서버의 기본 설정경로를 가져오는명령어
				// getRealPath 실제 저장공간의 바로 전 파일까지 가져오는거
				savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				log.info("저장위치 >>>> {}" , savePath);
				
				DiskFileItemFactory fileIremFactory = new DiskFileItemFactory();
				// setRepository file의 객체로만 들어갈수있음
				fileIremFactory.setRepository(fileDir); //저장할 위치를 file객체로 지정
				fileIremFactory.setSizeThreshold(1024*1024*3); //파일저장을 위함 임시저장공간 설정 (bare단위)
				
				//미리 객체 설정
				BoardVO bvo = new BoardVO();
				
				//multipart/for-data형식으로 넘어온 request객체를 다루기 쉽게 변환해주는 역할
				ServletFileUpload fileUpload = new ServletFileUpload(fileIremFactory);
				
				List<FileItem>itemList = fileUpload.parseRequest(request);
				for(FileItem item : itemList) {
					switch(item.getFieldName()){
					case "title" :
						bvo.setTitle(item.getString("utf-8"));
						break;
						
					case "writer" :
						bvo.setWriter(item.getString("utf-8"));
						break;
						
					case "conrent" :
						bvo.setContent(item.getString("utf-8"));
						break;
						
					case "image_file" :
						//이미지 있는지 체크
						if(item.getSize() > 0) {//데이터의 크기를 바이트 단위로 리턴 크기가 0보다 큰지 체크
							//경로를 포함한 이름 ~~~~~/dog.jps
							//FIle.separator : 파일경로 기호를 저장
							//시스템의 시간을 이용하여 파을을 기분 / 시간_dog.jpg
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1); //이름만 분리
							
							fileName = System.currentTimeMillis()+"_"+fileName;
							File uploadFilePath = new File(fileDir + File.separator + fileName);
							log.info("uploadFilePath >>>>>>> {}" , uploadFilePath.toString());
							
							//저장
							try {
								
								item.write(uploadFilePath); //자바 객체를 디스크에 쓰기
								bvo.setImageFile(fileName); //bvo에 저장할 값 설정
								
								//썸네일 작업 : 리스트 페이지에서 트레픽 과다사용 방지
								Thumbnails.of(uploadFilePath).size(75, 75).toFile(new File(fileDir + File.separator + "th_" + fileName));
								
							} catch (Exception e) {
								log.info(">>>> file writer on disk error");
								e.printStackTrace();
							}
						}
						break;
					}
						
				}
				
				isOk = bsv.register(bvo);
				log.info("board register >>>> {} ", isOk > 0 ? "OK" : "Fail");
				
				// 목적지 주소
				destPage = "/index.jsp";
								
				
				
				
				
				// 파일업로드가 없을
//				// jsp에서 데이터를 입력 후 => conteoller로 전송
//				// DB에 등록한 후 => index.jsp로 이동
//
//				// jsp에서 가져온 title , writer , content를 꺼내오기.
//				String title = request.getParameter("title");
//				String writer = request.getParameter("writer");
//				String content = request.getParameter("content");
//				log.info(">>>>> insert check 1");
//
//				BoardVO bvo = new BoardVO(title, writer, content);
//				log.info("insert bov >>> {}" + bvo);
//
//				// 만들어진 bvo를 db에 저장
//				isOk = bsv.register(bvo);
//				log.info("board register >>>> {} ", isOk > 0 ? "OK" : "Fail");
//
//				// 목적지 주소
//				destPage = "/index.jsp";
				
			} catch (Exception e) {
				log.info("insert Error");
				e.printStackTrace();
			}
			break;

		case "list":
			try {
				// index에서 list 버튼을 클릭하면
				// 컨트롤러에서 db로 전체 리스트 요청
				// 전체리스트를 가지고 list.jsp에 뿌리기
				log.info("list check 1");
				PagingVO pgvo = new PagingVO(); // 페이지:1/게시물갯수:10/번지:0

				if (request.getParameter("pageNo") != null) {
					int pageNo = Integer.parseInt(request.getParameter("pageNo"));
					int qty = Integer.parseInt(request.getParameter("qty"));
					String type = request.getParameter("type");
					String Keyword = request.getParameter("keyword");
					log.info(">>>>>> pageNo / qty" + pageNo + " / " + qty + " / " + type + " / " + Keyword);
					pgvo = new PagingVO(pageNo, qty, type, Keyword);
				}

				// 검색어를 반영한 리스트
				List<BoardVO> list = bsv.getList(pgvo);
				log.info("list >>>> {}" + list);
				
				// 검색한 값의 게시글 카운트
				int totalCount = bsv.getTotalCount(pgvo); // DB에서 전체 게시글수 가져오기
				log.info("totalCount>>>>>>>>>>>{}" + totalCount);
				PagingHandler ph = new PagingHandler(pgvo, totalCount);
				
				// list를 jsp로 전송
				// 검색어를 반영한 리스트

				request.setAttribute("list", list);
				request.setAttribute("ph", ph);
				destPage = "/board/list.jsp";

			} catch (Exception e) {
				log.info("list error");
				e.printStackTrace();
			}
			break;

		case "detail":
			try {
				// jsp에서 보낸 bno를 받아서
				// 해당 번호의 전체 값을 조회하여 detail.jsp에 뿌리기
				// 모든 파라미터는 String으로 리턴됨
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("detail check 1");

				BoardVO bvo = bsv.getDetail(bno);
				log.info("detail bvo >>>> {}", bno);
				request.setAttribute("bvo", bvo);
				destPage = "/board/detail.jsp";

			} catch (Exception e) {
				log.info("detail error");
				e.printStackTrace();
			}
			break;

		case "modify":
			try {
				// 수정할 데이터의 bno를 받아서 수정 페이지로 보내서
				// bodify.jsp를 띄우는 역할

				int bno = Integer.parseInt(request.getParameter("bno"));

				BoardVO bvo = bsv.getDetail(bno);

				request.setAttribute("bvo", bvo);
				destPage = "/board/modify.jsp";
			} catch (Exception e) {
				log.info("modify error");
				e.printStackTrace();
			}
			break;

		case "edit":
			try {

				savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				log.info(">>>> 1");
				DiskFileItemFactory fileItemFactoey = new DiskFileItemFactory();
				fileItemFactoey.setRepository(fileDir);
				fileItemFactoey.setSizeThreshold(1024*1024*3);
				log.info(">>>> 2");
				BoardVO bvo = new BoardVO();
				
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactoey);
				log.info(">>>> 3");
				List<FileItem> itemList = fileUpload.parseRequest(request);
				String old_file = null ;
				
				for(FileItem item : itemList) {
					
					switch(item.getFieldName()) {
					
					case "bno" :
						bvo.setBno(Integer.parseInt(item.getString("utf-8")));
						break;

					case "title" :
						bvo.setTitle(item.getString("utf-8"));
						break;

					case "content" :
						bvo.setContent(item.getString("utf-8"));
						break;

					case "image_file" :
						//이전 파일의 보관용
						old_file = item.getString("utf-8");
						log.info(">>>> 4");
						break;

					case "new_file" :
						//새로운 파일은 등록이 될수도있고 , 안될수도있음
						log.info(">>>> 5");
						if(item.getSize() > 0) {
							//새로운 등록파일 있다면
							if(old_file != null) {
								//old_file 삭제 작업
								//파일 삭제 핸들러를 통해서 파일 삭제 작업진행
								FileRemoveHandler fileHandler = new FileRemoveHandler();
								isOk = fileHandler.deleteFile(old_file, savePath);
							}
							//새로운 파일에 대한 객체 작업
							String fileName = item.getName().substring(item.getName().lastIndexOf(File.separator)+1);
							log.info("new File Name >>> {}" , fileName);
							
							fileName = System.currentTimeMillis() + "_" + fileName ;
							File uploadFilePath = new File(fileDir + File.separator + fileName);
							
							try {
								
								item.write(uploadFilePath);
								bvo.setImageFile(fileName);
								
								//썸네일 작업
								Thumbnails.of(uploadFilePath).size(75, 75).toFile(new File(fileDir + File.separator + "th_" + fileName));
								
							} catch (Exception e) {
								log.info("File Write Update Error");
								e.printStackTrace();
							}
						}else {
							// 기존 이미지파일은 있지만 , 새로운 이미지파일이 없다면
							bvo.setImageFile(old_file); //기존 객체를 bvo에 담기
						}
						break;
						
						
					}
				}
				log.info(">>>> 6" + bvo);
				
				isOk = bsv.modify(bvo);
				log.info("edit >> {}", isOk > 0 ? "OK" : "Fail");
				destPage = "list"; // 내부 list case로 이동
				

				
//				// 파라미터로 받은 bno , title , content 데이터를
//				// DB에 수정하여 넣고 , list로 이동
//				int bno = Integer.parseInt(request.getParameter("bno"));
//				String title = request.getParameter("title");
//				String content = request.getParameter("content");
//				BoardVO bvo = new BoardVO(bno, title, content);
//				log.info("edit check 1");
//				log.info("deit >>> {}" + bvo);
//
//				isOk = bsv.modify(bvo);
//				log.info("edit >> {}", isOk > 0 ? "OK" : "Fail");
//				destPage = "list"; // 내부 list case로 이동

			} catch (Exception e) {
				log.info("edit error");
				e.printStackTrace();
			}

			break;

		case "remove":
			try {

				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info("remove check 1");
				isOk = bsv.remove(bno);
				log.info("remove >>> {}", isOk > 0 ? "OK" : "fail");

				destPage = "list";

			} catch (Exception e) {
				log.info("remove error");
				e.printStackTrace();
			}

			break;

		}
		// 목적지 주소로 데이터를 전달(RequestDispatcher)

		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response); // 요청에 필요한 객체를 가지고 경로로전송

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get으로 오는 요청 처리
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post로 오는 요청을 처리
		service(request, response);
	}

}
