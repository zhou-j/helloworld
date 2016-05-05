package com.blog.bean;

import java.util.Date;

/**
 * 内容表 Content<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2014年11月9日-下午10:28:28 <BR>
 * 
 * @version 1.0.0
 * 
 */
public class Content implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// 注解id
	private Integer id;
	// 标题
	private String title;
	// 内容
	private String content;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 发布状态 1发布 0未发布
	private Integer status;
	// 删除状态 1删除 0未删除
	private Integer isDelete;
	// 发布人
	private Integer userId;
	/*标签*/
	private String tags;

	// 提供一个无参数的构造方法
	public Content() {

	}

	// 和提供一个带有主键的构造方法
	public Content(Integer id) {
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
