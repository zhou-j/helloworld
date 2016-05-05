package com.tanzhou.server;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
/**
 * 
 * 类名: CookieServlet
 * 描述: cookie例子
 * 创建人: zhoujuan
 * 时间: 2016年2月10日 下午4:37:29
 * @version: V1.0
 */ 
public class CookieServlet extends HttpServlet{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	@Override
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            
		    Cookie[] cookies = request.getCookies();
		    if(cookies!=null){
		    	for(Cookie cookie : cookies){
		    		if("username".equals(cookie.getName())){
		    			//URLDecoder
		    			String uname = URLDecoder.decode(cookie.getValue(),"UTF-8");
		    			System.out.println("浏览器获取的cookie的信息是:"+uname);
		    		}
		    	}
		    }
		    //URLEncoder:encode(str,charset)加密
		    //URLEncoder:decode(str,charset)解密
		    //存储在客户端(浏览器)，
		    //注意点：Cookie不能直接写入中文,URLEncoder
		    String username = URLEncoder.encode("皮囊","utf-8");
		    Cookie cookie = new Cookie("username",username);
             //设置有效时间为1天单位毫秒
		    cookie.setMaxAge(1000*60*60*24);
            //response.setContentType("text/html;charset=utf-8");
            response.addCookie(cookie);            
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
