package com.tanzhou.log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tanzhou.dao.ConnectUtil;

/**
 * 
 * 类名: TmLogDao
 * 描述: 查询日记信息
 * 创建人: zhoujuan
 * 时间: 2016年2月19日 下午4:02:42
 * @version: V1.0
 */
public class TmLogDao {

	//1:查询用户发表的日记;
    	
	/*
	 * 1:确认用户需求查询用户发表的日记。
	 * 2:建立数据库的连接类ConnectionUtil.java引入mysql的驱动包。
	 * 3:建立一个BookServlet类在web.xml中进行注册。
	 * 4:在BookServlet中调用查询用户发表的日记findLogs()
	 * 5:将查询出来的信息放入到作用域中request.setAttribute()
	 * 6:定义一个book.jsp解析请求中存放在作用域的值。*/
	
	//查询用户发表的日记
	public static List<HashMap<String, Object>> findLogs(int userId){
		//第一步在工具类里去执行一个有效的查询语句
		String sql = "select * from tm_user where id ="+userId;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<HashMap<String,Object>> maps = null;
		try{
			maps = new ArrayList<HashMap<String,Object>>();
			connection = ConnectUtil.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			HashMap<String,Object> map = null;
			while(rs.next()){
				map = new HashMap<String,Object>();
  				//再结果集返回的时候，列返回的索引是从1开始。
				map.put("id",rs.getInt("id"));
				map.put("account",rs.getString("account"));
				map.put("nickname",rs.getString("nickname"));
				map.put("createtime",rs.getInt("createtime"));
				map.put("updatetime",rs.getInt("updatetime"));
				map.put("headerpic",rs.getString("headerpic"));
				map.put("description",rs.getString("description"));
				maps.add(map);
			}
			return maps;
		}catch(SQLException ex){
            ex.printStackTrace();
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
	
	public static void main( String[] args){
		 List<HashMap<String,Object>> maps = findLogs(1);
		 for (HashMap<String,Object> Hashmap:maps){
			 System.out.println(Hashmap.get("id"));
			 System.out.println(Hashmap.get("account"));
			 System.out.println(Hashmap.get("nickname"));
			 System.out.println(Hashmap.get("updatetime"));
			 System.out.println(Hashmap.get("createtime"));
			 System.out.println(Hashmap.get("headerpic"));
			 System.out.println(Hashmap.get("description"));
			 System.out.println("=================");	
		 }
	}
}
