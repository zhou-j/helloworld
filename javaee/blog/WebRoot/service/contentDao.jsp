<%@page import="com.blog.dao.ConnectionUtil"%>
<%@page import="com.blog.bean.Content"%>
<%@page import="com.blog.util.StringUtils"%>
<%@page import="com.blog.dao.content.ContentDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//获取标题
    String title = request.getParameter("title");
	//获取内容
	String contentStr = request.getParameter("content");
	//获取内容
	String tag = request.getParameter("tag");
	//判断标题和内容部允许为空
	if(StringUtils.isNotEmpty(title) && StringUtils.isNotEmpty(contentStr)){
		Content content = new Content();
		content.setTitle(title);
		content.setContent(contentStr);
		content.setStatus(1);
		content.setIsDelete(0);
		content.setUserId(1);
		content.setTags(tag);
		boolean flag = ContentDao.saveContent(content);
		if(flag){
			out.print("success");
		}else{
			out.print("fail");
		}
	}else{
		out.print("fail");
	}
%>