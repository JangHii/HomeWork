package new01;

public class New01 {

	public static void main(String[] args) {
		/* ȫ�浿 �ֹε�Ϲ�ȣ�� 881122-1234567�̴�
		 * ������� => ������� : 881122 ���� : ��(1,3) ��(2,4)
		 * */
		
		// �־��� ��
		String pin = "881122-1234567";

		// 0~6�������� �̾Ƴ�
		String str1 = pin.substring(0,6);
		System.out.println("������� : " + str1);
		
		// char ���·� ������ �ϳ��� �̾Ƴ�
		char Num = pin.charAt(7);
		String str = Num % 2 == 0 ? "����" : "����" ;
		System.out.println(str);
		
		
		System.out.println();
		System.out.println("=====================");
		
		// ������ Ǯ��
		
		String birth = pin.substring(0,pin.indexOf("-"));
		System.out.println("������� : " + birth);
		
		String ch = pin.substring(pin.indexOf("-")+1,8);
//		System.out.println(ch);
		
		// char '' == / String "" equals()
		
		if(ch.equals("1") || ch.equals("3")) {
			System.out.println("���� : ��");
		}else {
			System.out.println("���� : ��");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
