package word;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WordManager {

	Word wd = new Word();
	HashMap <String, String> map = new HashMap<String , String>();
	

	
	// 메뉴출력
	public void menuprint() {
		System.out.println("단어장프로그램");
		System.out.println("1. 단어등록");
		System.out.println("2. 단어검색");
		System.out.println("3. 단어수정");
		System.out.println("4. 단어출력");
		System.out.println("5. 종료");
	}
	
	
	// 단어등록
	public void wordadd(Scanner scan) {
		System.out.println("단어 : ");
		String word = scan.next();
		System.out.println("의미 : ");
		String mean = scan.next();
		map.put(word, mean);
	}
	
	
	// 단어검색
	public void wordSearch(Scanner scan) {
		System.out.println("찾고싶은 단어를 입력해주세요");
		String word = scan.next();
		
		for(String tmp : map.keySet()) {
			
			if(tmp.equals(word)) {
				System.out.println("찾고싶은 단어를 출력했습니다.");
				System.out.println("단어 : "+ tmp);
				System.out.println("뜻 : " +map.get(tmp));
			}
		}
			
		}
		
	
	
	
	// 단어수정
	public void wordSub(Scanner scan) {
		System.out.println("수정할 단어를 입력해주세요");
		String word = scan.next();
		System.out.println("수정된 단어의 의미를 입력해주세요");
		String mean = scan.next();
		
		map.put(word, mean);
		map.replace(word, mean);
		System.out.println("입력한" + word + "가 수정되었습니다.");
	}
	
	
	// 단어출력
	public void wordPrint() {
		for(String tmp : map.keySet()) {
			System.out.println(tmp + ":" + map.get(tmp));
		}
	}

	// 파일프린트
	public void filePrint() throws IOException {
		FileWriter fw = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuffer sb = new StringBuffer();
		
		String data = "";
		int cnt = 0; // 리스트의 index
		
		while(cnt < map.size()) {
			sb.append(map.get(cnt).toString());
			sb.append("\r\n"); //줄바꿈
			cnt++;
		}
		data = sb.toString();
		System.out.println(data);
		fw.write(data);
		fw.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
