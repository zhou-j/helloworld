<%@ page language="java" import="java.util.*,com.yunpan.util.StringUtil,com.yunpan.dao.ResourceDao" pageEncoding="UTF-8"%>
<%
  /*
	      业务：根据id更新文件名称。
	      时间：2016/3/13
	      作者：newstart
	      描述：通过文件上传实现百度云盘的技术       
  */
  String id = request.getParameter("id");
  String name = request.getParameter("name");
  if(StringUtil.isNotEmpty(id)){
	  boolean flag = ResourceDao.updateResource(name,new Integer(id));
	  if(flag){
		  out.print("success");//request/response.getWriter()
	  }else{
		  out.print("fail");
	  }
  }else{
	  out.print("fail");
  }
%>