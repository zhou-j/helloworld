<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tm" uri="/WEB-INF/tld/tz.tld" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>详情页</title>
<link href="/book/css/sg.css" rel="stylesheet" type="text/css" />
<link href="/book/css/teacher.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/book/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/book/js/util.js"></script>
<script type="text/javascript" src="/book/js/chart/fusioncharts.js"></script>
<script type="text/javascript" src="/book/js/chart/themes/fusioncharts.theme.zune.js"></script>
</head>
<body>
<!-- 引入头部页面 -->
<%@include file="header.jsp" %>
<div id="chartContainer" style="text-align: center;">FusionCharts XT will load here!</div>
<div id="container">
	<input type="hidden" id="logId" value="${comment.id}">
	<select id="colunm" onchange="tm_ajaxLoadComments(this.value)">
		<option value="column3d">column3d</option>
		<option value="column2d">column2d</option>
		<option value="pie3d">pie3d</option>
		<option value="pie2d">pie2d</option>
		<option value="area2d">area2d</option>
	</select>
     <div class="detail_con">
          <div class="det_bt" id="title">${comment.title}</div>
          <div class="det_sm">
               <div class="fl"><span>发表于：${comment.createtime}  作者：${userSession.nickname}</span></div>
               <div class="fr"><a href="#"><i class="discuss teac_icon"></i><span>评论</span></a><a href="#"><i class="forward teac_icon"></i><span>转发</span></a><a href="#"><i class="praise teac_icon"></i><span>点赞</span></a></div>
               <div class="clearfix"></div>
          </div>
          <div class="det_nr">${comment.content}</div>
          <div id="message">
          		<div style="height: 25px;"> <label id="errormsg"></label>	</div>
                <div class="mes_nr">
                     <textarea name="" id="content" class="text_area" placeholder="请输入评论信息长度不能超过300位!"></textarea>
                     <div class="tongbu"><span>同步到：</span><a href="#" class="teac_icon xinlang"></a><a href="#" class="teac_icon tengxun"></a><a href="#" class="teac_icon renren"></a></div>
                     <div class="fabiao"><input  type="button" id="tm_sendcomment"  class="submit" value="发表评论" /><span>还可以输入140字</span></div>
                     <div class="clearfix"></div>
                </div>
                <div class="mes_list">
                     <div class="sort"><a href="#" class="current">按时间</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">按热门</a></div>
                     <!-- 评论内容存放区域 -->	
                     <div id="commentbox">
						<c:forEach var="clog" items="${commentLogs}">
							<div class="disc_list">
								<div class="pic">
									<a href="#"><img src="/book/${clog.headerpic}" width="43"
										height="43"></a>
								</div>
								<div class="liuyan1">
									<dl>
										<dt>${clog.username}&nbsp;&nbsp;&nbsp;</dt>
										<dd>${clog.content}</dd>
									</dl>
									<div class="pubdata">
										<span>发表于：${tm:dateFormat(clog.createtime,"yyyy-MM-dd HH:mm:ss")}|</span> <a href="#" class="fl">只看该作者</a>
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
		//第一步引入jquery.js
		//第二部：测试 引入是否正常
		//第三步：定义事件，。还第一行代码还是测试
		//第一定先把数据能够保存在数据库的前提下，在去做验证
		var timer = null;
		$("#tm_sendcomment").click(function(){
			var content = $("#content").val();
			var logId = $("#logId").val();
			if(isEmpty(content)){
				$("#content").focus();
				$("#errormsg").show().css("color","red").html("请输入评论内容").fadeOut(3000);
				return;
			}
			
			if(content.length>300){
				$("#content").focus();
				$("#errormsg").show().css("color","red").html("评论内容长度过长!不能超过300位!").fadeOut(3000);
				return;
			}
			
			clearTimeout(timer);
			timer = setTimeout(function(){
				$.ajax({
					type:"post",//请求方式
					url:"/book/page/saveComment",//请求地址
					data:{"content":content,"logId":logId},//传递给服务器的参数列表 json
					beforeSend:function(){},//在于服务器请求之前调用的回调方法
					success:function(data){//与服务器请求成功调用回调方法
						if(data=="success"){
							$("#content").val("");//清空文本框
							var html ="<div class='disc_list'>"+
							"		                          <div class='pic'><a href='#'><img src='"+$("#headerpic").attr("src")+"' width='43' height='43'></a></div>"+
							"		                          <div class='liuyan1'>"+
							"		                               <dl>"+
							"		                                   <dt>"+$("#username").text()+"</dt>"+
							"		                                   <dd>"+content+"</dd>                                   "+
							"		                               </dl>"+
							"		                               <div class='pubdata'>"+
							"		                                    <span>发表于："+new Date().format("yyyy-MM-dd HH:mm:ss")+" |</span>"+
							"		                                    <a href='#' class='fl'>只看该作者</a>"+
							"		                                    <a href='#' class='fr'><span class='nolike teac_icon'></span><p>不喜欢(21)</p></a>"+
							"		                                    <a href='#' class='fr'><span class='onlike teac_icon'></span><p>喜欢(123)</p></a>"+
							"		                               </div>"+
							"		                          </div>"+
							"		                          <div class='clearfix'></div>"+
							"		                     </div>";
		                     $("#commentbox").prepend(html);
		                     tm_ajaxLoadComments($("#colunm").find("option:selected").val());
						}else{
							alert("保存失败!");
						}	
					}
				});
			},200);
		});
	});
</script>
<script type="text/javascript">

