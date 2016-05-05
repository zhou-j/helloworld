<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tld/tz.tld" prefix="tz"%>
<%
	//拼接项目请求的根目录,解决URL多级资源文件找不到路径的问题
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	request.setAttribute("basePath", basePath);
%>
<input type="hidden" id="talcount" value="${result}" />
<c:forEach var="profit" items="${profitBeans}">
  <tr class="tmui-items">
	<td>${profit.id}</td>
	<td>${profit.money}</td>
	<td>${profit.username}</td>						
	<td class="key">${profit.typeName}</td>
	<td>${tz:dateFormat2(profit.createTime,"yyyy-MM-dd HH:mm:ss")}</td>
	<td>${profit.description}</td>
	<td><a href="${basePath}/profit/add/${profit.id}" data-opid="${profit.id}">编辑</a>&nbsp;&nbsp;
	<a href="javascript:void(0);" onclick="tm_delete(this)" data-opid="${profit.id}">删除</a>
	</td>
  </tr>				  
</c:forEach>