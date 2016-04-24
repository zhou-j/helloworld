package pkg;
import java.sql.*;

public class student
{
	public static void main(String[] args)
	{
		    Connection con=null;
			String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		    String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Test";
		    String userName="sa";
		    String userPwd="1";
	 try
	 {
		    Class.forName(driverName);
		    con=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement stat=con.createStatement();
			int count=stat.executeUpdate("insert into student values('200801','tom','23','123456789')");
			System.out.println("成功插入了"+count+"条记录！！！");
			ResultSet rs=stat.executeQuery("select * from student");
			System.out.println("学号  \t姓名 \t\t年龄\t电话");
			while(rs.next())
			{
				String sid=rs.getString(1);
				String sname=rs.getString(2);
				String sage=rs.getString(3);
				String stel=rs.getString(4);
				System.out.println(sid+""+sname+""+sage+""+stel);
				
			}
			rs.close();
			stat.close();
			
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {
		 try
		 {
			 con.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
		
  }
}