$(function(){
	tm_ajaxLoadComments("area2d");
});

//c:0,column3d:0,bar2d:0,bar3d:0,pie2d:0,pie3d:0,line:0,area2d:0,doughnut2d:0,doughnut3d:0,pareto2d:0,pareto3d:0,mscolumn2d:0,mscolumn3d:0,msline:0,msarea:0,msbar2d:0,msbar3d:0,stackedcolumn2d:0,marimekko:0,stackedcolumn3d:0,stackedarea2d:0,stackedcolumn2dline:0,stackedcolumn3dline:0,stackedbar2d:0,stackedbar3d:0,msstackedcolumn2d:0,mscombi2d:0,mscombi3d:0,mscolumnline3d:0,mscombidy2d:0,mscolumn3dlinedy:0,stackedcolumn3dlinedy:0,msstackedcolumn2dlinedy:0,scatter:0,bubble:0,ssgrid:0,scrollcolumn2d:0,scrollcolumn3d:0,scrollline2d:0,scrollarea2d:0,scrollstackedcolumn2d:0,scrollcombi2d:0,scrollcombidy2d:0,zoomline:0});a.powercharts=d.extend(a.powercharts||{},{spline:0,splinearea:0,msspline:0,mssplinearea:0,mssplinedy:0,multiaxisline:0,multilevelpie:0,waterfall2d:0,msstepline:0,inversemsline:0,inversemscolumn2d:0,inversemsarea:0,errorbar2d:0,errorscatter:0,errorline:0,logmsline:0,logmscolumn2d:0,logstackedcolumn2d:0,radar:0,dragnode:0,candlestick:0,selectscatter:0,dragcolumn2d:0,dragline:0,dragarea:0,boxandwhisker2d:0,kagi:0,heatmap:0
//查询统计信息
function tm_ajaxLoadComments(type){
	$.ajax({
		type:"post",
		url:"/book/page/commentStat",
		data:{"logId":1},
		success:function(data){
	 		var jdata = eval(data);
			var length = jdata.length;
			var title = $("#title").text();
			var html = "<chart caption='"+title+"' subcaption='日记统计（日/数量）' yaxisname='访问量' plotgradientcolor='' bgcolor='FFFFFF' showalternatehgridcolor='0' showplotborder='0' divlinecolor='#CCCCCC' showvalues='1' showcanvasborder='0' canvasbordercolor='#CCCCCC' canvasborderthickness='1' captionpadding='30' linethickness='3' yaxisvaluespadding='15' showshadow='0' labelsepchar=': ' basefontcolor='000000' labeldisplay='AUTO' numberscalevalue='1000,1000,1000' numberscaleunit='K,M,B' animation='0' palettecolors='e44a00' showborder='0'>";
			for(var i=0;i<length;i++){
				html += "<set label='"+jdata[i].ctime+"' value='"+jdata[i].count+"' alpha='100' tooltext='Popular in: {br}Europe{br}Africa{br}Asia{br}Americas' />'";
	 		}
	 		html +="</chart>";
	 		tm_loadFushionForXml(html,type,"chartContainer");
			
//  			var jdata = eval(data);
// 			var length = jdata.length;
// 			var jsonArr = []; 
// 			for(var i=0;i<length;i++){
// 				var obj = {};
// 				obj.label = jdata[i].ctime;
// 				obj.value = jdata[i].count;
//  				jsonArr.push(obj);
//  			}
// 			tm_loadFushion_Json(jsonArr,type,"chartContainer");
		}
	});
};


function tm_loadFushion_Json(jsonArr,type,target){
	FusionCharts.ready(function(){
		var revenueChart = new FusionCharts({
			 type: type,//统计图的类型
			 renderAt: "chartContainer",//目标对象
			 width: "1100",//统计图的宽度
			 height: "300",//统计图的高度
			 dataFormat: "json",//数据格式 xml json
			 dataSource:{
				    "chart": {
				        "caption": "% of visitors who added as Favorite",
				        "yaxismaxvalue": "100",
				        "bgcolor": "406181, 6DA5DB",
				        "bgalpha": "100",
				        "basefontcolor": "FFFFFF",
				        "canvasbgalpha": "0",
				        "canvasbordercolor": "FFFFFF",
				        "divlinecolor": "FFFFFF",
				        "divlinealpha": "100",
				        "numvdivlines": "10",
				        "vdivlineisdashed": "1",
				        "showalternatevgridcolor": "1",
				        "linecolor": "BBDA00",
				        "anchorradius": "4",
				        "anchorbgcolor": "BBDA00",
				        "anchorbordercolor": "FFFFFF",
				        "anchorborderthickness": "2",
				        "showvalues": "0",
				        "numbersuffix": "%",
				        "tooltipbgcolor": "406181",
				        "tooltipbordercolor": "406181",
				        "alternatehgridalpha": "5",
				        "labeldisplay": "ROTATE",
				        "canvaspadding": "10",
				        "showborder": "0"
				    },
				    "data": jsonArr
				}
		});
		revenueChart.render(target);//输出统计
	}); 
};


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

function tm_loadFushionForXml(xml,type,target){
	FusionCharts.ready(function(){
		var revenueChart = new FusionCharts({
			 type: type,//统计图的类型
			 renderAt: "chartContainer",//目标对象
			 width: "1100",//统计图的宽度
			 height: "300",//统计图的高度
			 dataFormat: "xml",//数据格式 xml json
			 dataSource:xml
		});
		revenueChart.render(target);//输出统计
	}); 
}
</script>
</body>
</html>