<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>ajaxform表单提交</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
	   <fieldset>
	      <legend>form表单常见的问题和解决方案</legend>
	      <form id="registerForm" action="data.jsp" method="post">
	          <p>用户:<input type="text" autofocus="autofocus" maxlength="9" name="username" id="username" placeholder="请输入用户名....."></p>
	          <p>密码:<input type="password" name="password" maxlength="9" id="password" placeholder="请输入密码....."></p>
	          <p>年龄:<select name="age" id="age">
	                    <option>1</option>
	                    <option>12</option>
	                    <option>13</option>
	                    <option>31</option>
	                    <option>21</option>
	                 </select>
	           <p>性别:<label><input type="radio" class="male" name="male" value="1">男</label>&nbsp;&nbsp;
	                  <label><input type="radio" class="male" name="male" value="0">女</label></p>
	           <p>兴趣:<label><input type="checkbox" class="hobbys" name="hobbys" value="看书">看书</label>&nbsp;&nbsp;
	                  <label><input type="checkbox" class="hobbys" name="hobbys" value="看电影">看电影</label>&nbsp;&nbsp;
	                  <label><input type="checkbox" class="hobbys" name="hobbys" value="游泳">游泳</label></p>
	           <p>描述:<textarea style="width:230px;height:100px;" name="description" id="description" placeholder="请输入用户描述"></textarea></p>
	           <p><input type="button" onclick="tm_saveuser();" value="保存"></p>
	      </form>     
	    </fieldset>
	    <script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
	    <script type="text/javascript">
	         //一定要选中第一个文本框输入。
	         //通过ajax form表单提交--serialize()--jquery/javascript--获取表单的值
	         //jquery serialize();
	         //作业：通过ajax方式提交进行form表单提交
	         function checkvalues(formId){
	        	 var arr = [];
	        	 var hobbys = document.getElementById(formId).hobbys;
	        	 alert(hobbys);
	        	 for(var i=0;i<hobbys.length;i++){
	        		 if(hobbys[i].checked){
	        			 arr.push(hobbys[i].value);
	        		 }
	        	 }
	        	 return arr.toString();
	         };
	         /*保存用户信息*/
	         //jQuery代码
	         function tm_saveuser(){
	        	 //jquery版本form元素:text password select checkbox radio textarea
	        	 var username = $("#username").val();
	             var password = $("#password").val();
	             var age = $("#age").val();
	             //元素方式获取
	             var male = $("input[type='radio'][name='male']:checked").val();
	             var hobbys = $("input[type='checkbox'][name='hobbys']:checked");
	             //class选择
//	             var male = $(".male:checked").val();
//	             var hobbys = $(".hobbys:checked").val();
	             var arr = [];
	             hobbys.each(function(){
	            	 arr.push($(this).val());
	             });
	             var hobbysval = arr.toString();
	             var description = $("#description").val();
	             alert(username+"====="+password+"====="+age+"====="+male+"====="+arr.toString()+"====="+description);
	             alert(typeof arr);
		         var params = {
		             "username":username,
		             "password":password,
		             "age":age,
		             "male":male,
		             "hobbys":hobbysval,
		             "description":description
		         };	        	 

	        	 $.ajax({
	        		 type:"post",//请求方式
	        		 url:"ajaxdata.jsp",
	        		 data:params,//往服务器传递数据
	        		 beforeSend:function(){},//服务器请求之前执行的方法
	        		 success:function(data){//服务器请求完毕执行的回调方法
	        			 alert(data);
	        		 }
	        	 });
	         }
	         
	         //js代码
/* 	         function tm_saveuser(){
		         var username = document.getElementById("username").value;
		         var password = document.getElementById("password").value;
		         var age = document.getElementById("age").value;
		         var male = document.getElementById("registerForm").male.value;
		         var hobbys = checkvalues("registerForm");
		         var description = document.getElementById("description").value;
		         var params = {
		             "username":username,
		             "password":password,
		             "age":age,
		             "male":male,
		             "hobbys":hobbys,
		             "description":description
		         };	        	 

	        	 $.ajax({
	        		 type:"post",//请求方式
	        		 url:"ajaxdata.jsp",
	        		 data:params,//往服务器传递数据
	        		 beforeSend:function(){},//服务器请求之前执行的方法
	        		 success:function(data){//服务器请求完毕执行的回调方法
	        			 alert(data);
	        		 }
	        	 });
	         } */
	    </script>
  </body>
</html>
