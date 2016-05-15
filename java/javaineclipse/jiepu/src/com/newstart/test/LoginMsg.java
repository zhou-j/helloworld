package com.newstart.test;


import java.io.Serializable;

public class LoginMsg extends Message implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String userName ;
	
	public String ipAddress ;
	
	public String clientId ;
	
	public String password ;
	
	public LoginMsg (){
		
		msgType = Constants.LOG_IN_MSG ;
		
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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
}
