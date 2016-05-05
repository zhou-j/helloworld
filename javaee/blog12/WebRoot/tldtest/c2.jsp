<%@ page language="java" import="java.util.*,com.blog.bean.Content,com.blog.dao.ContentDao" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>forEach</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	   #contentBox{width:800px;margin:100px auto;border-right:1px solid #dedede;border-top:1px solid #dedede;border-left:1px solid #dedede;box-shadow:2px 2px 15px #999;}
	   .content{border-bottom:1px solid #dedede;padding:10px 30px;}
	</style>
  </head>  
  <body>
      <%
         List<Content> contents = ContentDao.findContent(0,10,"desc");
         pageContext.setAttribute("contents", contents);
      %>
      
      <div id="contentBox">
         <c:forEach items="${contents}" var="content" varStatus="cindex">
             <div class="content">${cindex.index+1}:${content.title}${content.content}</div>
             <c:forEach begin="1" end="10" var="count">${count}&nbsp;</c:forEach>
             ===${1==1?"相等吗":"不相等"}
             ---相当于if()
             <c:if test="${1==1}">
                  <div>他们两个相等吗?</div>
             </c:if>
             <hr>
             <c:choose>
                <c:when test="${1==1}">相等</c:when>
                <c:when test="${1==1}">相等</c:when>
                <c:when test="${2==2}">相等</c:when>
                <c:when test="${3==3}">相等</c:when>
                <c:when test="${4==4}">相等</c:when>
                <c:otherwise>两个值不相等</c:otherwise>
             </c:choose>
         </c:forEach>
      </div>
      <p>el表达式可以放在页面的任意地方，包括js代码块中</p>
  </body>
</html>
