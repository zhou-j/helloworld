<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
     <meta charset = "utf-8" />
     <title></title>
     <style type="text/css">
        body{height:670px;}
        .red{color:red;}
     </style>
	 <%@include file="../common/taglib.jsp"%>
	 <%@include file="../common/common.jsp"%>
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
		    	<div class="cheader">
		    		<p class="ta_title"><a href="${basePath}/profit/list">【返回列表】</a>添加收入</p>
		    	</div>
		    	<!--表格-->
				<div id="contentbox">
					<input type="hidden" id="profitId" name="profitBean.id" value="${profitBean.id}">
					<form id="profitform" method="post">
					<div class="xt_right">
				     <div class="xtrt_nr">
				          <input type="hidden" id ="userId" data-opta="${tmuser.id}" />
				          <table width="100%" border="0" cellpadding="0" cellspacing="0">
				          <tr>
					          <td width="115">收入来源：</td>
					          <td>  
					          	<select name="profitBean.typeId" id="addtypeId" class="text_box">
					          		<option value="">--请选择收入类型--</option>
					          		<c:forEach var="pt" items="${maps}">
					          			<option ${pt.id==profitBean.typeId ? 'selected="selected"':''}   value="${pt.id}">${pt.name}</option>
					          		</c:forEach>
					          	</select>
					          	<i class="red">*</i>
					          	<span class="errormessage red"></span>
					          </td>
				          </tr>
				          <tr>
				          <td width="115">收入的金额：</td>
				          <td>
				          	<input type="text" name="profitBean.money" value="${profitBean.money}" class="text_box" autofocus="autofocus" id="money" maxlength="10" placeholder="请输入收入的金额"><i class="red">*</i>
				          	<span class="errormessage red"></span>
				          </td>
				          </tr>
				          <tr>
				          <td width="115" style="vertical-align: top;">收入描述：</td>
				          <td><textarea class="text_box" name="profitBean.description" id="description" maxlength="600" style="height: 200px;" placeholder="请输入收入的描述">${profitBean.description}</textarea></td>
				          </tr>
				          <tr>
				          <td width="115"></td>
				          <td>
				          	<input type="button" onclick="tm_save(this)" class="text_btn" value="保存收入">
				          	<input type="button" onclick="window.location.href='${basePath}/profit/list'" class="text_btn" value="返回">
				          </td>
				          </tr>
				          </table>
				     </div>
				</div>
				</form>
				</div>
			</div>
		</div>
     <script type="text/javascript">
         
         function tm_validator(){
        	 //类型
        	 var typeId = $("#addtypeId").val();
        	 //金额
        	 var money = $("#money").val();        	 
        	 if(isEmpty(typeId)){
        		 $("#addtypeId").focus();
        		 $("#addtypeId").parent().find(".errormessage").html("请选择收入类型！");
        		 return false;
        	 }else{
        		 $("#addtypeId").parent().find(".errormessage").empty();
        	 }
        	 
        	 if(isEmpty(money)){
        		 $("#money").focus();
        		 $("#money").parent().find(".errormessage").html("请输入金额！");
        		 return false;
        	 }else{
        		 $("#addtypeId").parent().find(".errormessage").empty();
        	 }

        	 if(isNaN(money)){
        		 $("#money").focus();
        		 $("#money").parent().find(".errormessage").html("请输入数字！");
        		 return false;
        	 }else{
        		 $("#addtypeId").parent().find(".errormessage").empty();
        	 }
        	 return true;
         }
         function tm_save(obj){
        	 if(!tm_validator()) return;
        	 //类型
        	 var typeId = $("#addtypeId").val();
        	 //金额
        	 var money = $("#money").val();
        	 //描述
        	 var description = $("#description").val();
        	 //用户id
             var userId = $("#userId").data("opta");
        	 var params = {"profitBean.typeId":typeId,"profitBean.money":money,"profitBean.userId":userId,"profitBean.description":description};
        	 $(obj).removeAttr("onclick").val("数据保存中...");
        	 var id = $("#profitId").val();
        	 var method = "save";
        	 if(isNotEmpty(id)) {
        		 params["profitBean.id"] = id;
        		 method = "update";
        	 }
        	 $.ajax({
        		 type:"post",
        		 url:basePath+"/json/"+method,
        		 data:params,
        		 error:function(){$(obj).attr("onclick","tm_save(this)").val("保存收入");},
        		 success:function(data){
        			 $(obj).attr("onclick","tm_save(this)").val("保存收入");                    
        			 if(data.result == "success"){
                    	 $.tmLoading("保存成功！");
                     }else{
                    	 $.tmLoading("保存失败!");
                     }
        		 }
        	 });
         }
     </script>
  </body>
</html>
