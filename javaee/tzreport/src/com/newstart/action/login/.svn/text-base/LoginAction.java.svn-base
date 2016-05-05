package com.newstart.action.login;

import org.apache.struts2.ServletActionContext;

import com.newstart.dao.UserDao;
import com.newstart.entity.UserBean;
import com.newstart.util.StringUtil;

/**
 * 
 * 类名: LoginAction
 * 描述: 登录处理Action类
 * 创建人: zhoujuan
 * 时间: 2016年4月9日 下午7:34:52
 * @version: V1.0
 */
public class LoginAction {
    private String username;
    private String password;
    private String result;
	/**
	 * 
	 * 方法名: login
	 * 描述: 登录跳转方法login
	 * 创建人: zhoujuan
	 * 时间: 2016年4月9日 下午7:36:42
	 * @return
	 * @return: String
	 * @since: V1.0
	 */
	public String login(){		
		return "login";
	}
    
	public String logined(){
		UserBean user = null;
		user = UserDao.searchUser(username, password);
		if(user!=null){
			ServletActionContext.getRequest().getSession().setAttribute("tmuser", user);
			result = "success";
//			return "main";
		}else{
			result = "fail";
//			return "loginRedirect";
		}
		return "Ajaxsuccess";		
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
