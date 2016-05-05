<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  	<!-- 浏览器对样式文件，js,图片文件会进行缓存的 -->
  	<!-- 页面渲染时候，对会对页面进行缓存在本地的浏览器中， -->
  	<img id="code" src="../code/code.jsp" onclick="this.src='../code/code.jsp?'+Math.random()">
  	<a href="javascript:void(0)" onclick="document.getElementById('code').src ='../code/code.jsp?'+Math.random()">换一张</a>
  	<!-- 验证码，邮件发送，图片水印  发帖子，登陆，注册时候要用到验证码-->
  </body>
</html>
