package hitmod2.day3.chatapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	Socket clientSock;
	BufferedReader serverIn,in;
	PrintWriter out;
	public Client() {
		try {
			while(true) {
			clientSock=new Socket("localhost",2000);
			serverIn=new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
			String msgFromServer=serverIn.readLine();
			System.out.println("From Server...:"+msgFromServer);
			
			in=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter msg for server");
			String msgToServer=in.readLine();
			
			out=new PrintWriter(clientSock.getOutputStream(),true);
			out.println(msgToServer);
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new Client();
	}
}
