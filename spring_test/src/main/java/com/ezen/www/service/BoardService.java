package com.ezen.www.service;

import java.util.List;

import com.ezen.www.domain.BoardVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> getList(); // javautil

	BoardVO getDetail(int bno);

	void modify(BoardVO bvo);

	int remove(int bno);


}
