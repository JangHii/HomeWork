package com.ezen.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class PagingVO {
	
	private int pageNo; // 현재 페이지 번호
	private int qty; // 한 화면에 보여줄 게시글 수 (10개)
	
	
	// 검색창 만들때 추가해야할 멤버변수
	private String type; 
	private String keyword;
	
	
	public PagingVO() {
		this.pageNo = 1;
		this.qty = 10;
	}

	
	public PagingVO (int pageNo , int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}
	
	
	public int getPageStart() {
		// DB상에서 limut의 시작값을 구하는 메서드
		return(this.pageNo-1)*this.qty;
	}
	
	
	// 검색창 추가할때 추가해야할 생성자
	// 여러가지의 타입을 같이 검색하기 위해서 타입을 배열로 구분
	// get뒤의 문자는 무조건 대문자로 입력해야한다
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}
	
	
	
}
