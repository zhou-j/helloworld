<%@ page language="java" import="java.util.*,com.yunpan.bean.Resource,com.yunpan.bean.User,com.yunpan.dao.ResourceDao,com.yunpan.util.StringUtil" pageEncoding="UTF-8"%>
<!-- c标签 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 自定义函数标签 -->
<%@taglib uri="/WEB-INF/tld/tz.tld" prefix="tz"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8" />
<head>
<title>潭州组件文件上传--云盘技术</title>
<!-- 布局样式 -->
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<!-- 上传样式 -->
<link href="js/upload/upload.css" rel="stylesheet" type="text/css" />
<!-- jquery核心js -->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!-- 工具JS -->
<script type="text/javascript" src="js/util.js"></script>
<!-- 拖动JS -->
<script type="text/javascript" src="js/tmdrag.js"></script>
<!-- 弹出层js -->
<script type="text/javascript" src="js/tmDialog.js"></script>
<!-- 上传组件js -->
<script type="text/javascript" src="js/upload/tz_upload.js"></script>
<!-- 去除页面的滚动条 -->
<style type="text/css">
html,body {
	overflow: hidden;
}
.tmui-btns{display:none;}
.name-text{position: relative;top: 7px;width:200px;height:26px;line-height: 26px;padding-left:13px;border-radius:3px;}
h1{font-size:22px;font-family:"微软雅黑";text-align:center;}
.sitem{display:block;height:45px;width:100%;}
.btns{padding:8px 10px;background:#666;border-radius:2px;margin-right:3px;margin-left:13px;}
.btns:hover{background:#999;}
.btns a{text-decoration:none;}
.sbtn{padding:5px 10px;background:#456CDC;border-radius:3px;margin-left:185px;}
.sbtn:hover{background:#446ED9;}
</style>
<!-- 
		---初学者,有点经验
		1：先写业务,而不是先写特效。是项目里面需要他的时候自然而然就去学习的.比如:验证码，文件上传。
		2：一定是先写业务，必须一定讲业务的代表CURD 增删查改 先把数据库把保存在表中。
		3：在思考数据合法性，完整性-----验证/js /服务器端的验证也好
	 -->
</head>
<body>
	<div id="container">
		<div id="header">
			<div class="fl logo">
				<a href="http://www.tanzhouedu.net/index"><img
					src="images/logo.png"></a>
			</div>
			<div class="fr">
				<h1>潭州学院云盘实现功能</h1>
			</div>
		</div>
		<div id="mainContent">
			<div id="sidebar">
				<ul>
					<li><a class="sitem" href="http://localhost/yunpan/index.jsp">全部文件</a></li>
					<li><a class="sitem" href="http://localhost/yunpan/index.jsp?t=1">文件</a></li>
					<li><a class="sitem" href="http://localhost/yunpan/index.jsp?t=2">图片</a></li>
					<li><a class="sitem" href="http://localhost/yunpan/index.jsp?t=3">视频</a></li>
					<li><a class="sitem" href="http://localhost/yunpan/index.jsp?t=4">其他</a></li>
					<li>回收站</li>
				</ul>
			</div>
			<!-- 内容区域 -->
			<div id="content">
				<div id="box">
					<div class="header fl" style="width: 100%;">
						<div class="upload fl">
							<span id="tmupload"></span>
						</div>
						<div class="fl" style="margin-left: 40px;">
							<a href="javascript:void(0)" class="btns" op="on" id="checkall">全选</a>
							<a href="javascript:void(0)" class="btns">新建文件夹</a>
							<a href="javascript:void(0)" class="btns" onclick="tm_deleteResources()">批量删除</a>
							<span style="margin-left:580px;color:#666;font-size:16px;margin-right:35px;">当前登录的用户是：${user.username}</span>
							<a href="http://localhost/yunpan/service/loginout.jsp">退出</a>
						</div>
					</div>
					<!-- 内容包含区 -->
					<ul class="fl" style="width: 100%;" id="contentbox">
                     
					</ul>
					<!-- 内容包含区 -->
					<div style="clear:both;"></div>
					<div style="height:30px;padding:20px 0 10px 300px;">
					<a href="javascript:void(0)" class="sbtn prev">上一页</a>
					<a href="javascript:void(0)" class="sbtn next">下一页</a>
					<span id="totalcount"></span>
					</div>
				</div>
			</div>
			<!-- 内容区结束 -->
		</div>
	</div>
    <script type="text/javascript">
    
    $(function(){
       var pageSize = 10;
       var pageNo =0;    	
       tm_search_resource(pageNo,pageSize,tm_init_page);
    });
    function tm_init_page(talcount){
        var pageSize = 10;
        var pageNo =0;      	
        $(".prev").click(function(){
     	   //pageindex++;
     	   if((pageNo-pageSize)<0){
     		   $(this).css("background","#666");
     		   return;    		   
     	   }
     	   pageNo = pageNo-pageSize;
     	   tm_search_resource(pageNo,pageSize);      	   
     	   $(".next").css("background","#456CDC");
        });	
       
        $(".next").click(function(){
           alert(pageNo+"======"+pageSize);
     	   if((pageNo+pageSize)>=talcount){
     		   $(this).css("background","#666");
     		   return;
     	   }
     	   pageNo = pageSize+pageNo;
     	   //pageindex++;
     	   tm_search_resource(pageNo,pageSize);    	   
     	   $(".prev").css("background","#456CDC");
        });    	
    };
    function tm_search_resource(pageNo,pageSize,callback){
        $.ajax({
        	type:"post",
        	url:"http://localhost/yunpan/service/search.jsp",
        	beforeSend:function(){
        	    $("#contentbox").html("<div style='text-align:center;'><img src='images/loading.gif'></div>");
        	},
        	data:{"pageNo":pageNo,"pageSize":pageSize},
        	success:function(data){
        		var jdata = data.trim();
        		var jsonData = eval("("+jdata+")");
        		if(callback)callback(jsonData.count);
        		var rsjsonData = jsonData.resources;
        		var html = "";
        		var length = rsjsonData.length;
        		for(var i=0;i<length;i++){
        			html+="<li class='items' id='tm-items-"+rsjsonData[i].id+"'>"+
					"	<div class='col c1' style='width: 50%;'>"+
					"		<span class='chk fl'></span>"+
					"		<span class='fl icon'>"+
					"		   <input type='checkbox' class='chk' value='"+rsjsonData[i].id+"'>"+
					"		   <img src='images/text.png'>"+
					"		</span>"+
					"		<div class='name fl'>"+
					"			<span class='name-text' title='"+rsjsonData[i].name+"' data-opid='"+rsjsonData[i].id+"'>"+rsjsonData[i].name+"</span>"+
					"		    <a href='javascript:void(0);' class='tmui-btns save'>确定</a>&nbsp;&nbsp;"+
					"		    <a href='javascript:void(0);' class='tmui-btns cancle'>取消</a>&nbsp;&nbsp;"+										
					"		</div>"+
					"	</div>"+
					"	<div class='col' style='width: 16%'	title='字节大小:"+rsjsonData[i].size+"'>"+rsjsonData[i].sizeString+"</div>"+
					"	<div class='col' style='width: 23%;color:green'>&nbsp;&nbsp;("+getTimeFormat(new Date())+")</div>"+
					"	<div class='col buttons'  style='width: 10%'>"+
					"		<a href='javascript:void(0);' class='edit'><img src='images/edit.png'></a>&nbsp;&nbsp;"+
					"		<a href='javascript:void(0);' data-opid='"+rsjsonData[i].id+"' onclick='tm_deleteresource(this);'>"+
					"		<img src='images/delete.gif'></a>"+
					"		<!-- 			            	<a href='javascript:void(0);' data-opid='"+rsjsonData[i].id+"' class='delete'><img src='images/delete.gif'></a> -->"+
					"	</div>"+
					"</li>";
        		}
        		$("#contentbox").html(html);
        	}
         });    	 	
    }

    </script>
	<script type="text/javascript" src="js/resource.js">

	</script>
</body>
</html>


