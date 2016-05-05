import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.newstart.CountMessageBean;
public class Message{
	public static List<CountMessageBean> getMessage()throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufr = new BufferedReader(new FileReader("D:\\fileread\\radwtmp"));
		String line = null;
	    List<CountMessageBean> beans = null; 
		beans = new ArrayList<CountMessageBean>();
		while ((line = bufr.readLine()) != null) {
			String[] s = line.toString().split("\\|");
			CountMessageBean messagebean = null;
			for (int i = 0; i < s.length; i++) {
				if(i%5==0){
				   messagebean = new CountMessageBean();
				   messagebean.setUsername(s[i]);
				   messagebean.setTerminator(s[i+1]);
				   messagebean.setTag(s[i+2]);
				   messagebean.setTime(s[i+3]);
				   messagebean.setIp(s[i+4]);
				   beans.add(messagebean);
				}
		    }
		}
		bufr.close();
		return beans;
	}
    
	public static boolean saveMessage(){
		try { 
			// 1.加载驱动 
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			// 2.得到连接 
			Connection ct = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jgs", "jgs"); 
			// 从下面开始，和SQL Server一模一样 
			Statement sm = ct.createStatement(); 
			ResultSet rs = sm.executeQuery("select * from t"); 
			while (rs.next()) { 
			//用户名 
			System.out.println("用户名： "+rs.getString(1)); 
			//默认是从1开始编号的 
			} 
			} catch (Exception e) { 
			   e.printStackTrace();
			   return false;
			}
		return true;
	}
	public static void main(String[] args) throws IOException {
      List<CountMessageBean> beans = getMessage();
		for(CountMessageBean messagebean : beans){
		    System.out.println(messagebean.getUsername());
		    System.out.println(messagebean.getTerminator());
		    System.out.println(messagebean.getTag());
		    System.out.println(messagebean.getTime());
		    System.out.println(messagebean.getIp());
			System.out.println("==================");
		};
		boolean flag = saveMessage();
		System.out.println(flag);
	}

}