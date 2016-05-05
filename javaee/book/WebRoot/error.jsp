<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>错误页面</title>
    
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
     <div> 非法请求<span id = "count">5</span>秒之后自动跳转！！！！！</div>
     <script type="text/javascript">
      var count = 5;
      window.onload = function(){
    	  setInterval(function(){
     		  count--;
    		  if(count<=0){
    			  window.location.href = "page/boo";
    		  }
    		  //js
    		  //documnet.getElementById("count").innerText = count;
    		  document.getElementById("count").innerHTML ="<b>" + count+ "</b>";
              //jquery
              //$("count").text(count);
              //$("count").html("<b>"+count+"</b>");
    	  },1000);
      };
      
     </script>

  </body>
</html>
