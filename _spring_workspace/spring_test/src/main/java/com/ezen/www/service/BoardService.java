package com.ezen.www.service;

import java.util.List;

import com.ezen.www.domain.BoardDTO;
import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.PagingVO;

public interface BoardService {

	int register(BoardDTO bdto);

	List<BoardVO> getList(PagingVO pgvo); // javautil

	BoardDTO getDetail(int bno);

	void modify(BoardVO bvo);

	int remove(int bno);

	int getTotalCount(PagingVO pgvo);

	int removeImage(String uuid);


}
