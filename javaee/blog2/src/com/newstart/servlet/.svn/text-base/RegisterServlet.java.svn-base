package com.newstart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newstart.util.StringUtil;


/**
 * 
 * 类名: RegisterServlet
 * 描述: Servlet的生命周期介绍
 * 创建人: zhoujuan
 * 时间: 2016年2月6日 上午10:10:48
 * @version: V1.0
 */
public class RegisterServlet extends HttpServlet{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		System.out.println(username);
		if(StringUtil.isNotEmpty(username) &&username.equals("keke")){
               //登录成功，跳转到登录成功页面success.jsp	
			
			  //请求分派
			  request.getRequestDispatcher("success.html");
		}else{
			//登录失败，调整到登录失败页面fail.jsp
			
			//重定向:第一次浏览器发送了一个请求---浏览器---fail.jsp
			//response.sendRedirect("fail.jsp");//重定向页面
			//response.sendRedirect("fail.html");//重定向静态页面
			response.sendRedirect("forward");//重定向servlet
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("3:servlet在这里被释放了。。。。。");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		 System.out.println("1:servlet初始化进入的方法！");
		 String username = this.getServletConfig().getInitParameter("username");
		 String password = this.getServletConfig().getInitParameter("password");
		 System.out.println(username+"====="+password); 
		 
		 String kekestring = this.getServletContext().getInitParameter("keke");
		 System.out.println(kekestring);
	}
	
	//1:servlet的实例化如何被加载的?
	//容器加载到Servlet后调用init()方法,进行初始化servlet上下文，servletConfig的初始化。
    //2:如何处理请求
	//根据请求的方法进入到service方法，进入到service方法后也会根据你的请求方式进入到doGet/doPost方法。
	//doGet(HttpServletRequest,HttpServletResponse);
	//3:Servlet如何被释放
	//servlet是单实例多线程(只初始化一次，每一次请求都会创建一个线程)。
}
