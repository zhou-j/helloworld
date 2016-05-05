package com.jgsu.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 类名: TestServlet
 * 描述: 查询数据库的信息类
 * 创建人: zhoujuan
 * 时间: 2016年3月11日 下午7:51:54
 * @version: V1.0
 */
public class TestServlet extends HttpServlet{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private List<HashMap<String,Object>> maps = new ArrayList<HashMap<String,Object>>();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub 		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Product</title></head>");		
		out.println("<style type='text/css'>.tab tr td{font-size:14px ;border:1px solid #D8D8d8;line-height:60px;text-align:center;}.tab thead tr td{font-size:16px;font-weigh:bold;background:#E1E1E1;}.tab tbody tr:hover{background:#dedede;}.tab tbody tr td:hover{background:blue;color:#fff;}</style>");
		out.println("<body>");
		out.println("<h1 style='text-align:center;margin-top:50px;'>产品库存表</h1>");
		out.println("<table class='tab' border='1' style='width:800px;height:200px;margin:100px auto;border-collapse:collapse;'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<td>产品名称</td><td>产品价格</td><td>产品库存</td>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(HashMap<String,Object> map:maps){
			out.println("<tr>");
			out.println("<td>"+map.get("name")+"</td>");			
			out.println("<td>"+map.get("price")+"</td>");			
			out.println("<td>"+map.get("pnumber")+"</td>");			
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");		
		out.println("</body>");		
		out.println("</html>");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		maps = ConntectionUtil.findProducts(driver, url, user, password);
	}
	
	
	

}
