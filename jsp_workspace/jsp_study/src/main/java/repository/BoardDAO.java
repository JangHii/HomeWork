package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	int readcountUpdate(int bno);

	BoardVO getDetail(int bno);

	int update(BoardVO bvo);

}
