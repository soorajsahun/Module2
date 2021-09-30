package hitmod2.day5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo4 {
	public static void main(String[] args) {
		JDBCDemo obj=JDBCDemo.getJDBCDemo();
//		obj.doOperationInsert();
//		obj.doOperationUpdate(0);
		obj.doOperationDelete(1);
	}
}
class JDBCDemo{
	//singleton pattern
	private JDBCDemo() {
		System.out.println("object created");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static JDBCDemo jdbcDemo;
	public static JDBCDemo getJDBCDemo() {
		if(jdbcDemo==null) {
			jdbcDemo=new JDBCDemo();
		}
		return jdbcDemo;
	}
	public void doOperationInsert() {
		Connection con=null;
		Statement stmt=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
			con.setAutoCommit(false);
			stmt=con.createStatement();//
//			String sql="insert into students values(sid,name,course,s_fees)";
			stmt.execute("insert into students values(1, 'RAHUL', 'eNGINEERING', 10.50)");
		} catch (Exception e) {
			e.printStackTrace();
			try {con.rollback();}catch(Exception ee) {ee.printStackTrace();}
		}
		finally {
			try {con.commit();con.close();stmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
		public void doOperationUpdate(float s_fees) {
			Connection con=null;
			Statement stmt=null;
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
				con.setAutoCommit(false);
				stmt=con.createStatement();//
				int noOfRowsUpadated=stmt.executeUpdate("update students set s_fess="+s_fees);
				System.out.println("noOfRowsUpadated "+noOfRowsUpadated);
			} catch (Exception e) {
				e.printStackTrace();
				try {con.rollback();}catch(Exception ee) {ee.printStackTrace();}
			}
			finally {
				try {con.commit();con.close();stmt.close();}catch(Exception e) {e.printStackTrace();}
			}
	}
		public void doOperationDelete(int sid) {
			Connection con=null;
			Statement stmt=null;
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
				con.setAutoCommit(false);
				stmt=con.createStatement();//
				int noOfRowsDeleted=stmt.executeUpdate("delete from students where s_id="+sid);
				System.out.println("noOfRowsDeleted"+noOfRowsDeleted);
			} catch (Exception e) {
				e.printStackTrace();
				try {con.rollback();}catch(Exception ee) {ee.printStackTrace();}
			}
			finally {
				try {con.commit();con.close();stmt.close();}catch(Exception e) {e.printStackTrace();}
			}
	}
}