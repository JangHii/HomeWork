package board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		// 게시판 데이터 처리 클래스
		// CRUD (create:생성, read:조회, update:수정, delete:삭제)
		// Board class(게시글번호, 제목, 내용, 작성자, 작성일)
		// 번호는 자동으로 카운트되게 설정.
		// 작성일은 현재 날짜시간으로 들어가게 자동 설정.
		
		BoardManager bm = new BoardManager();
		
		Scanner scan = new Scanner(System.in);
		int menu = -1;
		
		do {
			bm.printMenu();
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: bm.addBoard(scan);
				break;
			case 2: bm.searchBoard(scan);
				break;
			case 3: bm.modifyBoard(scan);
				break;
			case 4: bm.removeBoard(scan);
				break;
			case 5: bm.printBoard();
				break;
			case 6: 
				System.out.println("게시판 종료");
				break;
				
				default : System.out.println("잘못된 메뉴~!!");
				break;
			}
		}while(menu != 6);
		
	}

}
