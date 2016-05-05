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
	<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="../js/util.js"></script>
  </head>
  <body>
    <input type="text"> <a href="javascript:void(0)" onclick="tm_upload_file(this)">上传头像</a><br><br>
    <input type="text"> <a href="javascript:void(0)" onclick="tm_upload_file(this)">上传头像</a><br><br>
    <input type="text"> <a href="javascript:void(0)" onclick="tm_upload_file(this)">上传头像</a><br><br>
    
    <script type="text/javascript">
    	
    	function tm_upload_file(obj){
    		$("#uploadbox").remove();
    		var target = $(obj).attr("id");
    		var $box = $("<div id='uploadbox'><iframe id='contentDialog' width='640' height='460' border='0' src='http://localhost:8080/report/upload/file.jsp?target="+target+"'></iframe><input type='button' id='sure' value='确定'><input type='button' id='cancle' value='取消'></div>");
    		$box.css({"position":"fixed",width:640,height:460,top:100,left:100,"border":"1px solid #ccc"});
    		$("body").append($box);
    		$box.find("#sure").click(function(){
    			var iframeDom = document.getElementById("contentDialog").contentWindow;
    			iframeDom.tm_callback(function(data){
    				var arr = eval(data);
    				for(var i=0;i<arr.length;i++){
    					var jdata = eval("("+arr[i]+")");
    					$(obj).prev().val(jdata.url);
    				}
    				$box.find("#cancle").trigger("click");
    			});
    		});
    		
    		
    		
    		$box.find("#cancle").click(function(){
    			$box.remove();
    		});
    	}
    	
    </script>
  </body>
</html>
