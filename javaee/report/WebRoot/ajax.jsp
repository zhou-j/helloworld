<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'ajax.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/util.js"></script>
  </head>
  <body>
  	<input type="text" id="username">
  	<a  href="javascript:void(0)"  onclick="tm_save_user(this)">执行ajax请求</a>
  	
  	<script type="text/javascript">
  		//this----->
  		//json:获取数据的方式两种
  		//this:
  		function tm_save_user(obj){
  			var username = $("#username").val();
  			//if(isEmpty(username)){//空格，tab 多个空格
  			if(username.isEmpty()){
  				$("#username").focus();
  				alert("请输入用户名！");
  				return false;
  			}
  			var params = {"user.username":username,"user.password":"123456"};
  			params["user.age"] = 10;
  			$.ajax({
  				type:"post",//请求方式
  				url:"json/method",//请求服务器的地址
  				data:params,//给服务器传递参数,HttpServletRequest
  				beforeSend:function(){
  					//在和服务器请求之前执行的一个回调方法
  					//给一个合理的提示，
  				},
  				error:function(){
  					//与服务器断开了连接，或者请求失败，
  				},
  				success:function(data){
  					//out.print("xxxxx")==string
  					//json对象
  					var jdata = eval("("+data+")");
  					alert(data);
  					var arr = jdata;
  					for(var i=0;i<arr.length;i++){
  						$("body").append("<div>"+arr[i].username+"==="+arr[i].password+"==="+arr[i].address+"</div>");
  					}
  					//和服务器端请求成功返回数据的回调方法
  					//alert(data.user.username+"===="+data.user.password);//string字符串 HttpServletResponse
  				}
  			});
  		}
  		
  		
  		String.prototype.isEmpty = function(){
  			var val = this;
  			if (val == null)
  				return true;
  			if (val == undefined || val == 'undefined')
  				return true;
  			if (val == "")
  				return true;
  			if (val.length == 0)
  				return true;
  			if (!/[^(^\s*)|(\s*$)]/.test(val))
  				return true;
  			return false;
  		};
  		
  		String.prototype.isNotEmpty = function(){
  			return !this.isEmpty();
  		};
  		
  		alert(new Date().format("yyyy年MM月dd日 HH:mm:ss"))

  		
  		//关于javascript的json
  		//HashMap == Javabean
  		var json = {
  			"age":28,
  			"username":"keke",
  			"user.username":"士大夫士大夫士大夫"
  		};
  
  		//alert(json["user.username"]);
  		//alert(json.age);
  		//alert(json.username);
  		
  	</script>
  </body>
</html>
