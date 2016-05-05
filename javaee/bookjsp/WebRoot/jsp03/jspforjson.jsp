<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>ajax解析json</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
  </head>
  
  <body>
                城市:
     <select id="citySelect" onchange="selectCity(this)">
        
     </select>
              城市信息:
     <textarea id="message" style="width:600px;height:100px;line-height:100px;text-align:center;"></textarea>
     <%
         /*
		           业务：解析json文件
		           时间：2016/2/28
		           作者：newstart
		           描述：利用ajax技术解析json,获取json的数据。
         */
     %>
     <script type="text/javascript">
/*          var obj = {
        		 name:"keke",
        		 age:"29",
        		 address:"长沙雨花区西子一间给大家分享课程！"
         };
         alert(obj.name+"======"+obj.age+"======"+"======"+obj.address);
         
         var jsonArr = [];
         var userJson1 = {"name":"小郭","age":20};
         var userJson2 = {"name":"媳妇","age":21};
         var userJson3 = {"name":"keke","age":22};
         var userJson4 = {"name":"小贷","age":23};
         var userJson5 = {"name":"JSON","age":24};
         jsonArr.push(userJson1);
         jsonArr.push(userJson2);
         jsonArr.push(userJson3);
         jsonArr.push(userJson4);
         jsonArr.push(userJson5);
         for(var i=0;i<jsonArr.length;i++){
        	    var jsonString = jsonToString(jsonArr[i]);
        	    alert(jsonString+"======="+jsonString.length);
         } */
         $(function(){
        	$.ajax({
        		type:"post",//请求的方式get，post
        		url:"city.json",//请求的地址或者文件.jsp,.action,.do/servlet.html
        		beforeSend:function(){//页面加载之前执行的回调函数
            		
            	},
            	//timeout:2000,//告诉你和服务器交互的时间只有两秒，如果你和服务器请求的时间超过了timeout设定的时间，服务器自动断开。
            	//data:{"username":username,"password":password},//传递给服务器的参数
            	success:function(data){//与服务器交互成功进入的回调函数
                    var jsonArr = data;
            	    var length = jsonArr.length;
            	    if(jsonArr!=null && length>0){
            	    	var html="<option>--请选择--</option>";
            	    	for(var i=0;i<length;i++){
            	    		var cityName = jsonArr[i].name;
            	    		var description = jsonArr[i].description;
            	    		html +="<option value='"+cityName+"'description='"+description+"'>"+cityName+"</option>";
            	    	}
            	    	$("#citySelect").html(html);
            	    }            		
            		//jquery解析xml
            		/*  $(data).find("City").each(function(){
             			var cityName = $(this).attr("Name");
             			var description = $(this).find("Description").text();
             			alert(cityName+"==========="+description);
             		}); */
             	} 
        	});
        	
         });
         function selectCity(obj){
             var description = $(obj).find("option:selected").attr("description");
             $("#message").val(description);        	 
         }
   		 
         function jsonToString(obj) {
  			var THIS = this;
  			switch (typeof (obj)) {
  			case 'string':
  				return '"' + obj.replace(/(["\\])/g, '\\$1') + '"';
  			case 'array':
  				return '[' + obj.map(THIS.jsonToString).join(',') + ']';
  			case 'object':
  				if (obj instanceof Array) {
  					var strArr = [];
  					var len = obj.length;
  					for (var i = 0; i < len; i++) {
  						strArr.push(THIS.jsonToString(obj[i]));
  					}
  					return '[' + strArr.join(',') + ']';
  				} else if (obj == null) {
  					return 'null';

  				} else {
  					var string = [];
  					for ( var property in obj)
  						string.push(THIS.jsonToString(property) + ':'
  								+ THIS.jsonToString(obj[property]));
  					return '{' + string.join(',') + '}';
  				}
  			case 'number':
  				return obj;
  			case false:
  				return obj;
  			}
  		}
         
     </script>
  </body>
</html>
