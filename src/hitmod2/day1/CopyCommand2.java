package hitmod2.day1;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyCommand2 {
	public static void main(String[] args) {
		try(
			FileReader read=new FileReader("temp.txt");
			FileWriter write=new FileWriter("copytemp2.txt")
			){
			int i=0;
			while((i=read.read())!=-1) {
				System.out.print((char)i);
				write.write(i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
