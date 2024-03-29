package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {

	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao ; // interface로 생성
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl(); // calls로 생성
	}
	
	@Override
	public int register(BoardVO bvo) {
		log.info(">>>>>> insert check 2 <<<<<<");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info(">>>>>> list check 2 <<<<<<");
		return bdao.selecList(pgvo);
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info(">>>>>> detail check 2 <<<<<<");
		int isOk = bdao.readcountUpdate(bno);
		return bdao.getDetail(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info(">>>>>> modify check 2 <<<<<<");
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		log.info(">>>>>> remove check 2 <<<<<<");
		return bdao.delete(bno);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		log.info(">>>>>> getTotalCount check 2 <<<<<<");
		return bdao.totalcount(pgvo);
	}




}
