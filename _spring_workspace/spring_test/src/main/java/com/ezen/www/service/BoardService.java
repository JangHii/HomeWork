package com.ezen.www.service;

import java.util.List;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.PagingVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> getList(PagingVO pgvo); // javautil

	BoardVO getDetail(int bno);

	void modify(BoardVO bvo);

	int remove(int bno);

	int getTotalCount(PagingVO pgvo);


}
