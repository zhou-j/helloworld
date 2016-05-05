package com.tanzhou.dao.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.taglibs.standard.tag.common.sql.ResultImpl;

import com.tanzhou.dao.ConnectUtil;


/**
 * 
 * 类名: CommentDao
 * 描述: 评论业务
 * 创建人: zhoujuan
 * 时间: 2016年2月21日 下午11:05:28
 * @version: V1.0
 */
public class CommentDao {
	
  public static HashMap<String,Object> getLog(int id,int userId){
	      String sql  = "SELECT * FROM tm_log WHERE id = "+id+" and user_id="+userId;
          Connection connection = null;
		  java.sql.Statement statement = null;		  
		  ResultSet rs = null;
		  HashMap<String,Object> map = null;
		  try {
			  connection = ConnectUtil.getConnection();
			  statement = connection.createStatement();
			  rs = statement.executeQuery(sql);
			   if(rs.next()){
				   map = new HashMap<String,Object>();
				   map.put("id",rs.getInt("id"));
				   map.put("title",rs.getString("title"));
				   map.put("content",rs.getString("content"));
				   map.put("createtime",rs.getTimestamp("createtime"));
				   map.put("updatetime",rs.getString("updatetime"));
				   map.put("userId",rs.getInt("user_id"));
			   }
			   return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
				try {
					//关闭所有的处理。
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
   * 方法名: saveCommentLog
   * 描述: 插入评论日志。
   * 创建人: zhoujuan
   * 时间: 2016年2月24日 下午2:51:11
   * @param content
   * @param userId
   * @param logId
   * @return
   * @return: boolean
   * @since: V1.0
   */
  public static boolean saveCommentLog(String content,int userId,int logId){
	  Connection  connection = null;
	  PreparedStatement preparedStatement = null;
	  ResultSet rs = null;
	  try {
    	String sql = "insert into tm_comment_log(content,user_id,log_id) values(?,?,?)";
	    connection = ConnectUtil.getConnection();
		preparedStatement = connection.prepareStatement(sql);//预处理块，数据库的安全，防止SQL注入。
		preparedStatement.setString(1, content);
		preparedStatement.setInt(2, userId);
		preparedStatement.setInt(3, logId);
		int count = preparedStatement.executeUpdate();
		return count > 0 ? true:false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}finally{
		try {
			if(preparedStatement!=null);preparedStatement.close();
			if(connection!=null) connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
  } 
    /**
     * 
     * 方法名: findCommentLogs
     * 描述: 查询评论日志信息。
     * 创建人: zhoujuan
     * 时间: 2016年2月25日 下午6:59:00
     * @param logId
     * @return
     * @return: List<HashMap<String,Object>>
     * @since: V1.0
     */
	public static List<HashMap<String, Object>> findCommentLogs(int logId){
		//第一步在工具类里去执行一个有效的查询语句
		String sql = "select * from tm_comment_log where log_id ="+ logId;
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
				map.put("content",rs.getString("content"));
				map.put("createtime",rs.getInt("createtime"));
				map.put("updatetime",rs.getInt("updatetime"));
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
  
  //1:评论日记
  //2:写保存评论的插入语句
  //3:通过Ajax将用户内容传入到CommentSaveServlet;
  //4:调用保存日记的方法。
  //5:附加数据:<div id ="box"></div>
  public static void main(String[] args) {
//       saveCommentLog("即发生了看到发士大夫 ",1,4);
//	 HashMap<String,Object> map = new HashMap<String,Object>();
//	 map = getLog(1,1);
//	 System.out.println(map.get("title"));
	  List<HashMap<String,Object>> maps = findCommentLogs(1);
	  for (HashMap<String, Object> hashMap : maps) {
	      System.out.println(hashMap.get("content"));
	  }
  }
}	
