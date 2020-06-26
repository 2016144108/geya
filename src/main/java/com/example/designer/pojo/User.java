package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
	private int uid;
	private int tid;
	private String userid;
	private String uname;
	private String upassword;
	private String utelephone;
	private String uqq;
	private String ubirthday;
	private String uschool;
	private String ustudy;
	private String ugrade;
	private String upic;
	private String uma;
	public User() {
	}
	public User(int uid, int tid, String userid, String uname, String upassword, String utelephone, String uqq,
			String ubirthday, String uschool, String ustudy, String ugrade, String upic, String uma) {
		this.uid = uid;
		this.tid = tid;
		this.userid = userid;
		this.uname = uname;
		this.upassword = upassword;
		this.utelephone = utelephone;
		this.uqq = uqq;
		this.ubirthday = ubirthday;
		this.uschool = uschool;
		this.ustudy = ustudy;
		this.ugrade = ugrade;
		this.upic = upic;
		this.uma = uma;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUtelephone() {
		return utelephone;
	}
	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}
	public String getUqq() {
		return uqq;
	}
	public void setUqq(String uqq) {
		this.uqq = uqq;
	}
	public String getUbirthday() {
		return ubirthday;
	}
	public void setUbirthday(String ubirthday) {
		this.ubirthday = ubirthday;
	}
	public String getUschool() {
		return uschool;
	}
	public void setUschool(String uschool) {
		this.uschool = uschool;
	}
	public String getUstudy() {
		return ustudy;
	}
	public void setUstudy(String ustudy) {
		this.ustudy = ustudy;
	}
	public String getUgrade() {
		return ugrade;
	}
	public void setUgrade(String ugrade) {
		this.ugrade = ugrade;
	}
	public String getUpic() {
		return upic;
	}
	public void setUpic(String upic) {
		this.upic = upic;
	}
	public String getUma() {
		return uma;
	}
	public void setUma(String uma) {
		this.uma = uma;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", tid=" + tid + ", userid=" + userid + ", uname=" + uname + ", upassword="
				+ upassword + ", utelephone=" + utelephone + ", uqq=" + uqq + ", ubirthday=" + ubirthday + ", uschool="
				+ uschool + ", ustudy=" + ustudy + ", ugrade=" + ugrade + ", upic=" + upic + ", uma=" + uma + "]";
	}
}
