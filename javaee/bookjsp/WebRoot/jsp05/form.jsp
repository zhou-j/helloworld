<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
     <%
         //获取表单元素的值
         //form:text password radio checkbox select textarea
         //submit reset button
     %>
    <!-- 获取焦点，让用户减少一次鼠标的输入 -->
    <!-- 添加文本框输入的提示信息 -->
    <!-- 给radio标签和checkbox标签添加label标签，增加用户体验 -->
    <fieldset>
      <legend>form表单常见的问题和解决方案</legend>
      <form id="registerForm" action="data.jsp" method="post">
         <!--  <p>用户:<input type="text" autofocus="autofocus" maxlength="9" value="请输入用户名...." name="username"></p> -->
          <p>用户:<input type="text" autofocus="autofocus" maxlength="9" name="username" placeholder="请输入用户名....."></p>
          <p>密码:<input type="password" name="password" maxlength="9" placeholder="请输入密码....."></p>
          <p>年龄:<select name="age">
                    <option>1</option>
                    <option>12</option>
                    <option>13</option>
                    <option>31</option>
                    <option>21</option>
                 </select>
           <p>性别:<label><input type="radio" name="male" value="1">男</label>&nbsp;&nbsp;
                  <label><input type="radio" name="male" value="0">女</label></p>
           <p>兴趣:<label><input type="checkbox" name="hobbys" value="看书">看书</label>&nbsp;&nbsp;
                  <label><input type="checkbox" name="hobbys" value="看电影">看电影</label>&nbsp;&nbsp;
                  <label><input type="checkbox" name="hobbys" value="游泳">游泳</label></p>
           <p>描述:<textarea style="width:230px;height:100px;" name="description";placeholder="请输入用户描述"></textarea></p>
           <p><input type="submit" value="保存"></p>
      </form>     
    </fieldset>
    <script type="text/javascript">
         //一定要选中第一个文本框输入。
    </script>
  </body>
</html>
