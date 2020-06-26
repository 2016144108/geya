package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class School {
	private int sid;
	private String sname;
	private String spic;
	private String surl;
	public School() {
	}
	public School(int sid, String sname, String spic, String surl) {
		this.sid = sid;
		this.sname = sname;
		this.spic = spic;
		this.surl = surl;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpic() {
		return spic;
	}
	public void setSpic(String spic) {
		this.spic = spic;
	}
	public String getSurl() {
		return surl;
	}
	public void setSurl(String surl) {
		this.surl = surl;
	}
	@Override
	public String toString() {
		return "School [sid=" + sid + ", sname=" + sname + ", spic=" + spic + ", surl=" + surl + "]";
	}
}
