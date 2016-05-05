package com.blog.dao.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Content;
import com.blog.dao.ConnectionUtil;
import com.blog.util.TmDateUtil;

/**
 * 
 * 内存数据层 ContentDao<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2014年11月9日-下午10:59:13 <BR>
 * // 1:第一种情况:没有页面的情况:你自己开始去模拟业务
 * 
 * @version 1.0.0
 * 
 */
public class ContentDao {

	/**
	 * 保存内容 方法名：saveContent<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月9日-下午11:04:57 <BR>
	 * 
	 * @param content
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static boolean saveContent(Content content) {
		String sql = "INSERT INTO bg_content(title,content,updatetime,status,is_delete,user_id,tag)  VALUES (?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, content.getTitle());
			preparedStatement.setString(2, content.getContent());
			preparedStatement.setString(3, "2010-12-12 12:12:12");
			preparedStatement.setInt(4, content.getStatus());
			preparedStatement.setInt(5, content.getIsDelete());
			preparedStatement.setInt(6, content.getUserId());
			preparedStatement.setString(7, content.getTags());
			int count = preparedStatement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		} finally {
			ConnectionUtil.closeStatement(preparedStatement);
			ConnectionUtil.closeConnection(connection);
		}
	}
	
	/**
	 * 根据帖子ID删除帖子信息
	 * 方法名：deleteContent<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月16日-上午12:30:31 <BR>
	 * @param id
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static boolean deleteContent(Integer id) {
		String sql = "delete from bg_content WHERE id =?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int count = preparedStatement.executeUpdate();
			return count > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		} finally {
			ConnectionUtil.closeStatement(preparedStatement);
			ConnectionUtil.closeConnection(connection);
		}
	}

	/**
	 * 查询内容 方法名：findContents<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月11日-下午11:05:55 <BR>
	 * 
	 * @return List<?><BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static List<Content> findContents(int pageNo, int pageSize,
			String sortFlag) {
		String sql = "SELECT * FROM bg_content order by createtime " + sortFlag
				+ " LIMIT ? ,?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Content> contents = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, pageNo);
			preparedStatement.setInt(2, pageSize);
			rs = preparedStatement.executeQuery();
			contents = new ArrayList<Content>();
			Content content = null;
			while (rs.next()) {
				content = new Content();
				content.setId(rs.getInt("id"));
				content.setTitle(rs.getString("title"));
				content.setContent(rs.getString("content"));
				content.setCreateTime(rs.getTimestamp("createtime"));
				content.setUpdateTime(rs.getTimestamp("updatetime"));
				content.setStatus(rs.getInt("status"));
				content.setIsDelete(rs.getInt("is_delete"));
				content.setUserId(rs.getInt("user_id"));
				content.setTags(rs.getString("tag"));
				contents.add(content);// 返回最后一条数据
			}
			return contents;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 关闭
			ConnectionUtil.closeResultset(rs);
			ConnectionUtil.closeStatement(preparedStatement);
			ConnectionUtil.closeConnection(connection);
		}
	}

	public static void main(String[] args) {
		// Content content = new Content();
		// content.setTitle("dsfsdfsdf士大夫");
		// content.setContent("222是对方说的2");
		// content.setStatus(1);
		// content.setIsDelete(0);
		// content.setUserId(1);
		// content.setTags("人 的的");
		// boolean flag = saveContent(content);
		// if(flag){
		// System.out.println("添加成功");
		// }else{
		// System.out.println("添加失败");
		//
		// }
//
//		List<Content> contents = findContents(0, 3, "desc");
//		for (Content content : contents) {
//			System.out.println(content.getTitle());
//			System.out.println(content.getContent());
//			System.out.println(content.getCreateTime());
//			System.out.println("==============");
//		}
		
		System.out.println(deleteContent(44));
	}
}
