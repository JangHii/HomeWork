package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.CommebtDAOImpl;
import repository.CommentDAO;

public class CommentServiceImp implements CommentService {

	private static Logger log = LoggerFactory.getLogger(CommentServiceImp.class);
	
	private CommentDAO cdao ;
	
	public CommentServiceImp() {
		cdao = new CommebtDAOImpl();
	}

	@Override
	public int post(CommentVO cvo) {
		log.info(">>>> post check 2");
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		log.info(">>>> getList check 2");
		return cdao.getList(bno);
	}

	@Override
	public int remove(int cno) {
		log.info(">>>> cno check 2");
		return cdao.delete(cno);
	}


	
}