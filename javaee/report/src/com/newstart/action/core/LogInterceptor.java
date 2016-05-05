package com.newstart.action.core;

import org.apache.struts2.ServletActionContext;

import com.newstart.util.StringUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * 类名: LogInterceptor
 * 描述: 日记统计。
 * 创建人: zhoujuan
 * 时间: 2016年4月11日 下午1:55:43
 * @version: V1.0
 */
public class LogInterceptor extends AbstractInterceptor{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
    
	//接口里面全部都是抽象方法
	//抽象类：有抽象方法，也有普通方法。
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//这里的业务执行完毕之后放行。
		String username = (String) ServletActionContext.getRequest().getSession().getAttribute("tmuser");
		if(!username.equals("newstart")){
			return "index";//这个返回值为result的name可以是全局的，也可为以是局部的。
		}
		return invocation.invoke();//放行继续执行下面的Action.
	}

}
