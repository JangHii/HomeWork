package com.myweb.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
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
		bdao.getCmtCount();
		bdao.getFileCount();
		
		return bdao.getList(pgvo);
	}

	@Transactional
	@Override
	public BoardDTO getDetail(int bno) {
		bdao.upCount(bno); //조회수
		 
		BoardVO bvo1 = bdao.getDetail(bno); //게시글 디테일
		List<FileVO> flist = fdao.getFileList(bno);
		BoardDTO bdto = new BoardDTO(bvo1 , flist);
		
		return bdto;
	}

	@Override
	public void getModify(BoardDTO bdto) {
		bdao.getModify(bdto.getBvo());
		
		if(bdto.getFlist() == null) {
			return;
		}
		
		long bno = bdto.getBvo().getBno();
		if(bdto.getFlist().size() > 0) {
			for(FileVO fvo : bdto.getFlist()) {
				fvo.setBno(bno);
				fdao.insertFile(fvo);
			}
		}
	}

	@Override
	public int remove(int bno) {
		return bdao.delete(bno);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		return bdao.getTotalCount(pgvo);
	}

	@Override
	public int delete(String uuid) {
		int isOk = fdao.fileDelete(uuid);
		return isOk;
	}

}
