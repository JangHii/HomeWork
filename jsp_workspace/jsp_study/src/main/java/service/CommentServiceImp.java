package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import repository.CommebtDAOImpl;
import repository.CommentDAO;

public class CommentServiceImp implements CommentService {

	private static Logger log = LoggerFactory.getLogger(CommentServiceImp.class);
	
	private CommentDAO cdao ;
	
	public CommentServiceImp() {
		cdao = new CommebtDAOImpl();
	}
	
}
