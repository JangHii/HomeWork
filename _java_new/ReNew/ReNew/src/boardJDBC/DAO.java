package boardJDBC;

import java.util.List;

public interface DAO {

	int insert(BoardVO bv);

	List<BoardVO> selectlist();

	BoardVO detail(int bno);

	int modify(BoardVO bv);

	int remove(int bno);

}
