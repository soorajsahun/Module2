package hitmod2.day1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyCommandRevise {//In CopyCommand, the loop was running 6 times.Lets reduce to 1 time
	public static void main(String[] args){
		try(
				FileInputStream fis=new FileInputStream("temp.txt");
				FileOutputStream fos=new FileOutputStream("copytemp.txt",true)//true is used to append in file
			){
			int i=0;
			byte bytebag[]=new byte[fis.available()];//byte array
			while((i=fis.read(bytebag))!=-1) {
				System.out.println("No of characters..."+i);
				System.out.println(new String(bytebag));//byte array gets converted into String when passing into String constructor
				fos.write(bytebag);//this accept byte array
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}
