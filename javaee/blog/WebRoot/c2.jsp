<%@page import="com.blog.dao.content.ContentDao"%>
<%@page import="com.blog.bean.Content"%>
<%@page import="com.blog.bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>潭州</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%
		pageContext.setAttribute("width", 1000);
	%>
	<style type="text/css">
		*{padding:0px;margin:0px;}
		body{font-family: "微软雅黑";font-size: 14px;}
		#box{margin:  100px auto;width: ${width}px; border: 1px solid #ccc;}
		#box div{height: 38px;line-height: 38px;border-bottom: 1px solid #bbb;padding-left:5px;}
		#box div:HOVER {background: #e5e5e5}
		.red{background: red}
		.green{background: green}
		.yellow{background: yellow}
	</style>	
 </head>
  <body>
  	<%
  		List<Content> contents = ContentDao.findContents(0, 10, "desc");
  		pageContext.setAttribute("contents", contents);
  		
  		HashMap<String,Object> map = new HashMap<String,Object>();
  		map.put("name", "威威");
  		map.put("age", "17");
  		pageContext.setAttribute("map", map);
  		
  		
  		Content content = new Content();//javabean
  		content.setTitle("秋风士大夫士大夫士大夫士大夫");
  		content.setContent("秋风sdfssdfsdf");
  		pageContext.setAttribute("ctn", content);
  		//jsp本身就是一个模板。在这个模板中的任何位置都可以使用el表达式和标签,前提是一定要在jsp中.
  		//虽然可以，但是一定不要这样去做.
  		
  	%>
  	
<!--   	${map.name}===${map.age} -->
<!--   	${content.title} -->
<!--   	${content.content} -->
  	
	<!-- 集合，数组 -->
  	<c:forEach items="${map}" var="mk">
  		<p>${mk.key}===${mk.value}</p>
  	</c:forEach>
  	
  	<div id="box">
	    <c:forEach items="${contents}" var="content" varStatus="ctindex">
	    	<div <c:if test="${(ctindex.index+1)%2==0}">class="red"</c:if>>${ctindex.index+1}：${content.title}</div>
<%-- 	    	<div ${(ctindex.index+1)%2==0 ? "class='green'" : ""}>${ctindex.index+1}：${content.title}</div> --%>
	    </c:forEach>
	    
	    <c:forEach begin="1" end="10" var="count">${count}&nbsp;</c:forEach>
	    ===${1==1?"相等吗":"不相等" }
	    
	    ---相当于if()
	    <c:if test="${1==1}">
	    	<div>他们两个相等吗?</div>
	    </c:if>
	    
	    
	    <div class="<c:choose><c:when test='${2==1}'>red</c:when><c:when test='${3==2}'>green</c:when><c:when test='${4==4}'>yellow</c:when></c:choose>" style="width:100px;height:100px;"></div>
	    
	    <br>
	    <c:choose>
	    	<c:when test="${1==2}">相等</c:when>
	    	<c:when test="${2==3}">2==2不相等</c:when>
	    	<c:when test="${3==4}">3==2不相等</c:when>
	    	<c:when test="${4==5}">4==4不相等</c:when>
	    	<c:when test="${5==6}">5==5不相等</c:when>
	    	<c:otherwise>两个值不存在</c:otherwise>
	    </c:choose>
	    
	  	  当前的标题是:<span id="title">${ctn.title}</span>
	    <script type="text/javascript">
	    	//js其实更多就是处理我们页面的元素dom
	    	var title = document.getElementById("title").innerHTML;
	    </script>
	  </div>	
  </body>
</html>

