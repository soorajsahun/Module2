package hitmod2.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo1 {
	public static void main(String[] args) throws Exception {
//1-	load or register Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");//this not going to change (only database changes this changes)
//2-	connection to database
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");//getConnection returns an object of type Connection
//		jdbc-protocol(eg.http)
//		mysql-databse
//		localhost-machine
//		3306-port number(if not given then also work by default 3306)
//		aspire-database
		System.out.println(con);
		
//3-	create statement
		Statement stmt=con.createStatement();
		
//4-	execute statements
		stmt.execute("insert into students values(1,'Suraj','JEE',42.3)");
	}
}
