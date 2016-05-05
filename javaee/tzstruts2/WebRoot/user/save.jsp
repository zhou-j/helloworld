<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>  
    <title>test1</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
    <h1>test1</h1>
    <h2>request获取的用户是：${requestScope.username}</h2>
    <h2>application获取的用户是：${applicationScope.username}</h2>
    <h2>session获取的用户是：${sessionScope.username}</h2>
  </body>
</html>
