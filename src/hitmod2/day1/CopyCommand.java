package hitmod2.day1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class CopyCommand {//copy=to read from a file and write that in a file
	//This program opens a file connection and closes it automatically.
	//InputStream implements interface closeable which closes the connection
	public static void main(String[] args){
		//try with resources-Using this always closeable interface method is called which closes the resources
		try(
				FileInputStream fis=new FileInputStream("temp.txt");
				FileOutputStream fos=new FileOutputStream("copytemp.txt",true)//true is used to append in file
			){
			int i=0;
			
//			System.out.println(fis.available()); //fis.available() returns number of bytes(1characters=1byte)(1byte=8bit) present in the file
			while((i=fis.read())!=-1) {//fis.read() returns ASCII value of character
				//!=-1 because after end of loop fis.read() returns -1
				System.out.print((char)i);
				fos.write(i);//writing will be done only if close method is called(here happens automatically)
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}