package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class Major {
	private int mid;
	private String mname;
	public Major() {
	}
	public Major(int mid, String mname) {
		this.mid = mid;
		this.mname = mname;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Major [mid=" + mid + ", mname=" + mname + "]";
	}
}
