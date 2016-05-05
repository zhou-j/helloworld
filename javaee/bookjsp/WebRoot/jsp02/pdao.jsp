<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@ page language="java" import="java.util.*,com.newstart.dao.ConnectionUtil" pageEncoding="UTF-8"%>
<% 
     //根据省份Id查询省份城市
     //out.print("success");
     String pid = request.getParameter("provinceId");
     if(pid!=null && !pid.equals("")){//?//如果不判断这行代码：出现空指针异常。
	     int provinceId = Integer.parseInt(pid);//不是数字NumberFormatException
         System.out.println(provinceId);
	     List<HashMap<String,Object>> citys = ConnectionUtil.findCitys(provinceId); 
	     //JSONUtil.serialize(citys)将集合对象转换成json格式---List---JsonArr字符串[{},{}]
	     //如果你单个对象--json字符串{}
	     out.print(JSONUtil.serialize(citys));
     }else{    	 
    	 //查询失败
    	 out.print("fail");
     } 
     //如果在项目中加了方法，加了属性，加了类，或者添加了jar包，就要重新部署和启动容器。
%>