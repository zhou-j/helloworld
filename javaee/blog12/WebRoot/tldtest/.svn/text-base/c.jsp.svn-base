<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>   
    <title>My JSP 'c.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>  
  <body>
     
  <%-- 
    jstl:
    c标签:<c:out><c:if><c:choose><c:when><c:forEach><c:foreToken><c:remove>
    <c:import url=""></c:import>
    fml标签
    fn标签
    sql:标签,如果快速的去做一个网站，或者静态化的时候可以用它。
    
    C:impor jsp:include两者在进行页面包含的时候，一定要注意啦；他们并不是真正页面的一部分
            在执行动态数据填充的时候，是不能够共享页面的标签。一定要在包括的页面重新导入标签
            指令include就是页面的一部分。就不需要再次重新写入标签了。
            从作用域pageContext就可以证明这点。
   --%>
   
   <%
      List<String> strings = new ArrayList<String>();
      strings.add("1111111");
      strings.add("2222222");
      strings.add("3333333");
      request.setAttribute("strings",strings);
      String username = "会计分录放大了快";
      pageContext.setAttribute("username",username);
   %>
   
   <!-- c标签 -->
   
   <c:import url="header.jsp"></c:import>
   
   <jsp:include page="header.jsp"></jsp:include>
   
   <!-- 这个包含的内容才是真的页面的一部分 --> 
   <!--在实际开发过程中只推荐使用：指令的include,不要给自己带来不必要的麻烦。 -->
   <%@include file="header.jsp"%>
   <hr>
   <h2>c:out标签</h2>
   <c:out value="1+1"></c:out>===out.print("1+1");===<%=("1+1") %>===${"1+1"}
   <c:out value="${1+1}"></c:out>===${1+1}===<%=(1+1) %>
      
   ${username}===<c:out value="${username}"></c:out>
   <b>${username}</b>
   <c:out value="<b>${username}</b>" escapeXml="false"></c:out>
   <hr>
   <h2>c:set标签==定义的jsp的临时变量</h2>
   <hr>
   <c:set value="好好学习，天天向上" var="name" scope="page"></c:set>
   <hr>
   jsp:include
   c:import
   request.setAttribute("name","媳妇好好学习天天向上");
   <hr>
   pageContext.setAttribute("name","媳妇好好学习天天向上");
   <hr>   
   session.setAttribute("name","媳妇好好学习天天向上");
   <hr>
   <c:out value="${name}"></c:out>
   <hr>
   
   <c:set var="name" value="zwy同学1" scope="page"></c:set>
   <c:set var="name" value="zwy同学2" scope="request"></c:set>
   <c:set var="name" value="zwy同学3" scope="session"></c:set>
   <c:set var="name" value="zwy同学4" scope="application"></c:set>
   <p>pageContext  pageScope</p>
   <p>request requestScope</p>
   <p>session  sessionScope</p>
   <p>application  applicationScope</p>
   <br>
   <p>${name}</p>
   <p>${pageScope.name}</p>
   <p>${requestScope.name}</p>
   <p>${sessionScope.name}</p>
   <p>${applicationScope.name}</p>
   <c:remove var="name" scope="application" />
   <p><c:out value="${pageScope.name}"></c:out></p>
   <p><c:out value="${requestScope.name}"></c:out></p>
   <p><c:out value="${sessionScope.name}"></c:out></p>
   <p><c:out value="${applicationScope.name}"></c:out></p>
  </body>
</html>

