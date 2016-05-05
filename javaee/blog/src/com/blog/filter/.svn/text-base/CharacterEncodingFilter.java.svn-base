package com.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 编码拦截控制
 * CharacterEncodingFilter<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2014年9月30日-下午6:57:29 <BR>
 * @version 1.0.0
 *
 */
public class CharacterEncodingFilter implements Filter {

	private FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 获取filter初始化的参数值
 		String encoding = config.getInitParameter("encoding");
		if (null != encoding && !"".equalsIgnoreCase(encoding)) {
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		}
		// 把请求和响应传给过滤链中的下一个调用者或servlet
		chain.doFilter(request, response);
	}
	
	
	@Override
	public void destroy() {

	}

}
