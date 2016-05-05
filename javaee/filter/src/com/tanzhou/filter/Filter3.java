package com.tanzhou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 
 * 类名: Filter3
 * 描述: 第三个拦截器
 * 创建人: zhoujuan
 * 时间: 2016年2月20日 上午10:05:47
 * @version: V1.0
 */
public class Filter3 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("[filter3]========dofilter");
		chain.doFilter(request, response);//调用下一个拦截器
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	    System.out.println("这是第三个拦截器============Filter3");
	}

}
