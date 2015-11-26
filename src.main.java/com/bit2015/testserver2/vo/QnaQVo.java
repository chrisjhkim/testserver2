package com.bit2015.testserver2.vo;

public class QnaQVo {
	private Long qnaQNo;
	private Long toClassNo;
	private Long fromUserNo;
	private String questionType;
	private String question;
	private String createdDate;

	public Long getQnaQNo() {		return qnaQNo;	}
	public Long getFromUserNo() {		return fromUserNo;	}
	public Long getToClassNo() {		return toClassNo;	}
	public String getQuestionType() {		return questionType;	}
	public String getQuestion() {		return question;	}	
	public String getCreatedDate() {		return createdDate;	}
	
	
	public void setQnaQNo(Long qnaQNo) {		this.qnaQNo = qnaQNo;	}
	public void setFromUserNo(Long fromUserNo) {		this.fromUserNo = fromUserNo;	}
	public void setToClassNo(Long toClassNo) {		this.toClassNo = toClassNo;	}
	public void setQuestionType(String questionType) {		this.questionType = questionType;	}
	public void setQuestion(String question) {		this.question = question;	}
	public void setCreatedDate(String createdDate) {		this.createdDate = createdDate;	}
	
	@Override
	public String toString() {
		return "QnaQVo [qnaQNo=" + qnaQNo + ", toClassNo=" + toClassNo
				+ ", fromUserNo=" + fromUserNo + ", questionType="
				+ questionType + ", question=" + question + ", createdDate="
				+ createdDate + "]";
	}
	

	
	
}
