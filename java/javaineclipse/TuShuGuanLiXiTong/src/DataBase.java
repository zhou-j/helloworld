
import java.sql.*;
public class DataBase {
	public static void main(String[] args) {

		
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=myDatabase";
		String userName = "sa";
		String userPwd = "1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection ct = null;
		try {

			Class.forName(driverName);
			ct = DriverManager.getConnection(dbURL, userName, userPwd);
	
			ps = ct.prepareStatement("select * from book where BookNo=? or Author=?");
			ps.setInt(1,10001 );
			ps.setString(2, "王海亮");
			rs = ps.executeQuery();
			while (rs.next()) {// 
				int bianhao = rs.getInt(1);
				String mingcheng = rs.getString(2);
				String didian = rs.getString(3);
				System.out.println(bianhao + "    " + mingcheng + "    "
						+ didian);
			}
			/*ps = ct.prepareStatement("insert into bumen values(?,?,?)");
			ps.setInt(1, 7);
			ps.setString(2, "侦查");
			ps.setString(3, "山外");
			rs = ps.executeQuery("select * from bumen");*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (ct != null) {
					ct.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
