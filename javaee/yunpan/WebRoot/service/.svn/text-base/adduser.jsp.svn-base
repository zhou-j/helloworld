<%@ page language="java" import="java.util.*,com.yunpan.util.StringUtil,com.yunpan.bean.User,com.yunpan.dao.UserDao" pageEncoding="UTF-8"%>
<%
    String account = request.getParameter("account");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    password = StringUtil.saltPassword("keke", password);
    String email = request.getParameter("email");
	User user = new User();
	user.setAccount(account);
	user.setEmail(email);
	user.setPassWord(password);
	user.setUsername(username);
	boolean flag;
	flag = UserDao.addUser(user);
	if(flag){
		out.print("success");
		session.setAttribute("user", user);
	}else{
		out.print("fail");
	}

%>