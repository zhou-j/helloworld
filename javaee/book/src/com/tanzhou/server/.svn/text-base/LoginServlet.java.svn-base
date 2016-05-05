package com.tanzhou.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanzhou.dao.ConnectUtil;
import com.tanzhou.util.StringUtil;

/**
 * 
 * 类名: LoginServlet
 * 描述: 登陆的servlet.
 * 创建人: zhoujuan
 * 时间: 2016年2月11日 下午8:22:16
 * @version: V1.0
 */
public class LoginServlet extends HttpServlet{

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
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        HashMap<String,Object> sessionMap = (HashMap<String, Object>) request.getSession().getAttribute("user");
		
        PrintWriter out  = response.getWriter();
        if(sessionMap!=null){
 	         out.print("success");
        }else{
	            //获取登录框的账号
	    		String account = request.getParameter("account");
	    		//获取登录框的密码
	    		String password = request.getParameter("password");
	    		
	    		if(StringUtil.isNotEmpty(account) && StringUtil.isNotEmpty(password)){
	    			HashMap<String,Object> map = ConnectUtil.findUser(account,password);
	    			if(map==null){
	    				out.print("fail");				
	    			}else{
	    				//将用户信息存储在session中。
	    				request.getSession().setAttribute("user",map);
	    				out.print("success");				
	    			}
	//    			 boolean flag = ConnectUtil.getUserExist(account, password);
	//    			 //如果map==null用户名和密码错误
	//    			 if(flag){
	//    				 response.getWriter().print("success");
	//    				 
	//    			 }else{
	//    				 response.getWriter().print("fail");
	//    			 }
	    		}else{
	    			    response.getWriter().print("fail"); 
	    		}          	
        	
        }

		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
}
