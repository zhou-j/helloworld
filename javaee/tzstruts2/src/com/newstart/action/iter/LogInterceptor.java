package com.newstart.action.iter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 创建一个拦截器的步骤：
 * 1：定义一个LoginInterceptor 继承AbstractInterceptor
 * 2:在struts-login.xml中配置和注册我们的拦截器
 * 3：引用拦截器
 * 注意点：自定义的拦截器一定要在后面加上默认的拦截器栈，我们需要struts2提供的一系列拦截器，他们会帮我们处理：文件上传，参数注入，国际化，下载等等！
 * 类名: LogInterceptor
 * 描述: 登录拦截，继承AbstractInterceptor:拦截所有的进入action方法之前的一个拦截器
 * 创建人: zhoujuan
 * 时间: 2016年4月10日 下午11:17:23
 * @version: V1.0
 */
public class LogInterceptor extends AbstractInterceptor{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("日志拦截器进来了吗？");
		return invocation.invoke();//如果执行成功，就可以放行，去执行我们对应的Action或许操作。(进入Action方法)
	}
  
}
