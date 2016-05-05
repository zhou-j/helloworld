<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>文件下载出错</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <h1>文件下载出错,<span id="count">3</span>秒后跳转到下载页面！</h1>
    <script type="text/javascript">
       function redirectjsp(){
    	   window.location.href="http://localhost/report/download.jsp";
       }
       var Ocount = document.getElementById("count");
       //alert(Ocount.innerHTML()); 
       var count=2;
       setInterval(function(){Ocount.innerHTML = count+"";count--;},1000);
       setTimeout(redirectjsp,3000);  
    </script>
  </body>
</html>
