package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * 鏁版嵁搴撹繛鎺ョ被 ConnectionUtil<BR>
 * 鍒涘缓浜�娼窞瀛﹂櫌-keke <BR>
 * 鏃堕棿锛�014骞�1鏈�鏃�涓嬪崍10:22:36 <BR>
 * 
 * @version 1.0.0
 * 
 */
public class ConnectionUtil {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/blog";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "password";

	/**
	 * 鏁版嵁搴撶殑閾炬帴鏂规硶 鏂规硶鍚嶏細getConnection<BR>
	 * 鍒涘缓浜猴細娼窞瀛﹂櫌-keke <BR>
	 * 鏃堕棿锛�014骞�1鏈�鏃�涓嬪崍10:27:01 <BR>
	 * 
	 * @return Connection<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return connection;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 鍏抽棴杩炴帴 鏂规硶鍚嶏細closeConnection<BR>
	 * 鍒涘缓浜猴細娼窞瀛﹂櫌-keke <BR>
	 * 鏃堕棿锛�014骞�1鏈�鏃�涓嬪崍10:57:52 <BR>
	 * 
	 * @param connection
	 *            void<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 鍏抽棴杩炴帴 鏂规硶鍚嶏細closeConnection<BR>
	 * 鍒涘缓浜猴細娼窞瀛﹂櫌-keke <BR>
	 * 鏃堕棿锛�014骞�1鏈�鏃�涓嬪崍10:57:52 <BR>
	 * 
	 * @param connection
	 *            void<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static void closeResultset(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 鍏抽棴杩炴帴 鏂规硶鍚嶏細closeConnection<BR>
	 * 鍒涘缓浜猴細娼窞瀛﹂櫌-keke <BR>
	 * 鏃堕棿锛�014骞�1鏈�鏃�涓嬪崍10:57:52 <BR>
	 * 
	 * @param connection
	 *            void<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static void closeStatement(PreparedStatement pStatement) {
		try {
			pStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
