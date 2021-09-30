package hitmod2.day2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class BufferedDemo {//BufferedInputStream and BufferedReader are able to back and forth the position with methods 'mark' & 'reset'
	public static void main(String[] args)throws Exception {
		String str="jack and &copy; jill went up the &copy hill to fetch.....";
		System.out.println(str);
		String expectedStr="jack and "+(char)169+" jill went up the &copy hill to fetch.....";
		System.out.println(expectedStr);
		
		ByteArrayInputStream bais=new ByteArrayInputStream(str.getBytes());//converting string into ByteArrayInputStream
//		BufferedInputStream bis=new BufferedInputStream(bais);//as it takes input stream->(bais)
		
		InputStreamReader isr=new InputStreamReader(bais);
		BufferedReader br=new BufferedReader(isr);//as it takes input stream reader->(isr)
		
		int i=0;
		boolean print=true;
		while((i=br.read())!=-1) {
//			System.out.print((char)i);
			switch((char)i) {
			case'&':{
				print=false;
				br.mark(50);
				break;
			}
			case';':{
				System.out.print((char)169);
				print=true;
				break;
			}
			case' ':{
				if(print) {
					System.out.print(" ");
				}
				else {
					System.out.print("&");
					br.reset();
					print=true;
				}
				break;
			}
			default:{
				if(print) {
					System.out.print((char)i);
				}
			}
			}
		}
	}
}
