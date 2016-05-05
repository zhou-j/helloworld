<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	System.out.println("小杰认真听课，keke给一些数据:"+username+"==="+password);
	response.getWriter().print("keke数据已经收到!!!");
%>