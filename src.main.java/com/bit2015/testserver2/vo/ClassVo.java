package com.bit2015.testserver2.vo;

import org.springframework.web.bind.annotation.RequestParam;

public class ClassVo {
	private Long classNo;
	private Long groupNo;
	private String className;
	private String classStartTime;
	private String classEndTime;
	private String classType;
	private String classCoordinate;
	private Double latitude;
	private Double longitude;
	private String lesson;
	private String classPlace;

	
	
	
	
	
	public Double getLatitude() {
		return latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getLesson() {
		return lesson;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	public Long getClassNo() {		return classNo;	}
	public Long getGroupNo() {		return groupNo;	}
	public String getClassName() {		return className;	}
	public String getClassStartTime() {		return classStartTime;	}
	public String getClassEndTime() {		return classEndTime;	}
	public String getClassType() {		return classType;	}
	public String getClassCoordinate() {		return classCoordinate;	}
	public String getClassPlace() {		return classPlace;	}
	public void setClassNo(Long classNo) {		this.classNo = classNo;	}
	public void setGroupNo(Long groupNo) {		this.groupNo = groupNo;	}
	public void setClassName(String className) {		this.className = className;	}
	public void setClassStartTime(String classStartTime) {		this.classStartTime = classStartTime;	}
	public void setClassEndTime(String classEndTime) {		this.classEndTime = classEndTime;	}
	public void setClassType(String classType) {		this.classType = classType;	}
	public void setClassCoordinate(String classCoordinate) {		this.classCoordinate = classCoordinate;	}
	public void setClassPlace(String classPlace) {		this.classPlace = classPlace;	}
	@Override
	public String toString() {
		return "ClassVo [classNo=" + classNo + ", groupNo=" + groupNo
				+ ", className=" + className + ", classStartTime="
				+ classStartTime + ", classEndTime=" + classEndTime
				+ ", classType=" + classType + ", classCoordinate="
				+ classCoordinate + ", latitude=" + latitude + ", longitude="
				+ longitude + ", lesson=" + lesson + ", classPlace="
				+ classPlace + "]";
	}
	
	

}
