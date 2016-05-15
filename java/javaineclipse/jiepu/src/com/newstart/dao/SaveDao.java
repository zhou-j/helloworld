package com.newstart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.newstart.bean.CountMessageBean;

/**
 * 
 * 使用JDBC批处理操作Oracle数据库： 
 * 1.使用addBatch方法添加DML语句； 
 * 2.使用executeBatch方法提交批处理语句。 
 * 类名:SaveDao 
 * 描述: 数据入库类 
 * 创建人: zhoujuan 
 * 时间: 2016年5月10日 下午8:11:03
 * 
 * @version: V1.0
 */
public class SaveDao {

	/**
	 * 
	 * 方法名: saveMessage 
	 * 描述: 保存用户信息方法。 
	 * 创建人: zhoujuan 
	 * 时间: 2016年5月11日 下午9:52:23
	 * 
	 * @param countbeans
	 * @return: void
	 * @since: V1.0
	 */
	public static void saveMessage(List<CountMessageBean> countbeans){
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jgs", "jgs");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("数据库连接异常！");
		}
		//seq是在oracle中创建的序列,通过seq.nextval实现id的自动递增。
		String sql = "insert into tm_usermessage(id,username,userterminator,uplinetime,downlinetime,ipaddress) values(seq.nextval,?,?,?,?,?)";		
		try { 
			// 从下面开始，和SQL Server一模一样 
			statement= connection.prepareStatement(sql);
			//statement.setInt(1,messagebean.getId());
			for(CountMessageBean messagebean:countbeans){
				statement.setString(1,messagebean.getUsername());
				statement.setString(2,messagebean.getUserterminator());
				statement.setString(3,messagebean.getUplinetime());
				statement.setString(4, messagebean.getDownlinetime());
				statement.setString(5,messagebean.getIpaddress());
				statement.addBatch();				
			}
			  statement.executeBatch(); 
			} catch (Exception e) { 
			   e.printStackTrace();
			}finally{
			   try {				   
				   if(statement!=null)statement.close();
				   if(connection!=null)connection.close();
			   } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			   }
			}
	}
}
