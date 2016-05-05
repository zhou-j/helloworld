package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Content;

/**
 * 
 * 类名: ContentDao
 * 描述: 保存数据层ContentDao
 * 创建人: zhoujuan
 * 时间: 2016年3月2日 下午11:46:30
 * @version: V1.0
 */
public class ContentDao {
	
	//第一种：没有页面的情况下：你自己开始去模拟业务。
	/**
	 * 
	 * 方法名: saveContent
	 * 描述: 保存内容
	 * 创建人: zhoujuan
	 * 时间: 2016年3月4日 下午3:31:51
	 * @param content
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static boolean saveContent(Content content){
		String sql = "insert into bg_content(title,content,updatetime,status,is_delete,user_id,tag) values(?,?,?,?,?,?,?)";
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;	    
    	try {
    		connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,content.getTitle());
			preparedStatement.setString(2,content.getContent());
			preparedStatement.setString(3,"2010-12-12 12:12:12");
			preparedStatement.setInt(4,content.getStatus());
			preparedStatement.setInt(5,content.getIsDelete());
			preparedStatement.setInt(6,content.getUserId());
			preparedStatement.setString(7,content.getTags());
			int count = preparedStatement.executeUpdate();
			return count>0? true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		    return false;
		}finally{
		   ConnectionUtil.closeStatement(preparedStatement);
		   ConnectionUtil.closeConnection(connection);
		}    
	}
	
	public static List<Content> findContent(int begain,int end,String sort){
		String sql = "select * from bg_content order by createtime "+sort+" limit ?,?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Content> contents = null;
		Content content = null;
    	try {
    		connection = ConnectionUtil.getConnection();
    		statement = connection.prepareStatement(sql);
    		statement.setInt(1, begain);
    		statement.setInt(2, end);
    		rs = statement.executeQuery();
    		contents = new ArrayList<Content>();
            while(rs.next()){
        		content = new Content();
        		content.setId(rs.getInt("id"));
        		content.setContent(rs.getString("content"));
        		content.setTitle(rs.getString("title"));
        		content.setUpdateTime(rs.getTimestamp("updatetime"));
        		content.setCreateTime(rs.getTimestamp("createtime"));
        		content.setStatus(rs.getInt("status"));
        		content.setIsDelete(rs.getInt("is_delete"));
        		content.setUserId(rs.getInt("user_id"));
        		content.setTags(rs.getString("tag"));
        		contents.add(content);            	
            }
    		return contents;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		    return null;
		}finally{
		   ConnectionUtil.closeResultSet(rs);
		   ConnectionUtil.closeStatement(statement);
		   ConnectionUtil.closeConnection(connection);
		}			
	}
	
	/**
	 * 
	 * 方法名: deleteContent
	 * 描述: 根据帖子id删除内容
	 * 创建人: zhoujuan
	 * 时间: 2016年3月6日 下午11:28:41
	 * @param id
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static boolean deleteContent(Integer id){
		String sql = "delete from bg_content where id =?";
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;	    
    	try {
    		connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int count = preparedStatement.executeUpdate();
			return count>0? true:false;
		} catch (SQLException e) {
			return false;
		}finally{
		   ConnectionUtil.closeStatement(preparedStatement);
		   ConnectionUtil.closeConnection(connection);
		}    

	}
	public static void main(String[] args) {
/*		Content content = new Content();
		content.setTitle("223啥地方见是开发1111");
		content.setContent("222发送到方法2");
		content.setStatus(1);
		content.setIsDelete(0);
		content.setUserId(1);
		content.setTags("人的得到");
		boolean flag = saveContent(content);
		if(flag){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}*/
		
/*		List<Content> contents = findContent(1,2,"asc");
		for(Content content:contents){
			System.out.println(content.getContent());
			System.out.println(content.getTags());
			System.out.println(content.getTitle());
			System.out.println(content.getCreateTime());
			System.out.println(content.getId());
			System.out.println(content.getStatus());
			System.out.println(content.getUserId());
			System.out.println("========================");
		}*/
		
		System.out.println(deleteContent(8));
	}

}
