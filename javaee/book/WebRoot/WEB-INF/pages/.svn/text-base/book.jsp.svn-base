<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>讲师小站</title>
<link href="../css/sg.css" rel="stylesheet" type="text/css" />
<link href="../css/teacher.css" rel="stylesheet" type="text/css" />
<style type="text/css">
    ::selection{background:pink;color:#fff;}
</style>
</head>

<body>
<!--<div id="music">
     <div class="play">
          <div class="advance"><a href="#" class="teac_icon"></a></div>
          <div class="pause"><a href="#" class="teac_icon start"></a><a href="#" class="teac_icon suspend" style="display:none;"></a></div>
          <div class="back"><a href="#" class="teac_icon"></a></div>
     </div>
     
</div>-->
<div id="header">
     <div class="wth1100">
          <div class="teac_pic"><a href="#"><img src="../${user.headerPic}" alt=""/></a></div>          
          <div class="teac_nr">
               <div class="teac_bt"><span>${user.nickname}</span></div><br>
               <a href = "../out"  style = "display:inline-block;padding: 9px 0;border: 1px solid #dedede;width: 100px;height: 20px;text-align: center;border-radius: 3px;font-size: 16px;line-height: 20px;">退出</a>
               <div class="teac_zi">中共党员，本科学历，小学高级教师。长沙市小学语文优秀教师。<br />
               1995年参加湖南省小学语文教学比武，荣获一等奖的第一名，同年10月代表湖南省参加全国语文教学比武再获二等奖。<br />
               2005年——2007年多次代表学校担任省级，国家级观摩课的执教任务，并获得各级领导及专家们的一致好评。<br />
               2006年10月，作为语文学科带头人被学校派往昆明进行课题骨干培训，使自己的专业水平得以提升。撰写的经验论文多次获国家、省、市级一、二等奖。<br />
               2001年编写了《轻轻松松学作文》系列丛书，2003年参与编写《教学兵法》一书。<br />
               2008年担任《金典》多册练习册主编。所带班级班风正，学风浓，2007年被评为长沙市"红旗中队"。辅导学生习作参加各级各类比赛多次获特等奖及一、二等奖。</div>
          </div>
          <div class="clearfix"></div>
     </div>     
</div>
<div id="container">
     <div class="con_left">
          <c:forEach items="${logMaps}" var="hashMap">
          <div class="conl_nr">
               <div class="time"><p>9月<br />8日</p></div>
               <div class="conl_bt"><a href="#">${hashMap.title}</a></div>
               <div class="conl_zi"><p>${hashMap.content}</p></div>
               <div class="conl_btn">
                    <a href = "comment?id=${hashMap.id }" class="btnbg discuss"><span class="teac_icon"></span><i>评论(12)</i></a>
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
<!--  ${user.account}===${user.nickname}          
                  只有存储在作用域的值才能被el表达式存储。         
      ${username} -->
<div id="footer"><p>Copyright © 2013-2014 www.mooncollege.cn All Rights Reserved版权所有：湖南潭州教育咨询有限公司 备案号：备13016338号</p></div>
</body>
</html>

     

