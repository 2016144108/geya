package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SchoolMapper {
	
	@Select("select * from school")
	public ArrayList<School> queryall();
}
