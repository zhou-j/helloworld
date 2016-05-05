<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
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
<!--   动态部分的:指令,动作jsp:脚本,注释等 -->
<!--   创建一个对象  User user = new User();-->
      <jsp:useBean id="user" class="com.newstart.bean.User" scope="page"></jsp:useBean>
<!--   给属性赋值：user.setUserName("keke"); -->
      <jsp:setProperty property="username" name="user" value="潭州-码上有媳妇"></jsp:setProperty>
<!--   获取属性值：user.getUserName() -->
      <jsp:getProperty property="username" name="user"/>         
 <!-- 两者的区别是什么？page taglib include 只编译一次就可以到处运行 jsp:include一个动作，在用户每次访问的时候都会动态执行 -->
      <jsp:include page="test.html"></jsp:include>
      <%//这里是静态包含 %>
      <%@include file="test.html" %>
  </body>
</html>
