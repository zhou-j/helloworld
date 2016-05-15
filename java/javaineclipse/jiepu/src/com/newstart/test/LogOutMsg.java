package com.newstart.test;


public class LogOutMsg extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String userName ;
	
	@Override
	public String toString() {
		return "LogOutMsg [userName=" + userName + ", ipAddress=" + ipAddress
				+ ", clientId=" + clientId + ", password=" + password
				+ ", msgType=" + msgType + "]";
	}


	public String ipAddress ;
	
	public String clientId ;
	
	public String password ;
	
	
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LogOutMsg (){
		
		msgType = Constants.LOG_OUT_MSG ;
		
	}
	
}
