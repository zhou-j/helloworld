<%@ page language="java" import="java.util.*,com.tz.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>潭州Music - Arry老师</title>
		<meta name="keywords" content="关键词,关键词">
		<meta name="description" content="">

		<style type="text/css">
			*{margin:0;padding:0;}
			body{background:#4c5666;font-size:12px;font-family:"微软雅黑";color:#666;}
			
			/*music start*/
			#music{width:610px;height:500px;margin:100px auto;position:relative;overflow:hidden;}
			
			/*m_lrc start*/
			#music .m_lrc{width:300px;height:470px;float:left;background:#787878;border-radius:5px;position:relative;z-index:2;}
			#music .m_list{width:300px;height:500px;float:right;background:#212732;border-radius:5px;position:relative;z-index:1;}

			#music .m_lrc .l_title{width:100%;height:65px;border-radius: 5px 5px 0px 0px;border-bottom:1px solid #ced1d3;background-image:-webkit-gradient(linear, left top, left bottom, color-stop(0, #f2f3f3), color-stop(1, #dddfe1));}
			#music .l_con{width:300px;height:329px;overflow:auto;background:url("images/bg.jpg") no-repeat;background-size:cover;position:relative;}
			#music .l_con .l_con_lrc{width:300px;height:329px;overflow:auto;position:absolute;top:0;left:0;z-index:2;}
			#music .l_con .l_img{position:absolute;left:0;top:15px;z-index:1;}
			
			#music .m_lrc .l_tools{width:100%;height:104px;background-image:-webkit-gradient(linear, left top, left bottom, color-stop(0, #f2f3f3), color-stop(1, #dddfe1));border-radius: 0 0 5px 5px;}
			#music .m_lrc .l_title .l_dir a{width:24px;height:18px;display:block;background:url("images/sm_icon.png") no-repeat -243px -127px;float:left;margin: 26px 12px 0 15px;}
			#music .m_lrc .l_title .l_dir a:hover{background-position:-243px -151px;}
			#music .m_lrc .l_title h2 {float:left;line-height:65px;width:200px;text-align:center;font-size:18px;font-weight:500;white-space:nowrap;text-overflow:ellipsis;overflow:hidden;}
			#music .m_lrc .l_title .l_share a{width:18px;height:18px;display:block;background:url("images/sm_icon.png")  -269px -127px no-repeat;float:right;margin: 27px 17px 0 0;}
			#music .m_lrc .l_title .l_share a:hover{background-position:-28px -149px;}
			#music .m_lrc .l_tools .t_play{width:100%;height:40px;padding: 5px 0;}
			#music .m_lrc .l_tools .t_play .p_btn .b_com{display:block;background:url("images/sm_icon.png") no-repeat;float:left;}
			#music .m_lrc .l_tools .t_play .p_btn .b_1{width:23px;height:19px;background-position:-291px -127px;margin: 12px 0 0 7px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_1:hover{background-position:-291px -151px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_1.sel{background-position:-291px -151px;}

			#music .m_lrc .l_tools .t_play .p_btn .b_2{width:28px;height:18px;background-position:-317px -127px;margin: 12px 0 0 55px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_2:hover{background-position:-317px -152px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_3{width:20px;height:25px;background-position:-347px -125px;margin:8px 0 0 20px;display:none;}
			#music .m_lrc .l_tools .t_play .p_btn .b_3:hover{background-position:-347px -151px;}

			#music .m_lrc .l_tools .t_play .p_btn .b_6{width:20px;height:25px;background-position:-369px -125px;margin:8px 0 0 20px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_6:hover{background-position:-369px -151px;}		
			#music .m_lrc .l_tools .t_play .p_btn .b_4{width:28px;height:18px;background-position:-392px -127px;margin:12px 0 0 20px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_4:hover{background-position:-392px -151px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_5{width:24px;height:22px;background-position:-421px -126px;margin: 12px 0 0 68px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_5:hover{background-position:-421px -151px;}
			#music .m_lrc .l_tools .t_play .p_btn .b_5.sel{background-position:-421px -151px;}


			#music .m_lrc .l_tools .t_time{width:100%;height:14px;padding:16px 0;}
			#music .m_lrc .l_tools .t_time .t_start{float:left;width:35px;padding-left: 12px;}
			#music .m_lrc .l_tools .t_time .t_bar{width:206px;height:8px;background:#a2a7aa;float:left;margin-top:5px;border-radius:6px;position:relative;}
			#music .m_lrc .l_tools .t_time .t_end{float:left;width:35px;padding-left:12px;}
			#music .m_lrc .l_tools .t_time .t_bar .b_1{width:0%;height:8px;background:#f0676a;    border-radius: 6px 0 0 6px;}
			#music .m_lrc .l_tools .t_time .t_bar .b_2{width:12px;height:12px;background:#fff;position:absolute;top:-2px;left:0%;border-radius:50%;cursor: pointer;z-index:2;}
			#music .m_lrc .l_tools .t_time .t_bar .b_all{
				width:100%;height:100%;position:absolute;top:0;left:0;z-index:1;
			}



			/*end m_lrc*/

			/*m_list start*/
			#music .m_list .l_name{width:100%;height:48px;background-image:-webkit-gradient(linear, left top, left bottom, color-stop(0, #f87d7a), color-stop(1, #ef6a6c));border-radius:5px 5px 0 0;}
			#music .m_list .l_name .n_none a{width:16px;height:12px;display:block;background:url("images/sm_icon.png") no-repeat -448px -130px;float:left;margin: 20px 0 0 10px;}
			#music .m_list .l_name .n_none a:hover{background-position:-448px -151px;}
			#music .m_list .l_name .n_text{width:237px;line-height:48px;text-align:center;font-size:16px;color:#fff;float:left;}
			#music .m_list .l_name .n_down a{width:23px;height:16px;display:block;background:url("images/sm_icon.png") no-repeat -468px -128px;float:left;margin-top:18px;}
			#music .m_list .l_name .n_down a:hover{background-position:-468px -151px;}
			#music .m_list .l_m_con ul li{width:100%;height:40px;list-style:none;border-bottom:1px solid #1b1f25;background-image:-webkit-gradient(linear, left top, left bottom, color-stop(0, #262c35), color-stop(1, #212732));line-height:40px;}
			#music .m_list .l_m_con ul li i{width:12px;height:16px;display:block;background:url("images/sm_icon.png") no-repeat 0px -150px;float:left;margin:12px;}
			#music .m_list .l_m_con ul li a{width:224px;display:block;float:left;color:#7e868e;text-decoration:none;font-size:14px;white-space:nowrap;text-overflow:ellipsis;overflow:hidden;}
			#music .m_list .l_m_con ul li a:hover{color:#fff;}

			#music .m_list .l_m_con ul .b_sel{border-bottom:1px solid #ec5b62;}
			#music .m_list .l_m_con ul .b_sel i{background-position:-13px -150px;}
			#music .m_list .l_m_con ul .b_sel a{color:#fff;}
			.lrcline{font-size:14px;color:#fff;line-height:30px;padding-left:15px;}


			::-webkit-scrollbar{width:5px;height:6px;background:#ccc;}
			::-webkit-scrollbar-button{background-color:#e5e5e5;}
			::-webkit-scrollbar-track{background:#999;}
			::-webkit-scrollbar-track-piece{background:#ccc}
			::-webkit-scrollbar-thumb{background:#666;}
			::-webkit-scrollbar-corner{background:#82AFFF;}
			::-webkit-scrollbar-resizer{background:#FF0BEE;}
			scrollbar{-moz-appearance:none !important;background:rgb(0,255,0) !important;}
			scrollbarbutton{-moz-appearance:none !important;background-color:rgb(0,0,255) !important;}
			scrollbarbutton:hover{-moz-appearance:none !important;background-color:rgb(255,0,0) !important;}

			.lrcSel{font-size:20px;color:#6C0;}
			
			/*end m_list*/

			#lrc{display:none;}

			/*end music*/

			/*动画关键帧 , 定义播放旋转动画*/
			@keyframes rotate{
				0%{
					transform: rotate(0deg);
					-webkit-transform: rotate(0deg);
					-ms-transform: rotate(0deg);
					-moz-transform: rotate(0deg);
					-o-transform: rotate(0deg);										
				}
				100%{
					transform: rotate(360deg);
					-webkit-transform: rotate(360deg);
					-ms-transform: rotate(360deg);
					-moz-transform: rotate(360deg);
					-o-transform: rotate(360deg);
				}
			} 
			
			.arry{
				animation: rotate 10s linear infinite;
				-webkit-animation: rotate 10s linear infinite;
				-moz-animation: rotate 10s linear infinite;
				-ms-animation: rotate 10s linear infinite;
				-o-animation: rotate 10s linear infinite;				
			}
		
		
		</style>

	</head>
<body>
	
	<!--music start-->
	<div id="music">

		<!--m_lrc start-->
		<div class="m_lrc">
			<div class="l_title">
				<div class="l_dir">
					<a href="javascript:;" class="expandon"></a>
				</div>
				<h2 id="l_name_new">潭州幸福之歌</h2>
				<div class="l_share">
					<a href="javascript:;"></a>
				</div>
			</div>
			<div class="l_con">
				<div class="l_con_lrc"></div>
				<div class="l_img">
					<img src="images/m.png" alt="音乐旋转图" width="300" height="300" class="arry"/>
				</div>
			</div>
			
			<div class="l_tools">
				<div class="t_play">
					<div class="p_btn">
						<a href="javascript:;" class="b_com b_1 mark" data-mark="2" title="顺序播放"></a>
					</div>
					<div class="p_btn">
						<a href="javascript:;" class="b_com b_2 prev"></a>
					</div>
					<div class="p_btn">
						<a href="javascript:;" class="b_com b_6" title="播放" id="play"></a>
						<a href="javascript:;" class="b_com b_3" title="暂停" id="stop"></a>
					</div>
					<div class="p_btn">
						<a href="javascript:;" class="b_com b_4 next"></a>
					</div>
					<div class="p_btn">
						<a href="javascript:;" class="b_com b_5 mark" data-mark="1" title="随机播放"></a>
					</div>
				</div>
				<div class="t_time">
					<div class="t_start">0:00</div>
					<div class="t_bar">
						<div class="b_1 b_sroll"></div>
						<div class="b_2 b_flag"></div>
						<div class="b_3 b_all"></div>
					</div>
					<div class="t_end">0:00</div>
				</div>
			</div>
		</div>
		<!--end m_lrc-->

		<!--m_list start-->
		<div class="m_list">
			<div class="l_name">
				<div class="n_none">
					<a href="javascript:;" class="expand"></a>
				</div>
				<div class="n_text">TanZhou Music</div>
				<div class="n_down">
					<a href="javascript:;"></a>
				</div>
			</div>
			<div class="l_m_con">
				<ul id="l_box">
					<li data-src="mp3/1.mp3" class="b_items">
						<i></i>
						<a href="javascript:;">相亲相爱一家人</a>
						<span>分享</span>
					</li>
					<li data-src="mp3/2.mp3" class="b_items">
						<i></i>
						<a href="javascript:;">年轻的战场</a>
						<span>分享</span>
					</li>
					<li data-src="mp3/3.mp3" class="b_items">
						<i></i>
						<a href="javascript:;">海阔天空</a>
						<span>分享</span>
					</li>
					<li data-src="mp3/4.mp3" class="b_items">
						<i></i>
						<a href="javascript:;">让我一次爱个够+征服+哭不出来+存在</a>
						<span>分享</span>
					</li>
					<li data-src="mp3/5.mp3" class="b_items">
						<i></i>
						<a href="javascript:;">撕夜</a>
						<span>分享</span>
					</li>
					<li data-src="mp3/6.mp3" class="b_items">
						<i></i>
						<a href="javascript:;">五星红旗迎风飘扬</a>
						<span>分享</span>
					</li>
					<!--
					<li class="b_items">
						<i></i>
						<a href="javascript:;">五星红旗迎风飘扬</a>
						<span>分享</span>
					</li>
					<li class="b_items">
						<i></i>
						<a href="javascript:;">不要忘记我爱你</a>
						<span>分享</span>
					</li>
					<li class="b_items">
						<i></i>
						<a href="javascript:;">天意</a>
						<span>分享</span>
					</li>
					<li class="b_items">
						<i></i>
						<a href="javascript:;">第一次</a>
						<span>分享</span>
					</li>
					<li class="b_items">
						<i></i>
						<a href="javascript:;">贝加尔湖畔</a>
						<span>分享</span>
					</li>
					-->
				</ul>
			</div>
		</div>
		<!--end m_list-->

	</div>
	<!--end music-->

<audio id="audio"></audio>

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	
	// 创建一个mp3播放器
	//var audioDom = document.createElement("audio");
	var audioDom = document.getElementById("audio");
	// 播放索引记录
	var playIndex = 0;
	// 音乐列表的总长度
	var len = $("#l_box").children().length;


	// 监听时间
	function timeEvent(){
		// 音频加载完毕监听
		audioDom.oncanplaythrough = function(){
			// 获取总时长
			var time = this.duration;
			// 格式化时间
			var ftime = formartTime(time);
			$(".t_start").text(ftime);
		};
		
		// 播放事件监听
		audioDom.ontimeupdate = function(){
			// 获取总时长
			var time = this.duration;
			// 获取播放时长
			var stime = this.currentTime;
			// 格式化时间
			var ftime = formartTime(stime);
			$(".t_end").text(ftime);
			// 获取播放进度
			var pbit = stime / time;
			// 计算百分比
			var percent = pbit * 100;
			$(".b_sroll").width(percent+"%");
			$(".b_flag").css("left",(percent)+"%");
		};
	
		// 音乐播放结束
		audioDom.onended = function(){
			if(mark == 2){
				nextMusic();
			} else{
				randomMusic();
			}

		};

	}
	
	// 格式化日期
	function formartTime(time){
		var m = Math.floor(time / 60);
		var s = Math.floor(time % 60);
		return (m<10 ? "0" + m:m) + ":" + (s<10 ? "0" + s:s);
	}

	// 添加音乐
	function addMusic(src){
		audioDom.src = src;			
	}
	// 播放音乐
	function playMusic(obj){
		var name = obj.data("src");
		var s = name.split("/");
		var n = s[1];
		var a = n.split(".");
		// 从服务器动态加载歌词
		loadLrc(a[0]);
		audioDom.play();
		repeatName(obj);
	}

	// 动态替换歌名
	function repeatName(obj){
		var name = obj.find("a").text();
		$("#l_name_new").text(name);	
	}

	// 下一首
	function nextMusic(){
		playIndex = (playIndex == (len-1) ? 0 : ++playIndex);
		// 选中音乐文件
		var sel = $("#l_box").find(".b_items").eq(playIndex);
		var src = sel.data("src");
		addMusic(src);
		// 播放选中的音乐
		playMusic(sel);
		sel.addClass("b_sel").siblings().removeClass("b_sel");
	}

	// 上一首
	function prevMusic(){
		playIndex = (playIndex < 0 ? (len-1) : --playIndex);
		// 选中音乐文件
		var sel = $("#l_box").find(".b_items").eq(playIndex);
		var src = sel.data("src");
		addMusic(src);
		// 播放选中的音乐
		playMusic(sel);
		sel.addClass("b_sel").siblings().removeClass("b_sel");			
	}

	// 随机播放音乐
	function randomMusic(){
		var random = Math.floor(Math.random()*len);
		playIndex = random;
		var sel = $("#l_box").find(".b_items").eq(playIndex);
		var src = sel.data("src");
		// 添加音乐
		addMusic(src);
		// 播放选中的音乐
		playMusic(sel);
		sel.addClass("b_sel").siblings().removeClass("b_sel");		
	}



	// 顺序播放2, 随机播放1
	var mark = 2;

	$(function(){

		// 初始化监听事件
		timeEvent();

		// 点击播放按钮
		$("#play").click(function(){	
			// 如果已经有选中播放文件就直接播放
			var sel = $("#l_box").find(".b_sel");
			var src = sel.data("src");
			if(!src){
				// 如果没有把第一当做播放的元素时 
				sel = $("#l_box").find("li").eq(0);
				src = sel.data("src");
				// 添加到音乐播放器
				addMusic(src);
				sel.addClass("b_sel");
			}

			playMusic(sel);
			// 切换成暂停按钮
			$("#play").hide().next().show();

			// 将索引记录下来
			playIndex = sel.index();

		});
		
		// 点击暂停按钮
		$("#stop").click(function(){
			// 调用暂停方法
			audioDom.pause();
			// 切换成播放按钮
			$("#stop").hide().prev().show();
		});

		
		// 点击音乐列表播放
		$("#l_box").find(".b_items").click(function(){
			// 获取播放音乐文件的地址
			var src = $(this).data("src");
			// 添加到音乐播放器
			addMusic(src);
			// 播放音乐
			playMusic($(this));
			
			$(this).addClass("b_sel").siblings().removeClass("b_sel");

			// 点击音乐列表文件，记录索引
			playIndex = $(this).index();

			// 自动触发播放按钮
			$("#play").trigger("click");

		});




		// 点击下一首
		$(".next").click(function(){
			nextMusic();
		});
		// 点击上一首
		$(".prev").click(function(){
			prevMusic();
		});	
		
		// 随机播放和顺序播放
		$(".mark").click(function(){
			mark = $(this).data("mark");
			$(".mark").removeClass("sel");
			$(this).addClass("sel");
			if(mark == 2){
				nextMusic();
			} else {
				randomMusic();
			}
		});


		// 收起
		$(".expand").click(function(){
			$(".m_list").animate({left:-310},function(){
				$("#music").animate({width:300});
			});
		});

		// 展开
		$(".expandon").click(function(){
			$("#music").width(610);
			$(".m_list").animate({left:0});
		});

		
		// 拖动播放
		$(".b_2").mousedown(function(e){
			// 获取拖动对象
			var _this = $(this);
			// 获取鼠标的位置
			var x = e.clientX || e.pageX;
			// 获取拖动元素的起点位置
			var left = _this.position().left;
			// 获取拖动元素的终点位置
			var maxLeft = _this.parent().width() - 10;
			// 先暂停音乐
			audioDom.pause();

			// 拖动元素开始
			$(document).mousemove(function(e){
				// 获取鼠标拖动最终位置
				var n1 = (e.clientX || e.pageX) - x + left;
				// 判断边界
				if(n1 < 0){n1 = 0;}
				if(n1 > maxLeft){n1 = maxLeft;}
				// 定位拖动进度最终位置
				_this.css("left",n1);
				// 根据拖动的位置除以最大位置得到百分比
				var percent = (n1 / maxLeft) * 100;
				// 给进度条和拖动元素赋值
				$(".b_sroll").width(percent+"%");
				$(".b_flag").css("left",(percent-2)+"%");

				// 音乐文件的时间加载
				audioDom.currentTime = audioDom.duration * (n1 / maxLeft);
				
			}).mouseup(function(){
				// 松开鼠标，播放音乐
				audioDom.play();
				// 移除事件
				$(document).unbind("mousemove");
				$(document).unbind("mouseup");
			});

		});

		// 点击进度条
		$(".b_all").mousedown(function(e){
			// 获取点击位置
			var _this = $(this);
			// 获取鼠标位置
			var x = e.clientX || e.pageX;
			// 获取起点位置
			var left = _this.parent().offset().left;
			// 获取终点位置
			var maxWidth = _this.parent().width();
			// 最大位置
			var w = x - left;
			// 根据点击位置除以最大位置得到百分比
			var percent = (w / maxWidth) * 100;
			// 根据进度赋值
			$(".b_sroll").width(percent+"%");
			$(".b_flag").css("left",(percent-2)+"%");
			
			// 音乐文件的时间加载
			audioDom.currentTime = audioDom.duration * (w/maxWidth);

		});


	});

	// 从服务器动态家在歌词
	function loadLrc(name){
		$.ajax({
			type:"post",
			url:"data.jsp",
			data:{"name":name},
			success:function(data){
				var lrc = data;
				// 把时间个歌词分离出来
				var lrcArr = lrc.split("[");
				var htmlLrc = "";
				for(var i = 0; i < lrcArr.length; i++){
					// 第二次分割“]”
					var arr = lrcArr[i].split("]");
					// console.log(arr);
					// 取到歌词
					var message = arr[1];

					// 取到时间
					var timer = arr[0].split(".");
					// 取到分钟和秒
					var stime = timer[0].split(":");
					// 转换成秒数
					var ms = stime[0]*60 + stime[1]*1 - 1;

					if(message){
						htmlLrc += "<div class='lrcline' id='"+ms+"'>"+message+"</div>";
					}
				}
				// 把解析好的歌词放入div中
				$(".l_con_lrc").html(htmlLrc);

				// 联动音乐播放歌词
				audioDom.addEventListener("timeupdate",function(){
					// 获取当前播放时间
					var timer = this.currentTime;
					console.log(timer);
					// 解析音乐对应的时间
					var m = parseInt(timer / 60);
					var s = parseInt(timer);
					for(var i = 0; i < s; i++){
						$("#"+i).addClass("lrcSel").siblings().removeClass("lrcSel");
					}
					var st = m * 60 + s;
					$(".l_con_lrc").scrollTop(st*2);

				});				
			}
		});
		
	}


</script>


</body>
</html>