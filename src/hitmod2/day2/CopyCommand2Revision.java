package hitmod2.day2;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyCommand2Revision {//In CopyCommand2Revise,loop run 2 times as no characters was 8 and I have given size of 
	//character array as 6
	//first time it reads=AbCdEf
	//second time it reads=GhCdEf, which is wrong. This should be 'Gh' only
	//to overcome we are doing this excercise
	public static void main(String[] args) {
		try(
				FileReader reader=new FileReader("temp.txt");
				FileWriter writer=new FileWriter("copy2.txt")
			){
			int i=0;
			char chararray[]=new char[6];//efficient array size should be 2^n
			while((i=reader.read(chararray))!=-1) {
				System.out.println("No of characters..."+i);
				System.out.println(new String(chararray,0,i));
				writer.write(chararray,0,i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
