package com.ezen.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.www.domain.BoardDTO;
import com.ezen.www.domain.BoardVO;
import com.ezen.www.domain.FileVO;
import com.ezen.www.domain.PagingVO;
import com.ezen.www.repository.BoardDAO;
import com.ezen.www.repository.FileDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

	@Inject //등록하지않으면 객체를 생성하지않음
	private BoardDAO bdao; //repository폴더의 interface로 생성하기
	
	@Inject
	private FileDAO fdao;

	@Override
	public int register(BoardDTO bdto) {
		log.info("register service impl");
		
		// 기존 보드 내용을 DB에 저장
		int isOk = bdao.insert(bdto.getBvo());
		
		//flist를 db에 저장
		if(bdto.getFlist() == null) {
			// 파일의 값이 없다면
			isOk *= 1; // 그냥 성공한걸로 처리
		}else {
			// 파일저장
			if(isOk > 0 && bdto.getFlist().size()>0) {
				// fvo는 bno는 아직 설정되기 전
				// 현재 bdto 시점에서는 아직 bno가 생성되지 않음
				// insert를 통해 자동생성 => DB에서 검색해서 가져오기
				int bno = bdao.selectBno();
				
				for(FileVO fvo : bdto.getFlist()) {
					fvo.setBno(bno);
					// 파일 저장
					isOk *= fdao.insertFile(fvo);
				}
			}
		}
		
		return isOk;
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info("getList service impl");
		return bdao.selectList(pgvo);
	}

	@Override
	public BoardDTO getDetail(int bno) {
		log.info("getDetail service impl");
		bdao.addreadcount(bno);
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBvo(bdao.detail(bno)); // 게시글 내용 채우기
		boardDTO.setFlist(fdao.getFileList(bno)); // bno에 해당하는 모든 파일 리스트 검색
		
		return boardDTO;
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

	@Override
	public int removeImage(String uuid) {
		// TODO Auto-generated method stub
		return fdao.removeImage(uuid);
	}

	
	
}
