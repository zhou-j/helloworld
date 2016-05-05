<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>注册</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
    <style type="text/css">
	    *{margin:0;padding:0;}
		body{font-size:14px;font-family:"微软雅黑";color:#fff;background:#5F80A1;}
		h1{text-align:center;margin-top:100px;}
	    .box{width:425px;border:1px solid #999;margin:25px auto;box-shadow:1px 1px 3px #999;border-radius:6px;}
		/*头部部分*/
		.box-header{width:100%;height:45px;background:rgba(17,34,51,0.1);border-radius:3px;text-align:center;line-height:45px;}
		/*中间的input框部分*/
		.control-label{display:block;text-align:center;height:30px;border:1px dashed #dedede;line-height:30px;margin-top:3px;width: 92%;margin-left:4%;}
		.controls{padding:10px 0;}
		.input-block-level{width: 92%;height: 40px;line-height: 40px;background: rgba(17,34,51,0.1);margin: 5px auto;box-shadow: 0 0 1px #fff;border:none;outline-color:#fff;margin-left:4%;color:#fff;font-family:"微软雅黑"}
        input:-webkit-autofill, textarea:-webkit-autofill, select:-webkit-autofill {
        background: rgba(17,34,51,0.1);color: rgb(f, f, f);}
		#sign-up{-webkit-perspective: 600px;-webkit-transform-style: preserve-3d;}
		#sign-up .control-group.show{-moz-animation:songs_rcmd 2s forwards; 
		-webkit-animation:songs_rcmd 2s forwards; opacity:1;}
		#sign-up .control-group{list-style:none;margin: 0;padding: 0;list-style:none;border: none;opacity:0;}
		#sign-up li:first-child {
			margin-top: 15px;
		}
		/*底部的submit部分*/
        .form-actions{width:100%;height:45px;}
        .form-actions .btn{width:90%;height:40px;background:rgba(17,34,51,0.1);border-radius:6px;text-align:center;line-height:40px;outline:none;border:0;font-size:14px;margin-left:20px;font-family:"微软雅黑";color:#fff;box-shadow:1px 1px 2px #999;}
        .form-actions .btn:hover{background:#15EAEA;}
		@-moz-keyframes songs_rcmd{/*歌单出场动画*/
				0%{-moz-transform:rotateY(120deg);}
				40%{-moz-transform:rotateY(-30deg);}
				60%{-moz-transform:rotateY(20deg);}
				80%{-moz-transform:rotateY(-10deg);}
				100%{-moz-transform:rotateY(0deg);}
		}
		@-webkit-keyframes songs_rcmd{
				0%{-webkit-transform:rotateY(120deg);}
				40%{-webkit-transform:rotateY(-30deg);}
				60%{-webkit-transform:rotateY(20deg);}
				80%{-webkit-transform:rotateY(-10deg);}
				100%{-webkit-transform:rotateY(0deg);}
		}
	</style>    
    <body>
        <!-- section content -->
        <section class="section">
		    <h1>注册页面</h1>
            <div class="container">
                <div class="signin-form row-fluid">
                    <!--Sign Up-->
                    <div class="span5">
                        <div class="box corner-all">		                  
                            <div class="box-header">
                                <span>Create an account!</span>
                            </div>
                            <div class="box-body bg-white">
                                <form id="sign-up" />
                                    <li class="control-group">
                                        <label class="control-label">account</label>
                                        <div class="controls">
                                            <input type="text" class="input-block-level" autocomplete="off" jtip = "请输入账号....."  jrequired="jrequired" id = "account" jmin = "3" jmax = "50" class="inp" />
                                        </div>
                                    </li>
                                    <li class="control-group">
                                        <label class="control-label">Username</label>
                                        <div class="controls">
                                            <input type="text" class="input-block-level" autocomplete="off" jtip = "请输入用户名....."  jrequired="jrequired" id = "username" jmin = "3" jmax = "20" class="inp" />
                                        </div>
                                    </li>
                                    <li class="control-group">
                                        <label class="control-label">Email</label>
                                        <div class="controls">
                                            <input type="text" autocomplete="off" class="input-block-level" jvalidator = "email" jtip = "请输入邮箱...."  jrequired="jrequired" id = "email" jmin = "3" jmax = "20" class="inp" />
                                        </div>
                                    </li>
                                    <li class="control-group">
                                        <label class="control-label">Password</label>
                                        <div class="controls">
                                            <input type="password" autocomplete="off" class="input-block-level" jtip = "请输入密码...." jrequired="jrequired" id="pwd" jmessage="请输入数字[3-8]位" jregex="/\d{3,8}/" jmin = "3" jmax = "10" class="inp" />
                                        </div>
                                    </li>
                                    <li class="control-group">
                                        <label class="control-label">Password Again</label>
                                        <div class="controls">
                                            <input type="password" class="input-block-level" autocomplete="off"  jrequired="jrequired" id="pwd"  jmessage="请确定刚刚输入密码！" jregex="/\d{3,8}/" to="pwd"/>
                                        </div>
                                    </li>
                                    <div class="form-actions" id="submitbtn">
                                        <input type="button" class="btn" value="Create account" />
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div><!--/Sign Up-->
                </div><!-- /row -->
            </div><!-- /container -->
        </section>

        <script type="text/javascript" src="js/tzvalidator.js"></script>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>				
        <script type="text/javascript">
	        var tf = new tzForm(); 
	        tf.init({id:"sign-up",btnId:"submitbtn",callback:function(formDom){
	          	   var account = $("#account").val();
	          	   var username = $("#username").val();
	          	   var email = $("#email").val();
	          	   var pwd = $("#pwd").val();
	              $.ajax({
	                  type:"post",
	                  url:"http://localhost/yunpan/service/adduser.jsp",
	                  data:{"account":account,"username":username,"email":email,"password":pwd},
	                  success:function(data){
	               	   var jdata = data.trim();
	               	   if(jdata=="success"){
	               		   alert("注册成功，即将跳转到首页！");
	               		   window.location.href = "http://localhost/yunpan/index.jsp";
	               	   }else{
	               		   alert("注册失败，刷新页面后请重新注册！");                    		  
	               		   window.location.href = "http://localhost/yunpan/signup.jsp";                    		   
	               	   };
	                  }
	              }); 
	        }});
			$(function(){
	            //var songs_rcmd_top=$(".songs_rcmd").offset().top - $(".songs_rcmd").height()/5*6;
				 var songs_rcmd_top=755 - $(".box").height()/5*6; //计算高度             
				 var songs_rcmd_timer=null;											
				 var index_4;
				 //var songs_rcmd_off=true;
				 $(window).scroll(function(){	//窗口滚动事件
					 var oScrollTop=$(document).scrollTop();
					 if(oScrollTop>songs_rcmd_top){//当页面滚动距离大于这个值时，列表展开
						index_4=0;
						clearInterval(songs_rcmd_timer);
						songs_rcmd_timer=setInterval(function(){//分三组一起翻出
							$("#sign-up li").eq(index_4).addClass("show");
							index_4++;			//document.title=index_4;
							if(index_4==$("#sign-up li").length){
								clearInterval(songs_rcmd_timer);
							}
						},30);
					 }else{//当页面滚动距离小于这个值时，列表收缩
						index_4=$("#sign-up li").length;
						clearInterval(songs_rcmd_timer);
						songs_rcmd_timer=setInterval(function(){	
							$("#sign-up li").eq(index_4).removeClass("show");
							index_4--;			//document.title=index_4;
							if(index_4<0){
								clearInterval(songs_rcmd_timer);
							}
						},100);
					}
				 });							
			});
        </script>
    </body>
</html>

