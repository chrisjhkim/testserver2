package com.bit2015.testserver2.vo;

public class BoardVo {
	private Long boardNo;
	private Long groupNo;
	private String boardName;
	private String type;
	private String type2;

	public Long getBoardNo() {		return boardNo;	}
	public Long getGroupNo() {		return groupNo;	}
	public String getBoardName() {		return boardName;	}
	public String getType() {		return type;	}
	public String getType2() {		return type2;	}
	public void setBoardNo(Long boardNo) {		this.boardNo = boardNo;	}
	public void setGroupNo(Long groupNo) {		this.groupNo = groupNo;	}
	public void setBoardName(String boardName) {		this.boardName = boardName;	}
	public void setType(String type) {		this.type = type;	}
	public void setType2(String type2) {		this.type2 = type2;	}
	
	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", groupNo=" + groupNo
				+ ", boardName=" + boardName + ", type=" + type + ", type2="
				+ type2 + "]";
	}
	
	
	

}
