package com.bit2015.testserver2.vo;

public class GroupVo {
	private Long groupNo;
	private String groupName;
	private String groupType;
	
	public Long getGroupNo() {		return groupNo;	}
	public String getGroupName() {		return groupName;	}
	public String getGroupType() {		return groupType;	}
	public void setGroupNo(Long groupNo) {		this.groupNo = groupNo;	}
	public void setGroupName(String groupName) {		this.groupName = groupName;	}
	public void setGroupType(String groupType) {		this.groupType = groupType;	}

	@Override
	public String toString() {
		return "GroupVo [groupNo=" + groupNo + ", groupName=" + groupName
				+ ", groupType=" + groupType + "]";
	}
	
	

}
