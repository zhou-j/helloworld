<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@ page language="java" import="java.util.*,com.yunpan.util.StringUtil,com.yunpan.bean.Resource,com.yunpan.dao.ResourceDao" pageEncoding="UTF-8"%>
<%
   //获取分类
   String t = request.getParameter("type");
   //当前页
   String pageNo = request.getParameter("pageNo");
   String pageSize = request.getParameter("pageSize");
   Integer type = null;
   if(StringUtil.isNotEmpty(t)) type = new Integer(t);
   //调用类查询出数据库的文件信息。
   if(StringUtil.isEmpty(pageNo))pageNo = "0";
   if(StringUtil.isEmpty(pageSize))pageSize = "10";
   List<Resource> resources = ResourceDao.findResources(type,"",new Integer(pageNo),new Integer(pageSize));
   HashMap<String,Object> map = new HashMap<String,Object>();
   int count = ResourceDao.countResources(type,"");
   map.put("count", count);
   map.put("resources", resources);
   out.print(JSONUtil.serialize(map));
   
%>