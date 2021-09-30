package hitmod2.day5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDemo5 {
	public static void main(String[] args) {
		JDBCDemoo obj=JDBCDemoo.getJdbcDemoo();
		obj.doOperationInsertDynamic(3, "Nimesh", "Mechanical", 55);
////		obj.doOperationUpdateDynamic(20);
//		obj.doOperationDeleteDynamic(10);
	}
}
class JDBCDemoo{
	private JDBCDemoo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static JDBCDemoo jdbcDemoo;
	public static JDBCDemoo getJdbcDemoo() {
		if(jdbcDemoo==null) {
			jdbcDemoo=new JDBCDemoo();
		}
		return jdbcDemoo;
	}
	public void doOperationInsertDynamic(int sid,String name,String course,float s_fees) {
		Connection con=null;
		PreparedStatement stmt=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
			con.setAutoCommit(false);
			stmt=con.prepareStatement("insert into students values(?,?,?,?)");
			stmt.setInt(1, sid);
			stmt.setString(2, name);
			stmt.setString(3, course);
			stmt.setFloat(4, s_fees);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			try {con.rollback();}catch(Exception ee) {ee.printStackTrace();}
		}
		finally {
			try {con.commit();con.close();stmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
	public void doOperationDeleteDynamic(int sid) {
		Connection con=null;
		PreparedStatement stmt=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
			con.setAutoCommit(false);
			stmt=con.prepareStatement("delete from students where s_id=?");
			stmt.setInt(1, sid);
			int noOfRowsDeleted=stmt.executeUpdate();
			System.out.println("noOfRowsDeleted "+noOfRowsDeleted);
		} catch (Exception e) {
			e.printStackTrace();
			try {con.rollback();}catch(Exception ee) {ee.printStackTrace();}
		}
		finally {
			try {con.commit();con.close();stmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
	public void doOperationUpdateDynamic(float s_fees) {
		Connection con=null;
		PreparedStatement stmt=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aspire", "root", "root");
			con.setAutoCommit(false);
			stmt=con.prepareStatement("update students set s_fess=?");
			stmt.setFloat(1, s_fees);
			int noOfRowsUpdated=stmt.executeUpdate();
			System.out.println("noOfRowsUpdated "+noOfRowsUpdated);
		} catch (Exception e) {
			e.printStackTrace();
			try {con.rollback();}catch(Exception ee) {ee.printStackTrace();}
		}
		finally {
			try {con.commit();con.close();stmt.close();}catch(Exception e) {e.printStackTrace();}
		}
	}
}