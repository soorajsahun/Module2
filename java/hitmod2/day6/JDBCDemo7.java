package hitmod2.day6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;


public class JDBCDemo7 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
//		CallableStatement cs=con.prepareCall("{call mypro1()}");
//		cs.execute();
//		
//		cs=con.prepareCall("{call mypro2(?,?)}");
//		cs.setFloat(1, 30);
//		cs.setString(2, "Rahul");
//		cs.execute();
		//OR
//		cs=con.prepareCall("{call mypro2(60,'Suraj')}");
//		cs.execute();
		
		CallableStatement cs=con.prepareCall("{call mypro3(?)}");
		cs.registerOutParameter(1, Types.INTEGER);
		cs.execute();
		
		int noOfRows=cs.getInt(1);
		System.out.println("Number of rows..."+noOfRows);
	}

}
