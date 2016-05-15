package com.newstart.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * 类名: Connection
 * 描述: 数据库连接类。
 * 创建人: zhoujuan
 * 时间: 2016年5月11日 下午7:24:23
 * @version: V1.0
 */
public class ConnectionUtil {
	
    /**
     * 
     * 方法名: getConnection
     * 描述: 获取连接类。
     * 创建人: zhoujuan
     * 时间: 2016年5月11日 下午7:30:17
     * @param url 数据库连接路径。
     * @param username 数据库的用户名。
     * @param password 数据库的密码。
     * @return
     * @throws Exception
     * @return: Connection
     * @since: V1.0
     */
	public static Connection getConnection(String url,String username,String password) throws Exception{
		// 1.加载驱动 
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
		// 2.得到连接 
		Connection connection = DriverManager.getConnection(url,username, password);
	
		return connection;
	}
	

}
