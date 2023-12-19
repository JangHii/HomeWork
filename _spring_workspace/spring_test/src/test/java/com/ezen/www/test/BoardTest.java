package com.ezen.www.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.www.domain.BoardVO;
import com.ezen.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

// root-context.xml의 경로를 써준다
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class) // test할때 필수로 있어야함.
@Slf4j


public class BoardTest {
	
	@Inject
	private BoardDAO bdao; //import 해줘야함
	
	@Test
	public void insertBoard() {
		log.info(">>> Test Insert in >>>");
		
		for(int i=0; i<300; i++) {
			BoardVO bvo = new BoardVO(); // inpost 해야함
			bvo.setTitle("테스트 제목" + i); // 테스트의 숫자가 0~300까지 갈수있도록
			bvo.setWriter("테스트 이름" + i); 
			bvo.setContent("테스트 내용" + i); 
			
			bdao.insert(bvo);
		}
	}

}
