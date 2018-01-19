package cn.itcast.pojo;

public class User {
	
	/**
	 * @CarlosYYG
	 * 数据库中s_user相对应的实体类
	 * 
	 * 
	 */
	private int uid;
	
	private String username;
	
	private String nickname;
	
	private String password;
	
	private String phoneCheckCode;
	
	private String checkCode;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneCheckCode() {
		return phoneCheckCode;
	}

	public void setPhoneCheckCode(String phoneCheckCode) {
		this.phoneCheckCode = phoneCheckCode;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	
}
