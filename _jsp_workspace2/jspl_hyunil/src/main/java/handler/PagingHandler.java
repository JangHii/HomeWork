package handler;

import org.apache.ibatis.ognl.ASTThisVarRef;

import domain.PagingVO;

public class PagingHandler {

	
	//list 하단에 나오는 페이지네이션 핸들링 클래스
	
	//현재 화면에서 보여줄 시작 페이지네이션 번호
	// 1 / 11 / 21 / 31
	private int startPage;
	
	//현재 화면에서 보여줄 끝 페이지네이션 번호
	// 10 / 20 / 30 / 40
	private int endPage;
	
	//실제 전체 리스트의 끝번호
	private int realEndPage;
	
	//이전 , 다음페이지의 존재여부
	//이전 = File / 다음 = True
	private boolean prev , next; 
	
	//파라미터로 받기 totalCount , pgvo
	//전체 게시글의 갯수
	private int totalCount;
	
	
	//pageNo / qty
	//현재 사용자가 클릭한 번호와 한 화면에 표시되는 갯수
	private PagingVO pgvo;
	
	
	public PagingHandler(PagingVO pgvo , int totalCount) {
		
		this.pgvo = pgvo; //1페이지 / 10개씩
		
		//컨트롤러에서 DB 조회 후 파라미터로 전송
		this.totalCount = totalCount;
		
		//첫번째페이지 1~10 / 두번째페이지 11~20
		//페이지번호 1~10을 클릭해도 시작은1 , 끝은10
		// 1~10 , 2~10 , 3~10 , 11~20 , 12~20
		
		//페이지번호 / 한화면의 페이지네이션 갯수 * 한화면의 페이지네이션 수
		//1/10 => 0.1*10 (1*10)0.1을 1로 변환 -> 1*10
		//2/10 => 0.2*10 (1*10)0.2을 1로 변환 -> 1*10
		//11/10 => 1.11*10 (2*10)1.1을 2로 변환 -> 2*10
		//정수/정수=>졍수          /정수/실수 소수점이 나올수 있게 둘중하나를 double로 현변환해주기
		this.endPage = (int)Math.ceil(pgvo.getPageNo() / (double)pgvo.getQty()) * pgvo.getQty();
		
		//시작 페이지네이션의 숫자
		this.startPage = this.endPage - 9;
		
		//전체 게시글 수 / 한 화면에 게시되는 게시글수
		//101*10 => 10.1 올려서 11페이지가 되게 해야한다.
		//나머지 게시글이 하나라도 있으면 1페이지가 무조건 생겨야한다.
		this.realEndPage = (int)Math.ceil(totalCount / (double)pgvo.getQty());
		
		//realEndPage=11 / endPage=20
		//실제 페이지의 끝 설정
		//진짜 끝헤이지가 endPage와 같지않을 경우 처리
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		//이전 , 다음 유무
		//startPage = 1 , 11 , 21
		this.prev = this.startPage > 1 ;
		this.next = this.endPage < this.realEndPage ;

	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getRealEndPage() {
		return realEndPage;
	}


	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public PagingVO getPgvo() {
		return pgvo;
	}


	public void setPgvo(PagingVO pgvo) {
		this.pgvo = pgvo;
	}


	@Override
	public String toString() {
		return "PagingHandler [startPage=" + startPage + ", endPage=" + endPage + ", realEndPage=" + realEndPage
				+ ", prev=" + prev + ", next=" + next + ", totalCount=" + totalCount + ", pgvo=" + pgvo + "]";
	}
	
	
	
}
