<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		/*分页*/
		.pagination{font-size:12px;}
		.pagination a{text-decoration:none;border:solid 1px #ccc;color:#999;}
		.pagination a,.pagination span{display:block;float:left;padding:0.3em 0.5em;margin-right:5px;margin-bottom:5px;min-width:1em;text-align:center;}
		.pagination .current{background:#999;color:#fff;border:solid 1px #ccc;}
		.pagination .current.prev,.pagination .current.next{color:#999;border-color:#999;background:#fff;}
		.tm_psize_go{padding:5px;margin-right:4px; float:left;height:32px;line-height:32px;position:relative;border:1px solid #ccc;}
		#tm_pagego{height:31px;line-height:31px;width:30px;float:left;text-align:center;border:1px solid #ccc;}	      
	</style>
  </head> 
  <body>
     <div class="page"></div>
     <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
     <script type="text/javascript" src="js/jquery.pagination.js"></script>
     <script type="text/javascript" src="js/util.js"></script>
     <script type="text/javascript">
        /*
          1.引入jquery和分页插件。
          2.编写一个div添加class
          3.分页插件的初始化。
        */
         $(".page").pagination(100,{ //100分页的总数。
 			items_per_page:5,        //控制每页多少条信息。
			num_display_entries:2,   //主体页数。
			current_page:1,          //指明选中的页码。
			num_edge_entries:2,      //边缘页数。
			prev_text:"前一页",
			next_text:"后一页",
			ellipse_text:"...",
			renderer:"defaultRenderer",
			load_first_page:false,
			showGo : false,
			showSelect:false,
			callback:function(pageNo,psize){//会回传两个参数，一个为当前页，另一个为每页显示的页数。
				alert(pageNo+"====="+psize);
			}
         });
     </script>
  </body>
</html>
