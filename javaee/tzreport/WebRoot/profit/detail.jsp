<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
     <meta charset = "utf-8" />
     <title></title>
     <style type="text/css">
        body{font-size:14px;font-family:"微软雅黑";}
        .chart{width:100%;height:360px;}
        #contentbox{overflow-y:auto;overflow-x:hidden;}
     </style>
	 <%@include file="../common/taglib.jsp"%>
	 <%@include file="../common/common.jsp"%>
	 <script type="text/javascript" src="../js/chart/fusioncharts.js"></script>
	 <script type="text/javascript" src="../js/chart/themes/fusioncharts.theme.zune.js"></script>
	 <script type="text/javascript" src="../js/chart/tzChart.js"></script>
	 <!-- fusioncharts.theme.zune.js只支持一部分常用的报表统计比如,饼图,曲线图,柱形图 -->
	 <!-- 比如其他的：温度计，地图等等就必须在引入其他的js文件 -->	 
  </head>
  <body>
       <!-- 头部区域  -->
       <%@include file="../common/header.jsp"%>
		<!--中间内容-->
		<div id="mainContent">
			<!--右侧导航栏-->
			<div id="sidebar">
               <%@include file="../common/slider.jsp"%>
			</div>
		
			<!--内容区域-->
			<div id="content">
				<!--表格-->
				<div class="ta" id="contentbox">
				<!--标题-->   
				<p class="ta_title">部门虹之玉排名</p>
				<!--日期-->
				<div class="ta_select">				
                <a class="addprofit" href="http://localhost/tzreport/profit/add">添加收入</a>				
		        <!-- 存放报表统计的 -->
	          	<select name="profitBean.typeId" id="typeId" class="text_box" onchange="tm_searchProfit(this,false)">
	          		<option value="">--请选择收入类型--</option>
	          		<c:forEach var="pt" items="${maps}">
	          			<option ${pt.id==profitBean.typeId ? 'selected="selected"':''}   value="${pt.id}">${pt.name}</option>
	          		</c:forEach>
	          	</select>
	          	&nbsp;&nbsp;&nbsp;&nbsp;金额范围:&nbsp;<input type="text" id="minMoney" class="range" placeholder="最小金额">&nbsp;到 &nbsp;<input type="text" class="range" id="maxMoney" placeholder="最大金额">
	          	<input type="button" class="searchMoney" value="搜索" onclick="tm_searchProfit(this,true)">               
				</div>
				<div>
					<div class="fl">
				        <div id="chartboxc"></div>
				    </div>   
					<div class="fr">
				        <div id="chartbox"></div>
				    </div>   
					<div class="fl">			       
				        <div id="chartboxb"></div>
				    </div>
				  </div>				
				</div>
		</div>
     <script type="text/javascript">
        //作业:1.查询昨天，本周，本月，本年，收入类型的金额的平均排序
        //2.中等难度：查询昨天，当天，本周，本月，本年收入类型金额最大的排行。
        //掌握数据库日期搜索，聚合函数，分组。掌握项目开发的流程和项目细节点的把握
        //高难度：根据昨天，当天，本周，本月，本年金额的最高和最低检索出收入金额在这个范围的收入类型的排行。
        $(function(){
		   var height = $(window).height();
		   $("#sidebar").height(height-55);
		   $("#contentbox").height(height-90);
		   $(window).resize(function(){
				var height = $(this).height();
				$("#sidebar").height(height-55);
				$("#contentbox").height(height-90);
		   });	
           tmloadingYear();
           tmloadingType();
        });
        $.ajax({
        	type:"post",
        	url:basePath+"/json/detailAjax",
            success:function(data){
            	var jsonData = data.profitBeans;
                var length = jsonData.length;
                var datahtml = "";
                for(var i=0;i<length;i++){
                	datahtml += "<set value='"+jsonData[i].money+"' alpha='100' tooltext='描述: {br}"+jsonData[i].description+"{br}添加时间：{br}"+jsonData[i].createTime+"'/>";
                }
                //$.tzChart({target:"chartbox",type:"pie2d",data:"<chart caption='今天收入金额排行' numberprefix='￥' subcaption='每月收入' xaxisname='每月' yaxisname='人数' plotgradientcolor='#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000' bgcolor='FFFFFF' showalternatehgridcolor='0' showplotborder='0' divlinecolor='#CCCCCC' showvalues='1' showcanvasborder='0' canvasbordercolor='#CCCCCC' canvasborderthickness='1' captionpadding='30' linethickness='3' yaxisvaluespadding='15' showshadow='0' labelsepchar=': ' basefontcolor='000000' labeldisplay='AUTO' numberscalevalue='1000,1000,1000' numberscaleunit='K,M,B' animation='0' palettecolors='e44a00' showborder='0'>"+datahtml+" </chart>"});
                $.tzChart({target:"chartboxb",height:"300",width:"31%",data:"<chart caption='今天收入金额排行' numberprefix='￥' palettecolors='#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000' bgcolor='#dedede' showborder='0' use3dlighting='0' showshadow='0' enablesmartlabels='0' startingangle='0' showpercentvalues='0' showpercentintooltip='0' decimals='1' captionfontsize='14' subcaptionfontsize='14' subcaptionfontbold='0' tooltipcolor='#ffffff' tooltipborderthickness='0' tooltipbgcolor='#000000' tooltipbgalpha='80' tooltipborderradius='2' tooltippadding='5' showhovereffect='1' showlegend='1' legendbgcolor='#ffffff' legendborderalpha='0' legendshadow='0' legenditemfontsize='10' legenditemfontcolor='#666666' usedataplotcolorforlabels='1'>"+datahtml+"</chart>"});  	          	        
            }
        });
        /*查询本年的收入明细*/
        function tmloadingYear(){
        	$.ajax({
            	type:"post",
            	url:basePath+"/json/detailYear",
                success:function(data){
                	var jsonData = data.result;
                    var jdata = eval("("+jsonData+")");
                    var datahtml = "";
                    for(var key in jdata){                   	
                     	datahtml += "<set label='"+key+"' value='"+jdata[key]+"'/>";
                    }                    
                    $.tzChart({target:"chartbox",type:"column2d",height:"300",width:"53.5%",data:"<chart caption='2015年度收入明细' numberprefix='￥' xaxisname='收入金额(月/元)' plotgradientcolor='#999' bgcolor='#dedede' showalternatehgridcolor='0' showplotborder='0' divlinecolor='#CCCCCC' showvalues='1' showcanvasborder='0' canvasbordercolor='#CCCCCC' canvasborderthickness='1' captionpadding='30' linethickness='3' yaxisvaluespadding='15' showshadow='0' labelsepchar=': ' basefontcolor='000000' labeldisplay='AUTO' numberscalevalue='1000,1000,1000' numberscaleunit='K,M,B' animation='0' palettecolors='e44a00' showborder='0'>"+datahtml+"</chart>"});  	        
                }
            });        	
        }
        /*通过月份和类型查询收入明细*/
        function tmloadingType(){
        	$.ajax({
            	type:"post",
            	url:basePath+"/json/detailType",
                success:function(data){
                	var jsonData = data.result;
                    var jdata = eval("("+jsonData+")");
                    var arr = [];
                    for(var key in jdata){
                    	var jdatavalue = jdata[key];
                    	var label = "";
                    	var color="";
                    	if(key==1){
                    		color = "666666";
                    		label = "工资";
                    	}
                    	if(key==2){
                    		color = "F97D10";
                    		label = "红包";
                    	}
                    	if(key==3){
                    		color = "DEDEDE";
                    		label = "基金";
                    	}
                    	if(key==5){
                    		color="FF0000";
                    		label = "生活费";
                    	}
                    	if(key==6){
                    		color="141414";
                    		label="理财";
                    	}
	                    var datahtml = "<dataset seriesname='"+label+"' color='"+color+"'>";
	                    var length = jdatavalue.length;
	                    for(var i=0;i<length;i++){	                    	
		                    for(var k in jdatavalue[i]){                   	
		                     	datahtml += "<set label='"+jdatavalue[i][k]+"' value='"+jdatavalue[i][k]+"'/>";
		                    }                    
	                    }	
	                    datahtml += "</dataset>";
	                    arr.push(datahtml);
	                }
                    $.tzChart({target:"chartboxc",type:"msline",height:"300",width:"86%",data:"<chart caption='2014年度收入类型统计明细对比'  subcaption='' xaxisname='月份' yaxisname='每月/元' palette='3' bgcolor='e5e5e5' canvasbgcolor='#dedede' canvasbgalpha='5' canvasborderthickness='1' canvasborderalpha='20' legendshadow='0' numbersuffix='￥' showvalues='0' alternatehgridcolor='ffffff' alternatehgridalpha='100' showborder='0' legendborderalpha='0' legendiconscale='1.5' divlineisdashed='1'>"+
    					"<categories>"+
    					"<category label='一月' />"+
    					"<category label='二月' />"+
    					"<category label='三月' />"+
    					"<category label='四月' />"+
    					"<category label='五月' />"+
    					"<category label='六月' />"+
    					"<category label='七月' />"+
    					"<category label='八月' />"+
    					"<category label='九月' />"+
    					"<category label='十月' />"+
    					"<category label='十一月' />"+
    					"<category label='十二月' />"+
    					"</categories>"+arr.toString()+
    					"<styles>"+
    					"<definition>"+
    					"<style name='captionFont' type='font' size='15' />"+
    					"</definition>"+
    					"<application>"+
    					"<apply toobject='caption' styles='captionfont' />"+
    					"</application>"+
    					"</styles>"+
    					"</chart>"});
                }
            });        	
        }
        
        function tm_getType(key){
        	//执行一个ajax到后台去查询所有的分类。
        	var json = {
        		1:{name:"工资",color:"F97D10"},
        		2:{name:"红包",color:"FF0000"},
        		3:{name:"基金",color:"141414"},
        		5:{name:"生活费",color:"FF0044"},
        		6:{name:"理财",color:"EC89de"}
        	};
        	return json[key];
        }
     </script>
  </body>
</html>
