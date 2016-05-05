<%@ page language="java" import="java.util.*,com.newstart.dao.ConnectionUtil" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>省市区联动</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style>
        *{padding:0px;margin:0px;}
        body{font-size:14px;font-family:"微软雅黑";}
        fieldset{width:600px;height:200px;margin:100px auto;padding:50px;}
        #province,#city,#area{padding:6px;}
    </style>  
    <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
  </head>
  
  <body>
       <% 
/*       业务:省市区三级联动
                           时间:2016年2月27日
                           作者:newsart
                           描述:利用ajax和数据库查询实现省市区三级联动,jsp,taglib,数据库技术,jquery ajax */
         
/*       1.编写页面
         2.定义数据连接查询省市区
         3.将查询的数据返回到页面对应的select
         4.难点：给数据库分类。 */
       %>
       
       <% 
           List<HashMap<String,Object>> maps = ConnectionUtil.findProvinces();
           if(maps!=null&&maps.size()>0){
        	   pageContext.setAttribute("provinces", maps);
           }
       %>                
    <fieldset>
      <legend>省市区三级联动</legend>            
                   省份
      <select id="province" onchange="tm_select_citys(this)">
            <c:forEach var="pr" items="${provinces}">
                  <option value = "${pr.id}">${pr.province}</option>
            </c:forEach>
      </select>
                   城市
      <select id="city" onchange="tm_select_area(this)">
            <option>请选择</option>
      </select>
                   区域
      <select id="area">
            <option>请选择</option>
      </select>
     </fieldset>
     
     <script type="text/javascript">
          //通过省份Id查询所有的城市信息
          function tm_select_citys(obj){
        	  var provinceId = $(obj).val();
/*         	  var text = $(obj).find("option:selected").text();
              alert(provinceId+"======="+text); */
              //alert(provinceId);
              //发送一个ajax请求根据provinceId查询对应的城市将查询的区域的信息添加到id=city的select框中。
              if(!provinceId)return;
              $.ajax({
            	  type:"post",
            	  url:"jsp02/pdao.jsp",
            	  data:{"provinceId":provinceId},
            	  success:function(data){
            		  //alert(date.trim()+"========"+date.trim().length);
            		  var jdata = data.trim();
            		  if(jdata=="fail"){
            			  alert("查询失败");
            		  }else{
            			  //{"id":"1","province":"长沙"},{"id":"2","name":"俊州"}
            			  var jsonData = eval(jdata);//将字符串的json对象转换成json
/*             			  $("#city").html("<option>请选择</option>");
            			  $("#area").html("<option>请选择</option>");
            			  for(var i=0;i<jsonData.length;i++){
            				  $("#city").append("<option value='"+jsonData[i].id+"'>"+jsonData[i].city+"</optoin>");
            			  }
 */            	
	                      var length = jsonData.length;
	                      var html = "<option>--请选择--</option>";
	            		  $("#area").html("<option>--请选择--</option>");
	            		  for(var i=0;i<length;i++){
	            			  html+="<option value='"+jsonData[i].id+"'>"+jsonData[i].city+"</optoin>";
	            		  }
	            		  $("#city").html(html);
            		  }
            	  }
              });
          }

          function tm_select_area(obj){
        	  var cityId = $(obj).val();
/*         	  var text = $(obj).find("option:selected").text();
              alert(provinceId+"======="+text); */
              //alert(cityId);
              //发送一个ajax请求根据provinceId查询对应的城市将查询的区域的信息添加到id=city的select框中。
              if(!cityId)return;
              $.ajax({
            	  type:"post",
            	  url:"jsp02/cdao.jsp",
            	  data:{"cityId":cityId},
            	  success:function(data){
            		  //alert(date.trim()+"========"+date.trim().length);
            		  var jdata = data.trim();
            		  if(jdata=="fail"){
            			  alert("查询失败");
            		  }else{
            			  //{"id":"1","province":"长沙"},{"id":"2","name":"俊州"}
            			  var jsonData = eval(jdata);//将字符串的json对象转换成json
                          //这种方法效率不高。
            			  /*$("#area").html("<option>请选择</option>")
            			  //$("#area").empty();
            			  for(var i=0;i<jsonData.length;i++){
            				  $("#area").append("<option value='"+jsonData[i].id+"'>"+jsonData[i].area+"</optoin>");
            			  } */            			  
	                      var length = jsonData.length;
	                      var html = "<option>--请选择--</option>";
	            		  for(var i=0;i<length;i++){
	            			  html+="<option value='"+jsonData[i].id+"'>"+jsonData[i].area+"</optoin>";
	            		  }
	            		  $("#area").html(html);            			  
            		  }
            	  }
              });
          }
     </script>
  </body>
</html>
