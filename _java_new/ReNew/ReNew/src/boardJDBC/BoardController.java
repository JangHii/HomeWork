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
			System.out.println("--�Խ���--");
			System.out.println("1.�۾���|2.�۸�Ϻ���|3.�ۻ󼼺���");
			System.out.println("4.�ۼ���|5.�ۻ���|6.����");
			System.out.println(">> �޴����� : ");
			
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
		// �Խù� ����
		System.out.println("������ �Խñ� ��ȣ");
		int bno = scan.nextInt();
		
		int isOk = svc.remove(bno);
		System.out.println("�Խñۻ���" + (isOk > 0 ? "����" : "����"));
		
	}

	private void modify() {
		// �Խñ� ����
		System.out.println("���� �Խñ� ��ȣ");
		int bno = scan.nextInt();
		
		System.out.println("�������");
		scan.nextLine();
		String writer = scan.nextLine();
		
		System.out.println("�������");
		String content = scan.nextLine();
		
		BoardVO bv = new BoardVO(bno , content , writer);
		
		int isOk = svc.modify(bv);
		System.out.println("�Խñۼ���" + (isOk > 0 ? "���" : "�̵��"));
		
	}

	private void detail() {
		// �Խù� �� ����
		System.out.println("�Խù� ��ȣ");
		int bno = scan.nextInt();
		BoardVO bv = svc.detail(bno);
		System.out.println(bv);
	}

	private void list() {
		// �Խ��� ��Ϻ���
		List<BoardVO> list = svc.list();
		
		for(BoardVO bv : list) {
			System.out.println(bv);
		}
		
	}

	private void add() {
		// �Խ��ǵ��
		System.out.println("---�Խñ۵��---");
		System.out.println("����");
		scan.nextLine();
		String title = scan.nextLine();
		
		System.out.println("�г���");
		String writer = scan.next();
		
		System.out.println("����");
		scan.nextLine();
		String content = scan.nextLine();
		
		BoardVO bv = new BoardVO(title, writer, content);
		
		int isOk = svc.register(bv);
		System.out.println("��ñ۵��� "+((isOk > 0)? "���" : "�̵��"));
		
	}
	
	private void addreadcount() {
		// ī���� ����
		
	}
	
}
