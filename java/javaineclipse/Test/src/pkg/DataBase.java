package pkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DataBase 
{
	public static void main(String[] args)
	{
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=myDatabase";
		String userName="sa";
		String userPwd="1";
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    Connection ct=null;
	    try {
	    	  Class.forName(driverName);
	    	  ct=DriverManager.getConnection(dbURL,userName,userPwd);
			  ps=ct.prepareStatement("select * from bumen");
			  rs=ps.executeQuery();
			  while(rs.next())
			  {
				  int bianhao=rs.getInt(1);
				  String mingcheng=rs.getString(2);
				  String didian=rs.getString(3);
				  System.out.println(bianhao+"    "+mingcheng+"    "+didian);
			  }	
    		  ps=ct.prepareStatement("insert into bumen values(?,?,?)");
			  ps.setInt(1,7);     ps.setString(2,"’Ï≤È");   ps.setString(3,"…ΩÕ‚");
          	  rs=ps.executeQuery("select * from bumen");	
		} catch (Exception e){}
	    finally
	    {
	    	try {
	    		if(rs!=null)
				{
					rs.close();
				}
	    		if(ps!=null)
				{
					ps.close();
				}
				if(ct!=null)
				{
					ct.close();
				}
				
			} catch (Exception e){}
	    }
	}
}

