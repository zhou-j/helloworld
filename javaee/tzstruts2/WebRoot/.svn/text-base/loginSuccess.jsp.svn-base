<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登录成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	   *{margin:0;padding:0}
	   body{font-size:26px;font-family:"微软雅黑";color:#666}
	</style>
  </head>
   
  <body>
     <%
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       request.setAttribute("username",username);
       request.setAttribute("password",password);
     %>
   
    <h1>恭喜你登录成功！</h1>
    ${username}=======${password}
  </body>
</html>
