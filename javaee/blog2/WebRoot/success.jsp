<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
        <h1>jsp获取不同作用域中的值的方式一</h1>
        <p>jsp获取request作用域的值:<%=request.getAttribute("username") %></p>
        <p>jsp获取session作用域的值:<%=session.getAttribute("username") %></p>
        <p>jsp获取application作用域的值:<%=application.getAttribute("username") %></p>
        <hr>       
        <h1>jsp通过El表达式获取不同作用域中的值的方式二</h1>
        <p>jsp获取request作用域的值:${requestScope.password}</p> 
        <p>jsp获取session作用域的值:${sessionScope.password}</p> 
        <p>jsp获取application作用域的值:${applicationScope.password}</p>         
  </body>
</html>
