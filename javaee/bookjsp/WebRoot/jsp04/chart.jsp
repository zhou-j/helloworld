<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>   
    <title>keke老师统计报表插件</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="../js/chart/fusioncharts.js"></script>
	<script type="text/javascript" src="../js/chart/themes/fusioncharts.theme.zune.js"></script>
	<!-- fusioncharts.theme.zune.js只支持一部分常用的报表统计比如,饼图,曲线图,柱形图 -->
	<!-- 比如其他的：温度计，地图等等就必须在引入其他的js文件 -->
  </head>  
  <body>
     <!-- 存放报表统计的 -->
     <div id="chartbox"></div>
     <script type="text/javascript">
        //总结一句话：它就是数据的另一种展现形式。
        //fusionchart amchart hichart
        //fusionchart amchart --2012年以前是没有javascript版本；都是flash版本swf
        //fusionchart最新HTML5版本svg
        //第一步：引入js;
        //第二步：不要着急写业务逻辑，先建立一个页面去测试看一下效果。
        //column2d:0,column3d:0,bar2d,bar3d,pie2d:0,pie3d:0,area2d:0,doughnut2d:0,doughnut3d:0,pareto2d:0,pareto3d
        FusionCharts.ready(function(){
	        var revenueChart = new FusionCharts({
	        	type:"column2d",
	        	renderAt:"chartContainer",
	        	width:"800",
	        	height:"500",
	        	dataformat:"xml",
	        	dataSource:"<chart caption='潭州学院Vip2014季度报名统计' subcaption='统计招生' xaxisname='每月' yaxisname='人数' plotgradientcolor='' bgcolor='FFFFFF' showalternatehgridcolor='0' showplotborder='0' divlinecolor='#CCCCCC' showvalues='1' showcanvasborder='0' canvasbordercolor='#CCCCCC' canvasborderthickness='1' captionpadding='30' linethickness='3' yaxisvaluespadding='15' showshadow='0' labelsepchar=': ' basefontcolor='000000' labeldisplay='AUTO' numberscalevalue='1000,1000,1000' numberscaleunit='K,M,B' animation='0' palettecolors='e44a00' showborder='0'>"+
				 "	 <set label='一月' value='3500000000' alpha='100' tooltext='Popular in: {br}Europe{br}Africa{br}Asia{br}Americas' />"+
				 " 	 <set label='二月' value='3000000000' alpha='90' tooltext='Popular in: {br}India{br}UK{br}Pakistan{br}England{br}Australia' />"+
				 "	 <set label='三月 ' value='2200000000' alpha='80' tooltext='Popular in: {br}Asia{br}Europe{br}Africa{br}Australia' />"+
				 "	 <set label='Tennis' value='1000000000' alpha='70' tooltext='Popular in: {br}Europe{br}Americas{br}Asia' />"+
				 "	 <set label='Volleyball' value='900000000' alpha='55' tooltext='Popular in: {br}Asia{br}Europe{br}Americas{br}Australia' />"+
				 "	 <set label='Table Tennis' value='900000000' alpha='55' tooltext='Popular in: {br}Asia{br}Europe{br}Africa{br}Americas' />"+
				 "	 <set label='Baseball' value='500000000' alpha='40' tooltext='Popular in: {br}US{br}Japan{br}Cuba{br}Dominican Republic' />"+
				 "	 <set label='Golf' value='400000000' alpha='30' tooltext='Popular in: {br}US{br}Canada{br}Europe' />"+
				 " 	 <set label='Basketball' value='400000000' alpha='30' tooltext='Popular in: {br}US{br}Canada' />"+
				 " 	 <set label='American Football' value='390000000' alpha='25' tooltext='Popular in: {br}US' />"+
				 " </chart>"
	        });
	        revenueChart.render("chartbox");
        });
     </script>
  </body>
</html>
