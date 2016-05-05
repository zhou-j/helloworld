<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'file.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../js/upload/upload.css">
	<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="../js/upload/tz_upload.js"></script>
	<script type="text/javascript" src="../js/util.js"></script>
  </head>
  <body>
  		<%
  			String target = request.getParameter("target");
  			pageContext.setAttribute("target", target);
  		%>
		<div id="tmupload222"></div>
		<div id="box">
		
		</div>
		<script type="text/javascript">
			var arr = [];
			$(function(){
				$.tmUpload({
					btnId:"tmupload222",//按钮
					url:"/report/uploadfile2",//上传的地址
					limitSize:"10 MB",/*MB*///上传文件限制的大小
					fileTypes:"*.jpg;*.zip",//过来文件选择的类型*.jpg;*.gif
					multiple:false,
					callback:function(data,file){
						arr.push(data);
						//alert(file.name+"==="+file.size);
						var jdata = eval("("+data+")");
						$("#box").append("<img width='200' height='200' src='../"+jdata.url+"'>大小是:"+tm_countFileSize(jdata.size));
						jdata.target = "${target}";
					}
				});	
			});
			
			function tm_callback(callback){
				if(arr.length==0){
					alert("请上传文件");
					return false;
				}
						
				if(callback)callback(jsonToString(arr));
			}
		</script>  
  </body>
</html>