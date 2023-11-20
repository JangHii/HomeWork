package JDBC;

import java.util.Scanner;

public class ProductController {

	
	/* 상품등록 , 상품리스트보기 , 상품상세보기 , 상품수정 , 상품삭제
	 * Controller <-> Service <-> DAO <-> DB
	 * Controller에서 분기처리 모든 메뉴를 처리
	 * */
	
	private Scanner scan ;
	private Service svc ; // 아직 안만듬 -> package에 interface로 생성
	private boolean flag ; // 종료변수
	
	public ProductController() {
		scan = new Scanner(System.in);
		svc = new ProductServiceImpl(); // service 구현체
		flag = true ;
		printmenu(); // 메뉴 출력
	}

	private void printmenu() {
		//flag가 true면 계속 메뉴 출력
		while(flag) {
			System.out.println("--상품관리프로그램--");
			System.out.println("1.상품등록 | 2.상품목록 | 3.상품검색(상세)");
			System.out.println("4.상품수정 | 5.상품삭제 | 6.종료");
			System.out.println("menu >> ");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1: register(); break;
			case 2: list(); break;
			case 3: detail(); break;
			case 4: modify(); break;
			case 5: remove(); break;
			default :
				flag = false;
				break;
			}
			
		}
		
	}

	private void remove() {
		// TODO Auto-generated method stub
		
	}

	private void modify() {
		// TODO Auto-generated method stub
		
	}

	private void detail() {
		// TODO Auto-generated method stub
		
	}

	private void list() {
		// TODO Auto-generated method stub
		
	}

	private void register() {
		// TODO Auto-generated method stub
		
	}
	
	
}
