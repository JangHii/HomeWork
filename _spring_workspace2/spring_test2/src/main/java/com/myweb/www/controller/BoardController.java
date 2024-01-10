package com.myweb.www.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.FileHandler;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// @RequiredArgsConstructor 선언후
// private final로 객체 등록 => 생성자 주입

@Slf4j
@RequestMapping("/board/*")
@Controller
@RequiredArgsConstructor //생성자

public class BoardController {


	private final BoardService bsv;
	
	private final FileHandler fh;
	
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String insert(BoardVO bvo , @RequestParam(name = "files" , required = false)MultipartFile[] files) {
		log.info(">>>>> bvo >>>>> {}" , bvo);
		List<FileVO> flist = null;
		
		// fileHandler 생성 / multpartfile -> flist
		if(files[0].getSize() > 0) {
			flist = fh.uploadFiles(files);
		}
		
		int isOk = bsv.insert(new BoardDTO(bvo , flist));
		return "index";
	}
	
	@GetMapping("/list")
	public void list(Model m , PagingVO pgvo) {
		log.info(">>>>> PagingVO >>>>> {}" , pgvo);
		
		// 페이징처리
		List<BoardVO> list = bsv.getList(pgvo);
		
		//totalCount 구하기
		int totalCount = bsv.getTotalCount(pgvo);
		PagingHandler ph = new PagingHandler(pgvo , totalCount);
		
		m.addAttribute("list", list);
		m.addAttribute("ph", ph);
		
	}
	
	@GetMapping({"/detail" , "/modify"})
	public void detail(Model m ,  @RequestParam("bno")int bno) {
		m.addAttribute("bvo", bsv.getDetail(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo) {
		log.info(">>>>> bvo >>>>> {}" , bvo);
		
		bsv.getModify(bvo);
		return "redirect:/board/detail?bno="+bvo.getBno();
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") int bno) {
		int isOk = bsv.remove(bno);
		return "redirect:/board/list";
	}
	

	
	
	
	
	
	
	
	
	
	
}
