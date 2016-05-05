package com.newstart.servlet.areaexam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * 类名: SessionServlet
 * 描述: session作用域的特性。
 * 创建人: zhoujuan
 * 时间: 2016年2月9日 下午9:52:48
 * @version: V1.0
 */
public class SessionServlet extends HttpServlet{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         this.doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            //回话，和request有关，不同的用户请求，展现的内容不同。当浏览器关闭时失效。
		HttpSession session = request.getSession();
		session.setAttribute("username","单晨");
		session.setAttribute("password",666666);
        PrintWriter out = response.getWriter();
        out.println("<h1>session设值成功！</h1>");		
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
