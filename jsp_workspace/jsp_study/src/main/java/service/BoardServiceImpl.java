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
	private BoardDAO bdao; // interface로 생성
	private CommentServiceImp csv = new CommentServiceImp();

	public BoardServiceImpl() {
		bdao = new BoardDAOImpl(); // casll로 생성 bdao구현 객체 생성
	}

	@Override
	public int register(BoardVO bvo) {
		log.info(">>>> insert check 2");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info(">>>> list check 2");
		return bdao.selectList(pgvo);
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info(">>>> detail check 2");
		// detail 체크시 readcount +1
		int isOk = bdao.readcountUpdate(bno);
		return bdao.getDetail(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info(">>>> modify check 2");
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		log.info(">>>> remove check 2");
		// 지우기전에 댓글 삭제하고 글 지우기
		int isOk = csv.removeAll(bno);
		return bdao.delete(bno);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		log.info(">>>> getTotalCount check 2");
		return bdao.totalCount(pgvo);
	}

	@Override
	public String getFileName(int bno) {
		log.info(">>>> getTotalCount check 2");
		return bdao.getFaileName(bno);
	}




}
