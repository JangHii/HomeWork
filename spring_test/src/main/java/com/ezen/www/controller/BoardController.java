package com.ezen.www.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller //controller를 등록해야 html에서 입력받은걸 받을수있다.
@RequestMapping("/board/*") //board/ㅇㅇㅇ / ㅇㅇㅇ의 파일들을 가지고온다.
@Slf4j

public class BoardController {

	@Inject //등록하지않으면 객체를 생성하지않음
	private BoardService bsv; //service폴더의 interface로 생성하기
	
	// 경로와 리턴의 값이 같을경우 생략가능
	// /board/register => / board/register
	@GetMapping("/register")
	public void register() {}
	
	//@RequestParam("name")String name : 파라미터 받을때
	@PostMapping("/register")
	public String register(BoardVO bvo) {
		log.info(">>>>> bvo >>>>> {}" , bvo);
		int isOk = bsv.register(bvo);
		
		// 목적지 경로
		// redirect : BoardController에 list를 한번 훝고 뿌린다.
		// redirect는 같은 값으로는 설정이 불가능하다
		return "redirect:/board/list"; //board/list (리스트로 가는경로)
	}
	
	
	// /board/list => /board/list
	// void 처리해도 상관없음
	@GetMapping("/list")
	public String list(Model m) { //spring model 가져와야함
		// 리턴타입은 목적지 경로에 대한 타입(destPage가 리턴이라고 생각)
		// model 객체 => setAttribute 역할을 하는 객체
		m.addAttribute("list", bsv.getList());
		return "/board/list";
	}
	
	// 2개를 사용하려면 {}를 사용해야한다.
	@GetMapping({"/detail" , "/modify"})
	public void detail(Model m , @RequestParam("bno")int bno) {
		log.info(">>>>> bno >>>>> {}" , bno);
		m.addAttribute("bvo", bsv.getDetail(bno));	
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo , Model m) {
		log.info(">>>>> bvo >>>>> {}" , bvo);
		
		// update
		bsv.modify(bvo);
		
		//방법1
//		m.addAttribute("bno", bvo.getBno());
		//방법2
		return "redirect:/board/detail?bno="+bvo.getBno(); //bno가 필요함
		
	}
	
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") int bno , RedirectAttributes re) {
		log.info(">>> bno >>> {}" , bno);
		int isOk = bsv.remove(bno);
		
		// 페이지가 새로고침 될때 남아있을 필요가 없는 데이터
		// 리다이렉트 될때 데이터를 보내는 객체 (RedirectAtteibute)
		// 한번만 일회성으로 데이터를 보낼때 사용
		re.addFlashAttribute("isDel" , isOk); // 보냄
		return "redirect:/board/list"; // 받음
		
	}
	
	
	
	
	
	
	
	
	
}
