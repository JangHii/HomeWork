package new02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Network03 {

	public static void main(String[] args) {
//		https://www.dorocy.co.kr/
		URL url = null;
		BufferedReader input = null ;
		String addr = "https://www.dorocy.co.kr/";
		
		String line = "";
		
		try {
			url = new URL(addr);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
