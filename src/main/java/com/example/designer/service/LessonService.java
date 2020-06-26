package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;


import com.example.designer.mapper.LessonMapper;
import com.example.designer.pojo.Lesson;
import com.example.designer.pojo.LessonLink;
import com.example.designer.pojo.Major;
import org.springframework.stereotype.Service;

@Service("lessonService")
public class LessonService{
	
	@Resource(name="lessonMapper")
	LessonMapper lessonMapper;
	public LessonMapper getLessonMapper() {
		return lessonMapper;
	}
	public void setLessonMapper(LessonMapper lessonMapper) {
		this.lessonMapper = lessonMapper;
	}

	public ArrayList<Lesson> queryAllLesson() {
		return lessonMapper.queryAllLesson();
	}
	
	public ArrayList<Lesson> querySixLesson() {
		return lessonMapper.querySixLesson();
	}

	public ArrayList<Major> queryAllMajor() {
		return lessonMapper.queryAllMajor();
	}
	
	public ArrayList<Lesson> selectTheLesson(String lmajor){
		return lessonMapper.selectTheLesson(lmajor);
	}

	public Lesson queryTheLesson(int lid) {
		return lessonMapper.queryTheLesson(lid);
	}

	public void Insertlessonlink(LessonLink lessonLink) {
		lessonMapper.Insertlessonlink(lessonLink);
	}
	
	public LessonLink selectALessonLink(LessonLink lessonLink) {
		return lessonMapper.selectALessonLink(lessonLink);
	}

	public void updatenum(int lid) {
		lessonMapper.updatenum(lid);
	}
	
	public void deletelesson(int lid) {
		lessonMapper.deletelesson(lid);
	}
	
	public void Insertlesson(Lesson lesson) {
		lessonMapper.Insertlesson(lesson);
	}

	public void uplesson(Lesson lesson) {
		lessonMapper.uplesson(lesson);
	}
}
