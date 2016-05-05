//总结一句话：它就是数据的另一种展现形式。
//fusionchart amchart hichart
//fusionchart amchart --2012年以前是没有javascript版本；都是flash版本swf
//fusionchart最新HTML5版本svg
//第一步：引入js;
//第二步：不要着急写业务逻辑，先建立一个页面去测试看一下效果。
$.tzChart = function(options){
	var opts = $.extend({},{
    	type:"pie2d",//column2d:0,column3d:0,bar2d,bar3d,pie2d:0,pie3d:0,area2d:0,doughnut2d:0,doughnut3d:0,pareto2d:0,pareto3d
		target:"",
		width:"1100",
		height:"500",
		dataType:"xml",
	    data:"",
        callback:function(){
        	
        }
	},options);
    FusionCharts.ready(function(){
        var revenueChart = new FusionCharts({
        	type:opts.type,
        	renderAt:opts.target,
        	width:opts.width,
        	height:opts.height,
        	dataformat:opts.dataType,
        	dataSource:opts.data
        });
        revenueChart.render();
    });        	
};
