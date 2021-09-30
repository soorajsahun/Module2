package hitmod2.day3;

import java.io.IOException;
import java.net.Socket;

public class Client {
	Socket clientSock;
	public Client() {
		try {
			clientSock=new Socket("localhost", 2000);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Client();
	}
}
