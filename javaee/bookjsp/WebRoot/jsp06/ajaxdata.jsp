<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
   request.setCharacterEncoding("utf-8");
   response.setCharacterEncoding("utf-8");
   String username = request.getParameter("username");
   String password = request.getParameter("password");
   String age = request.getParameter("age");
   String male = request.getParameter("male");
   String description = request.getParameter("description");
   String hobbys = request.getParameter("hobbys");
   StringBuffer buffer = new StringBuffer();
   buffer.append("用户的姓名是：<b>"+username+"</b><br>");
   buffer.append("用户的密码是：<b>"+password+"</b><br>");
   buffer.append("用户的年龄是：<b>"+age+"</b><br>");
   buffer.append("用户的性别是：<b>"+male+"</b><br>");
   buffer.append("用户的兴趣爱好是：<b>"+hobbys+"</b><br>");
   buffer.append("用户的描述是：<b>"+description+"</b><br>");
   out.print(buffer.toString());
%>