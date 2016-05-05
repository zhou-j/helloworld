<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<ul>
   <c:choose>
        <c:when test="${tz:indexOf(pageContext.request.requestURI,'profit/list')==-1}">
            <li><a href="${basePath}/profit/list">收入明细</a></li>
        </c:when>
        <c:otherwise>
            <li class="selected"><a href="javascript:void(0);">收入明细</a></li>
        </c:otherwise>
   </c:choose>
   <c:choose>
        <c:when test="${tz:indexOf(pageContext.request.requestURI,'profit/detail')==-1}">
            <li><a href="${basePath}/profit/detail">打印清单</a></li>
        </c:when>
        <c:otherwise>
            <li class="selected"><a href="javascript:void(0);">打印清单</a></li>
        </c:otherwise>
   </c:choose>
   <c:choose>
        <c:when test="${tz:indexOf(pageContext.request.requestURI,'profit/list1')==-1}">
            <li><a href="${basePath}/profit/add">收入统计明细</a></li>
        </c:when>
        <c:otherwise>
            <li class="selected"><a href="javascript:void(0);">收入统计明细</a></li>
        </c:otherwise>
   </c:choose>
   <c:choose>
        <c:when test="${tz:indexOf(pageContext.request.requestURI,'profit/list2')==-1}">
            <li><a href="${basePath}/profit/add">支出统计明细</a></li>
        </c:when>
        <c:otherwise>
            <li class="selected"><a href="javascript:void(0);">支出统计明细</a></li>
        </c:otherwise>
   </c:choose>
   <c:choose>
        <c:when test="${tz:indexOf(pageContext.request.requestURI,'profit/list3')==-1}">
            <li><a href="${basePath}/profit/add">打印清单</a></li>
        </c:when>
        <c:otherwise>
            <li class="selected"><a href="javascript:void(0);">打印清单</a></li>
        </c:otherwise>
   </c:choose>
</ul>