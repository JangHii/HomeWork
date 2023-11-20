package new01;

public class New01 {

	public static void main(String[] args) {
		/* 홍길동 주민등록번호는 881122-1234567이다
		 * 출력형태 => 생년월일 : 881122 성별 : 남(1,3) 여(2,4)
		 * */
		
		// 주어진 값
		String pin = "881122-1234567";

		// 0~6번지까지 뽑아냄
		String str1 = pin.substring(0,6);
		System.out.println("생년월일 : " + str1);
		
		// char 형태로 번지수 하나만 뽑아냄
		char Num = pin.charAt(7);
		String str = Num % 2 == 0 ? "여자" : "남자" ;
		System.out.println(str);
		
		
		System.out.println();
		System.out.println("=====================");
		
		// 선생님 풀이
		
		String birth = pin.substring(0,pin.indexOf("-"));
		System.out.println("생년월일 : " + birth);
		
		String ch = pin.substring(pin.indexOf("-")+1,8);
//		System.out.println(ch);
		
		// char '' == / String "" equals()
		
		if(ch.equals("1") || ch.equals("3")) {
			System.out.println("성별 : 남");
		}else {
			System.out.println("성별 : 여");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
