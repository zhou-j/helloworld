<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>   
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <style type="text/css">
         *{margin:0;padding:0;}
         body{font-size:18px;font-family:"微软雅黑";color:#fff;overflow:hidden;}
         #container{width:100%;}
         #container .header{width:100%;height:33%;background:#267169;position:relative;}
         .header .logo{position:absolute;bottom:30px;left:45%;}
         #container .main{width:100%;height:67%;background:#008EFF;}
         #container .foot{padding-bottom:10px;text-align:center;}
         p{padding:30px 0 0;}
         #container .main .loginform{width:300px;height:300px;margin-left:42%;padding-top:45px;}
         #container .main .loginform .username,.password{width:180px;height:26px;}
         .regbtn{margin-left:91px;display:inline-block;background:white;font-size:12px;text-decoration:none;}
         #container .main .loginform .btn{width:80px;height:28px;outline:none;border:none;color:#666;font-family:"微软雅黑";margin-top:25px;border-radius:4px;line-height:28px;text-align:center;}
         .loginbtn{margin-left:1px;cursor:pointer;}
     </style>
  </head>
  
  <body>
   <div id="container">
     <div class="header">
          <div class="logo"><img src="images/logo.png" width="189" height="43"></div>
     </div>
     <div class="main">
      <form class="loginform">
        <div style="height:20px;text-align:center;"><span id="message"></span></div>
        <p>用户名：<input type="text" class="username" placeholder="请输入用户名" /></p>
        <p>密码：&nbsp;&nbsp;&nbsp;<input type="password" class="password" placeholder="请输入密码"/></p>
        <p><input type="button" class="btn loginbtn" id="loginbtn" onclick="tmlogin(this)" value="登录" /><a class="btn regbtn" href="http://localhost/yunpan/signup.jsp">注册</a> 
      </form>           
     <p class="foot">Copyright &copy;2016 newstart All Rights Reserved</p>      
     </div>
   </div>
   <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>     
   <script type="text/javascript" src="js/util.js"></script>     
   <script type="text/javascript">
       $(function(){
    	  $("#container").height($(window).height());
    	  $("#container").find(".username").focus();
    	  $(document).keydown(function(e){
    		  if(e.keyCode==13){
    			  $("#loginbtn").trigger("click");
    		  } 
    	  });
       });
       function tmlogin(obj){   	   
           var $username = $("#container").find(".username");
           var $password = $("#container").find(".password");
           var username = $username.val();
           var password = $password.val();
           //alert(text);
           if(isEmpty(username)){
           	//stop(true,true)清除所有的动画，包括上次点击的动画。
              tm_showmessage("请输入用户名！");
              $username.focus();
              return;
           }
           if(isEmpty(password)){
        	   tm_showmessage("请输入密码！");
              $password.focus();
              return;
           }
           
           $(obj).attr("value","登录中...").removeAttr("onclick");
           $.ajax({
           	type:"post",
           	url:"http://localhost/yunpan/service/searchUser.jsp",
           	error:function(){$(obj).attr("value","登录").attr("onclick","tmlogin(this)");},
           	data:{"username":username,"password":password},
           	success:function(data){
           		var jdata = data.trim();
           		if(jdata=="success"){
           			alert("登录成功！");
           			window.location = "http://localhost/yunpan/index.jsp";
           		}else if(jdata=="empty"){
           			tm_showmessage("用户名或者密码不能为空！");
           			$(obj).attr("value","登录").attr("onclick","tmlogin(this)");           			
           		}else{
           			//用户登录错误把密码清空，防止服务器重复提交。
           			$password.val("");
           			tm_showmessage("用户名或者密码不正确！");
           			$username.select();
           			$(obj).attr("value","登录").attr("onclick","tmlogin(this)");             			
           		}
           	}
           });    	   
       }
       
       function tm_showmessage(message){
  		    $("#message").show().html(message).stop(true,true).fadeOut(3000);    	   
       }
   </script>         
  </body>
</html>
