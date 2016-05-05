<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tm" uri="/WEB-INF/tld/tz.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>讲师小站</title>
<link href="/book/css/sg.css" rel="stylesheet" type="text/css" />
<link href="/book/css/teacher.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/book/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/book/js/util.js"></script>
</head>
<body>
<!-- 引入头部页面 -->
<%@include file="header.jsp" %>
<div id="container">
     <div class="con_left">
          <c:forEach items="${logMaps}" var="hashMap">
          <div class="conl_nr">
               <div class="time"><p></p></div>
               <div class="time"><p>${tm:dateFormat(hashMap.createtime,"MM")}月<br />${tm:dateFormat(hashMap.createtime,"dd")}日</p></div>
               <div class="conl_bt"><a href="/book/page/comment?id=${hashMap.id}">${hashMap.title}</a></div>
               <div class="conl_zi"><p>${hashMap.content}</p></div>
               <div class="conl_btn">
                    <a class="btnbg discuss"><span class="teac_icon"></span><i>评论(12)</i></a>
                    <a class="btnbg forward"><span class="teac_icon"></span><i>转发(23)</i></a>
                    <a class="btnbg praise"><span class="teac_icon"></span><i>点赞(127)</i></a>
                    <a class="btnbg collect"><span class="teac_icon"></span><i>收藏</i></a>
                    <a href="#" class="fr">【我要关注该讲师】</a>
                    <div class="veiw"><span class="teac_icon"></span><p>653432</p></div>
                    <div class="clearfix"></div>
               </div>
          </div>
          </c:forEach>
     </div>
     <div class="con_right">
          <div class="conr_bt">
               <div class="line"></div>
               <div class="zi">热门推荐</div>
               <div class="line"></div>
               <div class="clearfix"></div>
          </div>
          <div class="conr_nr">
               <div class="hot_list">
                    <div class="pic"><a href="#"><img src="../images/pic.jpg" width="265" height="205" /></a></div>
                    <h3><a href="#">百度快速提权优化方法杀手锏</a></h3>
                    <p>页面得分越高，越利于关键词排名，而搜索引擎对于不同的网站，页面得分判断标准是会变的，所以在优化方式是要改变的，例如：从差异性的角度来做关键词排名+结合营销来增强用户投票，带动网站整体的权重，SEO研究中心创始人"Moon老师"分享"快速提权优化方法杀手锏"，十年行业经验，精彩与你分享，今晚8:30分YY6359频道欢迎收听！</p>
                    <div class="operate"><a href="#"><span class="veiw teac_icon"></span><i>41231</i></a><a href="#"><span class="discuss teac_icon"></span><i>345</i></a><a href="#"><span class="forward teac_icon"></span><i>57</i></a><a href="#"><span class="praise teac_icon"></span><i>345</i></a><div class="clearfix"></div></div>
               </div>
               <div></div>
          </div>
     </div>
     <div class="clearfix"></div>
</div>
<div id="footer"><p>Copyright © 2013-2014 www.mooncollege.cn All Rights Reserved版权所有：湖南潭州教育咨询有限公司 备案号：备13016338号</p></div>
<script type="text/javascript">
	$(function(){
		forbiddenSelect();
	});
</script>
</body>
</html>