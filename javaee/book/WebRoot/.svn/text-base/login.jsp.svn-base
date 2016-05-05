<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>潭州学院JavaVip试听课程-登陆-KeKe老师</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/tm_cookie.js"></script>
<script type="text/javascript" src="js/util.js"></script>
<style type="text/css">
	#message{text-align: center;height: 35px;color: red;font-weight: bold;line-height: 35px;display: none;}
</style>
</head>
<body>
<!-- contact-form -->	
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>潭州学院登陆</h1>
		<div class="alert-close"> </div> 			
	</div>
	<div id="message"></div>
		<div id="errormessage" style="border:1px solid transparent;width:20xp;height:20px;color:red">${error}</div>
		<!-- jsp就是servlet  -->
		<form method="post">
			<li>
				<input type="text" name="account" id="username" placeholder="请输入用户名称!" class="text" ><a href="#" class=" icon user"></a>
			</li>
			<li>
				<input type="password" name="password" id="password"  placeholder="请输入用户密码!"><a href="#" class="icon lock"></a>
			</li>
			<div class="clear"> </div>
			<div class="submit">
				<input type = "button" class="button" onclick = "tm_login();" value="登 陆" >
				<h4><a href="javascript:void(0);">忘记密码 ?</a></h4>
				<div class="clear">  </div>	
			</div>
		</form>
		</div>					
	</div>
	<div class="clear"> </div>
<!--- footer --->
<div class="footer">
	<p>Copyright &copy; 2014.</p>
</div>
<script type="text/javascript">
	
		//$.tmCookie.setCookie("account","sdfdsf士大夫似的水电费","s7");
		//var account = $.tmCookie.getCookie("account");
		//alert(account);
		//$.tmCookie.delCookie("account");
		
		//查询--第一次不使用ajax---分页和搜索使用ajax
	    //最大的特点就是局部刷新，无状态。
/* 	    $.ajax({
	    	type:"请求方式",
	    	url:"与服务器请求的地址",
	    	data:{"username":"shanchen","password":"123456"},//传递给服务器的值，形式是key:value
	    	beforeSend:function(){//在域服务器进行交换之前的回调函数  },
	    	error:function(){
	    		//域服务器交换失败或者服务器关闭执行的回调函数  
	    	},
	    	timeout:3000,//指明和服务器交互的时间，如果请求超过了设定的时间则自动关闭请求，单位是毫秒(ms)
	    	success:function(data){//与服务器交互成功执行的回调函数
	    		
	    	}    	
	    }); */
	    $(function(){
	    	$(document).keydown(function(e){
	    		if(e.keyCode==13){
	    			tm_login();
	    		}
	    	});
	    });
	    function tm_login(){
	    	var timer = null;
	    	var account = $("#username").val();
	    	var password = $("#password").val();
		    if(isEmpty(account)){
		    	$("#username").focus();
		    	$("#errormessage").html("请输入账号！！");
		    	return;
		    };
		    
		    if(isEmpty(password)){
		    	$("#password").focus();
		    	$("#errormessage").html("请输入密码！");
		    	return;
		    };
            clearInterval(timer);
		    timer = setTimeout(function(){
		    	$.ajax({
			        type:"post",
			        url:"http://localhost/book/login",
			        data:{"account":account,"password":password},
			        beforeSend:function(){},
			        success:function(data){
			        	//data是获取服务器给客户端的数据
			        	alert(data);
			        	if(data=="success"){
                            var url = document.referrer;//获取页面的来访页面。
                            if(isEmpty(url)){
			        		    window.location.href = "page/boo";                            	
                            }else{
                            	window.location.href = url;
                            }
			        	}else{
			        		$("#password").select();
			        		$("#errormessage").html("用户名和密码不正确");
			        	    //alert("");
			        	}
			        }
			    });	    		    	
		    });
	    };	
	
	//jquery版本
	/*function tm_submit(){
		var username = $("#username").val();
		var password = $("#password").val();
		
		if(username=="" || username.length==0){
			showMessage("username","请输入用户名称");
			return false;
		}
		
		if(username.length>16){
			showMessage("username","您输入的用户名不能超过16位!");
			return false;
		}
		
		if(password=="" || password.length==0){
			showMessage("password","请输入用户密码");
			return false;
		}
		
		if(password.length>16){
			showMessage("password","您输入的密码不能超过16位!");
			return false;
		}
		
		return true;
	}
	
	//显示提示信息的总控方法
	function showMessage(id,message){
		$("#id").focus();
		$("#message").slideDown("slow").html(message).fadeOut(3000);
	};
	*/
	
	
	//javascript版本
// 	function tm_submit(){
// 		var username = document.getElementById("username").value;
// 		var password = document.getElementById("password").value;
// 		if(username=="" || username.length==0){
// 			document.getElementById("username").focus();
// 			document.getElementById("message").style.display = "block";
// 			document.getElementById("message").innerHTML = "请输入用户名称!";
// 			return false;
// 		}
// 		if(password=="" || password.length==0){
// 			document.getElementById("password").focus();
// 			document.getElementById("message").style.display = "block";
// 			document.getElementById("message").innerHTML = "请输入用户密码!";
// 			return false;
// 		}

// 		return true;
// 	}
// 	1:获取用户名和密码
// 	2:判断用户名和密码格式
// 	3:js验证用户名和密码
// 	4:服务器验证用户名和密码的格式
// 	5:判断用户是否存在
// 	6:如果存在:服务器反馈信息给浏览器登陆成功
// 	7:如果不存在:服务器反馈信息给浏览器登陆失败

</script>

</body>
</html>