package com.omaropendata.entity;

public class Student {
	
	private int stdid;
	private String name;
	private String fName;
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", name=" + name + ", fName=" + fName + "]";
	}
	
	
	

}
