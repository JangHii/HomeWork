package com.myweb.www;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;


// RootConfig의 설정을 그대로 가져온다
@ContextConfiguration(classes = {com.myweb.www.config.RootConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j 
public class BoardTest {

	@Inject
	private BoardDAO bdao;
	
	// 생성용
	@Test
	public void insertBoard() {
		for(int i=1; i<300; i++) {
			BoardVO bvo = new BoardVO();
			bvo.setTitle("테스트용 제목 " + i);
			bvo.setWriter("테스트용 작성자 " + i);
			bvo.setContent("테스트용 내용 " + i);
			bdao.insert(bvo);
		}
	}

	// 삭제용
//	@Test
//	public void deleteBoard() {
//		for(int i=0; i<305; i++) {
//			bdao.delete(i);
//		}
//	}
	
}
