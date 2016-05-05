<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>  
    <title>用户登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	   *{margin:0;padding:0;}
	   body{font-size:16px;font-family:"微软雅黑",color:#666;}
	   form{width:500px;height:600px;border:1px solid #dedede;margin:100px auto}
	   form .inp{height:28px;margin:15px 30px;}
	   form p{padding-left:80px;}
	   h1{text-align:center;margin-top:50px;}
	   form .subbtn{width:80px;height:30px;margin-left:195px;margin-top:20px;border-radius:5px;outline:none;border:0;background:green;}
	   form .subbtn:hover{background:blue;}
	   form .userid{margin-top:70px;}
	</style>
  </head> 
  <body>
     <form action="login" method="get">
        <h1>用户登录</h1>
        <p>账号:&nbsp;<input type = "text" name="userid"  class="inp userid" /></p>
        <p>密码:&nbsp;<input type = "password" name="password" class="inp" /></p>
        <p>验证码:<input type = "text" name="checkcode" class="inp" /><img src="CheckCodeGet" width = "70" /></p>
        <input type="submit" class="subbtn" value = "提交" />
     </form> 
  </body>
</html>
     