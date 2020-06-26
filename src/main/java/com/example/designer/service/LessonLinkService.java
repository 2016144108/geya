package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.LessonLinkMapper;
import com.example.designer.pojo.Lesson;
import com.example.designer.pojo.LessonLink;
import org.springframework.stereotype.Service;

@Service("lessonLinkService")
public class LessonLinkService {
	
	@Resource(name="lessonLinkMapper")
	LessonLinkMapper lessonLinkMapper;
	public LessonLinkMapper getLessonLinkMapper() {
		return lessonLinkMapper;
	}
	public void setLessonLinkMapper(LessonLinkMapper lessonLinkMapper) {
		this.lessonLinkMapper = lessonLinkMapper;
	}

	public ArrayList<LessonLink>selectAllLessonLink(int uid){
		return lessonLinkMapper.selectAllLessonLink(uid);
	}

	public ArrayList<LessonLink>queryMylessonlink(Lesson lesson){
		return lessonLinkMapper.queryMylessonlink(lesson);
	}
	
	public void deletelessonlink(int leid) {
		lessonLinkMapper.deletelessonlink(leid);
	}
	
	public void Insertlessonlink(LessonLink lessonLink) {
		lessonLinkMapper.Insertlessonlink(lessonLink);
	}
	
	public LessonLink selectALessonLink(LessonLink lessonLink) {
		return lessonLinkMapper.selectALessonLink(lessonLink);
	}
	
	public void updatenum(int lid) {
		lessonLinkMapper.updatenum(lid);
	}
}
