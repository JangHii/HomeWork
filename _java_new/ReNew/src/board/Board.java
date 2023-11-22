package board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Board {
	
	//번호, 제목, 내용, 작성자, 작성일
	//번호, 작성일 자동작성
	//번호만 같은 객체가 들어오면 같은 객체로 인정 equals
	
	private static int count;
	private int num;
	private String title;
	private String writer;
	private String content;
	private String registerDate;
	
	public Board() {
		count++;
		this.num = count;
		SimpleDateFormat sh = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.registerDate = sh.format(new Date());
	}
	public Board(String title, String writer, String content) {
		this();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	public Board(int num) {
		this.num = num;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(content, num, registerDate, title, writer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if(num != other.num) {
			return false;
		}
		return true;
	}
	
	public void print() {
		System.out.println("-----------------------------");
		System.out.println("번호: "+num);
		System.out.println("제목: "+title);
		System.out.println("작성자: "+writer);
		System.out.println("작성일: "+registerDate);
		System.out.println(content);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", writer=" + writer + ", registerDate=" + registerDate + "]";
	}
	
	
}