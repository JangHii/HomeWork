package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> getList(PagingVO pgvo);

	BoardVO getDetail(int bno);

	void getModify(BoardVO bvo);

	void upCount(int bno);

	int delete(int bno);

	int getTotalCount(PagingVO pgvo);

	long selectOneBno();

}
