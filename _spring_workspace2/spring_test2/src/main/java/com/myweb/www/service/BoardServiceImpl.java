package com.myweb.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.BoardDAO;
import com.myweb.www.repository.FileDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor

public class BoardServiceImpl implements BoardService{

	private final BoardDAO bdao;
	private final FileDAO fdao;

	@Override
	public int insert(BoardDTO bdto) {
		// bvo boardMapper / flist fileMapper 등록
		int isOk = bdao.insert(bdto.getBvo());
		
		if(bdto.getFlist() == null) {
			return isOk;
		}
		
		// bvo insert 후 파일도 있다면
		if(isOk > 0 && bdto.getFlist().size() > 0) {
			// bno setting
			long bno = bdao.selectOneBno(); // 가장 마지막에 등록된 bno
			for(FileVO fvo : bdto.getFlist()) {
				fvo.setBno(bno);
				isOk *= fdao.insertFile(fvo);
			}
		}
		return isOk;
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		return bdao.getList(pgvo);
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

	@Override
	public int getTotalCount(PagingVO pgvo) {
		return bdao.getTotalCount(pgvo);
	}

}
