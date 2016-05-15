package com.newstart.bean;
public class CountMessageBean implements java.io.Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
	private String username;
	private String userterminator;
	private String uplinetime;
	private String downlinetime;
	private String ipaddress;
    
	public CountMessageBean(){
		
	}
	
	public CountMessageBean(Integer id){
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
	
	public String getUserterminator() {
		return userterminator;
	}

	public void setUserterminator(String userterminator) {
		this.userterminator = userterminator;
	}

	public String getUplinetime() {
		return uplinetime;
	}

	public void setUplinetime(String uplinetime) {
		this.uplinetime = uplinetime;
	}

	public String getDownlinetime() {
		return downlinetime;
	}

	public void setDownlinetime(String downlinetime) {
		this.downlinetime = downlinetime;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}


}