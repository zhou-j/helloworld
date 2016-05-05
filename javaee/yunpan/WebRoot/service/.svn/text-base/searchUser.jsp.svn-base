<%@ page language="java" import="java.util.*,com.yunpan.dao.UserDao,com.yunpan.bean.User,com.yunpan.util.StringUtil" pageEncoding="UTF-8"%>
<%
   String username = request.getParameter("username");
   String password = request.getParameter("password");
   password = StringUtil.saltPassword("keke", password);
   if(StringUtil.isNotEmpty(username) && StringUtil.isNotEmpty(password)){ 
	   User user = null;
       user = UserDao.searchUser(username, password);
	   if(user!=null){
		   out.print("success");
		   session.setAttribute("user", user);
	   }else{
		   out.print("fail");
	   }
   }else{
	   out.print("empty");
   }
%>