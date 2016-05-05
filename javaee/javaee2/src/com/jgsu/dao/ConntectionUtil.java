package com.jgsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 类名: ConntectionUtil
 * 描述: 数据库的连接类
 * 创建人: zhoujuan
 * 时间: 2016年3月11日 下午7:57:20
 * @version: V1.0
 */
public class ConntectionUtil {
	public static Connection getConection(String driver,String url,String user,String password){
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public static List<HashMap<String,Object>> findProducts(String driver,String url,String user,String password){
		String sql = "select name,price,pnumber from products";
		Statement statement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<HashMap<String,Object>> maps =null;
		try {
			maps = new ArrayList<HashMap<String,Object>>();
			connection = getConection(driver,url,user,password);
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			HashMap<String,Object> map = null;
			while(rs.next()){
				map = new HashMap<String,Object>();
				map.put("name", rs.getString("name"));
				map.put("price", rs.getInt("price"));
				map.put("pnumber", rs.getString("pnumber"));
				maps.add(map);
			}
		    return maps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}finally{
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
	     List<HashMap<String,Object>> maps = new ArrayList<HashMap<String,Object>>();
	     maps = findProducts("com.mysql.jdbc.Driver","jdbc:mysql://127.0.0.1:3306/northwind","root","password");
	     for(HashMap<String,Object> map:maps){
	    	 System.out.println(map.get("name"));
	    	 System.out.println(map.get("price"));
	    	 System.out.println(map.get("pnumber"));
	    	 System.out.println("=================");
	     }
	}
}
