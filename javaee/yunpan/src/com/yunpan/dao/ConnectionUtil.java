package com.yunpan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 类名: ConnectionUtil
 * 描述: 数据库连接的工具类。
 * 创建人: zhoujuan
 * 时间: 2016年3月12日 上午11:37:35
 * @version: V1.0
 */
public class ConnectionUtil {
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/yunpan","root","password");
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	public static void closeConnection(Connection connection){
		try {
			if(connection!=null)connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("资源关闭失败！！");
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
	
	public static void closeResultSet(ResultSet rs){
		try {
		   if(rs!=null)rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
