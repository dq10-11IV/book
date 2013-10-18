package com.turtledove.bookdrift.domain.entity;

import com.turtledove.bookdrift.common.AbstractClass.AbstractDomainObject;

public class User extends AbstractDomainObject{

	private String userName;
	private String userEmail;
	private String userPwd;
	private int userLevel;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	
}
