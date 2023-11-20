package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManager implements BoardInterface{
	
	ArrayList<Board> list = new ArrayList<>();
	
	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("--게시판--");
		System.out.println("1.글쓰기|2.조회|3.수정|4.삭제|5.전체목록|6.종료");
		System.out.println(">> menu : ");
	}

	@Override
	public void addBoard(Scanner scan) {
		// 게시글 추가
		System.out.println("--게시글 등록--");
		System.out.println("제목:");
		scan.nextLine(); //앞의 공백처리용
		String title = scan.nextLine(); // 공백포함 / scan.next() 공백미포함
		System.out.println("작성자:");
		String writer = scan.next();
		System.out.println("내용:");
		scan.nextLine();
		String content = scan.nextLine();
		Board b = new Board(title, writer, content);
		list.add(b);
	}

	@Override
	public void searchBoard(Scanner scan) {
		// 게시글 검색
		// 번호가 같다면 같은 값으로 인지
		// 1번글 검색
		System.out.println("조회할 번호 입력:");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		//index가 -1이라면 객체가 없다는 것을 의미
		if(index != -1) { // indexOf 값이 false면 -1를 리턴함 
			//해당 게시글이 있다면...
			Board temp = list.get(index);
			temp.print();
			return;
		}else {
			System.out.println("일치하는 글이 없습니다.");
		}
		System.out.println(index);
	}

	@Override
	public void modifyBoard(Scanner scan) {
		// 게시글 수정 : 제목, 내용
		System.out.println("수정할 번호 입력");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			//수정작업
			System.out.println("제목:");
			scan.nextLine();
			String title = scan.nextLine();
			System.out.println("내용 :");
			//위쪽 입력값이 nextLine()인경우 알아서 처리됨.
			String content = scan.nextLine();
			Board b = list.get(index); //검색해 놓은 번지의 객체
			b.setTitle(title);
			b.setContent(content);
			System.out.println("수정완료~!!");
			return;
		}else {
			System.out.println("게시글이 존재하지 않습니다.");
		}
		
	}

	@Override
	public void removeBoard(Scanner scan) {
		// 게시글 삭제
		System.out.println("삭제할 번호 입력");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		
		if(index != -1) {
			list.remove(index);
			System.out.println("게시글이 삭제되었습니다.");
		}else {
			System.out.println("게시글이 존재하지 않습니다.");
		}
	}

	@Override
	public void printBoard() {
		// 전체목록
		for(Board b : list) {
			System.out.println(b);
		}
	}
	
}


