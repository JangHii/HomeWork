package com.myweb.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class PagingVO {

	private int pageNo; // 현재페이지번호
	private int qty; // 한페이지당 표시될 리스트 갯수
	
	private String type;
	private String keyword;
	
	public PagingVO() {
		this.pageNo = 1;
		this.qty = 10;
	}
	
	public PagingVO(int pageNO , int qwy) {
		this.pageNo = pageNO;
		this.qty = qwy;
	}
	
	// 시작 번지 구하기
	public int getPageStart() {
		return (this.pageNo-1) * qty;
	}
	
	//type의 값을 배열로 생성
	//복합타입의 키워드일 경우 각자 검색해야하기 때문에 배열을 생성
	public String[] getTypeToArray() {
		return this.type == null? new String[] {} : this.type.split("");
	}
}
