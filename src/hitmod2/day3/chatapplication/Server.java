package hitmod2.day3.chatapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket ss;
	Socket s;
	BufferedReader in,clientIn;
	PrintWriter out;
	public Server() {
		try {
//			1-accept client socket
			ss=new ServerSocket(2000);
			while(true) {
			s=ss.accept();
			System.out.println("Server is ready to make connection");
			
//			2-accept input from user
			in=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter msg for client");
			String msgForclient=in.readLine();
			
//			3-accept client socket output stream
			out=new PrintWriter(s.getOutputStream(),true);//true=to fresh the memory everytime so that new new content added
			out.println(msgForclient);
			
			clientIn=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String msgFromclient=clientIn.readLine();
			System.out.println("From client:.."+msgFromclient);
//			System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}
