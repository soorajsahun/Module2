package hitmod2.day3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class NetProgramming {//how to copy a page from any website
	public static void main(String[] args) throws Exception{
		URL url=new URL("http://www.haarisinfotech.com/index.html");
//		URL url=new URL("http://www.google.com/index.html");
		
//		URL url=new URL("file:///D:\\HIT-Study material/Basic Definitions.txt");
		
		URLConnection urlCon=url.openConnection();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		FileWriter out=new FileWriter("google.html");
		
		int i=0;
		while((i=br.read())!=-1) {
			System.out.print((char)i);
			out.write(i);
		}
		out.close();
	}
}

