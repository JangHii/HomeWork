package com.ezen.www.handler;

import com.ezen.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class PagingHandler {

	private int startPage; // 1 11 21 31 / 각페이지의 시작
	private int endPage; // 10 20 30 / 각페이지의 마지막
	private boolean prev , next;
	private int totalCount;
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo , int totalCount) {
		
		// pgvo , totalCount 컨트롤러에서 받아서 넣기
		// 화면에서 받고 DB에서 찾아야하는것들
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		// 1~10까지 누르면 마지막페이지는 10이여야한다. pgvo=1~10 => endPage 10
		// 11~20까지는 20이여야한다
		// 정수 나누기 소수를 만들기 위해서 둘중하나를 형변환을 해준다.
		// 1/10.0 => 0.1(올림) => 1*10 = 10
		// 2/10.0 => 0.2(올림) => 1*10 = 10
		// 0.1~9는 1이라 생각하고 1.1~1.9는 2라고 생각한다
		this.endPage = (int)Math.ceil(pgvo.getPageNo() / (double)pgvo.getQty()) * pgvo.getQty();
		this.startPage = endPage - 9;
		
		// 게시판의 맨 마지막
		// 한 페이지의 값이 다 차지않는 나머지의 페이지를 하나의 페이지로 만들기 위해 올림을 사용
		// 총게시글수 111 / 표시할 페이지수 10
		// 111 / 10 => 11.1 => 12page 설정
		// 하나라도 있으면 page는 무조건 생성되어야한다.
		int realEndPage = (int)Math.ceil(totalCount / (double)pgvo.getQty()) ;
		
		if(realEndPage < endPage) { // 페이지의 마지막이 진짜게시글의마지막수보다 크면 relaEcdPage로 바꿔라
			this.endPage = realEndPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndPage;
		
	}
	
}
