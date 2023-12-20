package com.ezen.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.PagingVO;


public interface BoardDAO {

	
	int insert(BoardVO bvo);

	List<BoardVO> selectList(PagingVO pgvo);

	void addreadcount(int bno);

	BoardVO detail(int bno);

	void modify(BoardVO bvo);

	int delete(int bno);

	int getTotalCount(PagingVO pgvo);



}
