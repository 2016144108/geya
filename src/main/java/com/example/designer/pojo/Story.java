package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class Story {
	private int sid;
	private int tid;
	private String spic;
	private String sintro;
	private String sname;
	private String stime;
	private String scontent;
	private int sread;
	public Story() {
	}
	public Story(int sid, int tid, String spic, String sintro, String sname, String stime, String scontent, int sread) {
		this.sid = sid;
		this.tid = tid;
		this.spic = spic;
		this.sintro = sintro;
		this.sname = sname;
		this.stime = stime;
		this.scontent = scontent;
		this.sread = sread;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getSpic() {
		return spic;
	}
	public void setSpic(String spic) {
		this.spic = spic;
	}
	public String getSintro() {
		return sintro;
	}
	public void setSintro(String sintro) {
		this.sintro = sintro;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public int getSread() {
		return sread;
	}
	public void setSread(int sread) {
		this.sread = sread;
	}
	@Override
	public String toString() {
		return "Story [sid=" + sid + ", tid=" + tid + ", spic=" + spic + ", sintro=" + sintro + ", sname=" + sname
				+ ", stime=" + stime + ", scontent=" + scontent + ", sread=" + sread + "]";
	}
}
