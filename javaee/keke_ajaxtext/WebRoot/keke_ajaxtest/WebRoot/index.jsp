<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Document</title>
 </head>
 <body>
  
	<!--
		get /post /put /delete

		get基于浏览器请求，
			1:直接在浏览器输入框输入一个地址进行请求
			2:点击a连接是一个get请求
			3:通过form指明method="get"
			4:ajax 指明请求方式get

        post:form里面method="post"
		     ajax里面指明post请求


        他们区别在于：get发送给服务器段数量是有限的
		get请求的URL每个浏览器都有字符串的长度的限制，它不适用于大文本数据的传递
		用post

		get会暴露参数信息，不安全
		post安全，不会暴露
	
	-->
	<form action="http://localhost/keke_ajaxtest/xiaojie.jsp" method="get">	
		<input type="text" name="username"/>
		<input type="password" name="password"/>
		<input type="text" name="code"/>
		<input type="submit" value="form登陆"/>
	</form>
	<hr/>
	<!--ajax-->
	<form action="#" method="post">	
		<input type="text" name="username" id="username"/>
		<input type="password" name="password" id="password"/>
		<input type="button" onclick="loginAjax2()" value="ajax登陆"/>
	</form>



	<script type="text/javascript">
		/*
			
			XMLHttpRequest i8+ 你口中所说的ajax
			它是构建HTTP请求的javascript对象,在早期它是ActiveX对象形式存在，
			服务器端和客户端数据传递过程异步的问题，早期数据的传递一个字符串一个xml
			实际上，ajax就是在javascript和xml之间建立一种异步传输的方式

			

			xml:为什么出现xml文档格式：
			一种有格式方便进行管理和解析


			它只不过是另外一种Http请求而已，它和form表单原理是一样，只不过不会刷新页面进行一种异步的交互
		*/

		function loginAjax(){
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var params = "username="+username+"&password="+password;
			//创建一个(ajax)xhr对象
			var xhr = new XMLHttpRequest();
			//true代码的是异步请求,执行成功和失败回调函数
			//请求的状态, readyState 
			//0:未初始化状态
			//1:载入请求的状态
			//2:载入完成状态
			//3:请求交互状态
			//4:请求完成状态

			//可以捕获服务器错误，知识点：status
			//500 服务器连接失败 ---服务器关闭
			//404 代表页面找到
			//400 Bad Request请求语法。url写错了，请求地址有问题
			//405 请求方式有问题 springmvc  methpd=RequestMethod.POST
			//200 代表交互成功,正确请求和响应
			xhr.onreadystatechange = function(){
				//ajax载入完成和服务器没错误
				if(this.readyState == 4 && this.status ==200){
					alert(this.responseText);
				}
			};
			//请求方式:post/get
			//get请求的方式如下:
			//xhr.open("get","http://localhost/keke_ajaxtest/xiaojie.jsp"+params,true);
			//xhr.send();
			//post请求的方式如下:
			xhr.open("post","http://localhost/keke_ajaxtest/xiaojie.jsp",true);
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;"); 
			xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
			//发送数据,如果请求方式是post话send一定要设置参数
			xhr.send(params);//发送
		};
		
		
		function loginAjax2(){
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var params = "username="+username+"&password="+password;
			request({
				type:"post",
				url:"http://localhost/keke_ajaxtest/xiaojie.jsp",
				params:params,
				callback:function(data){
					alert(data);
				}
			});
		};

		function request(opts){
			//ajax初始化
			var xhr =null;
			if(window.XMLHttpRequest){
				xhr = new XMLHttpRequest();
			}else{
				var ids = ["MSXML2.XMLHTTP.3.0","Microsoft.XMLHTTP","MSXML2.XMLHTTP"];
				for(var i=0;i<ids.length;i++){
					try{	
						xhr = new ActiveXObject(ids[i]);
						break;
					}catch(e){
					
					}
				}
			}
			//第二步：设置请求方式，请求地址
			if(opts.type.toLowerCase() === "get"){
				xhr.open("get",opts.url+"?"+opts.params,true);
				xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
			}

			if(opts.type.toLowerCase() === "post"){
				xhr.open("post",opts.url,true);
				xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");
				xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
				xhr.send(opts.params);
			}

			xhr.onreadystatechange = function(){
				if(this.readyState == 4){
					if(this.status == 200){
						var text = this.responseText;
						if(opts.callback)opts.callback.call(this,text);
					}else if(this.status ==404){
						alert("网页不存在...");
					}else if(this.status ==500){
						alert("服务器出现问题...");
					}
				}
			};
		};
		
		
		
		
	</script>

 </body>
</html>