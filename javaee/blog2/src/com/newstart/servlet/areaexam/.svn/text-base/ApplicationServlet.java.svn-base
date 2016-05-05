package com.newstart.servlet.areaexam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 类名: ApplicationServlet
 * 描述: application作用域的特性。
 * 创建人: zhoujuan
 * 时间: 2016年2月9日 下午9:52:48
 * @version: V1.0
 */
public class ApplicationServlet extends HttpServlet{

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
            //获取上下文对象，和web容器同生共死，所有的servlet都可以共享作用域(可能导致值会覆盖);
		ServletContext application = this.getServletContext();
		application.setAttribute("username","张龙");
		application.setAttribute("password",222222);
        PrintWriter out = response.getWriter();
        out.println("<h1>application设值成功！</h1>");		
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
