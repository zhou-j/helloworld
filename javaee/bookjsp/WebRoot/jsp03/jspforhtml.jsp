<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>ajax解析xml</title>
    
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
		           业务：解析xml文件
		           时间：2016/2/28
		           作者：newstart
		           描述：利用ajax技术解析xml,获取xml的数据。
         */
     %>
     <script type="text/javascript">
         $(function(){
        	$.ajax({
        		type:"post",//请求的方式get，post
        		url:"city.html",//请求的地址或者文件.jsp,.action,.do/servlet.html
        		beforeSend:function(){//页面加载之前执行的回调函数
            		
            	},
            	//timeout:2000,//告诉你和服务器交互的时间只有两秒，如果你和服务器请求的时间超过了timeout设定的时间，服务器自动断开。
            	//data:{"username":username,"password":password},//传递给服务器的参数
            	success:function(data){//与服务器交互成功进入的回调函数
                    //js解析xml
/*                  var html="<option>--请选择--</option>";
                    var cityListArr = data.getElementsByTagName("CityList");
            	    for(var i=0;i<cityListArr.length;i++){
       	            	var citysArr = cityListArr[i].getElementsByTagName("City");      	           
       	            	var len = citysArr.length;
       	            	for(var j=0;j<len;j++){
       	            		var cityName = citysArr[j].getAttribute("Name");
       	            		var description = citysArr[j].getElementsByTagName("Description")[0].childNodes[0].nodeValue;
                            //alert(citysArr[j].getElementsByTagName("Description")[0].text);
       	              // 	var name = citysArr[j].getElementsByTagName("name")[1].childNodes[0].nodeValue;
       	            		html +="<option value='"+cityName+"'description='"+description+"'>"+cityName+"</option>";
       	                    //alert(description);
       	            	}
       	            	$("#citySelect").html(html);
       	            }
            		 */
            		//jquery解析xml
            		 var html="<option>--请选择--</option>";             			
            	     //alert(cityName);
            		 $(data).find(".city").each(function(){
            			var cityName = $(this).attr("name");
               			var description = $(this).find(".description").text();
               			html +="<option value='"+cityName+"'description='"+description+"'>"+cityName+"</option>";             			
             		});
            		$("#citySelect").html(html);
             	} 
        	});
        	
         });
         function selectCity(obj){
             var description = $(obj).find("option:selected").attr("description");
             $("#message").val(description);        	 
         }
     </script>
  </body>
</html>
