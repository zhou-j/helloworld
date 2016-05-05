package com.tanzhou.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanzhou.dao.comment.CommentDao;
import com.tanzhou.util.StringUtil;

/**
 * 
 * 类名: CommentSaveServlet
 * 描述: 保存用户评论到数据库的Servlet.
 * 创建人: zhoujuan
 * 时间: 2016年2月24日 下午4:01:59
 * @version: V1.0
 */
public class CommentSaveServlet extends HttpServlet{

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
		// TODO Auto-generated method stub
	     String content = request.getParameter("content");
	     String logId = request.getParameter("logId");
	     PrintWriter out = response.getWriter();
	     if(StringUtil.isNotEmpty(content) && StringUtil.isNotEmpty(logId)){
	    	  int $logId = Integer.parseInt(logId);
	    	  HashMap<String,Object> userMap = (HashMap<String,Object>) request.getSession().getAttribute("user");
	    	  int userId = Integer.parseInt(String.valueOf(userMap.get("id")));
	    	  CommentDao.saveCommentLog(content, userId, $logId);
	    	  out.print("success");
	     }else{
	    	 out.print("fail");
	     };
	         
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
