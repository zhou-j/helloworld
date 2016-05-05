package com.newstart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.newstart.dao.core.ConnectionUtil;
import com.newstart.entity.ProfitBean;

/**
 * 
 * 类名: ProfitStatDao
 * 描述: 统计报表业务类。
 * 创建人: zhoujuan
 * 时间: 2016年4月26日 上午11:05:17
 * @version: V1.0
 */
public class ProfitStatDao {
   
	/**
	 * 
	 * 方法名: findProfits
	 * 描述: 查找profits的方法
	 * 创建人: zhoujuan
	 * 时间: 2016年4月17日 下午1:46:18
	 * @return
	 * @return: List<ProfitBean>
	 * @since: V1.0
	 */
	public static List<ProfitBean> findDetailProfits(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<ProfitBean> profitBeans = null;
		try{
			//查询的sql
			String sql = " select id,money,description,create_time from tm_profit where DATE_FORMAT(create_time,'%Y-%m-%d') = DATE_FORMAT(NOW(),'%Y-%m-%d') AND is_delete=0 ORDER BY money desc LIMIT 0,20 ";
			//获取数据库的连接
			connection = ConnectionUtil.getConnection();
			//处理块
			statement = connection.prepareStatement(sql);
			//返回数据查询的结果集
			rs = statement.executeQuery();
			//初始化集合
			profitBeans = new ArrayList<ProfitBean>();
			ProfitBean profitBean = null;
			while(rs.next()){
				profitBean = new ProfitBean();
				profitBean.setId(rs.getInt("id"));
				profitBean.setMoney(rs.getFloat("money"));
				profitBean.setDescription(rs.getString("description"));
                profitBean.setCreateTime(rs.getTimestamp("create_time"));
				profitBeans.add(profitBean);
			}
			return profitBeans;
		}catch(SQLException eq){
			eq.printStackTrace();
			return null;
		}finally{
			ConnectionUtil.closeResultSet(rs);
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}
	}
	/**
	 * 
	 * 方法名: findProfitsByYear
	 * 描述: 根据类型和年份查询收入记录。
	 * 创建人: zhoujuan
	 * 时间: 2016年4月26日 下午7:44:19
	 * @return
	 * @return: List<ProfitBean>
	 * @since: V1.0
	 */
	public static HashMap<String,Object> findProfitsByType(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try{
			//查询的sql
			String sql = " SELECT DATE_FORMAT(create_time,'%m'),SUM(money),type_id FROM tm_profit WHERE is_delete = 0 AND DATE_FORMAT(create_time,'%Y') = DATE_FORMAT(NOW(),'%Y')  GROUP BY DATE_FORMAT(create_time,'%m'),type_id; ";
			//获取数据库的连接
			connection = ConnectionUtil.getConnection();
			//处理块
			statement = connection.prepareStatement(sql);
			//返回数据查询的结果集
			rs = statement.executeQuery();
			HashMap<String,Object> map = null;
			//初始化集合
			map = new HashMap<String,Object>();
			while(rs.next()){
				map.put(rs.getInt(1)+"_"+rs.getInt(3), rs.getString(2));
			}
			return map;
		}catch(SQLException eq){
			eq.printStackTrace();
			return null;
		}finally{
			ConnectionUtil.closeResultSet(rs);
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}
	}

	/**
	 * 
	 * 方法名: findProfitsByYear
	 * 描述: 查询收入记录通过年份。
	 * 创建人: zhoujuan
	 * 时间: 2016年4月26日 下午7:44:19
	 * @return
	 * @return: List<ProfitBean>
	 * @since: V1.0
	 */
	public static HashMap<Integer,Object> findProfitsByYear(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		HashMap<Integer,Object> map= null;
		try{
			//查询的sql
			String sql = " SELECT DATE_FORMAT(create_time,'%m'),SUM(money),create_time FROM tm_profit WHERE is_delete = 0 and DATE_FORMAT(create_time,'%Y') = DATE_FORMAT(NOW(),'%Y') GROUP BY DATE_FORMAT(create_time,'%m') ORDER BY create_time ASC ";
			//获取数据库的连接
			connection = ConnectionUtil.getConnection();
			//处理块
			statement = connection.prepareStatement(sql);
			//返回数据查询的结果集
			rs = statement.executeQuery();
			//初始化集合
			map = new HashMap<Integer,Object>();
			while(rs.next()){
				map.put(rs.getInt(1), rs.getInt(2));
			}
			return map;
		}catch(SQLException eq){
			eq.printStackTrace();
			return null;
		}finally{
			ConnectionUtil.closeResultSet(rs);
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}
	}
	
    public static void main(String[] args) {
//		HashMap<Integer,Object> map = findProfitsByYear();
//		TreeMap<Integer,Object> treeMap = new TreeMap<Integer,Object>();
//		for(int i=1; i<=12; i++){
//		    Object value = map.get(i);
//		    treeMap.put(i,value==null?0:value);
//		}
//		for(Map.Entry<Integer, Object> entry : treeMap.entrySet()){
//			System.out.println(entry.getKey()+"==="+entry.getValue());
//		}
	    HashMap<String,Object> hashMap = findProfitsByType();
	    HashMap<String,Object> map =new HashMap<String,Object>();
	    for(Map.Entry<String, Object> entry: hashMap.entrySet()){
	    	//System.out.println(entry.getKey()+"==="+entry.getValue());
	    	String[] keys = entry.getKey().split("_");
	    	//获取类型
	    	String type = keys[1];
	    	if(map.get(type)==null){	    		
	    		//定义一个map补齐月份
	    		List<HashMap<Integer,Object>> maps = new ArrayList<HashMap<Integer,Object>>();
	    		HashMap<Integer,Object> mmap = null;
	    		for(int i=1;i<=12;i++){
	    			mmap = new HashMap<Integer,Object>();
	    			Object value = hashMap.get(i+"_"+type);
	    			mmap.put(i,value==null ? 0:value);
	    			maps.add(mmap);
	    		}
	    		map.put(type,maps);
	    	}
	    }
	    System.out.println(map);
	}
    	
}
