package new01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		// 	
		
		Scanner scan = new Scanner(System.in);
//		
//		HashMap<String,String> map = new HashMap<>();
//		
//		
//		System.out.println("�ܾ���");
//		
//		
//		System.out.println("�ܾ �Է����ּ���");
//		String Key = scan.next();
//		System.out.println("�ܾ��� ���� �Է����ּ���");
//		String Value = scan.next();
//		
//		map.put(Key, Value);
//		
//		System.out.println(map);
		
		
		
		
		
		// ������ Ǯ��
		HashMap<String,String> map1 = new HashMap<>();
		
		System.out.println("�ܾ�� : ");
		int size = scan.nextInt();
		
		while(map1.size()<size) {
			System.out.println("�ܾ� : ");
			String word = scan.next();
			System.out.println("�ǹ� : ");
			String mean = scan.next();
			
			map1.put(word ,  mean);
		}
		
		Iterator<String>it = map1.keySet().iterator();
		while(it.hasNext()) {
			String word = it.next();
			System.out.println(word + ":"+map1.get(word));
		}
		
		
		
		
		
		
		scan.close();
		
	}

}
