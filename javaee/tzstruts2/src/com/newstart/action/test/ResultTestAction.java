package com.newstart.action.test;

import com.newstart.util.StringUtil;

/**
 * 
 * 类名: ResultTestAction
 * 描述: 结果集测试类。
 * 创建人: zhoujuan
 * 时间: 2016年4月5日 下午9:58:39
 * @version: V1.0
 */
public class ResultTestAction {
    private String username;
    
	public String login(){
		if(StringUtil.isNotEmpty(username) && username.equals("keke")){
			System.out.println("跳转到首页中去！");
			return "index";			
		}else{
			System.out.println("跳转到登陆页面中去！");
			return "login";						
		}
	}
	
	public String register(){
		System.out.println("注册成功跳转到首页中去！");
		return "index";
	}
	
	public String logout(){
		System.out.println("注销用户跳转到登录去！");
		return "login";
	}

	public String main(){
		System.out.println("用户调到主页面中去了！");
		return "login";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
