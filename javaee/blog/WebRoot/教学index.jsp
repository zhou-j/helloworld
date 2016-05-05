<%@page import="com.blog.dao.content.ContentDao"%>
<%@page import="com.blog.bean.*"%>
<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/tz.tld" prefix="tz" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tq" %>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
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
	</style>
</head>
<body>
<tq:index name="标题内容我是传递进去的哦!"/>
<

<!-- 业务逻辑标签  不滥用业务自定义标签 -->
<%-- 
<c:import url="test2.html" charEncoding="utf-8"></c:import>
<%@include file="test2.html" %>
<jsp:include page="test2.html"></jsp:include>
--%>

<tz:upperlower content="aaadsdsfsdfsdfjlsadjfljsadkf" sort="2" var="ustr"/>
==========${ustr}
<tz:loopupper count="2">
	*****11111*****
</tz:loopupper>


//数字，字符串处理，日期处理--函数自定义标签
${tz:toUpper("aaadsdsfsdfsdfjlsadjfljsadkf")}


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
     	 <input type="text" id="title"  class="input" autofocus="autofocus" placeholder="请输入标题" maxlength="10">
	     <br>
	     <br>
	     <textarea id="myEditor" class="input text_area" style="height: 400px" maxlength="140"  placeholder="请输入评论信息长度不能超过140位!"></textarea>
	     <br>
     	 <input type="text" id="tag" class="input" placeholder="请输入标签" maxlength="50">
	     <div class="fabiao"><input type="button" id="tm_sendcomment" class="submit" value="发表评论"><span>还可以输入<label id="count">140</label>字</span></div>
	     <div class="clearfix"></div>
	</div>
	
	<script type="text/javascript">
		$(function(){
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
</div>
<%-- <c:forEach begin="1" end="100" var="num">${num}</c:forEach> --%>
<div class="postwrapper box wid700" id="contentbox">
		<tz:contentTag  var="content"><!-- 默认是:查询 10条内容出来，并且按照创建时间排降序 -->
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
						${tz:dateString(content.createTime)}
						${tz:dateFormat(content.createTime,"yyyy-MM-dd HH时mm分ss秒")}
					</a>
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
		
	});

 </script> 
 <tq:footer/>
</body></html>