package com.newstart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 类名: ConnectionUtil
 * 描述: 数据库的连接类。
 * 创建人: zhoujuan
 * 时间: 2016年2月27日 下午4:58:41
 * @version: V1.0
 */
public class ConnectionUtil {
     
	private static String url = "jdbc:mysql://127.0.0.1:3306/pcald";
	private static String username = "root";
	private static String password = "password";
	
	/**
	 * 
	 * 方法名: getConnection
	 * 描述: 数据库的连接方法。
	 * 创建人: zhoujuan
	 * 时间: 2016年2月27日 下午5:10:49
	 * @return
	 * @return: Connection
	 * @since: V1.0
	 */
	public static Connection getConnection(){
		    Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url,username,password);
				return connection;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
    
	/**
	 * findxxxxx()查询多条
	 * queryxxxx()查询多条
	 * getxxxxx()查询单条
	 * 方法名: findProvinces
	 * 描述: 查询省份。
	 * 创建人: zhoujuan
	 * 时间: 2016年2月27日 下午5:25:55
	 * @return
	 * @return: List<HashMap<String,Object>>
	 * @since: V1.0
	 */
	public static List<HashMap<String,Object>> findProvinces(){
		   Connection connection = null;
		   Statement statement = null;
		   ResultSet rs = null;
		   
		   String sql = "select province,id from tm_province";
		   connection = getConnection();
		   List<HashMap<String,Object>> maps = null;
		   try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			maps = new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> map = null;
			while(rs.next()){
				 map = new HashMap<String,Object>();
				 map.put("id", rs.getInt("id"));
				 map.put("province", rs.getString("province"));
				 maps.add(map);
			}
			return maps;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{				
				try {
					if(rs!=null) rs.close();
					if(statement!=null) statement.close();
					if(connection!=null) connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	/**
	 * 
	 * 方法名: findCitys
	 * 描述: 根据省份Id查询城市信息。
	 * 创建人: zhoujuan
	 * 时间: 2016年2月27日 下午6:31:58
	 * @return
	 * @return: List<HashMap<String,Object>>
	 * @since: V1.0
	 */
	public static List<HashMap<String,Object>> findCitys(int provinceId){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<HashMap<String,Object>> maps = null;		
		try {
			String sql = "select id,city from tm_city where province_id =?";
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1,provinceId);
			rs = statement.executeQuery();
			
			maps = new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> map = null;
			while(rs.next()){
				map = new HashMap<String,Object>();
				map.put("id", rs.getInt("id"));
				map.put("city", rs.getString("city"));
				maps.add(map);
			}
			return maps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{				
			try {
				if(rs!=null) rs.close();
				if(statement!=null) statement.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static List<HashMap<String,Object>> findArea(int cityId){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<HashMap<String,Object>> maps = null;		
		try {
			String sql = "select id,area from tm_area where city_id =?";
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1,cityId);
			rs = statement.executeQuery();
			
			maps = new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> map = null;
			while(rs.next()){
				map = new HashMap<String,Object>();
				map.put("id", rs.getInt("id"));
				map.put("area", rs.getString("area"));
				maps.add(map);
			}
			return maps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{				
			try {
				if(rs!=null) rs.close();
				if(statement!=null) statement.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
//		Connection con = getConnection();
//		System.out.println(con);

//		List<HashMap<String,Object>> maps = findProvinces();
//		for(HashMap<String,Object> hashmap:maps){
//			 System.out.println(hashmap.get("id")+"======"+hashmap.get("province"));
//		}

		List<HashMap<String,Object>> maps = findCitys(130000);
		for(HashMap<String,Object> hashmap:maps){
			 System.out.println(hashmap.get("id")+"======"+hashmap.get("city"));
		}		

//		List<HashMap<String,Object>> maps = findArea(110100);
//		for(HashMap<String,Object> hashmap:maps){
//			 System.out.println(hashmap.get("id")+"======"+hashmap.get("area"));
//		}		
	}
}
