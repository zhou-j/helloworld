<%@ page language="java" import="java.util.*,com.blog.util.StringUtil,com.blog.dao.ContentDao" pageEncoding="UTF-8"%>
<% 

      String id = request.getParameter("id");
	  if(StringUtil.isNotEmpty(id)){
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