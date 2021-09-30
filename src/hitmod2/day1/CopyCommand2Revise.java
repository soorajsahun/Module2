package hitmod2.day1;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyCommand2Revise {//In CopyCommand2, the loop was running 6 times.Lets reduce to 1 time
	public static void main(String[] args) {
		try(
			FileReader read=new FileReader("temp.txt");
			FileWriter write=new FileWriter("copytemp2.txt",true)
			){
			int i=0;
			char charbag[]=new char[6];
			while((i=read.read(charbag))!=-1) {
				System.out.println("No of characters..."+i);
				System.out.println(new String(charbag));
				write.write(charbag);//this accept char array
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
