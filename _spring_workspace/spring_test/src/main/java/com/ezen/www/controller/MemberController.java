package com.ezen.www.controller;



import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.www.domain.MemberVO;
import com.ezen.www.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j

public class MemberController {
	
	@Inject
	private MemberService msv;
	
	@GetMapping("/register")
	public void register() {}
	
	
	@PostMapping("/register")
	public String register(MemberVO mvo) {
		log.info(">>>>>>>mvo>>>>>>>>{}" , mvo);
		
		int isOk = msv.signUp(mvo);
		log.info(">>>>>>>> signUp ? " + (isOk > 0 ? "OK" : "Fail"));
		
		return "index";
	}
	
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	// 자동으로 아이디와 비밀번호만 가져온다.
	// 받은값만 가져와지고 나머지는 null처리가 되어서 들어온다
	public String login(MemberVO mvo ,  Model m ,HttpServletRequest request) {
		log.info(">>>>>>>mvo>>>>>>>>>>>{}" , mvo);
		
		// mvo 객체가 db에 일치하는지 체크
		// 유저가 있는지 없는지 확인
		MemberVO loginMvo = msv.isUser(mvo);
		
		if(loginMvo != null) {
			// 로그인 성공시
			HttpSession ses = request.getSession();
			ses.setAttribute("ses", loginMvo); // session에 로그인 객체 저장
			ses.setMaxInactiveInterval(60*10); //로그인유지시간
		}else {
			// 로그인 실패시
			m.addAttribute("mfg_login", "1");
		}
		
		return "index";
	}
	
	
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request , Model m) {
		// 세션 객체 삭제 => 세션 끊기
		MemberVO mvo = (MemberVO)request.getSession().getAttribute("ses");
		msv.lastLogin(mvo.getId());
		
		request.getSession().removeAttribute("ses");
		request.getSession().invalidate();
		m.addAttribute("msg_logout", "1");
		return "index";
		
	}
	
	// 가는거
	@GetMapping("/modify")
	public void modify() {}
	

	@PostMapping("/modify")
	public String modify(MemberVO mvo , RedirectAttributes re) {
		log.info(">>>>>>>>>>>> mvo >>>>>>>>{}" , mvo);
		
		int isOk =  msv.modify(mvo);
		log.info(">>>>> modify ? >>>>>" + (isOk > 0 ? "OK" : "Faill"));
		
		re.addFlashAttribute("msg_modify", isOk);
		
		return "redirect:/member/logout";
	}
	
	
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request , Model m) {
		
		MemberVO mvo = (MemberVO)request.getSession().getAttribute("ses");
		msv.delete(mvo.getId());
		
		request.getSession().removeAttribute("ses");
		request.getSession().invalidate();
		m.addAttribute("msg_delete", "1");
		
		return "index";
	}
	
	
	
	
	
	
}
