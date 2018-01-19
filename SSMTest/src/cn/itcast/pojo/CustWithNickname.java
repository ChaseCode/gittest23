package cn.itcast.pojo;

/**
 * @CarlosYYG
 * 一对一关联查询 使用增强类的方式 
 * 
 */
public class CustWithNickname extends Cust{

	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
