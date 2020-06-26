package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class Lesson {
	private int lid;
	private int mid;
	private String lname;
	private String lmajor;
	private String lteacher;
	private int lnum;
	private Integer lstar;
	private String lintro;
	private String lpic;
	private String lurl;
	public Lesson() {
	}
	public Lesson(int lid, int mid, String lname, String lmajor, String lteacher, int lnum, Integer lstar, String lintro,
			String lpic, String lurl) {
		this.lid = lid;
		this.mid = mid;
		this.lname = lname;
		this.lmajor = lmajor;
		this.lteacher = lteacher;
		this.lnum = lnum;
		this.lstar = lstar;
		this.lintro = lintro;
		this.lpic = lpic;
		this.lurl = lurl;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLmajor() {
		return lmajor;
	}
	public void setLmajor(String lmajor) {
		this.lmajor = lmajor;
	}
	public String getLteacher() {
		return lteacher;
	}
	public void setLteacher(String lteacher) {
		this.lteacher = lteacher;
	}
	public int getLnum() {
		return lnum;
	}
	public void setLnum(int lnum) {
		this.lnum = lnum;
	}
	public Integer getLstar() {
		return lstar;
	}
	public void setLstar(Integer lstar) {
		this.lstar = lstar;
	}
	public String getLintro() {
		return lintro;
	}
	public void setLintro(String lintro) {
		this.lintro = lintro;
	}
	public String getLpic() {
		return lpic;
	}
	public void setLpic(String lpic) {
		this.lpic = lpic;
	}
	public String getLurl() {
		return lurl;
	}
	public void setLurl(String lurl) {
		this.lurl = lurl;
	}
	@Override
	public String toString() {
		return "Lesson [lid=" + lid + ", mid=" + mid + ", lname=" + lname + ", lmajor=" + lmajor + ", lteacher="
				+ lteacher + ", lnum=" + lnum + ", lstar=" + lstar + ", lintro=" + lintro + ", lpic=" + lpic + ", lurl="
				+ lurl + "]";
	}
}
