package com.blog.bean;

import java.util.Date;

/**
 * 
 * 类名: Content
 * 描述: 内容表
 * 创建人: zhoujuan
 * 时间: 2016年3月2日 下午10:12:27
 * @version: V1.0
 */
public class Content implements java.io.Serializable{
    /**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	//注解id
	private Integer id;
	//标题
	private String title;
	//内容
	private String content;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//发布状态1发布,0未发布。
	private Integer status;
	//删除状态1删除,0未删除。
	private Integer isDelete;
    //发布人
	private Integer userId;
	
	private String tags;

	//提供一个无参的构造方法
	public Content(){
		
	}
	//和提供一个带有主键的构造方法
	public Content(Integer id){
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}	
	
}
