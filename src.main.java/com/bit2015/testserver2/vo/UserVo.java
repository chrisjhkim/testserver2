package com.bit2015.testserver2.vo;

public class UserVo {
	private Long userNo;
	private String userId;
	private String userName;
	private String userPassword;
	private String userPhoneId;
	private String userType;
	
//	private String role;
	
	public Long getUserNo() {		return userNo;	}
	public String getUserName() {		return userName;	}
	public String getUserId() {		return userId;	}
	public String getUserPassword() {		return userPassword;	}
	public String getUserPhoneId() {		return userPhoneId;	}
	public String getuserType() {		return userType;	}

	public void setUserNo(Long userNo) {		this.userNo = userNo;	}
	public void setUserName(String userName) {		this.userName = userName;	}
	public void setUserId(String userId) {		this.userId = userId;	}
	public void setUserPassword(String userPassword) {		this.userPassword = userPassword;	}
	public void setUserPhoneId(String userPhoneId) {		this.userPhoneId = userPhoneId;	}
	public void setuserType(String userType) {		this.userType = userType;	}

	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", userId=" + userId
				+ ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userPhoneId=" + userPhoneId + ", userType=" + userType
				+ "]";
	}

	
	

}
