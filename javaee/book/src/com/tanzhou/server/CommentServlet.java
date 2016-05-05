package com.tanzhou.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tanzhou.dao.comment.CommentDao;
import com.tanzhou.util.StringUtil;


/**
 * 
 * 类名: CommentServlet
 * 描述: 评论的servlet类.
 * 创建人: zhoujuan
 * 时间: 2016年2月15日 下午10:28:53
 * @version: V1.0
 */
public class CommentServlet extends HttpServlet{

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
		request.setAttribute("username", "newstart");
        //1:定义一个CommentServlet
		//2:根据Id查询具体的评论信息
		//获取具体的日记信息的Id
		String id = request.getParameter("id");
		if(StringUtil.isNotEmpty(id) && id.matches("\\d")){
			HashMap<String,Object> user = (HashMap<String, Object>) request.getSession().getAttribute("user");
		 	String userId = String.valueOf(user.get("id"));
			//String userId = request.getParameter("userId");//需要这样传递吗？？？？？
			HashMap<String, Object> map = CommentDao.getLog(Integer.parseInt(id),Integer.parseInt(userId));		//3:然后将查询出来的评论的信息放入在作用域的Request.setAttribute("comment",comment);
			request.setAttribute("comment",map);
			//根据日志id查询出该日志的评论信息。
			int logId = Integer.parseInt(String.valueOf(map.get("id")));
			List<HashMap<String,Object>> commentLogMaps = CommentDao.findCommentLogs(logId);
			request.setAttribute("commentLogs", commentLogMaps);
			//4:解析作用域。			
			request.getRequestDispatcher("/WEB-INF/pages/comment.jsp").forward(request,response);			
		}else{
			response.sendRedirect("../error.jsp");
		}
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
