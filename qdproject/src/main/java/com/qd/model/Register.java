package com.qd.model;


public class Register {
	
	private String userName;
	private String userPass;
	private String userEmail;
	private String userMob;
	
	
	public Register() {
		super();
	}
	
	public Register(String userName, String userPass, String userEmail, String userMob) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userEmail = userEmail;
		this.userMob = userMob;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserMob() {
		return userMob;
	}
	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	
}
