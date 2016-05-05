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

import com.yunpan.util.StringUtil;

/**
 * 
 * 类名: PermissionFilter
 * 描述: 权限拦截！！！
 * 创建人: zhoujuan
 * 时间: 2016年3月16日 下午5:19:15
 * @version: V1.0
 */
public class PermissionFilter implements Filter{
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
		String url = request.getRequestURI();//请求的相对路径
		//获取请求方式。
		String method = request.getMethod();	
		//String url2 = request.getRequestURL().toString();//请求的绝对路径。
		if(isValidateUrl(url)&&StringUtil.isNotEmpty(url) && url.indexOf("service")!=-1 && method.equalsIgnoreCase("get")){
			request.getRequestDispatcher("/error.jsp").forward(request,response);
		}else{			
			chain.doFilter(request,response);
		}
	}
	
//	public void main(String[] args) {
//		System.out.println(isValidateUrl("loginout.jsp"));
//	}
	private boolean isValidateUrl(String url){
		String filterUrl = config.getInitParameter("filterUrl");
		boolean flag = true;
		if(StringUtil.isNotEmpty(filterUrl) && StringUtil.isNotEmpty(url)){
			String[] urls = filterUrl.split(",");
			for(String ustr:urls){
				if(url.indexOf(ustr)!=-1){
					flag = false;
					break;
				}
			}
			
		}
		return flag;
	}
	@Override    
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
