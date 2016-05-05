<%@page import="com.blog.dao.content.ContentDao"%>
<%@page import="com.blog.util.StringUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	if(StringUtils.isNotEmpty(id)){
		boolean flag = ContentDao.deleteContent(new Integer(id));
		if(flag){
			out.print("success");
		}else{
			out.print("fail");
		}
	}else{
		out.print("fail");
	}
%>