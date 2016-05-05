<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登录</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	    *{padding:0px;margin:0px;}
	    body{font-family:"微软雅黑",font-size:14px;}
	    fieldset{width:640px;margin:100px auto;}
	    input{display:block;margin-top:20px;width:230px;height:30px;}
	    form{width:500px;height:300px;margin:30px auto;}
	</style>
  </head>
  <body>
	 <fieldset>
	    <form action="login" method="post">
	            用户名:<input type="text" name="username">
	            密码:<input type="password" name="password">
	       <input type="submit" value="登录">
	    </form>
	 </fieldset>
  </body>
</html>
