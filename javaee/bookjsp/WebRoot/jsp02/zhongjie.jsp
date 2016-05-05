<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>九大隐式对象</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
      
      <%
         //jsp 静态内容(html)
         //jsp 一个类
         //动态部分：指令(page,include,taglib).tld,动作(jsp),脚本<% %>,注释<%-- --%>,声明<%!%>
<!--     //九大隐式对象：application session request pageContext response page config out exception -->
      
      
      <c:forEach var="i" begin="1" end="9">
          <p>  
            <c:forEach var="j" begin="1" end="${i}">
                ${i}*${j}=${i*j};  
            </c:forEach>
          </p>
      </c:forEach>
  </body>
</html>
