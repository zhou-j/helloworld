<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
   request.setCharacterEncoding("utf-8");
   //response.setCharacterEncoding("utf-8");
   //获取用户名的文本值:
   String username = request.getParameter("username");
   //获取密码
   String password = request.getParameter("password");
   //年龄select name="age"
   String age = request.getParameter("age");
   //性别 type="radio"
   String male = request.getParameter("male");
   //兴趣?type="checkbox"
   String [] hobbys = request.getParameterValues("hobbys");
   StringBuffer buf = new StringBuffer();
   for(String h:hobbys){
	   buf.append(h+" ");
   }
   //描述
/* String description = request.getParameter("description");
   StringBuffer buffer = new StringBuffer();
   buffer.append("用户名是:"+username+"<br>");
   buffer.append("用户密码是:"+password+"<br>");
   buffer.append("用户年龄是:"+age+"<br>");
   buffer.append("用户兴趣爱好是:<b>"+buf.toString()+"</b><br>");
   buffer.append("用户性别是:"+male+"<br>");
   buffer.append("用户描述是:"+description+"<br>");
   out.print(buffer.toString()); */
   
   Map<String,String[]> map = request.getParameterMap();
   for(Map.Entry<String,String[]> entry:map.entrySet()){
	   String[] strings = (String[])entry.getValue();
	   if(strings!=null && strings.length==1){
		    System.out.println(entry.getKey()+"====="+strings[0]);
	   }
	   
	   if(strings!=null && strings.length > 1){
		   for(String str : strings){
			   System.out.println(entry.getKey()+"======="+str);
		   }
	   }
   }
 
%>