package com.tanzhou.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanzhou.dao.log.TmLogDao;


public class BookServlet extends HttpServlet{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   //将留言簿的数据查询出来放在，request作用域中就可以返回到页面中去！！！
	   //4.在BookServlet中调用查询用户发表的日记findLogs();
		HashMap<String, Object> map = (HashMap<String, Object>)request.getSession().getAttribute("user");
		List<HashMap<String, Object>> logMaps = TmLogDao.findLogs(Integer.parseInt(String.valueOf(map.get("id"))));
	   //5.将查询出来的信息放入到作用域中request.setAttribute();
	   request.setAttribute("logMaps", logMaps);
       request.getRequestDispatcher("/WEB-INF/pages/book.jsp").forward(request,response);
	}

}
