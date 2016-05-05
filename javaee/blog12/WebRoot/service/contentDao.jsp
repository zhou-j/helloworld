<%@ page language="java" import="java.util.*,com.blog.bean.Content,com.blog.dao.ContentDao,com.blog.dao.ConnectionUtil,java.sql.Connection,com.blog.util.StringUtil" pageEncoding="UTF-8"%>
<% 
     String contentSr = request.getParameter("content");
     String title = request.getParameter("title");
     String tag = request.getParameter("tag");
     if(StringUtil.isNotEmpty(title) && StringUtil.isNotEmpty(contentSr)){
	     Content content = new Content();
	     content.setContent(contentSr);
	     content.setTitle(title);
	     content.setStatus(1);
	     content.setIsDelete(0);
	     content.setUserId(1);
	     content.setTags(tag);
	     Connection connection = ConnectionUtil.getConnection();
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