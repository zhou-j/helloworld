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
  </head>
  <body>
  	<%-- 
  		jstl:
  		c标签:<c:out> <c:if <c:choose> <c:when> <c:forEach <c:foreToken <c:remove
  		<c:import url=""></c:import> 
  		fmt标签
  		fn标签
  		sql:标签,如果快速的去做一个网站或者做一个专题，或者生成静态化的化的时候可以用它.
  		
  		
  		c:import jsp:include两者在进行页面包含的时候，一定要注意啦：他们并不是真正页面的一部分。
  		在执行动态数据填充的时候，是不能够共享父页面的标签。一定要在包括的页面重新导入标签
  		指令include他就是页面的一部分。就不需要再次重新引入标签了.
  		从作用域pageContext就已经印证了这点.
  	 --%>
  	 <%
  	 	
  	 	List<String> strings = new ArrayList<String>();
  		strings.add("1111");
  		strings.add("2222");
  		strings.add("3333");
  		request.setAttribute("strings", strings);
  		
  		String username = "bill同学和秋风同学都是小帅哥";
  		pageContext.setAttribute("username", username);
  		
  	 %>
  	 
  	 <h1>页面包含部分</h1>
  	 <hr>
  	 <!-- c标签 -->
  	 <c:import url="header.jsp"></c:import>
  	 <jsp:include page="header.jsp"></jsp:include>
  	 <!-- 这个包括的内容才是真正页面的一部分 -->
  	 <%@include file="header.jsp" %>
  	 <h1>页面包含静态页面</h1>
  	 <hr>
  	 <!-- 静态页面的包含 -->
  	 <c:import url="test2.html"></c:import>
  	 <jsp:include page="test2.html"></jsp:include>
  	 <%@include file="test2.html" %>
  	 <b>总结在实际开发过程中推荐使用:指令的include，不要给自己带来不必要的麻烦。</b>
  	 <hr>
  	 <h1>c:out标签</h1>
  	 <c:out value="1+1"></c:out>==<%=("1+1")%>===${"1+1"}<br>
  	 <c:out value="${1+1}"></c:out>=====${1+1}===<%=(1+1) %><br>
  	 ${username}===<c:out value="${username}" ></c:out>
  	 <b>${username}</b>
  	 <c:out value="<b>${username}</b>" escapeXml="false"></c:out>
  	 <hr>
  	 <h1>c:set标签==定义jsp的临时变量</h1>
  	 <br>
  	 <c:set value="媳妇好好学习天天向上" var="name" scope="page"></c:set>
  	 <br>
  	 <br>
  	 request.setAttribute("name","媳妇好好学习天天向上")
  	 <br>
  	 session.setAttribute("name","媳妇好好学习天天向上")
  	 <br>
  	 <c:out value="${name}"></c:out>
	<br>  	 
  	 <c:set var="name" value="zwy同学1" scope="page"></c:set>
  	 <c:set var="name" value="zwy同学2" scope="request"></c:set>
  	 <c:set var="name" value="zwy同学3" scope="session"></c:set>
  	 <c:set var="name" value="zwy同学4" scope="application"></c:set>
  	 <p>pageContext  pageScope</p>
  	 <p>reuqest      requestScope</p>
  	 <p>session      sessionScope</p>
  	 <p>application  appliationScope</p>
  	 <br>
  	 <p>${pageScope.name}</p>
  	 <p>${requestScope.name}</p>
  	 <p>${sessionScope.name}</p>
  	 <p>${applicationScope.name}</p>
 	 <c:remove var="name" scope="application"/>
  	 <p><c:out value="${pageScope.name}"></c:out></p>
 	 <p><c:out value="${requestScope.name}"></c:out></p>
 	 <p><c:out value="${sessionScope.name}"></c:out></p>
 	 <p><c:out value="${applicationScope.name}"></c:out></p>
 	 
 	  总结：在实际开发过程中：我们一般都不在使用这些set setAttribute out getAttribute remove removeAttribute标签的形式。就使用el就行了${pageScope/requestScope/sessionScope/applicationScope}
  </body>
</html>
