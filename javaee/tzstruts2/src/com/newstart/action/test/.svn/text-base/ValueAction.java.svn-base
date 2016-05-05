package com.newstart.action.test;

import java.util.Map;

import javafx.application.Application;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 类名: ValueAction
 * 描述: 获取servlet-----HttpServletRequest,HttpServletResponse,ServletContext对象
 * 创建人: zhoujuan
 * 时间: 2016年4月9日 上午9:49:10
 * @version: V1.0
 */
public class ValueAction implements ServletRequestAware,ServletResponseAware,ServletContextAware,SessionAware{
   
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext application;
	private Map<String,Object> session;
	//值注入的方式获取参数值
	private String username;

	public String value(){
		System.out.println("进入了吗？");
		//值注入的方式获取参数值
		System.out.println("="+username);
		//通过类继承ServletRequestAware接口初始化HttpServletRequest获取参数值
		System.out.println("==="+request.getParameter("username"));
		//通过Struts2提供的ServletActionContext的请求对象获取参数值。
		System.out.println("====="+ServletActionContext.getRequest().getParameter("username"));
		//ActionContext.getContext().put(HTTP_REQUEST, request);
		HttpServletRequest r = (HttpServletRequest)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
		System.out.println("======="+r.getParameter("username"));
		return "value";
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
    
	public String save(){
		//request作用域
		request.setAttribute("username", "喆同学");
		ServletActionContext.getRequest().setAttribute("username","abcdefg");
		//session作用域
		request.getSession().setAttribute("username", "小虎虎同学");
		ServletActionContext.getRequest().getSession().setAttribute("username", "小虎虎同学123456");
		session.put("username", "小虎虎同学789");
		ServletActionContext.getContext().getSession().put("username", "无名小虎虎");
		//application作用域,后面的覆盖前面的。
		application.setAttribute("username", "keke老师");
		ServletActionContext.getServletContext().setAttribute("username", "kekexx老师");
		ServletActionContext.getContext().getApplication().put("username", "keke老师yyy");
		return "save";
	}
	
	public String update(){
		System.out.println("动态值的注入username====="+username);
		return "update";
	}
	
	public String search(){
		return "search";
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}	
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setServletContext(ServletContext application) {
		// TODO Auto-generated method stub
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	

}
