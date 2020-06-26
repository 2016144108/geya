package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class Question {
	private int qid;
	private int uid;
	private int sid;
	private String qname;
	private String qtime;
	private int qgood;
	private int qbad;
	private int qcommon;
	private String qcontent;
	private int qstatus;
	private User user;
	public Question() {
	}
	public Question(int qid, int uid, int sid, String qname, String qtime, int qgood, int qbad, int qcommon,
			String qcontent, int qstatus, User user) {
		this.qid = qid;
		this.uid = uid;
		this.sid = sid;
		this.qname = qname;
		this.qtime = qtime;
		this.qgood = qgood;
		this.qbad = qbad;
		this.qcommon = qcommon;
		this.qcontent = qcontent;
		this.qstatus = qstatus;
		this.user = user;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public String getQtime() {
		return qtime;
	}
	public void setQtime(String qtime) {
		this.qtime = qtime;
	}
	public int getQgood() {
		return qgood;
	}
	public void setQgood(int qgood) {
		this.qgood = qgood;
	}
	public int getQbad() {
		return qbad;
	}
	public void setQbad(int qbad) {
		this.qbad = qbad;
	}
	public int getQcommon() {
		return qcommon;
	}
	public void setQcommon(int qcommon) {
		this.qcommon = qcommon;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getQstatus() {
		return qstatus;
	}
	public void setQstatus(int qstatus) {
		this.qstatus = qstatus;
	}
	@Override
	public String toString() {
		return "Question [qid=" + qid + ", uid=" + uid + ", sid=" + sid + ", qname=" + qname + ", qtime=" + qtime
				+ ", qgood=" + qgood + ", qbad=" + qbad + ", qcommon=" + qcommon + ", qcontent=" + qcontent
				+ ", qstatus=" + qstatus + ", user=" + user + "]";
	}
}
