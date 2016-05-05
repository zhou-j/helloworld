package com.tanzhou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * 
 * 类名: ConnectUtil
 * 描述: 数据库的连接类。
 * 创建人: zhoujuan
 * 时间: 2016年2月11日 下午6:14:02
 * @version: V1.0
 */

public class ConnectUtil {
	/**
	 * 
	 * 方法名: getConnection
	 * 描述: 连接数据库的方法。
	 * 创建人: zhoujuan
	 * 时间: 2016年2月11日 下午7:26:28
	 * @return
	 * @return: Connection
	 * @since: V1.0
	 */
	//DriverManager.getConnection(jdbc:mysql://ip地址:端口号/数据库名,数据库的用户名,数据库的密码)	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/book","root","password");
	        return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
    
	/**
	 * 
	 * 方法名: findUser
	 * 描述: 根据用户名和
	 * 创建人: zhoujuan
	 * 时间: 2016年2月11日 下午8:06:37
	 * @param account
	 * @param password
	 * @return
	 * @return: HashMap<String,Object>
	 * @since: V1.0
	 */
	public static HashMap<String,Object> findUser(String account,String password){
		String sql = "select * from tm_user where account = '"+account+"' AND password = '"+password+"'";
	    Connection connection = getConnection();//获取连接对象
	    Statement statement = null;//处理块，缓冲区
	    ResultSet rs = null;
	    HashMap<String,Object> hashMap = null;
	    try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if(rs.next()){
				hashMap = new HashMap<String, Object>();
				hashMap.put("id",rs.getInt("id"));
				hashMap.put("account",rs.getString("account"));
				hashMap.put("password",rs.getString("password"));
				hashMap.put("nickname",rs.getString("nickname"));
				hashMap.put("headerPic",rs.getString("headerpic"));
				hashMap.put("age",rs.getInt("age"));
				hashMap.put("male",rs.getInt("male"));
				hashMap.put("createtime",rs.getTimestamp("createtime"));
				hashMap.put("email",rs.getString("email"));
				hashMap.put("address",rs.getString("address"));
				hashMap.put("description",rs.getString("description"));
				hashMap.put("telephone",rs.getString("telephone"));
				hashMap.put("birthday",rs.getDate("birthday"));
/*				System.out.println(rs.getString("account"));
				System.out.println(rs.getString("password"));
				System.out.println(rs.getString("nickname"));*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	
		}finally{
			try {
				rs.close();
				statement.close();
				connection.close();
				System.out.println("资源已经关闭！！！");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	    return hashMap;
	}
	
	public static boolean getUserExist(String username,String password){
	    String sql = "select count(1) from tm_user where account = '"+username+"' and password = '"+password+"'";
	    //1:获取连接对象
	    Connection connection = null;
	    //2:获取处理对象
	    Statement statement = null;   
	    ResultSet rs = null;
	    try {
	    	connection = getConnection();
			statement = connection.createStatement();
			//3:获取结果集 select ===executeQuery update insert delete ===executeupdate
             rs = statement.executeQuery(sql);
			//4:解析出结果集,如果你确保你的结果集放后的是唯一的一条数据，你用if
			//肯定结果集有多条的情况,一般都使用我们的集合作为返回值类型List
//			while(rs.next()){
//				
//			}
			int count = 0;
			if(rs.next()){//游标
				count = rs.getInt(1);
			}
			return count > 0? true :false;
		} catch (SQLException e) {
             return false;
		}finally{
			//5:关闭连接对象:后打开的先关闭，先打开的后关闭。
             try {
				if(rs!=null)rs.close();
				if(statement!=null)statement.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		
	}
	public static void main(String[] args) {
	   findUser("shanchen","123456");
	}  
}
