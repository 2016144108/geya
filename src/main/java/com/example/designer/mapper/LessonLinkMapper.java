package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.Lesson;
import com.example.designer.pojo.LessonLink;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LessonLinkMapper {
	
	public ArrayList<LessonLink>selectAllLessonLink(int uid);

	public ArrayList<LessonLink>queryMylessonlink(Lesson lesson);
	
	@Delete("delete from lessonlink where leid=#{leid}")
	public void deletelessonlink(int leid);
	
	@Insert("insert into lessonlink (uid,lid) values (#{uid},#{lid})")
	public void Insertlessonlink(LessonLink lessonLink);
	
	public LessonLink selectALessonLink(LessonLink lessonLink);
	
	@Update("update lesson set lnum=lnum+1 where lid=#{lid}")
	public void updatenum(int lid);

}
