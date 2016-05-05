<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>图片水印页面</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	     *{margin:0;padding:0;}
	     body{font-family:"微软雅黑";font-size:20px;color:#999;}
	     fieldset{width:800px;height:500px;border:1px solid #dedede;margin:100px auto;}
	     .imagebox{height:465px;width:370px;float:left;margin-left:13px;}
	     img{width:100%;height:100%;}
	     .line{width:1px;height:470px;background:blue;float:left;margin-left:13px;} 
	     form{height:465px;width:370px;border:1px solid #dedede;float:left;margin-left:13px;}
	     form .inp{width:250px;height:35px;border:1px solid #999;border-radius:5px;}
	     form p{padding:5px;}
	     form .subbtn{width:100px;height:30px;border:0;outline:0;border-radius:3px;color:#666;margin-left:135px;}
	     .zoombox{width:360px;border:1px solid #ccc;}
	     .zoombox{float:left;}
	     .zoombox img{height:100px;width:100px;float:left;padding:10px;}
	</style>
  </head>  
  <body>
     <div class="zoombox">
          <div class="zoom"><img src="images/m4.jpg" /></div>
          <div style="zoom:1;padding:5px;">
                                          放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达加快速度解放了开始就富士达家乐福接收到了的大师傅都是富士达
          </div>
     </div>
     <fieldset>
         <legend>文字水印</legend>
         <div class="imagebox">
             <img src = "images/m0.jpg" alt="jpg" width="" height="" />
         </div>
         <div class="line"></div>
         <form action="pressimg.action" method="post">
            <p>
                                         文字：&nbsp;<input type="text" class="inp" name="text" />
            <p>
            <p>
                                         源图：&nbsp;<input type="text" class="inp" name="sourceImg" disabled="disabled"/>
            <p>
            <p>
                                         目标：&nbsp;<input type="text" class="inp" name="targetImg" disabled="disabled"/>
            <p>
            <p>
                                         字体：
              <select class="inp" name="fontName">
                 <option value="微软雅黑">微软雅黑</option>
                 <option value="宋体">宋体</option>
                 <option value="仿宋">仿宋</option>
              </select>
            <p>
            <p>
                                         大小：
              <select class="inp" name="fontSize">
                 <option value="14">14</option>                           
                 <option value="18">18</option>                           
                 <option value="22">22</option>                           
                 <option value="26">26</option>                           
                 <option value="30">30</option>                           
                 <option value="34">34</option>                           
                 <option value="38">38</option>                           
                 <option value="42">42</option>                           
              </select>
            <p>
            <p>
              x：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <select class="inp" name="x">
                  <option value="10">10</option>
                  <option value="15">15</option>
                  <option value="20">20</option>
                  <option value="25">25</option>
                  <option value="30">30</option>
                  <option value="35">35</option>
                  <option value="40">40</option>
                  <option value="45">45</option>
                  <option value="50">50</option>
                  <option value="55">55</option>
              </select>
            <p>
            <p>
              y：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <select class="inp" name="y">
                  <option value="10">10</option>
                  <option value="15">15</option>
                  <option value="20">20</option>
                  <option value="25">25</option>
                  <option value="30">30</option>
                  <option value="35">35</option>
                  <option value="40">40</option>
                  <option value="45">45</option>
                  <option value="50">50</option>
                  <option value="55">55</option>
             </select>
            <p>
            <p>
                                         位置：
              <select class="inp" name="flag">
                  <option value="1">左上角</option>
                  <option value="2">右上角</option>
                  <option value="3">左下角</option>
                  <option value="4">右下角</option>
              </select>
            <p> 
            <input type="submit" class="subbtn" value="登录" />        
         </form>
     </filedset>
  </body>
</html>
