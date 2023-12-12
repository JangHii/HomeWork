package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	int readcountUpdate(int bno);

	BoardVO getDetail(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

	int totalcount(PagingVO pgvo);

	List<BoardVO> selecList(PagingVO pgvo);



}
