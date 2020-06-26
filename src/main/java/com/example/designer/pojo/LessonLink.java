package com.example.designer.pojo;

import org.springframework.stereotype.Component;

@Component
public class LessonLink {
	private int leid;
	private int lid;
	private int uid;
	private Lesson lesson;
	public LessonLink() {
	}
	public LessonLink(int leid, int lid, int uid, Lesson lesson) {
		this.leid = leid;
		this.lid = lid;
		this.uid = uid;
		this.lesson = lesson;
	}
	public int getLeid() {
		return leid;
	}
	public void setLeid(int leid) {
		this.leid = leid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	@Override
	public String toString() {
		return "LessonLink [leid=" + leid + ", lid=" + lid + ", uid=" + uid + ", lesson=" + lesson + "]";
	}
}
