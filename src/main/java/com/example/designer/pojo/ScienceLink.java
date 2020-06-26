package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class ScienceLink {
	private int scid;
	private int sid;
	private int uid;
	private Science science;
	public ScienceLink() {
	}
	public ScienceLink(int scid, int sid, int uid, Science science) {
		this.scid = scid;
		this.sid = sid;
		this.uid = uid;
		this.science = science;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
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
	public Science getScience() {
		return science;
	}
	public void setScience(Science science) {
		this.science = science;
	}
	@Override
	public String toString() {
		return "ScienceLink [scid=" + scid + ", sid=" + sid + ", uid=" + uid + ", science=" + science + "]";
	}
}
