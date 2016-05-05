package com.newstart.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 类名: LoginServlet
 * 描述: 我的第一个Servlet程序
 * 创建人: zhoujuan
 * 时间: 2016年2月4日 下午11:00:42
 * @version: V1.0
 */
public class LoginServlet extends HttpServlet {
	
	//第一步:类要继承HttpServlet
	//重写父类里的doGet()/doPost()方法
	//get/post
	//第三步:在web.xml中注册Servelet
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @Title: doGet
	 * @Description: TODO
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理中文乱码问题，指明内容请求输入的格式是什么
		resp.setContentType("text/html;charset=UTF-8");
		//指明输出流的编码格式
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<div style='text-shadow:3px 3px 3px #666;margin:100px 500px;font-size:30px'>您好！我是第一个Servlet</div>");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求的编码
/*		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");*/
		System.out.println("进来了吗？我是post请求方式哦");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String coursename = request.getParameter("coursename");
		System.out.println(username+"==="+password+"==="+coursename);
		if(username!=null && !username.equals("")){
			if(username.equals("keke") && password.equals("123456")){
				response.sendRedirect("success.html");//页面重定向
			}else{
				//页面请求分发
				request.getRequestDispatcher("empty.html").forward(request,response);
			}
		}else{
			//一个提示页面
			request.getRequestDispatcher("empty.html").forward(request,response);
		}
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

}
