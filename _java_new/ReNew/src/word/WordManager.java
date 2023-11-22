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
	

	
	// �޴����
	public void menuprint() {
		System.out.println("�ܾ������α׷�");
		System.out.println("1. �ܾ���");
		System.out.println("2. �ܾ�˻�");
		System.out.println("3. �ܾ����");
		System.out.println("4. �ܾ����");
		System.out.println("5. ����");
	}
	
	
	// �ܾ���
	public void wordadd(Scanner scan) {
		System.out.println("�ܾ� : ");
		String word = scan.next();
		System.out.println("�ǹ� : ");
		String mean = scan.next();
		map.put(word, mean);
	}
	
	
	// �ܾ�˻�
	public void wordSearch(Scanner scan) {
		System.out.println("ã����� �ܾ �Է����ּ���");
		String word = scan.next();
		
		for(String tmp : map.keySet()) {
			
			if(tmp.equals(word)) {
				System.out.println("ã����� �ܾ ����߽��ϴ�.");
				System.out.println("�ܾ� : "+ tmp);
				System.out.println("�� : " +map.get(tmp));
			}
		}
			
		}
		
	
	
	
	// �ܾ����
	public void wordSub(Scanner scan) {
		System.out.println("������ �ܾ �Է����ּ���");
		String word = scan.next();
		System.out.println("������ �ܾ��� �ǹ̸� �Է����ּ���");
		String mean = scan.next();
		
		map.put(word, mean);
		map.replace(word, mean);
		System.out.println("�Է���" + word + "�� �����Ǿ����ϴ�.");
	}
	
	
	// �ܾ����
	public void wordPrint() {
		for(String tmp : map.keySet()) {
			System.out.println(tmp + ":" + map.get(tmp));
		}
	}

	// ��������Ʈ
	public void filePrint() throws IOException {
		FileWriter fw = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuffer sb = new StringBuffer();
		
		String data = "";
		int cnt = 0; // ����Ʈ�� index
		
		while(cnt < map.size()) {
			sb.append(map.get(cnt).toString());
			sb.append("\r\n"); //�ٹٲ�
			cnt++;
		}
		data = sb.toString();
		System.out.println(data);
		fw.write(data);
		fw.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
