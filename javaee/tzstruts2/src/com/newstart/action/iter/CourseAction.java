package com.newstart.action.iter;

import org.apache.struts2.ServletActionContext;

/**
 * 
 * 类名: CourseAction
 * 描述: 课程类。
 * 创建人: zhoujuan
 * 时间: 2016年4月10日 下午9:18:27
 * @version: V1.0
 */
public class CourseAction {
    /**
     * 
     * 方法名: save
     * 描述: 保存
     * 创建人: zhoujuan
     * 时间: 2016年4月10日 下午9:19:37
     * @return
     * @return: String
     * @since: V1.0
     */
	private String username;
	private String password;
	
	public String save(){
		return "success";
	}
	
	/**
	 * 
	 * 方法名: save
	 * 描述: 修改
	 * 创建人: zhoujuan
	 * 时间: 2016年4月10日 下午9:19:37
	 * @return
	 * @return: String
	 * @since: V1.0
	 */
	public String update(){
		return "success";
	}
	/**
	 * 
	 * 方法名: save
	 * 描述: 删除
	 * 创建人: zhoujuan
	 * 时间: 2016年4月10日 下午9:19:37
	 * @return
	 * @return: String
	 * @since: V1.0
	 */
	public String delete(){
		return "success";
	}
	/**
	 * 
	 * 方法名: save
	 * 描述: 查询
	 * 创建人: zhoujuan
	 * 时间: 2016年4月10日 下午9:19:37
	 * @return
	 * @return: String
	 * @since: V1.0
	 */
	public String select(){
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
