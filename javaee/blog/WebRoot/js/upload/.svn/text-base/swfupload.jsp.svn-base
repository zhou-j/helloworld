<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<head>
<title>潭州组件文件上传</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/upload/swfupload.js"></script>
<style type="text/css">
@charset "utf-8";/* 重置 */
* {word-wrap: break-word;}
html {-webkit-text-size-adjust: none; }
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td,span{padding:0;margin:0;}
body{font:normal 14px/24px "Microsoft Yahei","冬青黑体简体中文 w3","宋体"; }
fieldset,img,html,body,iframe{border:0;}
table{border-collapse:collapse;border-spacing:0;}
ol,ul{list-style:none;}
address,caption,cite,code,dfn,em,strong,th,var{font-weight:normal;font-style:normal;}
caption,th{text-align:left;}
em,i,small,caption,th{font-weight:normal;font-style:normal;font-size:100%;}
h1,h2,h3,h4,h5,h6,em,strong,b{font-weight:bold;font-size:100%;}
q:before,q:after{content:'';}
.clearfix{*zoom:1}
.clearfix:after{content:".";display:block;clear:both;visibility:hidden;line-height:0;height:0;}
html,body{width:100%;height:100%;}
a {color: #333;text-decoration: none;}
a:hover {text-decoration: underline;}
a img {border: none;}
.red{color: red}
a,button{ outline:none; border:0;}
input,select{border:1px solid #ccc;}
button::-moz-focus-inner{border:0;padding:0;margin:0;}
textarea,input,button,select{outline:0;font-size:inherit;line-height:inherit;color:inherit;font-family:inherit;}
textarea{overflow:auto;resize:none;}
.hide,.none{display: none}
.hidden{visibility: hidden;}
.show,.block{display: block;}
img,object,embed,video{max-width:100%}
input:disabled,select:disabled,textarea:disabled{background:#ccc;}
.fl{float: left;}
.fr{float: right;}
#aspupload{position:fixed;bottom:0;right:2px;width:577px;height:auto;overflow:hidden;z-index:9999;border:1px #056a5c solid;-webkit-box-shadow:0 0 20px -2px rgba(0,0,0,0.5);-moz-box-shadow:0 0 20px -2px rgba(0,0,0,0.5);-ms-box-shadow:0 0 20px -2px rgba(0,0,0,0.5);box-shadow:0 0 20px -2px rgba(0,0,0,0.5)}
#aspupload .headbar{position:relative;height:36px;color:#FFF;background:#629600}
#aspupload .headbar .bar_title{font:normal 14px/35px 微软雅黑;margin-left:12px}
#aspupload .headbar .bar_total{position:absolute;right:80px;line-height:35px;color:#ffc}
#aspupload .headbar .bar_total a{color:#ffc}
#aspupload .headbar .bar_add{position:absolute;right:-15px;top:2px;*top:8px;width:70px;line-height:35px;text-align:center}
#aspupload .headbar .bar_add a{color:#FFF;background:url(http://base1.zhihuishu.com/able-commons/resources/uploader/test/aspupload/images/aspupload/del_img1.png) no-repeat;width:16px;height:16px;display:inline-block}
#aspupload .headbar .bar_add a:hover{color:#FFF;background:url(http://base1.zhihuishu.com/able-commons/resources/uploader/test/aspupload/images/aspupload/del_img.png) no-repeat;width:16px;height:16px;display:inline-block}
a.shrink,a.enlarge{background:url(http://base1.zhihuishu.com/able-commons/resources/uploader/test/aspupload/images/aspupload/load.png) no-repeat;display:block;width:18px;height:18px;position:absolute;right:45px;top:8px}
#aspupload .headbar a.shrink{background-position:0 -42px}
#aspupload .headbar a.enlarge{background-position:-32px -44px}
#aspupload .loadbar{height:0;overflow:auto}
#aspupload .loadbar ul li{height:55px;border-bottom:1px solid #dadada;border-top:1px solid #f8f8f8}
#aspupload .loadbar ul li .load_area{width:545px;height:40px;margin-left:10px;margin-top:15px}
#aspupload .loadbar ul li .loadbar_area{float:left;width:480px;height:40px;margin-left:10px}
#aspupload .load_info{height:22px}
#aspupload .itembox{width:422px}
.filename,.filesize{padding:6px;font-size: 12px;}
.filename{overflow:hidden;white-space:nowrap;text-overflow:ellipsis}
.file_ico{background:url('images/file.png');padding:16px}
#aspupload .load_info span a{color:#008f7c}
.loading{clear:both;width:478px;height:10px;background:#DDD;border-width:1px 1px 1px 0;border-style:solid;border-color:#CCC #FFF #FFF #FFF;font-size: 12px;}
.up-prograss{background:#629600;height:10px}
</style>
</head>
<body>
<span id="spanButtonPlaceHolder"></span>

<script type="text/javascript">
		var upload;
		window.onload = function() {
			var settings = {
				flash_url : "js/upload/swfupload.swf",
				upload_url: "http://localhost:8080/blog/upload.jsp",	//上传的服务器的地址
				post_params: {"username" : "keke","password":"1234566"},
				file_size_limit : "100 MB",//上传上传的过来
				file_types : "*.*",//格式过滤
				//file_types : "*.*",
				file_types_description : "请选择PDF文件",
				file_upload_limit : 100,  //配置上传个数
				file_queue_limit : 0,//代表不限制
				//file_post_name : "file",
				debug: false,
				// Button settings
				button_image_url: "http://9dian.me/images/TestImageNoText_65x29.png",
				button_width: "65",
				button_height: "29",
				button_placeholder_id: "spanButtonPlaceHolder",
				button_text: '<span class="theFont">浏览</span>',
				button_text_style: ".theFont { font-size: 16; }",
				button_text_left_padding: 12,
				button_text_top_padding: 3,
				//button_action : SWFUpload.BUTTON_ACTION.SELECT_FILE,//button_action : (opts.multiple? SWFUpload.BUTTON_ACTION.SELECT_FILES : SWFUpload.BUTTON_ACTION.SELECT_FILE),
				
				//事件的调用
				file_queued_handler : function(file){
					tm_append_uploaditem(file);
				},
				//queue_complete_handler : queueComplete,	
				file_dialog_complete_handler : function(numFilesSelected, numFilesQueued){
					$("#aspupload").find(".bar_total").html("共"+numFilesSelected+"个文件 ，还剩余<span class='number'>"+numFilesQueued+"</span>个");
					this.startUpload();
				},
				file_queue_error_handler : fileQueueError,
				upload_start_handler : function(file){
					$("#"+file.id).find(".loading").hide();
					$("#"+file.id).find(".loaded").show();
				},
				upload_progress_handler : function(file, bytesLoaded, bytesTotal){
					var percent = Math.ceil((bytesLoaded / bytesTotal) * 100);
					$("#"+file.id).find(".up-prograss").width(percent+"%");
					$("#"+file.id).find(".filesize").text(tm_countFileSize(bytesLoaded)+" / "+tm_countFileSize(bytesTotal));
					
				},
				upload_success_handler : function(file, serverData){
					//var data = eval("("+serverData.trim()+")");
				},
				upload_complete_handler : function(file){
					$("#"+file.id).fadeOut("slow",function(){
						$(this).remove();
						$("#aspupload").find(".bar_total").find(".number").text($("#uploaditembox").find("li").length);
					});
					this.startUpload();
				},
				upload_error_handler : uploadError
			};
			upload = new SWFUpload(settings);
	     };
	     
	     //空判断
	     function isEmpty(val) {
	    		val = $.trim(val);
	    		if (val == null)
	    			return true;
	    		if (val == undefined || val == 'undefined')
	    			return true;
	    		if (val == "")
	    			return true;
	    		if (val.length == 0)
	    			return true;
	    		if (!/[^(^\s*)|(\s*$)]/.test(val))
	    			return true;
	    		return false;
	    	}
	     
	      /*折叠上传框*/
	      function tm_expand_upload(obj){
			if($(obj).hasClass("shrink")){
				$(obj).removeClass("shrink").addClass("enlarge");
				$("#mainloadarea").animate({"height":0});
			}else{
				$(obj).removeClass("enlarge").addClass("shrink");
				$("#mainloadarea").animate({"height":345});
			}
		  }
	     
	     //关闭上传框以关闭上传的队列
	     function tm_expand_close(obj){
	    	$("#mainloadarea").empty();
			$("#aspupload").animate({"height":0},function(){
				$(this).remove();
			});
			upload.cancelQueue();
		 }
	     //附加上传框
	     function tm_append_uploaditem(file){
	    	 var html =$("#aspupload").html();
	    	 if(isEmpty(html)){
		    	 $("body").append("<div id='aspupload'><div class='headbar'>"+
				 "		<span class='fl bar_title'>潭州学院上传组件</span></span>"+
				 "		<span class='fr bar_total'></span>"+
				 "		<span class='fr bar_add'><a id='continue' onclick='tm_expand_close(this)' class='continue_1' href='javascript:void(0);'></a></span>"+
				 "		<a href='javascript:void(0);' id='enlarge' onclick='tm_expand_upload(this)' class='windowClick shrink'></a>"+
				 "	</div>"+
				 "	<div class='loadbar' id='mainloadarea' style='height: 345px; background: rgb(238, 238, 238);'>"+
				 "		<ul id='uploaditembox'>"+
				 "		</ul>"+
				 "	</div>"+
				 "</div>");
	    	 }
	    	 var fileName = file.name;
	    	 if(fileName.length>20)fileName = fileName.substring(0,20)+"...";
	    	 $("#uploaditembox").append("<li id='"+file.id+"'>"+
			 "	<div class='load_area'>"+
 			 "			<div class='fl file_ico'></div>"+
 	 		 "			<div class='fl itembox'>"+
 	 		 "				<div class='load_info'>"+
 	 		 "					<span class='loading'>初始化中...</span>"+
 	 		 "					<span class='loaded' style='display:none'><img src='images/loading2.gif'/></span>"+
 	 		 "					<span class='filename'>"+fileName+"</span>"+
 	 		 "					<span class='filesize'>大小:"+tm_countFileSize(file.size)+"</span>"+
 	 		 " 				</div>"+
 	 		 "				<div class='uppbox'>"+
 	 		 "					<div class='up-prograss' style='width: 0%'></div>"+
 	 		 "				</div>"+
 	 		 "			</div>"+
 	 		 "			<a class='fr' href='javascript:void(0);' data-opid='"+file.id+"' onclick='tm_delete_file(this)'>删除</a>"+
	    	 "	</div>"+
	    	 "	</li>");
	     }
	     
	     //删除文件
	     function tm_delete_file(obj){
	    	 var opid = $(obj).data("opid"); 
	    	 upload.cancelUpload(opid);
	    	 upload.startUpload($(obj).parents("li").next().attr("id"));
	    	 $(obj).parents("li").fadeOut("slow",function(){
	    		 $(this).remove();
	    		 $("#aspupload").find(".bar_total").find(".number").text($("#uploaditembox").find("li").length);
	    	 });
	     };
	     
	     //统计文件的大小
	     function tm_countFileSize(size) {
    		var fsize = parseFloat(size, 2);
    		var fileSizeString;
    		if (fsize < 1024) {
    			fileSizeString = fsize.toFixed(2) + "B";
    		} else if (fsize < 1048576) {
    			fileSizeString = (fsize / 1024).toFixed(2) + "KB";
    		} else if (fsize < 1073741824) {
    			fileSizeString = (fsize / 1024 / 1024).toFixed(2) + "MB";
    		} else if (fsize < 1024 * 1024 * 1024) {
    			fileSizeString = (fsize / 1024 / 1024 / 1024).toFixed(2) + "GB";
    		} else {
    			fileSizeString = "0B";
    		}
    		return fileSizeString;
	    };
	    
	    //文件开始上传异常捕获信息
	    function fileQueueError(file, errorCode, message) {
	    	tm_append_uploaditem(file);
	    	try {
	    		if (errorCode === SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED) {
	    			$filename.html("您已达到上传限制 您最多能选择 " + (message > 1 ? "上传 " + message + " 文件." : "一个文件."));
	    			return;
	    		}
	    		var $filename = $("#"+file.id).find(".filename");
	    		switch (errorCode) {
		    		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
		    			$filename.html("<span class='red'>文件尺寸过大," + file.name+"</span>");
		    			break;
		    		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
		    			$filename.html("<span class='red'>零字节文件, 文件名: " + file.name+"</span>");
		    			break;
		    		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
		    			$filename.html("<span class='red'>不支持的文件类型, 文件名: " + file.name+"</span>");
		    			break;
		    		default:
		    			$filename.html("<span class='red'>未知错误</span>");
		    			break;
		    	}
	    		$("#"+file.id).fadeOut(8000,function(){$(this).remove(); $("#aspupload").find(".bar_total").find(".number").text($("#uploaditembox").find("li").length);});
	    	} catch (ex) {
	            this.debug(ex);
	        }
	    };
	    
	    //出错信息
	    function uploadError(file, errorCode, message) {
	    	try {
	    		var $filename = $("#"+file.id).find(".filename");
	    		switch (errorCode) {
		    		case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:
		    			$filename.html("<span class='red'> HTTP错误, 文件名: " + file.name+"</span>");
		    			break;
		    		case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:
		    			$filename.html("<span class='red'>上传失败</span>");
		    			break;
		    		case SWFUpload.UPLOAD_ERROR.IO_ERROR:
		    			$filename.html("<span class='red'>服务器 (IO) 错误</span>");
		    			break;
		    		case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:
		    			$filename.html("<span class='red'>安全错误</span>");
		    			break;
		    		case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
		    			$filename.html("<span class='red'>超出上传限制.</span>");
		    			break;
		    		case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED:
		    			$filename.html("<span class='red'>无法验证.  跳过上传.</span>");
		    			break;
		    		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
		    			$filename.html("<span class='red'>取消</span>");
		    			break;
		    		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
		    			$filename.html("<span class='red'>停止</span>");
		    			break;
		    		default:
		    			$filename.html("<span class='red'>未处理的错误: " + errorCode+"</span>");
		    			break;
	    		}
	    		$("#"+file.id).fadeOut(8000,function(){$(this).remove(); $("#aspupload").find(".bar_total").find(".number").text($("#uploaditembox").find("li").length);});
	    	} catch (ex) {
	            this.debug(ex);
	        }
	    }
	</script>
</body>
</html>