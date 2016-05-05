package com.yunpan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yunpan.bean.User;

/**
 * 
 * 类名: UserDao
 * 描述: 用户业务类
 * 创建人: zhoujuan
 * 时间: 2016年3月18日 下午12:38:06
 * @version: V1.0
 */
public class UserDao {
	/**
	 * 
	 * 方法名: searchUser
	 * 描述: 用户登录,查询用户是否存在。
	 * 创建人: zhoujuan
	 * 时间: 2016年3月18日 下午1:45:39
	 * @return
	 * @return: boolean
	 * @since: V1.0
	 */
	public static User searchUser(String username,String password){
		String sql = "select * from tm_user where account=? and password = ? and is_delete =0;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		User user = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			statement.setString(2, password);
			rs = statement.executeQuery();
			if(rs.next()){
			   user = new User();
			   user.setAccount(rs.getString("account"));
			   user.setId(rs.getInt("id"));
			   user.setIsDelete(rs.getInt("is_delete"));
			   user.setPassWord(rs.getString("password"));
			   user.setCreatetime(rs.getTimestamp("createtime"));
			   user.setUpdatetime(rs.getTimestamp("updatetime"));
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
     * 时间: 2016年3月25日 下午10:31:59
     * @return
     * @return: boolean
     * @since: V1.0
     */
	public static boolean addUser(User user){
		String sql = "insert into tm_user(account,username,password,email) values(?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1,user.getAccount() );
			statement.setString(2,user.getUsername());
			statement.setString(3, user.getPassWord());
			statement.setString(4,user.getEmail());
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
//登录
//		User user = new User();
//    	user = searchUser("aiwan","1234567");
//    	System.out.println(user);
//		System.out.println(user.getAccount());
//		System.out.println(user.getPassWord());
//		System.out.println(user.getUsername());
//		System.out.println(user.getCreatetime());
//		System.out.println(user.getId());
//		System.out.println(user.getIsDelete());
//		System.out.println(user.getUpdatetime());
    	//注册
//    	User user = new User();
//    	user.setAccount("account");
//    	user.setEmail("email");
//    	user.setPassWord("66666");
//    	user.setUsername("username");
//    	boolean flag;
//    	flag = addUser(user);
//    	System.out.println(flag);
	}
}
