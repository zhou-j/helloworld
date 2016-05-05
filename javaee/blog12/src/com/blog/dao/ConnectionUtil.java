package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * 类名: ConnectionUtil
 * 描述: 数据库连接类。
 * 创建人: zhoujuan
 * 时间: 2016年3月2日 下午9:52:49
 * @version: V1.0
 */
public class ConnectionUtil {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/blog";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "password";
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public static void closeStatement(PreparedStatement statement){		
			try {
				if(statement!=null) statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void closeConnection(Connection connection){		
		try {
			if(connection!=null) connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void closeResultSet(ResultSet rs){
			try {
		    	if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	//第二种：有页面的情况。
	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection);
	}
}
