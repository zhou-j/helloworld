<%@page import="com.blog.dao.content.ContentDao"%>
<%@page import="com.blog.bean.*"%>
<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/tz.tld" prefix="tz" %>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/tz_dialog_1.0.js"></script>
<html>
<head>
	<meta name="themename" content="29002">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>图片-xuchengfeifei</title>
	<meta name="Keywords" content="">
	<meta name="Description" content="">
	<link href="css/index.css" rel="stylesheet" type="text/css">
	<link href="js/editor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/util.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/editor/umeditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/editor/umeditor.min.js"></script>
	<style type="text/css">
		.input{height: 32px;border: 1px solid #ccc;border-radius:1px;width:240px;}
		.content{font-size: 16px;}
		.layer_icon{ background:url(images/b_layer.png) no-repeat; display:inline-block;}
		.w460{width: 460px;}
		.fr{float:right}
		.fl{float:left}
		/*弹出通用样式*/
		.b_l{border-radius:4px; box-shadow:1px 2px 4px #6c6e72;-moz-box-shadow:1px 2px 4px #6c6e72;-webkit-box-shadow:1px 2px 4px #6c6e72;background:#fff;position:fixed;z-index:100}
		/*标题*/
		.bcom_ti{ background:#f4f4f4;border-bottom:1px solid #e4e4e4; border-radius:4px 4px 0 0; height:46px; line-height:44px;padding:0 15px;}
		.bide{ background-position:0 0;width:22px; height:22px;margin-top:11px;}
		.bide:hover{background-position:-23px 0;}
		/*单独样式（评论删除）*/
		.bcom_cent{padding:40px 0 30px}
		.bcomti{ font-size:18px;text-align:center; color:#000}
		.bcoma{margin:auto;width:180px;}
		.bcoma a{ width:74px; height:30px; line-height:25px; border-radius:4px; margin:30px 6px 0; color:#fff; text-align:center; display:inline-block}
		.bc_abut1{ background:#5580fb}
		.bc_abut1:hover{background:#4e79f1;}
		.bc_abut2{ background:#cacaca}
		.bc_abut2:hover{background:#c2c0c0;}
		.tmui-overlay{width:100%;height:100%;background-color:#000;position:absolute;top:0;left:0;z-index:99;filter:alpha(opacity=58);-moz-opacity:0.58;-khtml-opacity:0.58;opacity:0.58;}
	</style>
</head>
<body>
<!-- 
//弹出层 jquery插件 tree 
//1:弹出，loading,都是一个div
//2:都离不开定位position:absolute fixed relative 
//3:无非就是改变他的坐标：left和top
//4:如果要有层级关系那么久用试用z_index
//5:试用fixed定位的时候高度不要超过<=520,left,top,z-index不能单独使用一定要结合position
//6:遮罩层
 -->
<!-- 业务逻辑标签  不滥用业务自定义标签 -->
<%-- 
<c:import url="test2.html" charEncoding="utf-8"></c:import>
<%@include file="test2.html" %>
<jsp:include page="test2.html"></jsp:include>

记住这句话：
逻辑删除是：更改字段标示，表中还是存在的 update 表名 set is_delete = 1 where id =1;
物理删除是:表中的数据部存在了:delete from 表名 where id=1;
1：不管是逻辑删除还是物理删除都一定要给提示框
2：业务的数据 尽量不要使用物理删除,而使用逻辑删除
--%>

<img src="code.jsp">
<div class="h95"></div>
<div class="box wid700  "> 
    <div class="selfinfo">
       	<div class="logo">
               <a href="/"><img src="images/proxy.jpg" height="80"><i></i></a>
        </div>
       	<h1><a href="/">xuchengfeifei</a></h1>
        <div class="text"></div>
    </div>
    <div class="sch">
        <form action="/search" method="get">
            <input value="搜索" type="text" name="q" onfocus="if(this.value=='搜索'){this.value='';}" onblur="if(this.value==''){this.value='搜索';}" class="txt">
        </form>
    </div>
    <ul class="sidelist">
		<li><a href="javascript:void(0);" rel="nofollow">私信</a></li>
		<li><a href="javascript:void(0);">归档</a></li>
		<li><a href="javascript:void(0);">RSS</a></li>
    </ul>
</div>
<div id="message" class="postwrapper box wid700  ">
     <div class="mes_nr">
     	 <input type="text" id="title"  class="input" autofocus="autofocus" placeholder="请输入标题" maxlength="100">
	     <br>
	     <br>
	     <textarea id="myEditor" class="input text_area" style="height: 400px" maxlength="140"  placeholder="请输入评论信息长度不能超过140位!"></textarea>
	     <br>
     	 <input type="text" id="tag" class="input" placeholder="请输入标签" maxlength="50">
	     <div class="fabiao"><input type="button" id="tm_sendcomment" class="submit" value="发表评论"><span>还可以输入<label id="count">140</label>字</span></div>
	     <div class="clearfix"></div>
	</div>
</div>
<%-- <c:forEach begin="1" end="100" var="num">${num}</c:forEach> --%>
<div class="postwrapper box wid700" id="contentbox">
		<tz:contentTag  var="content" sort="1"><!-- 默认是:查询 10条内容出来，并且按照创建时间排降序 -->
		<div class="block photo">
<!-- 			<label style="font-weight: 700;font-size: 18px;">第${tz:numberToString(cindex.index+1)}章</label> -->
			<div class="side">
				<div class="day">
					<a href="javascript:void(0);">${tz:dateFormat(content.createTime,"MM")}</a>
				</div>
				<div class="month">
					<a href="javascript:void(0);">${tz:dateFormat(content.createTime,"dd")}</a>
				</div>
			</div>
			<div class="main">
				<div class="content">
<!-- 				${tz:cutContent(content.content,0,100)} -->
					${content.content}
				</div>
				<div class="link">
					<a href="javascript:void(0);">评论(1) 
						${tz:dateString(content.createTime)}&nbsp;&nbsp;
						${tz:dateFormat(content.createTime,"yyyy-MM-dd HH时mm分ss秒")}
					</a>
					<a href="javascript:viod(0);" data-opid="${content.id}" onclick="tm_delete_content(this)">删除</a>
				</div>
				<div class="bcmt">
					<div class="s-fc0 ztag" style="line-height: 30px; display: none;">由于该用户的权限设置，你暂时无法进行评论...</div>
					<div class="bcmtadd" style="display:none">
						<div class="bcmtipt s-bd0 s-bg0">
							<div class="bcmtiptc">
								<div contenteditable="true" class="editdiv s-fc0 ztag f-trans"
									maxlength="200" style="height: 130px;"></div>
							</div>
						</div>
						<div class="bcmtbtn">
							<span class="ztag"
								style="color:red;display:none;margin-right:10px;">提示</span>
							<button class="s-bd1 s-fc1 s-bg1 ztag">发布</button>
							<div class="txt s-fc0"></div>
						</div>
					</div>
					<div class="bcmtlst">
						<ul class="clearfix ztag" id="commentbox"></ul>
					</div>
					<div class="bcmtmore s-bd2 ztag" style="display: none;">
						<div class="bcmtlsta">
							<span class="s-fc4">正在载入中...</span>
						</div>
					</div>
					<div class="bcmtmore s-bd2" style="display: none;">
						<div class="bcmtlsta">
							<a href="#" class="s-fc2 ztag">查看更多</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</tz:contentTag>
</div>

<script type="text/javascript">
	$(function(){
		$("#contentbox").find(".photo").each(function(){
			var content = $(this).find(".content").html();
			var result = "";
			var start = "";
			if(content.length>100){
				start = content.substring(0,100);
				result = "<span style='display:none;'>"+content.substring(100,content.length)+"</span>";
				$(this).find(".content").html(start+result+"&nbsp;&nbsp;<a onclick='tm_show_expand(this)' href='javascript:void(0)'>展开</a>");
			}
		});
	});
	
	
	//删除帖子
	function tm_delete_content(obj){
		//根据帖子ID去删除 
		//通过ajax方式去删除
		var opid = $(obj).data("opid");
		tm_dialoag({content:"您确定删除改帖子吗?",callback:function(ok){
			if(ok){
				$.ajax({
					type:"post",
					url:"service/deleteContent.jsp",
					data:{"id":opid},
					success:function(data){
						var jdata = data.trim();
						if(jdata=="success"){
							//删除div
							$(obj).parents(".photo").fadeOut("slow",function(){
								$(this).remove();
							});
						}else{
							//删除失败
							tm_dialoag({title:"删除提示",content:"删除用户失败!"});
						}
					}
				});
			}
		}});
	}
	
	function tm_show_expand(obj){
		var text = $(obj).text();
		if(text=="展开"){
			$(obj).text("收起");
			$(obj).prev().fadeIn("slow");
		}else{
			$(obj).text("展开");
			$(obj).prev().fadeOut("slow");
		}
	}
	
	//获取富文本编辑器的带有格式的内容
	function getEditoHtml(myEditor){
		return UM.getEditor(myEditor).getContentTxt();
	}
	
	//获取富文本编辑器的纯文本内容
	function getEditText(myEditor){
		return UM.getEditor(myEditor).getContentTxt();
	}
	
	//给某个富文本框赋值
	function setEditorText(message,myEditor){
		 UM.getEditor(myEditor).setContent(message, false);//清空富文本编辑器
	}
	
	$(function(){
		var timer = null;
		$("#tm_sendcomment").click(function(){
			var content = getEditText("myEditor");
			var title = $("#title").val();
			var tag = $("#tag").val();
			if(isEmpty(title)){
				alert("请输入标题");
				$("#title").focus();
				return;
			}
			if(isEmpty(content)){
				alert("请输入内容");
				UM.getEditor("myEditor").focus();
				return;
			}
			clearTimeout(timer);
			content = getEditoHtml("myEditor");
			timer = setTimeout(function(){
				$.ajax({
					type:"post",
					url:"service/contentDao.jsp",
					data:{"content":content,"title":title,"tag":tag},
					success:function(data){
						var jdata = data.trim();
						if(jdata=="success"){
							var day = new Date().format("dd");
							var month = new Date().format("MM");
							//append 追加到元素的后面d
							//prepend:追加到元素的前面
							var length = $("#contentbox").find(".photo").length;
							$("#contentbox").prepend("<div class='block photo'>"+
							// "		<label style='font-weight: 700;font-size: 18px;'>第"+tm_NumberToChinese(length+1)+"章</label>"+
				             "        <div class='side'>"+
					         "               <div class='day'><a href='javascript:void(0);'>"+day+"</a></div>"+
					         "               <div class='month'><a href='javascript:void(0);'>"+month+"</a></div>"+
					         "           </div>"+
					         "       <div class='main'>"+
					         "           <div class='content'>"+content+"</div>"+
					         "       <div class='link'>"+
					         "           <a href='javascript:void(0);'>评论(1)</a>"+
					         "           <a href='javascript:void(0);' onclick='tm_delete_content(this)'>删除</a>"+
					         "       </div>"+
					         "       <div class='bcmt'>"+
							"		<div class='s-fc0 ztag' style='line-height: 30px; display: none;'>由于该用户的权限设置，你暂时无法进行评论...</div>"+
							"		<div class='bcmtadd' style='display:none'>"+
							"	    	<div class='bcmtipt s-bd0 s-bg0'>"+
							"	        	<div class='bcmtiptc'><div contenteditable='true' class='editdiv s-fc0 ztag f-trans' maxlength='200' style='height: 130px;'></div></div>"+
							"	        </div>"+
							"	         <div class='bcmtbtn'>"+
							"	        	<span class='ztag' style='color:red;display:none;margin-right:10px;'>提示</span><button class='s-bd1 s-fc1 s-bg1 ztag'>发布</button>"+
							"	        	<div class='txt s-fc0'></div>"+
							"	        </div>"+
							"	    </div>"+
							"	    <div class='bcmtlst'>"+
							"	        <ul class='clearfix ztag' id='commentbox'></ul>"+
							"	    </div>"+
							"	    <div class='bcmtmore s-bd2 ztag' style='display: none;'>"+
								"    	<div class='bcmtlsta'><span class='s-fc4'>正在载入中...</span></div>"+
							"	    </div>"+
							"	    <div class='bcmtmore s-bd2' style='display: none;'>"+
							"	    	<div class='bcmtlsta'><a href='#' class='s-fc2 ztag'>查看更多</a></div>"+
							"	    </div>"+
							"	</div>"+
					         "   </div>"+
					        "</div>");
							$("#title").val("");
							$("#content").val("");
							setEditorText("","myEditor");
							$("#tag").val("");
						}else{
							$("#title").focus();
							alert("标题和内容部允许为空!");
						}
					}
				});	
			},200);
			
		});
	});
	
</script>
<script type="text/javascript">
	$(function(){
		/* 置顶 */
	    $(window).scroll(function() {
	    	var stop = $(window).scrollTop();
	        if (stop >= 100){
	        	$("#dynamic-to-top").stop(true, true).fadeIn(300);
	        	$("#dynamic-to-bottom").stop(true, true).fadeOut(300);
	        }else {
	        	$("#dynamic-to-top").stop(true, true).fadeOut(300);
	        	$("#dynamic-to-bottom").stop(true, true).fadeIn(300);
	        }
	    });

	    $("#dynamic-to-top").on("click",function() {
	        $("html, body").stop(true, true).animate({ scrollTop: 0});
	        return false;
	    });
	    
	    $("#dynamic-to-bottom").click(function(){
			var scrollHeight = document.body.scrollHeight || document.documentElement.scrollHeight;
			$("body").stop(true,true).animate({"scrollTop":scrollHeight},35000,function(){
				$("#dynamic-to-bottom").hide();
			});
		});
	    
		var um = UM.getEditor("myEditor");
		//keydown:键盘按下去的事件
		//keyup :键盘抬起来的事件
		$("#content").keyup(function(){
			tm_number_textarea($(this));
		}).keydown(function(){
			tm_number_textarea($(this));
		});
		
		function tm_number_textarea($obj){
			var value = $obj.val();
			var maxLength = $obj.attr("maxLength");
			//获取你输入的个数
			var length = value.length;
			if(length <= maxLength){
				$("#count").text(maxLength-length);
			}
		};
	});
 </script> 
</body></html>