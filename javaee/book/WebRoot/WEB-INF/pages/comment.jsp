<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tm" uri="/WEB-INF/tld/tm.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>详情页</title>
<link href="../css/sg.css" rel="stylesheet" type="text/css" />
<link href="../css/teacher.css" rel="stylesheet" type="text/css" />
</head>

<body>
<script type = "text/javascript" src = "../js/jquery-1.11.1.min.js"></script>
<script type = "text/javascript" src = "../js/util.js"></script>
<div id="header">
     <div class="wth1100">
          <div class="teac_pic" ><a href="#"><img id="headerpic" src="../images/peple.jpg" alt=""/></a></div>
          <div class="teac_nr">
               <div class="teac_bt" id = ><span id="username">${user.nickname}</span></div>
               <a href = "boo"  style = "display:inline-block;padding: 9px 0;border: 1px solid #dedede;width: 100px;height: 20px;text-align: center;border-radius: 3px;font-size: 16px;line-height: 20px;margin-top:20px">返回</a>               
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
     <input type = "text" id = "logId" value = "${comment.id}" style="display:none;"/>
     <div class="detail_con">
          <div class="det_bt">${comment.title}</div>
          <div class="det_sm">
               <div class="fl"><span>发表于：${comment.createtime}  作者：${user.nickname} </span></div>
               <div class="fr"><a href="#"><i class="discuss teac_icon"></i><span>评论</span></a><a href="#"><i class="forward teac_icon"></i><span>转发</span></a><a href="#"><i class="praise teac_icon"></i><span>点赞</span></a></div>
               <div class="clearfix"></div>
          </div>
          <div class="det_nr" >${comment.content}</div>
          <div id="message">
                <div class="mes_nr">
                     <div style="height:25px"><label id = "errormsg"></label></div>
                     <textarea name="" cols="" rows="" id = "content" class="text_area" placeholder="请输入内容！长度不能超过300位。"></textarea>
                     <div class="tongbu"><span>同步到：</span><a href="#" class="teac_icon xinlang"></a><a href="#" class="teac_icon tengxun"></a><a href="#" class="teac_icon renren"></a></div>
                     <div class="fabiao"><input name="" type="button" id="tm_sendcomment" class="submit" value="发表评论" /><span>还可以输入140字</span></div>
                     <div class="clearfix"></div>
                </div>
                <div class="mes_list" >
                     <div class="sort"><a href="#" class="current">按时间</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">按热门</a></div>
                     
                     <div id = "commentbox">
                       <c:forEach var = "clog" items="${commentLogs}">
						<div class="disc_list">
							<div class="pic">
								<a href="#"><img src="../images/peple.jpg" width="43"
									height="43"></a>
							</div>
							<div class="liuyan1">
								<dl>
									<dt>${clog.username}</dt>
									<dd>${clog.content}</dd>
								</dl>
								<div class="pubdata">
									<span>发表于：${clog.createtime}|</span> <a href="#" class="fl">只看该作者</a>
									<a href="#" class="fr"><span class="nolike teac_icon"></span>
									<p>不喜欢(21)</p></a> <a href="#" class="fr"><span
										class="onlike teac_icon"></span>
									<p>喜欢(123)</p></a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
                      </c:forEach>
					</div>                     
                     <div class="pagesize">
                          <ul>
                              <li><span>跳转到：</span><input name="" type="text" class="text_box" /><input name="" type="button" value="GO" class="text_btn" /></li>
                              <li><a href="#">下一页</a></li>
                              <li><a href="#">上一页</a></li>
                          </ul>                              
                     </div>
                     <div class="clearfix"></div>
                </div>
           </div>
     </div>
</div>
<div id="footer"><p>Copyright © 2013-2014 www.mooncollege.cn All Rights Reserved版权所有：湖南潭州教育咨询有限公司 备案号：备13016338号</p></div>
<script type="text/javascript">
       $(function(){
    	   //第一步：引入jquery.js
    	   //测试引入是否正常
    	   //定义事件，第一步还是测试
    	   $("#tm_sendcomment").click(function(){
     		   var content = $("#content").val();
    		   var logId = $("#logId").val();
    		   var timer = null;
    		   if(isEmpty(content)){
    			   $("#content").focus();
    			   $("#errormsg").show().css("color","red").html("请输入内容！").fadeOut(3000);
    			   return;
    		   }
    		   
    		   if(content.length>=300){
    			   $("#content").focus();   			   
    			   $("#errormsg").show().css("color","red").html("输入内容的长度不能超过300位！").fadeOut(3000);
    			   return;
    		   }
    		   
    		   clearTimeout(timer);
               timer = setTimeout(function(){
    			   $.ajax({
        			   type:"post",//请求方式
        			   url:"commentsave",//请求地址
        			   data:{"content":content,"logId":logId},
        			   beforeSend:function(){},//在于服务器交互之前执行的函数。
        			   success:function(data){
        				   if(data=="success"){
        					   $("#content").val("");//清空文本框。
        					   $("#commentbox").prepend("<div class='disc_list'>"+
     		                    "      <div class='pic'><a href='#'><img src='"+$("#headerpic").attr("src")+"' width='43' height='43'></a></div>"+
    		                    "      <div class='liuyan1'>"+
    		                    "           <dl>"+
    		                    "               <dt>"+$("#username").text()+"</dt>"+
    		                    "               <dd>"+content+"</dd>"+                                   
    		                    "           </dl>"+
    		                    "           <div class='pubdata'>"+
    		                    "                <span>发表于："+new Date().format("yyyy-MM-dd HH:mm:ss")+" |</span>"+
    		                    "                <a href='#' class='fl'>只看该作者</a>"+
    		                    "                <a href='#' class='fr'><span class='nolike teac_icon'></span><p>不喜欢(21)</p></a>"+
    		                    "                <a href='#' class='fr'><span class='onlike teac_icon'></span><p>喜欢(123)</p></a>"+
    		                    "           </div>"+
    		                    "      </div>"+
    		                    "      <div class='clearfix'></div>"+
    		                    "   </div>                     ");   
        					   alert("保存成功!");
        				   }else{
        					   alert("保存失败！");
        				   }
        			   }
        		   });
    		   },200);
    		   
    	   });
       });
</script>
</body>
</html>
