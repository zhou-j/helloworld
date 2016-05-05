package com.tanzhou.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		    System.out.println("进入了登录拦截器！！！！！");
	        HttpServletRequest request = (HttpServletRequest)req;
	        HttpServletResponse response = (HttpServletResponse)res;
		    HashMap<String,Object> sessionMap = (HashMap<String, Object>) request.getSession().getAttribute("user");		
	        if(sessionMap==null){
	        	response.sendRedirect(request.getContextPath()+"/login.jsp");
	        }else{
	        	chain.doFilter(request,response);
	        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
