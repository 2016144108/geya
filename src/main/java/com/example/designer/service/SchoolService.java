package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.SchoolMapper;
import com.example.designer.pojo.School;
import org.springframework.stereotype.Service;

@Service("schoolService")
public class SchoolService{

	@Resource(name="schoolMapper")
	SchoolMapper schoolMapper;
	public SchoolMapper getSchoolMapper() {
		return schoolMapper;
	}
	public void setSchoolMapper(SchoolMapper schoolMapper) {
		this.schoolMapper = schoolMapper;
	}

	public ArrayList<School> queryall() {
		return schoolMapper.queryall();
	}

}
