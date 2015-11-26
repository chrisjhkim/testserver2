package com.bit2015.testserver2.vo;

public class AttendanceVo {
	private Long userNo;
	private Long classNo;
	private String attdStatus;
	private String attdDescription;

	public Long getUserNo() {		return userNo;	}
	public Long getClassNo() {		return classNo;	}
	public String getAttdStatus() {		return attdStatus;	}
	public String getAttdDescription() {		return attdDescription;	}

	public void setUserNo(Long userNo) {		this.userNo = userNo;	}
	public void setClassNo(Long classNo) {		this.classNo = classNo;	}
	public void setAttdStatus(String attdStatus) {		this.attdStatus = attdStatus;	}
	public void setAttdDescription(String attdDescription) {		this.attdDescription = attdDescription;	}

	@Override
	public String toString() {
		return "AttendanceVo [userNo=" + userNo + ", classNo=" + classNo
				+ ", attdStatus=" + attdStatus + ", attdDescription="
				+ attdDescription + "]";
	}


}
