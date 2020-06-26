package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class ServiceLink {
	private int seid;
	private int sid;
	private int uid;
	private com.example.designer.pojo.Services service;
	public ServiceLink() {
	}
	public ServiceLink(int seid, int sid, int uid,com.example.designer.pojo.Services service) {
		this.seid = seid;
		this.sid = sid;
		this.uid = uid;
		this.service = service;
	}
	public int getSeid() {
		return seid;
	}
	public void setSeid(int seid) {
		this.seid = seid;
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
	public com.example.designer.pojo.Services getService() {
		return service;
	}
	public void setService(com.example.designer.pojo.Services service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "ServiceLink [seid=" + seid + ", sid=" + sid + ", uid=" + uid + ", service=" + service + "]";
	}
}
