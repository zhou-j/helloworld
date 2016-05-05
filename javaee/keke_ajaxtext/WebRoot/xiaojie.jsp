<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println("小杰认真听课，keke给一些数据:" + username + "==="
			+ password);
	response.getWriter().print("keke数据已经收到!!!");
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--声明当前页面的三要素-->
<title>HTML模版</title>
<meta name="keyworld" content="关键词，关键词">
<meta name="description" content="">
<!--css/js-->
<style type="text/css">
* {
	margin: 10px;
	padding: 0;
}
</style>

</head>
<body>
	<form action="http://localhost:8080/keke_ajaxtext/xiaojie.jsp" >
		username0：<input type="text" name="username" id="username" /><br />
		password：<input type="text" name="password" id="password" /><br /> 
		<input	type="button" onclick="LoginAjax2()" value=" ajax登  陆 " />
	</form>
	<script type="text/javascript">
		function LoginAjax() {
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var params = "username=" + username + "&password=" + password;
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				//ajax载入完成和服务器没错误
				if (this.readyState == 4 && this.status == 200) {
					console.log(this.responseText);
				}
			};
			xhr.open("post", "http://localhost:8080/keke_ajaxtext/xiaojie.jsp",
					true);
			xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
			xhr.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;");
			xhr.send(params);//发送
		};

		function LoginAjax2() {
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value; 
			var params = "username=" + username + "&password=" + password;
			alert(params);
			request({
				type : "post",
				url : "http://localhost:8080/keke_ajaxtext/xiaojie.jsp",
				data : params,
				callback : function(data) {
					console.logs(data);
				}
			});
		};
		/*ajax初始化*/
		function request(opts) {
			var xhr;
			if (window.XMLHttpRequest) {
				xhr = new XMLHttpRequest();
			} else {

				var ids = [ "MSXML2.XMLHTTP.3.0", "Microsoft.XMLHTTP",
						"MSLXML2.XMLHTTP" ];
				for (var i = 0; i < ids.length; i++) {
					try {
						xhr = new ActiveXobject(jds[i]);
						break;
					} catch (e) {
					}
				}
			}
			//更改参数
			changeParams(opts);
			//第二步：设置请求方式，请求地址
			if (opts.type.toLowerCase() === "get") {
				xhr.open("get", opts.url + "?" + opts.data, true);
				xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
			}
			if (opts.type.toLowerCase() === "post") {
				xhr.open("post", opts.url, true);
				xhr.setRequestHeader("Content-Type",
						"application/x-www-form-urlencoded;");
				xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
				xhr.send(opts.data);
			}

			xhr.onreadystatechange = function() {
				if (this.readyState == 4) {
					if (this.status == 200) {
						var text = this.responseText;
						if (opts.callback)
							opts.callback.call(this, text);
					} else if (this.status == 400) {
						alert("网页服务不存在....");
					} else if (this.status == 500) {
						alert("服务器出现了问题...");
					}
				}
			};
		 /*更改参数*/
	     function changeParams(opts){
		     if (typeof opts.data ==="object")
		     {
			     var p="";
				 for(var k in opts.data){
				     p +=k+"="+opts.data[k]+"&";
				 } 
				 p = p.substring(0,p.length-1);
				 opts.data = p;
		     }
		 }
	};
	</script>
</body>
</html>




