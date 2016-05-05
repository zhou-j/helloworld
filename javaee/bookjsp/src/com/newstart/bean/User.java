package com.newstart.bean;

/**
 * 
 * 类名: User
 * 描述: user javaBean
 * 创建人: zhoujuan
 * 时间: 2016年2月29日 上午10:48:25
 * @version: V1.0
 */
public class User {
      private String username;
      private String password;
      private String userName;
      private Boolean isFlag;
      public String getUsername() {
		return username;
	}
	//快捷键ctrl+shift+s
    //这个一定要有
    public User(){
    	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Boolean getIsFlag() {
		return isFlag;
	}
	public void setIsFlag(Boolean isFlag) {
		this.isFlag = isFlag;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	private Integer age;
    
	public static void main(String[] args) {
	      
    }
}
