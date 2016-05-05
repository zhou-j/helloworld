package com.newstart.action.core;

import java.util.Date;

/**
 * 
 * User<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2014年12月14日-下午10:54:50 <BR>
 * 
 * @version 1.0.0
 * 
 */
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// 创建对象有几种方式
	private String username;
	private String password;
	private Integer age;
	private String address;
	private Date date;
	private Float money;
	
	public User(){
		
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}
}
