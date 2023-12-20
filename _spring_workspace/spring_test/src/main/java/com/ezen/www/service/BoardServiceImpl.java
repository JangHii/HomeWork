package com.ezen.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

	@Inject //등록하지않으면 객체를 생성하지않음
	private BoardDAO bdao; //repository폴더의 interface로 생성하기

	@Override
	public int register(BoardVO bvo) {
		log.info("register service impl");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info("getList service impl");
		return bdao.selectList(pgvo);
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("getDetail service impl");
		bdao.addreadcount(bno);
		return bdao.detail(bno);
	}

	@Override
	public void modify(BoardVO bvo) {
		log.info("modify service impl");
		bdao.modify(bvo);
	}

	@Override
	public int remove(int bno) {
		log.info("remove service impl");
		return bdao.delete(bno);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getTotalCount(pgvo);
	}

	
	
}
