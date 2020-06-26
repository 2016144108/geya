package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class ScienceInfo {
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
	private String uname;
	private String tname;
	private int status;
	public ScienceInfo() {
	}
	public ScienceInfo(int sid, int uid, int tid, int mid, String sname, String spic, int snum, String stime,
			String smajor, String sintro, String stelephone, int sque, String uname, String tname, int status) {
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
		this.uname = uname;
		this.tname = tname;
		this.status = status;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ScienceInfo [sid=" + sid + ", uid=" + uid + ", tid=" + tid + ", mid=" + mid + ", sname=" + sname
				+ ", spic=" + spic + ", snum=" + snum + ", stime=" + stime + ", smajor=" + smajor + ", sintro=" + sintro
				+ ", stelephone=" + stelephone + ", sque=" + sque + ", uname=" + uname + ", tname=" + tname
				+ ", status=" + status + "]";
	}
}
