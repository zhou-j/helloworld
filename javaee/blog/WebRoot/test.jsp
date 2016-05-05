<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSP文件上传</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  
  	<!-- 
  		描述:文件上传
  		1:引入common-fileupload-1.2.jar
  		2:建立upload.jsp文件作为上传服务器的处理类
  		3:建立test.jsp页面作为上传页面
  		form表单一定要指明:enctype="multipart/form-data"
  	 -->
  	 <h1>文件上传</h1>
  	 <form action="upload.jsp" method="post" enctype="multipart/form-data">
  	 	<input type="file" name="file">
  	 	<input type="submit" value="文件上传"> 
  	 </form>
  	 
  	 
  	 <script type="text/javascript">
  	 
	  	/* 文件大小转换为MB GB KB格式 */
	  	function tm_countFileSize(size) {
	  		var fsize = parseFloat(size, 2);
	  		var fileSizeString;
	  		if (fsize < 1024) {
	  			fileSizeString = fsize.toFixed(2) + "B";
	  		} else if (fsize < 1048576) {
	  			fileSizeString = (fsize / 1024).toFixed(2) + "KB";
	  		} else if (fsize < 1073741824) {
	  			fileSizeString = (fsize / 1024 / 1024).toFixed(2) + "MB";
	  		} else if (fsize < 1024 * 1024 * 1024) {
	  			fileSizeString = (fsize / 1024 / 1024 / 1024).toFixed(2) + "GB";
	  		} else {
	  			fileSizeString = "0B";
	  		}
	  		return fileSizeString;
	  	};
  	 </script>
  </body>
</html>
