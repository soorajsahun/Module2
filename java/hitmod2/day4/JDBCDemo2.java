package hitmod2.day4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JDBCDemo2 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire","root" ,"root" );
		System.out.println(con);
		
		DatabaseMetaData dmd=con.getMetaData();//meta=mother
		//DatabaseMetaData has all the information of database
		
		System.out.println("Product Name..:"+dmd.getDatabaseProductName());
		System.out.println("Product Version..:"+dmd.getDatabaseProductVersion());
		System.out.println(dmd.getDriverName());
		System.out.println(dmd.getDriverVersion());
		System.out.println(dmd.getDefaultTransactionIsolation());
		
		System.out.println(dmd.supportsTransactionIsolationLevel(12));
		System.out.println(dmd.supportsTransactionIsolationLevel(4));
		con.setTransactionIsolation(8);
		System.out.println("Default isolation level set...is..:"+dmd.getDefaultTransactionIsolation());
		System.out.println("Current isolation level...:"+con.getTransactionIsolation());;
		
		System.out.println(con.getAutoCommit());
		con.setAutoCommit(false);
		System.out.println(con.getAutoCommit());
	}
}
