package com.jgsu.codeget;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jgsu.util.StringUtil;

/**
 * 
 * 类名: LoginAction
 * 描述: 用户登录类
 * 创建人: zhoujuan
 * 时间: 2016年4月5日 下午2:07:12
 * @version: V1.0
 */
public class LoginAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    String driver = null;
    String url = null;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid").trim();
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		if(userid==null||userid.trim().length()==0){
			response.sendRedirect("login.jsp");
			return;
		}
		if(password==null||password.trim().length()==0){
			response.sendRedirect("login.jsp");
			return;
		}
		if(checkcode==null||checkcode.trim().length()==0){
			response.sendRedirect("login.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		String checkCodeInSession = (String)session.getAttribute("validate_code");
		if(!checkcode.equals(checkCodeInSession)){
			response.sendRedirect("login.jsp");
		}else{
			String sql = "select * from tm_user where userid = ? and password = ?";
		    Connection cn = null;
			boolean check = false;
			try{
			    Class.forName(driver);
			    cn = DriverManager.getConnection(url,"root","password");
			    PreparedStatement ps = cn.prepareStatement(sql);
			    ps.setString(1,userid);
			    ps.setString(2,password);
			    ResultSet rs = ps.executeQuery();
			    if(rs.next()){
			    	check = true;
			    }
			    rs.close();
			    ps.close();
			}catch(Exception e){
				response.sendRedirect("login.jsp");
			}finally{
				try{cn.close();}catch(Exception e){};
			}
			if(check){
				session.setAttribute("userid", userid);
				response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
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
		driver = config.getInitParameter("driver");
		url = config.getInitParameter("url");
	}
    
}
