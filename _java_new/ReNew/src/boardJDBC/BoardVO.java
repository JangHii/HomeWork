package boardJDBC;

public class BoardVO {

	
	
	private int bno ;
	private String title ;
	private String writer;
	private String content ;
	private String regdate ;
	private String moddate ;
	private int readcount ;
	
	public BoardVO() {}
	
	// �۾���� : title , writer , content
	public BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	// �� ������ : bno , title , content
	public BoardVO(int bon, String title, String content) {
		this.bno = bon;
		this.title = title;
		this.content = content;
	}
	
	// ��ü ����Ʈ�� : bno , title , writer , moddate , readcount
	public BoardVO(int bon, String title, String writer, String moddate , int readcount) {
		this.bno = bon;
		this.title = title;
		this.writer = writer;
		this.moddate = moddate;
		this.readcount = readcount;
	}
	
	// ���� �������� : ��ü
	public BoardVO(int bon, String title, String writer, String content, String regdate, String moddate , int readcount) {
		this.bno = bon;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readcount = readcount;
	}
	
	// ���������� ��� �޼���
	public void printDetail() {
		System.out.println("�۹�ȣ : "+bno+"      writer:"+writer);
		System.out.println("����  : "+title+"         ("+moddate+")");
		System.out.println("-----����-----");
		System.out.println(content);
	}

	public int getBon() {
		return bno;
	}

	public void setBon(int bon) {
		this.bno = bon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getModdate() {
		return moddate;
	}

	public void setModdate(String moddate) {
		this.moddate = moddate;
	}
	
	public int getReadCount() {
		return readcount;
	}

	public void setReadCount(int readCount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "BoardVO [bon=" + bno + ", title=" + title + ", writer=" + writer + ", date=" + moddate + "]";
	}
	
	
	
	
}
