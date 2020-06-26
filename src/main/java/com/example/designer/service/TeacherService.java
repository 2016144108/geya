package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.TeacherMapper;
import com.example.designer.pojo.Teacher;
import org.springframework.stereotype.Service;

@Service("teacherService")
public class TeacherService{
	
	@Resource(name="teacherMapper")
	TeacherMapper teacherMapper;
	public TeacherMapper getTeacherMapper() {
		return teacherMapper;
	}
	public void setTeacherMapper(TeacherMapper teacherMapper) {
		this.teacherMapper = teacherMapper;
	}

	public ArrayList<Teacher> queryAllTeacher() {
		return teacherMapper.queryAllTeacher();
	}
	
	public ArrayList<Teacher> querySixTeacher() {
		return teacherMapper.querySixTeacher();
	}
	
	public ArrayList<Teacher> selectTheTeacher(Teacher teacher) {
		return teacherMapper.selectTheTeacher(teacher);
	}
	
	public ArrayList<Teacher> selectSomeTeacher(Teacher teacher) {
		return teacherMapper.selectSomeTeacher(teacher);
	}

	public void deleteteacher(int tid) {
		teacherMapper.deleteteacher(tid);
	}
	
	public Teacher querytheTeacher(int tid) {
		return teacherMapper.querytheTeacher(tid);
	}
	
	public void Insertteacher(Teacher teacher) {
		teacherMapper.Insertteacher(teacher);
	}
	
	public void upteacher(Teacher teacher) {
		teacherMapper.upteacher(teacher);
	}

}
