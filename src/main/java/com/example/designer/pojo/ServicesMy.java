package com.example.designer.pojo;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ServicesMy {
	private int sid;
	private int uid;
	private int tid;
	private int mid;
	private String sname;
	private String spic;
	private int snum;
	private String sintro;
	private String smajor;
	private String sstime;
	private String setime;
	private String sctime;
	private int sread;
	private int sservice;
	private int sgood;
	private int sbad;
	private int ssave;
	private int status;
	private String stelephone;
	private String sfile;
	private String sstate;
	private String uname;
	private String tname;
	private ArrayList<String> scontent;
	public ServicesMy() {
	}
	public ServicesMy(int sid, int uid, int tid, int mid, String sname, String spic, int snum, String sintro,
			String smajor, String sstime, String setime, String sctime, int sread, int sservice, int sgood, int sbad,
			int ssave, int status, String stelephone, String sfile, String sstate, String uname, String tname,
			ArrayList<String> scontent) {
		this.sid = sid;
		this.uid = uid;
		this.tid = tid;
		this.mid = mid;
		this.sname = sname;
		this.spic = spic;
		this.snum = snum;
		this.sintro = sintro;
		this.smajor = smajor;
		this.sstime = sstime;
		this.setime = setime;
		this.sctime = sctime;
		this.sread = sread;
		this.sservice = sservice;
		this.sgood = sgood;
		this.sbad = sbad;
		this.ssave = ssave;
		this.status = status;
		this.stelephone = stelephone;
		this.sfile = sfile;
		this.sstate = sstate;
		this.uname = uname;
		this.tname = tname;
		this.scontent = scontent;
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
	public String getSintro() {
		return sintro;
	}
	public void setSintro(String sintro) {
		this.sintro = sintro;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	public String getSstime() {
		return sstime;
	}
	public void setSstime(String sstime) {
		this.sstime = sstime;
	}
	public String getSetime() {
		return setime;
	}
	public void setSetime(String setime) {
		this.setime = setime;
	}
	public String getSctime() {
		return sctime;
	}
	public void setSctime(String sctime) {
		this.sctime = sctime;
	}
	public int getSread() {
		return sread;
	}
	public void setSread(int sread) {
		this.sread = sread;
	}
	public int getSservice() {
		return sservice;
	}
	public void setSservice(int sservice) {
		this.sservice = sservice;
	}
	public int getSgood() {
		return sgood;
	}
	public void setSgood(int sgood) {
		this.sgood = sgood;
	}
	public int getSbad() {
		return sbad;
	}
	public void setSbad(int sbad) {
		this.sbad = sbad;
	}
	public int getSsave() {
		return ssave;
	}
	public void setSsave(int ssave) {
		this.ssave = ssave;
	}
	public String getStelephone() {
		return stelephone;
	}
	public void setStelephone(String stelephone) {
		this.stelephone = stelephone;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public String getSstate() {
		return sstate;
	}
	public void setSstate(String sstate) {
		this.sstate = sstate;
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
	public ArrayList<String> getScontent() {
		return scontent;
	}
	public void setScontent(ArrayList<String> scontent) {
		this.scontent = scontent;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ServicesMy [sid=" + sid + ", uid=" + uid + ", tid=" + tid + ", mid=" + mid + ", sname=" + sname
				+ ", spic=" + spic + ", snum=" + snum + ", sintro=" + sintro + ", smajor=" + smajor + ", sstime="
				+ sstime + ", setime=" + setime + ", sctime=" + sctime + ", sread=" + sread + ", sservice=" + sservice
				+ ", sgood=" + sgood + ", sbad=" + sbad + ", ssave=" + ssave + ", status=" + status + ", stelephone="
				+ stelephone + ", sfile=" + sfile + ", sstate=" + sstate + ", uname=" + uname + ", tname=" + tname
				+ ", scontent=" + scontent + "]";
	}
}
