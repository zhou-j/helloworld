package com.newstart.test;


public class UserInfo {

	private String userName ;
	
	private String clientID ;
	
	private long loginTime ;
	
	private long logoutTime ;
	
	private String ipAdd ;
	
	

	public UserInfo(String userName, String clientID, long loginTime,
			long logoutTime, String ipAdd) {
		
		super();
		this.userName = userName;
		this.clientID = clientID;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
		this.ipAdd = ipAdd;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	public long getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(long logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getIpAdd() {
		return ipAdd;
	}

	public void setIpAdd(String ipAdd) {
		this.ipAdd = ipAdd;
	}
	
	
}
