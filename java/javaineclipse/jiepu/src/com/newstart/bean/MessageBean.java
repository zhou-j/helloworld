package com.newstart.bean;

/**
 * 
 * 类名: MessageBean
 * 描述: 用户信息Bean.
 * 创建人: zhoujuan
 * 时间: 2016年5月14日 下午3:10:58
 * @version: V1.0
 */
public class MessageBean implements java.io.Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
   
    private Integer id;
	private String username;
	private String userterminator;
	private String tag;
	private String time;
	private String ipaddress;
    
	public MessageBean(){
		
	}
	
	public MessageBean(Integer id){
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

	public String getUserterminator() {
		return userterminator;
	}

	public void setUserterminator(String userterminator) {
		this.userterminator = userterminator;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	
	
}
