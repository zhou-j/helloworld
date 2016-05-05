package com.newstart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newstart.dao.core.ConnectionUtil;
import com.newstart.entity.UserBean;


/**
 * 
 * 类名: UserDao
 * 描述: 用户数据库操作。
 * 创建人: zhoujuan
 * 时间: 2016年4月22日 下午2:26:40
 * @version: V1.0
 */
public class UserDao {
    /**
     * 
     * 方法名: searchUser
     * 描述: 用户登录，查询用户是否存在。
     * 创建人: zhoujuan
     * 时间: 2016年4月22日 下午2:53:33
     * @param username
     * @param password
     * @return
     * @return: UserBean
     * @since: V1.0
     */
	public static UserBean searchUser(String username,String password){
		String sql = "select * from tm_user where username=? and password = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		UserBean user = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			statement.setString(2, password);
			rs = statement.executeQuery();
			if(rs.next()){
			   user = new UserBean();
			   user.setAccount(rs.getString("account"));
			   user.setId(rs.getInt("id"));
			   user.setPassword(rs.getString("password"));
			   user.setCreateTime(rs.getTimestamp("create_time"));
			   user.setUsername(rs.getString("username"));
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			if(rs!=null)ConnectionUtil.closeResultSet(rs);
			if(statement!=null)ConnectionUtil.closeStatement(statement);
			if(connection!=null)ConnectionUtil.closeConnection(connection);
		}
	}

    /**
     * 
     * 方法名: addUser
     * 描述: 用户注册。
     * 创建人: zhoujuan
     * 时间: 2016年4月22日 下午2:53:11
     * @param user
     * @return
     * @return: boolean
     * @since: V1.0
     */
	public static boolean addUser(UserBean user){
		String sql = "insert into tm_user(account,username,password) values(?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,user.getAccount() );
			statement.setString(2,user.getUsername());
			statement.setString(3, user.getPassword());
			int count = 0;
			count = statement.executeUpdate();
			return count>0? true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			ConnectionUtil.closeStatement(statement);
			ConnectionUtil.closeConnection(connection);
		}
	}
	
	public static void main(String[] args) {
//		UserBean user = searchUser("newstart","456");
//		System.out.println(user.getAccount());
//		System.out.println(user.getCreateTime());
//		System.out.println(user.getId());
		
//		UserBean user = new UserBean();
//		user.setAccount("130912032");
//		user.setPassword("110");
//		user.setUsername("jz");
//		addUser(user);
	}
		
}
