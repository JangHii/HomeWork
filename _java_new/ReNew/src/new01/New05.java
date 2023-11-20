package new01;

import java.util.HashMap;
import java.util.Scanner;

public class New05 {

	public static void main(String[] args) {
		// new 04 클래스의 단어장을 메서드로 분리
		// 메서드에서 리턴한 map을 받아서 출력
		HashMap<String, String> map = make();
		System.out.println(map);
		
		for(String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
	}

	// 기능 : 단어/의미를 입력받아 map을 구성
	// map은 메서드 안에서 생성하여 리턴
	// make()
	
	public static HashMap<String , String> make(){
		HashMap<String, String> map = new HashMap<String , String>();	
		Scanner scan = new Scanner(System.in);
		System.out.println("입력받을 개수 : ");
		int size = scan.nextInt();
		
		while(map.size() < size) {
			System.out.println("단어 : ");
			String word = scan.next();
			System.out.println("의미 : ");
			String mean = scan.next();
			
			map.put(word, mean);
		}
		return map ;
	}
	
}
