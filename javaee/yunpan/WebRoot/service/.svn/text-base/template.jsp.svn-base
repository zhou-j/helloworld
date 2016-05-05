<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- c标签 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 自定义函数标签 -->
<%@taglib uri="/WEB-INF/tld/tz.tld" prefix="tz"%>

<c:choose>
<c:when test="${tz:getLength(resources)==0}">
      <h1>暂无上传数据</h1>
</c:when>
<c:otherwise>
	<c:forEach var="resource" items="${resources}" varStatus="vs">
		<li class="items" id="tm-items-${resource.id}">
		    <c:if test="${vs.index==0}"><input id="resourcetotal" data-opta="${itemcount}" style="width:20px;display:none;"></c:if>
			<div class="col c1" style="width: 50%;">
				<span class="chk fl"></span>
				<span class="fl icon">
				   <input type="checkbox" class="chk" value="${resource.id}">
				   <img src="images/text.png">
				</span>
				<div class="name fl">
					<span class="name-text" title="${resource.name}" data-opid="${resource.id}"><span class="name-text">${resource.name}</span></span>
				    <a href="javascript:void(0);" class="tmui-btns save">确定</a>&nbsp;&nbsp;
				    <a href="javascript:void(0);" class="tmui-btns cancle">取消</a>&nbsp;&nbsp;										
				</div>
			</div>
			<div class="col" style="width: 16%"
				title="字节大小:${resource.size}">${resource.sizeString}</div>
			<div class="col" style="width: 23%;color:green">${tz:dateFormat2(resource.createTime,"yyyy-MM-dd   HH:mm:ss")}&nbsp;&nbsp;(${tz:dateString(resource.createTime)})</div>
			<div class="col buttons"  style="width: 10%">
				<a href="javascript:void(0);" class="edit"><img src='images/edit.png'></a>&nbsp;&nbsp;
				<a href="javascript:void(0);" data-opid="${resource.id}"
					onclick="tm_deleteresource(this);"><img
					src='images/delete.gif'></a>
				<!-- 			            	<a href="javascript:void(0);" data-opid="${resource.id}" class="delete"><img src='images/delete.gif'></a> -->
			</div>
		</li>
	</c:forEach>						  
</c:otherwise>
</c:choose>

