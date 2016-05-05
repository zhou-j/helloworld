<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<head>
<title>潭州组件文件上传</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link href="js/upload/upload.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/upload/tz_upload.js"></script>
</head>
<body>
<span id="tmupload"></span>
<div id="test"></div>
<script type="text/javascript">
	$.tmUpload({"fileTypes":"*.jpg;*.gifl;*.png",callback:function(data,file){
		var jdata = eval("("+data+")");
		$("#test").append("<p>"+jdata.name+"<img width='200' height='200' src='"+jdata.url+"'>大小:"+jdata.sizeString+"</p>")
	}});
</script>
</body>
</html>