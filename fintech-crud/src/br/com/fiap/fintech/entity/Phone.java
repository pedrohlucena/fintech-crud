package br.com.fiap.fintech.entity;

public class Phone {
	private int phoneCode;
	private int userCode;
	private int phoneNumber;
	private int DDI;
	private int DDD;
	private String type;
	public Phone(int phoneCode, int userCode, int phoneNumber, int DDI, int DDD, String type) {
		super();
		this.phoneCode = phoneCode;
		this.userCode = userCode;
		this.phoneNumber = phoneNumber;
		this.DDI = DDI;
		this.DDD = DDD;
		this.type = type;
	}
	public Phone(int userCode, int phoneNumber, int dDI, int dDD, String type) {
		super();
		this.userCode = userCode;
		this.phoneNumber = phoneNumber;
		this.DDI = DDI;
		this.DDD = DDD;
		this.type = type;
	}
	public int getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(int phoneCode) {
		this.phoneCode = phoneCode;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getDDI() {
		return DDI;
	}
	public void setDDI(int DDI) {
		this.DDI = DDI;
	}
	public int getDDD() {
		return DDD;
	}
	public void setDDD(int DDD) {
		this.DDD = DDD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
