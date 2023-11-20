package new02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Network01 {

	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress ip = null;
		ip = InetAddress.getByName("www.naver.com");
		System.out.println("naver ip");
		System.out.println("HostAddress > " + ip.getHostAddress());
		System.out.println("HostName > " + ip.getHostName());
		System.out.println(ip.toString());

		
		
	}

}
