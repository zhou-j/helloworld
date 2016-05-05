package com.newstart.login;

import org.apache.struts2.ServletActionContext;

/**
 * 
 * 类名: LoginAction.extends ActionSupport
 * 描述: 登录处理的Action.
 * 创建人: zhoujuan
 * 时间: 2016年3月27日 下午1:06:06
 * @version: V1.0
 */
public class LoginAction {
	
	private String username;
	private String password;
	
	//类的入口方法execute()一个Action类的默认方法。
	//不需要去继承ActionSupport
	//类命名:xxxxxxxAction
	public String execute(){
		return "success";
	}
    
	//保存资源
	public String save(){
		System.out.println(username+"======"+password);		
		ServletActionContext.getRequest().getSession().setAttribute("username", username);
		ServletActionContext.getRequest().getSession().setAttribute("password", password);
		return "success";
	}
	
	public String delete(){
		username = "keke";
		password = "123456";//valuestatus===值栈 ===request.setAttribute("username","keke");request.setAttribute("password","123456");
		System.out.println("删除进这里了！");
		return "success";
	}
	
	public String update(){
//		username = "keke";
//		password = "456789";		
		System.out.println("更新资源进入了这里！");
		return "redirect";
	}
	
	public String list(){
		username = "keke_list";
		password = "list_456789";		
		System.out.println("list进入了这里！");
		return "chain";
	}
	
	
	//产生属性的getter/setter
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
	
  
}
