package boardJDBC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardController {
	
	private Scanner scan ;
	private Service svc ;
	private boolean flag ;
	
	
	
	public BoardController() {
		scan = new Scanner(System.in);
		svc = new BoardServiceImpl();
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("--게시판--");
			System.out.println("1.글쓰기|2.글목록보기|3.글상세보기");
			System.out.println("4.글수정|5.글삭제|6.종료");
			System.out.println(">> 메뉴선택 : ");
			
			int menu = scan.nextInt();
			
			
			switch(menu) {
			case 1: 
					add();
				break;
			case 2: 
					list();
				break;
			case 3: 
					detail();
				break;
			case 4: 
					modify();
				break;
			case 5: 
					remove();
				break;
			default : flag = false; 
				break;
			}
		}
		
	}

	private void remove() {
		// 게시물 삭제
		System.out.println("삭제할 게시글 번호");
		int bno = scan.nextInt();
		
		int isOk = svc.remove(bno);
		System.out.println("게시글삭제" + (isOk > 0 ? "삭제" : "실패"));
		
	}

	private void modify() {
		// 게시글 수정
		System.out.println("수정 게시글 번호");
		int bno = scan.nextInt();
		
		System.out.println("제목수정");
		scan.nextLine();
		String writer = scan.nextLine();
		
		System.out.println("내용수정");
		String content = scan.nextLine();
		
		BoardVO bv = new BoardVO(bno , content , writer);
		
		int isOk = svc.modify(bv);
		System.out.println("게시글수정" + (isOk > 0 ? "등록" : "미등록"));
		
	}

	private void detail() {
		// 게시물 상세 보기
		System.out.println("게시물 번호");
		int bno = scan.nextInt();
		BoardVO bv = svc.detail(bno);
		System.out.println(bv);
	}

	private void list() {
		// 게시판 목록보기
		List<BoardVO> list = svc.list();
		
		for(BoardVO bv : list) {
			System.out.println(bv);
		}
		
	}

	private void add() {
		// 게시판등록
		System.out.println("---게시글등록---");
		System.out.println("제목");
		scan.nextLine();
		String title = scan.nextLine();
		
		System.out.println("닉네임");
		String writer = scan.next();
		
		System.out.println("내용");
		scan.nextLine();
		String content = scan.nextLine();
		
		BoardVO bv = new BoardVO(title, writer, content);
		
		int isOk = svc.register(bv);
		System.out.println("계시글동록 "+((isOk > 0)? "등록" : "미등록"));
		
	}
	
	private void addreadcount() {
		// 카운터 증가
		
	}
	
}
