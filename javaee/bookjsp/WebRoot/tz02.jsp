<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tz02.jsp' starting page</title>
    
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
      
          &lt;!-- 动态指令 --&gt;<br><br>
          &lt;%@(page/include/taglib)%&gt;<br><br>
                             脚本<br><br>
          &lt;%<br>
              //java片段化代码,他最终编译到service方法内部<br>
          %&gt;<br><br>
                              表达式<br><br>
          &lt;%=expression<br>
             //编译到service对应代码块是：out.print(expression);<br>
          %&gt;<br><br>
          
          out.print(getName());<br><br>
          
                              声明<br><br>
          &lt;%!<br>
                                        在这里定义方法和属性，定义的方法和属性给谁用 <br>
          %&gt;<br><br>
          
          &lt;!-- 只能注释html元素 --&gt;<br><br>
          &lt;%-- 能注释脚本和html元素--%&gt;<br><br>
       ============<%= getName() %>=========<br><br>
       <% out.println(getName()); %><br>
       <%!
           public static String getName(){
    	       return "keke";
       }
       %>
  </body>
</html>
