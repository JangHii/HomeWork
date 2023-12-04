package domain;

public class PagingVO {

	
	// 화면에 출력되는 페이지네이션번호
	private int pageNo ; 
	
	// 한페이지에 보여줄 게시물 수 (10개)
	private int qty ;
	
	
	// 검색에 관한 맴버변수 추가
	private String type ; // 검색대상
	private String Keyword ; // 검색어
	
	
	
	public PagingVO() { // 처음 리스트로 들어갔을때 규칙
		
		// 페이지네이션을 클릭하기 전 기본값 설정
		this.pageNo = 1 ; // 화면에 보이는 페이지의 스타트번호
		this.qty = 10 ; // 화면에 보이는 게시물의 수
	}
	
	
	
	public PagingVO(int pageNo , int qty , String type , String Keyword) {
		
		// 페이지네이션을 클릭하면 설정되는 값
		this.pageNo = pageNo ; 
		this.qty = qty ;
		this.type = type ;
		this.Keyword = Keyword ;
	}
	
	
	
	public int getPageStart() { // db에서 사용되는 시작번호 0번지부터 시작
		
		// 1페이지 = 0 / 2페이지 = 10 / 3페이지 = 20
		return (pageNo-1)*qty; // 0*10이 되기위한 계산값
	}
	
	
	
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}

	
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getKeyword() {
		return Keyword;
	}



	public void setKeyword(String keyword) {
		Keyword = keyword;
	}



	@Override
	public String toString() {
		return "PagingVO [pageNo=" + pageNo + ", qty=" + qty + ", type=" + type + ", Keyword=" + Keyword + "]";
	}




	
	
	
	
	
}
