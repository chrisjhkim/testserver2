package com.bit2015.testserver2.vo;

public class QnaQVo {
	private Long qnaQNo;
	
	private Long toWhoNo;
	private Long fromUserNo;
	
	private String qMessage;
	
	private String createdDate;
	private Long classNo;
	
	private String qType;
	private String qRef;
	
	
	public Long getQnaQNo() {		return qnaQNo;	}
	public Long getToWhoNo() {		return toWhoNo;	}
	public Long getFromUserNo() {		return fromUserNo;	}
	public String getqMessage() {		return qMessage;	}
	public String getCreatedDate() {		return createdDate;}
	public Long getClassNo() {		return classNo;	}
	public String getqType() {		return qType;	}
	public String getqRef() {		return qRef;	}

	public void setQnaQNo(Long qnaQNo) {
		this.qnaQNo = qnaQNo;
	}
	public void setToWhoNo(Long toWhoNo) {
		this.toWhoNo = toWhoNo;
	}
	public void setFromUserNo(Long fromUserNo) {
		this.fromUserNo = fromUserNo;
	}
	public void setqMessage(String qMessage) {
		this.qMessage = qMessage;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public void setClassNo(Long classNo) {
		this.classNo = classNo;
	}
	public void setqType(String qType) {
		this.qType = qType;
	}
	public void setqRef(String qRef) {
		this.qRef = qRef;
	}
	@Override
	public String toString() {
		return "QnaQVo [qnaQNo=" + qnaQNo + ", toWhoNo=" + toWhoNo
				+ ", fromUserNo=" + fromUserNo + ", qMessage=" + qMessage
				+ ", createdDate=" + createdDate + ", classNo=" + classNo
				+ ", qType=" + qType + ", qRef=" + qRef + "]";
	}
	
}
