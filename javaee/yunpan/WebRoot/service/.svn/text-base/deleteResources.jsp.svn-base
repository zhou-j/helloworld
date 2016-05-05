<%@ page language="java" import="java.util.*,com.yunpan.util.StringUtil,com.yunpan.dao.ResourceDao" pageEncoding="UTF-8"%>
<%
  /*
	      业务：根据id删除文件信息。
	      时间：2016/3/13
	      作者：newstart
	      描述：通过文件上传实现百度云盘的技术       
  */
  String ids = request.getParameter("ids");
  if(StringUtil.isNotEmpty(ids)){
	  boolean flag = ResourceDao.deleteResources(ids);
	  if(flag){
		  out.print("success");//request/response.getWriter()
	  }else{
		  out.print("fail");
	  }
  }else{
	  out.print("fail");
  }
%>