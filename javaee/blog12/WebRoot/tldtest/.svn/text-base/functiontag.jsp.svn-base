<%@ page language="java" import="java.util.*,com.blog.bean.Content,com.blog.dao.ContentDao" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/tz.tld" prefix="tz" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title></title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	    body{font-family:"微软雅黑";font-size:18px}
	    fieldset{padding:30px;margin:0 auto;width:640px;}
	    #box p{margin-left:25px;color:red;font-weight:700;border-bottom:1px solid #ccc;}
	</style>
	</head>
  <body>
      <fieldset>
         <legend>自定义标签---函数自定义标签-fn</legend>
         <div id="box">
           <h2> 知识点步骤:</h2>
           <p>1:定义一个普通的类:TmFunctions</p>                    
           <p>2:在类中定义一个静态方法即可</p>                    
           <p>3:注册在tld文件中<br>
           <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;什么是一个tld:jsp一个配置自定义标签和函数标签的一个xml文件.</p>
           <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;自定义标签的tld文件一定要存放在WEB-INF或者META-INF</p>                    
           <p>4:在页面中通过taglib引入tld文件</p>                    
           <p>5:通过el表达式处理业务</p>                    
         </div>
         <div>1:大写转小写</div>
          aaabbcc---${tz:toUpper("aaabbcc")};
         <div>2:日期格式化</div>
         <div>3:性别判断</div>
         <div>4:空判断</div>
         <div>5:数字转中文</div>
          1101---${tz:numberToString(1011)}
         <div>6:时间转字符串</div>
          2016-3-4 20:11:10=====${tz:dateString("2016-3-4 20:11:10")}
          <p>
                                   自定义标签:TagSupport,<br>
                                    实现:业务自定义标签,ContentTag<br>
                                    描述：查询内容表中的数据，根据查询条件可以过滤<br>
            1:定义ContentTag的类,继承TagSupport<br>                                
            2:覆盖TagSupport中的方法doStartTag()doAttrBody()release()<br>
            3:在tld文件中注册定义的标签<br>
            4:在页面中引入tld文件<br>
            5:调用<br>
            <% 
              List<Content> contents = ContentDao.findContent(0,30,"desc");
              pageContext.setAttribute("contents", contents);
            %>
            <tz:contentTag var="content" begain="0" end="30" sort="1">
             <p>${content_index+1}=======${content.title}</p>
            </tz:contentTag>
           <p>                       
                                    自定义标签：TagSupport<br>
                                    实现：业务自定义标签,tz:loop<br>
                                    描述：查询内容表中的数据，根据查询条件可以过滤<br>
           </p>                                    
<%--         <tz:loop var="content" items="${作用域中的key }"--%>
<%--         </tz:loop> --%>
          </p>
      </fieldset>
  </body>
</html>
