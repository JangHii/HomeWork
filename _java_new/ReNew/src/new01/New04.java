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
//		System.out.println("단어장");
//		
//		
//		System.out.println("단어를 입력해주세요");
//		String Key = scan.next();
//		System.out.println("단어의 뜻을 입력해주세요");
//		String Value = scan.next();
//		
//		map.put(Key, Value);
//		
//		System.out.println(map);
		
		
		
		
		
		// 선생님 풀이
		HashMap<String,String> map1 = new HashMap<>();
		
		System.out.println("단어개수 : ");
		int size = scan.nextInt();
		
		while(map1.size()<size) {
			System.out.println("단어 : ");
			String word = scan.next();
			System.out.println("의미 : ");
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
