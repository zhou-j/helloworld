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
<!-- 字体图标 -->
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css" />
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
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
<!-- 引入分页插件 -->
<script type="text/javascript" src="js/jquery.pagination.js"></script>
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
.select{background:#999;}
.search{height:20px;width:160px;border-radius:1px;line-height:20px;font-size:14px;position:relative;top:2px;left:8px;padding:6px;border:none;outline:0;}
.searchbtn{padding-left:50px;font-size:14px;color:#999;}
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
					<li class="select"><a class="sitem" href="javascript:void(0)" onclick="tm_init_type(this)">全部文件</a></li>
					<li><a class="sitem" href="javascript:void(0)" data-opta="1" onclick="tm_init_type(this)">文件</a></li>
					<li><a class="sitem" href="javascript:void(0)" data-opta="2" onclick="tm_init_type(this)">图片</a></li>
					<li><a class="sitem" href="javascript:void(0)" data-opta="3" onclick="tm_init_type(this)">视频</a></li>
					<li><a class="sitem" href="javascript:void(0)" data-opta="4" onclick="tm_init_type(this)">其他</a></li>
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
							<a href="javascript:void(0)" class="searchbtn" onclick="tm_search_info()"><i class="fa fa-search"></i></a>
							<div style="line-height:31px;display:inline-block;"><input type="text" value="" class="search" placeholder="Search pictrues..."></div>
							<span style="margin-left:230px;color:#666;font-size:16px;margin-right:35px;">当前登录的用户是：${user.username}</span>
							<a href="http://localhost/yunpan/service/loginout.jsp" style = "font-size:14px;">退出</a>
						</div>
					</div>
					<!-- 内容包含区 -->
					<ul class="fl" style="width: 100%;" id="contentbox">
                     
					</ul>
					<!-- 内容包含区 -->
					<div style="clear:both;"></div>
					<div style="height:30px;padding:10px 0 10px 400px;">
<!-- 					<a href="javascript:void(0)" class="sbtn prev">上一页</a> -->
<!-- 					<a href="javascript:void(0)" class="sbtn next">下一页</a> -->
					<div class="page"></div>
					</div>
				</div>
			</div>
			<!-- 内容区结束 -->
		</div>
	</div>
    <script type="text/javascript">
      
/* 	items_per_page:5,
	num_display_entries:11,
	current_page:0,
	num_edge_entries:0,
	link_to:"javascript:void(0)",
	prev_text:"前一页",
	next_text:"后一页",
	ellipse_text:"...",
	prev_show_always:true,
	next_show_always:true,
	renderer:"defaultRenderer",
	load_first_page:false,
	showGo : true,
	showSelect:true,
	callback:function(){return false;},
	goback :function(){
		
	}  */   
    $(function(){   	
/*     var pageSize = 10;
       var pageNo =0;    */ 	
       tm_search_resource(0,10,function(talcount){
    	    tm_page_init(talcount);
       });
	   $(document).keydown(function(e){
			if(e.keyCode==13){
				tm_search_info();
			}
	   });
    });
	//搜索文件初始化。
	function tm_search_info(){
		//$search.select();
		tm_search_resource(0,10,function(talcount){
			tm_page_init(talcount);
		});
	    $("#box").find(".search").val("");				
	}
	
	//关键字高亮。
	function keyHighlighter(keyword){
		$("#contentbox").find(".name-text").each(function(){
			$(this).html($(this).text().replace(keyword,"<label style='color:red'>"+keyword+"</label>"));
		});
	};
	//初始化分页插件。
	function tm_page_init(talcount){
        $(".page").pagination(talcount,{ //100分页的总数。
 			items_per_page:10,        //控制每页多少条信息。
			num_display_entries:2,   //主体页数。
			current_page:0,          //指明选中的页码。
			num_edge_entries:2,      //边缘页数。
			prev_text:"前一页",
			next_text:"后一页",
			ellipse_text:"...",
			renderer:"defaultRenderer",
			load_first_page:false,
			showGo : true,
			showSelect:true,
			callback:function(pnum,psize){//会回传两个参数，一个为当前页，另一个为每页显示的页数。
				var pageNo = pnum*psize;
				tm_search_resource(pageNo,psize);
			}
         }); 		
	}
	//选择文件类型初始化。
	function tm_init_type(obj){
		$(obj).parent().addClass("select").siblings().removeClass("select");
		tm_search_resource(0,10,function(talcount){
			  tm_page_init(talcount);
		});
	};
	
    //自定义分页初始化。
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
    	var type = $(".select").find("a").data("opta");
		var $search = $("#box").find(".search");
		var keyword = "";
		if(isNotEmpty($search.val())){
		   keyword = $search.val();
		}    	
        $.ajax({
        	type:"post",
        	url:"http://localhost/yunpan/service/search.jsp",
        	beforeSend:function(){
        	    $("#contentbox").html("<div style='text-align:center;'><img src='images/loading.gif'></div>");
        	},
        	data:{"pageNo":pageNo,"pageSize":pageSize,"type":type,"keyword":keyword},
        	success:function(data){
        		var jdata = data.trim();
        		$("#contentbox").html("");
                $("#contentbox").append(jdata);
        		if(callback){
               		var talcount = $("#resourcetotal").data("opta");
        			callback(talcount);
        		}
        		keyHighlighter(keyword);
        	}
         });    	 	
    }

    </script>
	<script type="text/javascript" src="js/resource.js">

	</script>
</body>
</html>


