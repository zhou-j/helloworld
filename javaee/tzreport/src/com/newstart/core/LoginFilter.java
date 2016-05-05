package com.newstart.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newstart.entity.UserBean;
import com.newstart.util.StringUtil;

/**
 * 
 * 类名: LoginFilter
 * 描述: 登录权限拦截类。
 * 创建人: zhoujuan
 * 时间: 2016年4月9日 下午10:00:20
 * @version: V1.0
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//获取session里面的用户信息
		String url = request.getRequestURI();
		UserBean user = (UserBean) request.getSession().getAttribute("tmuser");
		if(user!=null || url.indexOf("login")!=-1 || url.indexOf("/js/")!=-1 || url.indexOf("/css/")!=-1 || url.indexOf("/images/")!=-1 || url.indexOf("/signup.jsp")!=-1){//如果登录了或者是登录页面就直接放行。
			chain.doFilter(req, res);
		}else{
			response.sendRedirect("logined");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
