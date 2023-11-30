package repository;

import java.util.List;

import domain.BoardVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selecList();

	int readcountUpdate(int bno);

	BoardVO getDetail(int bno);

	int update(BoardVO bvo);

	int delete(int bno);



}
