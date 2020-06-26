package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class Comment {
	private int cid;
	private int uid;
	private int qid;
	private String ccontent;
	private String ctime;
	private String cstate;
	private User user;
	public Comment() {
	}
	public Comment(int cid, int uid, int qid, String ccontent, String ctime, String cstate, User user) {
		this.cid = cid;
		this.uid = uid;
		this.qid = qid;
		this.ccontent = ccontent;
		this.ctime = ctime;
		this.cstate = cstate;
		this.user = user;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", uid=" + uid + ", qid=" + qid + ", ccontent=" + ccontent + ", ctime=" + ctime
				+ ", cstate=" + cstate + ", user=" + user + "]";
	}
}
