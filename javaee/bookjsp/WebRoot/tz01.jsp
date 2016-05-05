<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tz01.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <style type="text/css">
         body{font-size:20px;font-family:"微软雅黑";margin:50px;}        
    </style>
  </head>
  
  <body>
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->
      <%-- 由<%@指令名称page/include/taglib)属性="属性值"%> --%>    
      <!-- 静态注释 快捷键 ctrl + shift + c -->
      <!--<%-- --%>jsp特有的注释，如果被他注释，jsp编译个时候就会忽略。-->
      <!-- pageEncodeing:的默认字符集编码是：ISO8859-1(数字，字母，标点符号); -->
      <!-- import:引入其他类：导入类：-------import = "java.util.*,java.io.*,com.keke.servlet.*,com.keke.servlet.*" -->
      <p>专门注释JSP代码块和指令：&lt;%-- --%&gt;</p>
      <hr/> <br>
      <p>
                             页面包含：&lt;%@include file="html/jsp(页面的一部分)"%&gt;<br>
                             为什么使用include?<br>
          1.页面中存在很多相同的代码的时候<br>
          2.头部js文件的通用配置。<br>
      </p>
      <p>
                              页面的脚本引入技术：&lt;% %&gt; &lt;% %&gt; &lt;% %&gt;
      
      </p>
      <hr/><br>
      <!-- 头部  -->
      <%@ include file="header.jsp" %>
      <div id = "content" style="width:600px;height:400px;background:black">
                               身体
      </div>
      <div id="footer" style="width:600px;height:100px;background:yellow">
          <div></div>
          <div></div>
      </div>
  </body>
</html>
