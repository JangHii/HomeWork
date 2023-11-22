package boardJDBC;

import java.util.List;

public interface Service {

	int register(BoardVO bv);

	List<BoardVO> list();

	BoardVO detail(int bno);

	int modify(BoardVO bv);

	int remove(int bno);
	
	
}
