package hitmod2.day3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket ss;
	Socket s;
	
	public Server() {
		try {
			ss=new ServerSocket(2000);
			while(true) {
				System.out.println("Server is ready to make connection");
				s=ss.accept();
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}
