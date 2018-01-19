package cn.itcast.pojo;

public class Cust {

	/**
	 * @CarlosYYG
	 * 数据库中s_cust相对应的实体类
	 * 
	 * 
	 */
	
	private int cid;
	
	private String custName;
	
	private String custType;
	
	private String custPhone;
	
	private String custAddress;
	
	private int custLinkUser;
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public int getCustLinkUser() {
		return custLinkUser;
	}

	public void setCustLinkUser(int custLinkUser) {
		this.custLinkUser = custLinkUser;
	}
	
}
