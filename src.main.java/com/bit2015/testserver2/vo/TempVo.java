package com.bit2015.testserver2.vo;



public class TempVo {
	private String name;
	private String id;
	private String password;
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "TempVo [name=" + name + ", id=" + id + ", password=" + password
				+ "]";
	}
	
	

}
