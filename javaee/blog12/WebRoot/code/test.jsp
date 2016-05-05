<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
  <head>    
    <title></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>  
  <body>
    <!-- 浏览器样式文件,js,图片文件进行缓存的 -->
    <!-- 页面渲染的时候,对页面进行缓存在本地的浏览器中 -->
    <%--
       <img id="code" src="http://localhost:8080/blog/code/mycode.jsp" />
     --%>
    <img id="code" src="../code/mycode.jsp" onclick="this.src='../code/mycode.jsp?'+Math.random()"> -->
    <a href="javascript:void(0)"onclick="document.getElementById('code').src='../code/mycode.jsp?'+Math.random()">换一批</a>
 
 
 
 
 
 
 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  
  
  </body>
</html>
