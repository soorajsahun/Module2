package hitmod2.day2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class ObjectSavingDemo {
	public static void main(String[] args) throws Exception{
		Laddu myladdu=new Laddu(10);
		System.out.println(myladdu.getSize());
		myladdu.name="some value....";
		
		myladdu.setSize(5);
		System.out.println(myladdu.getSize());
		//I want to save this state of object and retrieve it when i want.
		//To achieve this, you can serialize this myladdu object into a file
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("laddu.dat"));//dat is non readable file format
		out.writeObject(myladdu);
		
		myladdu.setSize(0);
		System.out.println(myladdu.getSize());
		System.out.println("before serialization..:"+myladdu.name);
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("laddu.dat"));
//		myladdu=(Laddu)in.readObject();
//		System.out.println(myladdu.getSize());
//		System.out.println("after serialization..:"+myladdu.name);
		
		//how can you create a deep copy of an object
		//The answer is through serialization
		Laddu myladdu2=(Laddu)in.readObject();
		System.out.println(myladdu2.getSize());
		System.out.println("after serialization..:"+myladdu2.name);

	}
}
class Laddu implements Serializable{//marker interface to use Object I/O Stream
	int size;
	transient String name;//these transient variables are not saved during serialization
	public Laddu(int size) {
		this.size=size;
	}
	public int getSize() {
		return this.size;
	}
	public void setSize(int size) {
		this.size=size;
	}
}