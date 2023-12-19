package com.ezen.www.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ezen.www.domain.MemberVO;
import com.ezen.www.repository.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO mdao;
	
	@Inject
	HttpServletRequest request;
	
	// 암호화를 하기위한 객체 추가
	@Inject
	BCryptPasswordEncoder passwordEncoder;

	
	
	@Override
	public int signUp(MemberVO mvo) {
		
		// 아이디가 중복되면 회원가입 실패
		// => 아이디만 주고 DB에서 일치하는 mvo 객체를 리턴
		// 일치하는 유저가 있다면 가입실패 없다면 가입성공
		MemberVO tempMvo = mdao.getUser(mvo.getId());
		if(tempMvo != null) {
			// null이 아니라는건 기존아이디가 있는경우
			return 0; // 가입 불가능한 케이스
		}
		
		// 아이디가 중복되지 않는다면 회원가입 진행
		// 비밀번호를 작성하지않거나 값이 맞지않다면 가입불가
		if(mvo.getId() == null || mvo.getId().length() == 0) {
			return 0; // 가입 불가능한 케이스
		}
		if(mvo.getPw() == null || mvo.getPw().length() == 0) {
			return 0; // 가입 불가능한 케이스
		}
		
		// 모든게 맞다면 회원가입 진행
		// 비밀번호는 암호화해서 가입진행
		// 암호화(encode) / matches(입력된 비번 , 암호화된비번 ) => true / false
		String pw = mvo.getPw();
		
		String encodePw = passwordEncoder.encode(pw); // 비밀번호 암호화
		mvo.setPw(encodePw);
		
		// 회원가입
		int isOk = mdao.insrt(mvo);
		
		return isOk;
	}

	
	
	@Override
	public MemberVO isUser(MemberVO mvo) {
		// 로그인 유저 확인
		// 아이디를 주고 해당 아이디의 객체를 리턴
		MemberVO tmpMvo = mdao.getUser(mvo.getId()); // 회원가입할때 했던 메서드 그대로 호출
		
		//해당 아이디가 없는 경우
		if(tmpMvo == null) {
			return null ;
		}
		
		// matches (원래비번 , 암호화돈비번) 비교
		if(passwordEncoder.matches(mvo.getPw(), tmpMvo.getPw())){
			return tmpMvo;
		}
		return null;
		
		
	}

	@Override
	public void lastLogin(String id){
		mdao.lastLogin(id);
		
	}



	@Override
	public int modify(MemberVO mvo) {
		// 비밀번호의 여부에 따라서 변경사항을 나누어 처리
		// 비밀번호가 없다면 기존값으로 설정
		// 비밀번호가 있다면 암호화 처리하여 변경
		
		if(mvo.getPw() == null || mvo.getPw().length() == 0) { // 비밀번호가 없는상황
			MemberVO sesMvo = (MemberVO)request.getSession().getAttribute("ses"); // 아이디 가져오기
			mvo.setPw(sesMvo.getPw());
		}else {
			String setPw = passwordEncoder.encode(mvo.getPw());
			mvo.setPw(setPw);
		}
		log.info(">>>>> pw 수정후 mvo >>>>> {}" , mvo);
		return mdao.update(mvo);
	}



	@Override
	public void delete(String id) {
		
		mdao.delete(id);
		
	}







	
	
	
	
	
	
}
