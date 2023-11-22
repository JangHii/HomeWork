package boardJDBC;

import java.util.List;

public class BoardServiceImpl implements Service {

	
	private DAO dao ;
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bv) {
		// 1. 게시글 등록 메서드
		System.out.println("register_service success!!");
		return dao.insert(bv);
	}

	@Override
	public List<BoardVO> list() {
		// 2. 글목록보기
		System.out.println("list_service success!!");
		return dao.selectlist();
	}

	@Override
	public BoardVO detail(int bno) {
		System.out.println("detail_service success!!");
		return dao.detail(bno);
	}

	@Override
	public int modify(BoardVO bv) {
		System.out.println("modify_service success!!");
		return dao.modify(bv);
	}

	@Override
	public int remove(int bno) {
		System.out.println("remove_service success!!");
		return dao.remove(bno);
	}
	
	
}
