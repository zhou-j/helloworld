package com.blog.bean;

import java.util.Date;


/**
 * 
 * 类名: User
 * 描述: 用户表。
 * 创建人: zhoujuan
 * 时间: 2016年3月2日 下午10:30:41
 * @version: V1.0
 */
public class User implements java.io.Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
    //注解
	private Integer id;
    //用户名
	private String username;
    //密码
	private String password;
    //头像
	private String headerpic;
    //创建时间
	private Date createtime;
    //更新时间
	private Date updatetime;
    //发布状态0未发布,1发布。
	private Integer status;
    //删除状态0未删除,1删除。
	private Integer isDelete;
	
    public User(){
    	
    }
    
    public User(Integer id){
        this.id = id;
    }
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getHeaderpic() {
		return headerpic;
	}
	public void setHeaderpic(String headerpic) {
		this.headerpic = headerpic;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
