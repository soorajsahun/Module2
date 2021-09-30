package hitmod2.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo3 {//Atomicity properties
	public JDBCDemo3() throws Exception{//loaded driver in constructor
		//Driver is heavy object and should be created only once...
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	public static void main(String[] args) throws Exception{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
		try {
			con.setAutoCommit(false);
			Statement stmt=con.createStatement();
			stmt.execute("insert into students values (2,'Rahul','CET',10.54)");
			stmt.execute("insert into students values(3,'Manoj','CET')");
		} catch (Exception e) {
			System.out.println(e);
			con.rollback();
		}
		finally {
			con.commit();
		}
	}
}
