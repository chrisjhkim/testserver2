package com.bit2015.testserver2.vo;

public class QnaAVo {
	private Long qnaQNo;
	private Long userNo;
	private String answer;
	
	public Long getQnaQNo() {		return qnaQNo;	}
	public Long getUserNo() {		return userNo;	}
	public String getAnswer() {		return answer;	}
	
	public void setQnaQNo(Long qnaQNo) {		this.qnaQNo = qnaQNo;	}
	public void setUserNo(Long userNo) {		this.userNo = userNo;	}
	public void setAnswer(String answer) {		this.answer = answer;	}
	
	@Override
	public String toString() {
		return "QnaAVo [qnaQNo=" + qnaQNo + ", userNo=" + userNo + ", answer="
				+ answer + "]";
	}
	
	

}
