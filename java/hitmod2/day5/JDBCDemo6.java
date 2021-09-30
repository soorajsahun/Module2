package hitmod2.day5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCDemo6 {
	public static void main(String[] args) {
		ReadJDBCDemo obj=ReadJDBCDemo.getReadJDBCDemo();
		obj.queryTable();
//		obj.queryTableDynamic(2);
	}
}
class ReadJDBCDemo{
	private ReadJDBCDemo() {
		try {
			getClass().forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static ReadJDBCDemo jdbcDemo;
	public static ReadJDBCDemo getReadJDBCDemo() {
		if(jdbcDemo==null) {
			jdbcDemo=new ReadJDBCDemo();
		}
		return jdbcDemo;
	}
	public void queryTable() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from students");
			
//			while(rs.next()) {
//				System.out.println("Students id..."+rs.getInt(1));
//				System.out.println("Students name..."+rs.getString(2));
//				System.out.println("Students course..."+rs.getString(3));
//				System.out.println("Students fees..."+rs.getFloat(4));
				
				//Column name can also be given
//				System.out.println("Students id..."+rs.getInt("s_id")); 
//				System.out.println("Students name..."+rs.getString("s_name"));
//				System.out.println("Students course..."+rs.getString("s_course"));
//				System.out.println("Students fees..."+rs.getFloat("s_fess"));
				
//			}
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int numberOfColumns=rsmd.getColumnCount();
			System.out.println("Number of columns..."+numberOfColumns);
			
			for(int i=1;i<=numberOfColumns;i++) {
				System.out.print(rsmd.getColumnName(i)+"\t\t"+"|");//String can fetch all int,float,String
			}
			System.out.println();
			System.out.println("___________________________________________________________________________");
			while(rs.next()) {
				for(int i=1;i<=numberOfColumns;i++) {
					System.out.print(rs.getString(i)+"\t\t"+"|");//String can fetch all int,float,String
				}
			System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {rs.close();con.close();stmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
	public void queryTableDynamic(int sid) {
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
			stmt=con.prepareStatement("select * from students where s_id=?");
			stmt.setInt(1, sid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				System.out.println("Students id..."+rs.getInt(1));
				System.out.println("Students name..."+rs.getString(2));
				System.out.println("Students course..."+rs.getString(3));
				System.out.println("Students fees..."+rs.getFloat(4));
				
				//Column name can also be given
//				System.out.println("Students id..."+rs.getInt("s_id"));
//				System.out.println("Students id..."+rs.getString("s_name"));
//				System.out.println("Students id..."+rs.getString("s_course"));
//				System.out.println("Students id..."+rs.getFloat("s_fess"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {rs.close();con.close();stmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
}
