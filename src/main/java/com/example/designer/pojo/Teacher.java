package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
	private int tid;
	private int mid;
	private String tname;
	private String tschool;
	private String tstatus;
	private String tmajor;
	private String tpic;
	private String tintro;
	private String ttelephone;
	public Teacher() {
	}
	public Teacher(int tid, int mid, String tname, String tschool, String tstatus, String tmajor, String tpic,
			String tintro, String ttelephone) {
		this.tid = tid;
		this.mid = mid;
		this.tname = tname;
		this.tschool = tschool;
		this.tstatus = tstatus;
		this.tmajor = tmajor;
		this.tpic = tpic;
		this.tintro = tintro;
		this.ttelephone = ttelephone;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTschool() {
		return tschool;
	}
	public void setTschool(String tschool) {
		this.tschool = tschool;
	}
	public String getTstatus() {
		return tstatus;
	}
	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}
	public String getTmajor() {
		return tmajor;
	}
	public void setTmajor(String tmajor) {
		this.tmajor = tmajor;
	}
	public String getTpic() {
		return tpic;
	}
	public void setTpic(String tpic) {
		this.tpic = tpic;
	}
	public String getTintro() {
		return tintro;
	}
	public void setTintro(String tintro) {
		this.tintro = tintro;
	}
	public String getTtelephone() {
		return ttelephone;
	}
	public void setTtelephone(String ttelephone) {
		this.ttelephone = ttelephone;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", mid=" + mid + ", tname=" + tname + ", tschool=" + tschool + ", tstatus="
				+ tstatus + ", tmajor=" + tmajor + ", tpic=" + tpic + ", tintro=" + tintro + ", ttelephone="
				+ ttelephone + "]";
	}
}