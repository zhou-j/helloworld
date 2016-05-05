package com.newstart.action.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 类名: AjaxAction
 * 描述: ajax提交类
 * 创建人: zhoujuan
 * 时间: 2016年4月14日 下午9:23:01
 * @version: V1.0
 */
public class AjaxAction extends ActionSupport{
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	//如果你要把action里面的某个属性的值，要返回给ajax话吗，记得一定要生成get方法
	//业务里面的方法一定不能够使用:get开头。
	private User user;
	private String result;
	private List<User> users;
	
	public String method() throws JSONException{
		users =  new ArrayList<User>();
		User user2 = new User();
		user2.setUsername("单晨");
		user2.setPassword("122345");
		User user3 = new User();
		user3.setUsername("小Q");
		user3.setPassword("789456");
		User user4 = new User();
		user4.setUsername("忙碌");
		user4.setPassword("aaaaa");
		
		users.add(user2);
		users.add(user3);
		users.add(user4);
		result = JSONUtil.serialize(users);
		//System.out.println(JSONUtil.serialize(users));
		//System.out.println("================="+user.getUsername()+"===="+user.getPassword());
		return "ajaxSuccess";
	}
	
	public String method2(){
		System.out.println("进来么!!!!!!");
		return "ajaxSuccess";
	}


	
	//setter/getter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JSON(serialize=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JSON(serialize=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
