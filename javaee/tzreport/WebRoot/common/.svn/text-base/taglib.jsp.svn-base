<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tld/tz.tld" prefix="tz"%>
<script type="text/javascript">var basePath="${basePath}";</script>
<%
	//拼接项目请求的根目录,解决URL多级资源文件找不到路径的问题
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	request.setAttribute("basePath", basePath);
%>