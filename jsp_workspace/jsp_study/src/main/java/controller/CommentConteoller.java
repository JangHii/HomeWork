package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.CommentService;
import service.CommentServiceImp;

@WebServlet("/cmt/*")
public class CommentConteoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Logger log = LoggerFactory.getLogger(CommentConteoller.class);
	private CommentService csv ;
	private int isOk ;

    public CommentConteoller() {
    	csv = new CommentServiceImp();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// contentType은 jsp 화면으로 갈때 설정 => 비동기식에서는 설정안함
		String uri = request.getRequestURI();
		log.info("경로 >>>>>>>>> {}" + uri);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request , response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request , response);
	}

}
