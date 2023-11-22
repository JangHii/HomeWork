package new02;

public class Singleton {

	public static void main(String[] args) {
		
		// 싱글톤 패턴 : 디자인 패턴 중 하나
		// 객체를 1개만 생성하여 공유하고자 할때 사용
		
//		single s = new single(); //생성x
		
		Single s = Single.getInstance(); // 클래스명.메서드명
		Single s2 = Single.getInstance(); 
		
		System.out.println(s);
		System.out.println(s2);
		
		if(s == s2) {
			System.out.println("s와 s2는 같은 객체");
		}else {
			System.out.println("s와 s2는 다른 객체");
		}
	}

}



class Single {
	
	// 객체를 1개만 생성하여 공유
	private static Single instance;
	
	// 생성자를 통한 객체 생성을 막기위해 생성자를 private 설정
	private Single() {}
	
	// getInstance() 메서드를 사용하여 instance가 생성되지 않았다면
	// 생성해서 리턴 , 아니면 기존 인스턴스를 리턴
	public static Single getInstance() {
		if(instance == null) { // 아직 객체가 생성되지 않았다면...
			instance = new Single();
		}
		
		return instance;
	}
	
	
	
	
	
	
	
	
	
	
	
}