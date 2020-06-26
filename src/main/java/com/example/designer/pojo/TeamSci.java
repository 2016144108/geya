package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class TeamSci {
	private int tid;
	private int mid;
	private int uid;
	private String tname;
	private String tmajor;
	private int tnum;
	private String tintro;
	private String tdate;
	private String tschool;
	private String tpic;
	public TeamSci() {
	}
	public TeamSci(int tid, int mid, int uid, String tname, String tmajor, int tnum, String tintro, String tdate,
			String tschool, String tpic) {
		this.tid = tid;
		this.mid = mid;
		this.uid = uid;
		this.tname = tname;
		this.tmajor = tmajor;
		this.tnum = tnum;
		this.tintro = tintro;
		this.tdate = tdate;
		this.tschool = tschool;
		this.tpic = tpic;
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTmajor() {
		return tmajor;
	}
	public void setTmajor(String tmajor) {
		this.tmajor = tmajor;
	}
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public String getTintro() {
		return tintro;
	}
	public void setTintro(String tintro) {
		this.tintro = tintro;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getTschool() {
		return tschool;
	}
	public void setTschool(String tschool) {
		this.tschool = tschool;
	}
	public String getTpic() {
		return tpic;
	}
	public void setTpic(String tpic) {
		this.tpic = tpic;
	}
	@Override
	public String toString() {
		return "TeamSci [tid=" + tid + ", mid=" + mid + ", uid=" + uid + ", tname=" + tname + ", tmajor=" + tmajor
				+ ", tnum=" + tnum + ", tintro=" + tintro + ", tdate=" + tdate + ", tschool=" + tschool + ", tpic="
				+ tpic + "]";
	}
}
