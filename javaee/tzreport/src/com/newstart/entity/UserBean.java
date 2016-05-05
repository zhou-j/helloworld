package com.newstart.entity;

import java.util.Date;

/**
 * 
 * 类名: UserBean
 * 描述: 用户实体类。
 * 创建人: zhoujuan
 * 时间: 2016年4月22日 下午2:17:26
 * @version: V1.0
 */
public class UserBean implements java.io.Serializable{
 
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	//用户id
	private Integer id;
	//用户名称。
	private String username;
	//用户密码。
	private String password;
	//用户账号。
	private String account;
	//用户创建时间。
	private Date createTime;
    
	public UserBean(){
		
	}
	
	public UserBean(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
