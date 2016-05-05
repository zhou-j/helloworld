<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>   
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	    *{padding:0px;margin:0px;}
	    body{font-size:14px;font-family:"微软雅黑"}
	    fieldset{width:640px;margin:100px auto;height:280px;padding:10px;}
	</style>
  </head>
   
  <body>
    <fieldset>
        <legend>文件上传</legend>
        <!-- application/x-www-form-urlencoded -->
        <!-- 
                             步骤：
          1:导入：commons-fileupload-1.3.1.jar 和 commons-io-2.2.jar
          2:定义一个form表单：enctype="multipart/form-data"
                                    注意：name="file"这个一定要写。
          3:定义一个UploadAction类，上传文件类。
          4:为什么我们要进行文件上传?
          5:上传文件的原理是什么？为什么要这样做?      
         -->
         <!-- 
                             文件上传它是一种把客户端的文件复制到服务器的容器的某个目录下的一种行为，它以字节流的方式进行数据的传输。
                             那么就必须更改你的form表单的entype="multipart/form-data"
                             默认:application/x-www-form-urlencoded:以URL的形式把form表单中name含有value元素的值传递给服务器，通过request.getParameter                   
          -->
        <form action="upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="submit" value="提交">
        </form>
    </fieldset>    
  </body>
</html>
