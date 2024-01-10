package com.myweb.www.handler;

import java.util.List;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingHandler {

	private int startPage; //하단 페이지네이션의 시작번호 1,11,21
	private int endPage; //하단 페이지네이션의 끝번호 10,20,30
	private boolean prev , next; //이전 , 다음
	
	private int totalCount; //총게시글의 수 (매개변수로 전달)
	private PagingVO pgvo; //매개변수로 전달
	
	private List<CommentVO> cmtList;
	
	//생성자에서 모든 값들이 설정되야함
	public PagingHandler(PagingVO pgvo , int totalCoung) {
		this.pgvo = pgvo;
		this.totalCount = totalCoung;
		
		// 1~10 / 11~20 / 21~30 ........................
		// 1부터 10까지는 무조건 endPage = 10
		// 1 2 3 4 ..... 10 / 10 나머지를 올려(ceil) 1로 만듬 * 10
		this.endPage = (int)Math.ceil((double)pgvo.getPageNo() / pgvo.getQty()) * pgvo.getQty();
		
		this.startPage = endPage - 9;
		
		//실제 마지막 페이지
		//전체 글수 / 한페이지에 표시되는 게시글수 => 올림s
		int realEndpage = (int)Math.ceil(totalCoung / (double)pgvo.getQty());
		
		if(realEndpage < endPage) {
			this.endPage = realEndpage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEndpage;
	}
	
	public PagingHandler(PagingVO pgvo , int totalCount , List<CommentVO> cmtList) {
		this(pgvo , totalCount);
		this.cmtList = cmtList;
	}
	
}
