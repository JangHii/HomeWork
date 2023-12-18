package com.ezen.www.repository;

import java.util.List;

import com.ezen.www.domain.BoardVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	void addreadcount(int bno);

	BoardVO detail(int bno);

	void modify(BoardVO bvo);

	int delete(int bno);



}
