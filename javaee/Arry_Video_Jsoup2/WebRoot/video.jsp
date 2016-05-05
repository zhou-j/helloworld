<%@ page language="java" import="java.util.*,com.tz.video.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Java开发视频上传组件 - Arry老师</title>
		<meta name="Keywords" content="关键词,关键词">
		<meta name="description" content="">

		<style type="text/css">
			*{margin:0;padding:0;}
			body{background:url("images/bg.jpg") top center;font-size:12px;font-family:"微软雅黑";color:#666;}

			/*video start*/
			.video{width:450px;height:150px;margin:50px auto;text-align:center;}
			.video .v_btn{font-size:16px;text-decoration:none;color:#fff;font-weight:bold;}
			.video .v_con{width:400px;height:50px;background:#fff;margin:20px auto;padding:25px;}
			.video .v_con .v_text{width:410px;}
			.video .v_con .v_text .v_txt{width:309px;height:30px;border:1px solid #ccc;line-height:30px;padding-left:5px;box-shadow:1px 1px 1px 1px #F5F5F5;outline:none;}
			.video .v_con .v_text .v_sub{width:82px;height:32px;background:#eb7350;color:#fff;border:0;font-size:14px;font-weight:bold;border-radius: 3px;cursor: pointer;outline:none;}
			.video .v_con .v_text .v_sub:hover{background:#F30;}
			.video .v_con p{text-align:left;width:400px;margin-top: 6px;}
			.video .v_con p a{text-decoration:none;color:#eb7350;}
			/*end video*/

			/*show_video start*/
			.show_video{width:480px;height:400px;margin:0 auto;}
			/*end show_video*/

		</style>

	</head>
<body>

	<%
		String url = request.getParameter("url");
		if(url != null){
			String html = VideoUtil.getHtmlResourceByURL(url, "utf-8");
			HashMap<String,String> map = VideoUtil.getVideo(html);
			pageContext.setAttribute("map", map);
		}
	
	%>

	<!--video start-->
	<form action="video.jsp" method="get">
	<div class="video">
		<a href="#" class="v_btn">插入视频</a>
		<div class="v_con">
			<div class="v_text">
				<input type="text" class="v_txt" name="url"/>
				<input type="submit" class="v_sub" value=" 确 定 " />
			</div>
			<p>目前已支持<a href="#">新浪播客</a>、<a href="#">优酷网</a>、<a href="#">土豆网</a>、<a href="#">酷6网</a>、<a href="#">搜狐视频</a>、<a href="#">56网</a>、<a href="#">奇艺网</a>、<a href="#">凤凰网</a>、<a href="#">音悦台</a>、<a href="#">乐视网</a>等视频网站的视频播放页链接。</p>
		</div>
	</div>
	</form>
	<!--end video-->
		
	<!--show_video start-->
	<div class="show_video">
		${map.link4}
	</div>
	<!--end show_video-->



</body>
</html>