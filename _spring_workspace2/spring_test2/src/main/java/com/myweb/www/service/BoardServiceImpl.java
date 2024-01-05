package com.myweb.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.repository.BoardDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor

public class BoardServiceImpl implements BoardService{

	private final BoardDAO bdao;

	@Override
	public int insert(BoardVO bvo) {
		int isOk = bdao.insert(bvo);
		return isOk;
	}

	@Override
	public List<BoardVO> getList() {
		return bdao.getList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		bdao.upCount(bno);
		return bdao.getDetail(bno);
	}

	@Override
	public void getModify(BoardVO bvo) {
		bdao.getModify(bvo);
	}

	@Override
	public int remove(int bno) {
		return bdao.delete(bno);
	}

}
