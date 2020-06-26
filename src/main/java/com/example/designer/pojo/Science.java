package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class Science {
	private int sid;
	private int uid;
	private int tid;
	private int mid;
	private String sname;
	private String spic;
	private int snum;
	private String stime;
	private String smajor;
	private String sintro;
	private String stelephone;
	private int sque;
	private int status;
	private com.example.designer.pojo.TeamSci team;
	public Science() {
	}
	public Science(int sid, int uid, int tid, int mid, String sname, String spic, int snum, String stime, String smajor,
			String sintro, String stelephone, int sque, int status, com.example.designer.pojo.TeamSci team) {
		this.sid = sid;
		this.uid = uid;
		this.tid = tid;
		this.mid = mid;
		this.sname = sname;
		this.spic = spic;
		this.snum = snum;
		this.stime = stime;
		this.smajor = smajor;
		this.sintro = sintro;
		this.stelephone = stelephone;
		this.sque = sque;
		this.status = status;
		this.team = team;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	public String getSintro() {
		return sintro;
	}
	public void setSintro(String sintro) {
		this.sintro = sintro;
	}
	public String getStelephone() {
		return stelephone;
	}
	public void setStelephone(String stelephone) {
		this.stelephone = stelephone;
	}
	public int getSque() {
		return sque;
	}
	public void setSque(int sque) {
		this.sque = sque;
	}
	public com.example.designer.pojo.TeamSci getTeam() {
		return team;
	}
	public void setTeam(com.example.designer.pojo.TeamSci team) {
		this.team = team;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Science [sid=" + sid + ", uid=" + uid + ", tid=" + tid + ", mid=" + mid + ", sname=" + sname + ", spic="
				+ spic + ", snum=" + snum + ", stime=" + stime + ", smajor=" + smajor + ", sintro=" + sintro
				+ ", stelephone=" + stelephone + ", sque=" + sque + ", status=" + status + ", team=" + team + "]";
	}
}
