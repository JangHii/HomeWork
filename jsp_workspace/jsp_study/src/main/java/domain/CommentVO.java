package domain;

public class CommentVO {


	
	
	
	private int cno ;
	private int bno ;
	private String wtiter ;
	private String content ;
	private String regdate ;
	
	
	public CommentVO () {}

	
	// post : bno , writer , content
	public CommentVO(int bno, String wtiter, String content) {
		this.bno = bno;
		this.wtiter = wtiter;
		this.content = content;
	}
	
	
	//modify : cno , content
	public CommentVO(int cno, String content) {
		this.cno = cno;
		this.content = content;
	}
	
	
	public CommentVO(int cno, int bno, String wtiter, String content, String regdate) {
		this.cno = cno;
		this.bno = bno;
		this.wtiter = wtiter;
		this.content = content;
		this.regdate = regdate;
	}
	



	public int getCno() {
		return cno;
	}




	public void setCno(int cno) {
		this.cno = cno;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getWtiter() {
		return wtiter;
	}


	public void setWtiter(String wtiter) {
		this.wtiter = wtiter;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", bno=" + bno + ", wtiter=" + wtiter + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
	
	
	
	
}
