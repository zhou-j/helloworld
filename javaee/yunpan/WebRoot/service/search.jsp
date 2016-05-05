<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@ page language="java" import="java.util.*,com.yunpan.util.StringUtil,com.yunpan.bean.Resource,com.yunpan.dao.ResourceDao" pageEncoding="UTF-8"%>
<%
   //获取分类
   String t = request.getParameter("type");
   //获取查询关键字
   String k = request.getParameter("keyword");
   //当前页
   String pageNo = request.getParameter("pageNo");
   String pageSize = request.getParameter("pageSize");
   Integer type = null;
   if(StringUtil.isNotEmpty(t)) type = new Integer(t);
   String keyword ="";
   if(StringUtil.isNotEmpty(k)) keyword = k;
   //调用类查询出数据库的文件信息。
   if(StringUtil.isEmpty(pageNo))pageNo = "0";
   if(StringUtil.isEmpty(pageSize))pageSize = "10";
   List<Resource> resources = ResourceDao.findResources(type,keyword,new Integer(pageNo),new Integer(pageSize));
   int count = ResourceDao.countResources(type,keyword);
   //request.setAttribute("count", count);
   request.setAttribute("resources", resources);
   request.setAttribute("itemcount",count);
   //跳转到我们的模板页面。
   request.getRequestDispatcher("template.jsp").forward(request, response);
   
%>