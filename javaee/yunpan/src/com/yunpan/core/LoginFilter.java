package com.yunpan.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunpan.bean.User;
import com.yunpan.util.StringUtil;

/**
 * 
 * 类名: PermissionFilter
 * 描述: 登录拦截！！！
 * 创建人: zhoujuan
 * 时间: 2016年3月16日 下午5:19:15
 * @version: V1.0
 */
public class LoginFilter implements Filter{
    FilterConfig config = null;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}
		
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)res;
		String url = request.getRequestURI();
	    User user = (User)request.getSession().getAttribute("user");
	    if(user==null && url.indexOf("login")==-1 && url.indexOf("searchUser")==-1 && url.indexOf("signup")==-1 && url.indexOf("adduser")==-1){
		    response.sendRedirect("http://localhost/yunpan/login.jsp");
	    }else{			
			chain.doFilter(request,response);
		}
	}
	
	@Override    
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
