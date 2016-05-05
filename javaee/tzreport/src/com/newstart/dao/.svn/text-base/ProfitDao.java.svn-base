package com.newstart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.newstart.dao.core.ConnectionUtil;
import com.newstart.entity.ProfitBean;

/**
 * 
 * 类名: ProfitDao
 * 描述: 收入的业务处理类。
 * 创建人: zhoujuan
 * 时间: 2016年4月17日 下午12:02:04
 * @version: V1.0
 */
public class ProfitDao {
   
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
	public static List<ProfitBean> findProfits(Integer typeId,Integer maxMoney,Integer minMoney,Integer pageNo,Integer pageSize){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<ProfitBean> profitBeans = null;
		try{
			//查询的sql
			String sql = " SELECT p.*,c.name,u.username from tm_profit p,tm_profit_category c,tm_user u where p.type_id = c.id and p.user_id = u.id and p.is_delete = 0 ";
			if(typeId!=null){
				sql+=" AND p.type_id = "+typeId;
			}
			if(maxMoney!=null && minMoney !=null){
				sql+=" AND p.money between "+minMoney+" and "+maxMoney;
			}
			sql+=" order by p.create_time desc LIMIT ?,? ";//查询未删除的
			//获取数据库的连接
			connection = ConnectionUtil.getConnection();
			//处理块
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageNo);
			statement.setInt(2, pageSize);
			//返回数据查询的结果集
			rs = statement.executeQuery();
			//初始化集合
			profitBeans = new ArrayList<ProfitBean>();
			ProfitBean profitBean = null;
			while(rs.next()){
				profitBean = new ProfitBean();
				profitBean.setId(rs.getInt("id"));
				profitBean.setMoney(rs.getFloat("money"));
				profitBean.setIsDelete(rs.getInt("is_delete"));
				profitBean.setDescription(rs.getString("description"));
				profitBean.setUserId(rs.getInt("user_id"));
                profitBean.setUpdateTime(rs.getTimestamp("update_time"));
                profitBean.setCreateTime(rs.getTimestamp("create_time"));
				profitBean.setStatus(rs.getInt("status"));
				profitBean.setTypeId(rs.getInt("type_id"));
				profitBean.setTypeName(rs.getString("name"));
				profitBean.setUsername(rs.getString("username"));
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
	 * 方法名: findProfit
	 * 描述: 根据id查询一条记录。
	 * 创建人: zhoujuan
	 * 时间: 2016年4月24日 上午11:35:35
	 * @param id
	 * @return
	 * @return: ProfitBean
	 * @since: V1.0
	 */
	public static ProfitBean getProfitBean(Integer id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ProfitBean profitBean = null;
		try{
            String sql = "select * from tm_profit where id = ?";
			//获取数据库的连接
			connection = ConnectionUtil.getConnection();
			//处理块
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			//返回数据查询的结果集
			rs = statement.executeQuery();            
			if(rs.next()){
				profitBean = new ProfitBean();
				profitBean.setId(rs.getInt("id"));
				profitBean.setMoney(rs.getFloat("money"));
				profitBean.setIsDelete(rs.getInt("is_delete"));
				profitBean.setDescription(rs.getString("description"));
				profitBean.setUserId(rs.getInt("user_id"));
				profitBean.setUpdateTime(rs.getTimestamp("update_time"));
				profitBean.setCreateTime(rs.getTimestamp("create_time"));
				profitBean.setStatus(rs.getInt("status"));
				profitBean.setTypeId(rs.getInt("type_id"));
			}
			return profitBean;
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
	 * 方法名: countProfit
	 * 描述: 根据条件统计记录的总数。
	 * 创建人: zhoujuan
	 * 时间: 2016年4月24日 上午11:27:32
	 * @param typeId
	 * @param maxMoney
	 * @param minMoney
	 * @return
	 * @return: int
	 * @since: V1.0
	 */
	public static int countProfit(Integer typeId,Integer maxMoney,Integer minMoney){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int count = 0;
		try {
			String sql = "SELECT count(1) from tm_profit p,tm_profit_category c,tm_user u where p.type_id = c.id and p.user_id = u.id and p.is_delete = 0 ";
			if(typeId!=null){
				sql+=" AND p.type_id = "+typeId;
			}	
			if(maxMoney!=null && minMoney !=null){
				sql+=" AND p.money between "+minMoney+" and "+maxMoney;
			}			
			//获取数据库的连接
			connection = ConnectionUtil.getConnection();
			//处理块
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			if(rs.next())count = rs.getInt(1);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return count;
		}finally{
			ConnectionUtil.closeResultSet(rs);
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);			
		}
		
	}
	/**
	 * 
	 * 方法名: updateProfit
	 * 描述: 更新收入状态.
	 * 创建人: zhoujuan
	 * 时间: 2016年4月19日 下午7:27:18
	 * @param isDelete
	 * @param id
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static boolean updateProfit(Integer isDelete,Integer id){
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			//查询的sql
			String sql = "update tm_profit set is_delete = ? where id = ?";//查询删除的
			//获取数据库的连接
			connection = ConnectionUtil.getConnection();
			//处理块
			statement = connection.prepareStatement(sql);
			statement.setInt(1, isDelete);
			statement.setInt(2, id);
			//返回数据查询的结果集
			int count = statement.executeUpdate();
			return count>0 ? true:false;
		}catch(SQLException eq){
			eq.printStackTrace();
			return false;
		}finally{
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}		
	}
	
	/**
	 * 
	 * 方法名: saveProfit
	 * 描述: 保存收入记录。
	 * 创建人: zhoujuan
	 * 时间: 2016年4月22日 下午1:50:54
	 * @param profit
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static boolean saveProfit(ProfitBean profit){
		String sql = "insert into tm_profit (money,description,user_id,is_delete,status,type_id)VALUES(?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setFloat(1, profit.getMoney());
			statement.setString(2, profit.getDescription());
			statement.setInt(3, profit.getUserId());
			statement.setInt(4, profit.getIsDelete());
			statement.setInt(5, profit.getStatus());
			statement.setInt(6,profit.getTypeId());
			int count = statement.executeUpdate();
			return count>0 ? true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}
		
	}
    
	/**
	 * 
	 * 方法名: updateProfit
	 * 描述: 更新收入记录。
	 * 创建人: zhoujuan
	 * 时间: 2016年4月24日 下午12:07:27
	 * @param profit
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static boolean updateProfit(ProfitBean profit){
		String sql = "UPDATE tm_profit SET money = ?,description = ?,type_id = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setFloat(1, profit.getMoney());
			statement.setString(2, profit.getDescription());
			statement.setInt(3, profit.getTypeId());
			statement.setInt(4, profit.getId());
			int count = statement.executeUpdate();
			return count>0 ? true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}
		
	}
	
	/**
	 * 
	 * 方法名: findProfitTypes
	 * 描述: 查询收入类型。
	 * 创建人: zhoujuan
	 * 时间: 2016年4月22日 下午1:50:30
	 * @return
	 * @return: List<HashMap<String,Object>>
	 * @since: V1.0
	 */
	public static List<HashMap<String,Object>> findProfitTypes(){
		String sql = "select * from tm_profit_category where is_delete = 0 ORDER BY sort";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> profitTypes = null;
		try {
			connection  = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			profitTypes = new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> profitType = null;
			while(rs.next()){
				profitType = new HashMap<String,Object>();
				profitType.put("id", rs.getInt("id"));
				profitType.put("name", rs.getString("name"));
				profitType.put("createTime", rs.getTimestamp("create_time"));
                profitType.put("status", rs.getInt("status"));
				profitType.put("isDelete", rs.getInt("is_delete"));
				profitTypes.add(profitType);
			}
			return profitTypes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			ConnectionUtil.closeResultSet(rs);
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}
	}
	public static void main(String[] args) {
//	   List<ProfitBean> profitBeans = findProfits(0,5);
//	   for(ProfitBean profitbean : profitBeans){
//		   System.out.print(profitbean.getCreateTime());
//		   System.out.print(profitbean.getDescription());
//		   System.out.print(profitbean.getId());
//		   System.out.print(profitbean.getIsDelete());
//		   System.out.print(profitbean.getMoney());
//		   System.out.print(profitbean.getStatus());
//		   System.out.print(profitbean.getTypeId());
//		   System.out.print(profitbean.getUpdateTime());
//		   System.out.print(profitbean.getUserId());
//		   System.out.print(profitbean.getTypeName());
//		   System.out.print(profitbean.getUsername());
//		   System.out.println("========================");
//	   }
		
//	   boolean flag = updateProfit(1,2);
//	   System.out.println(flag);

//		List<HashMap<String,Object>> profits = findProfitTypes();
//		for(HashMap<String,Object> profit : profits){
//			System.out.println(profit.get("id"));
//			System.out.println(profit.get("name"));
//			System.out.println(profit.get("createTime"));
//			System.out.println(profit.get("status"));
//			System.out.println(profit.get("isDelete"));
//			System.out.println("=======================");
//		}
		
//		ProfitBean profit = new ProfitBean();
//		profit.setMoney((float) 10000.0);
//		profit.setDescription("sdfkjs dlkfjs");
//		profit.setUserId(1);
//        profit.setStatus(1);
//		profit.setIsDelete(0);
//		profit.setTypeId(2);
//		boolean flag = saveProfit(profit);
//		System.out.println(flag);

//		System.out.println(countProfit());
	}
}
