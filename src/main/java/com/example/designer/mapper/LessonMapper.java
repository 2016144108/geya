package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.Lesson;
import com.example.designer.pojo.LessonLink;
import com.example.designer.pojo.Major;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LessonMapper {
	
	@Select("select * from lesson")
	public ArrayList<Lesson> queryAllLesson();
	
	@Select("select * from lesson order by lid desc limit 0,6")
	public ArrayList<Lesson> querySixLesson();
	
	@Select("select * from major")
	public ArrayList<Major> queryAllMajor();
	
	public ArrayList<Lesson> selectTheLesson(String lmajor);
	
	@Select("select * from lesson where lid=#{lid}")
	public Lesson queryTheLesson(int lid);
	
	@Insert("insert into lessonlink (uid,lid) values (#{uid},#{lid})")
	public void Insertlessonlink(LessonLink lessonLink);
	
	public LessonLink selectALessonLink(LessonLink lessonLink);
	
	@Update("update lesson set lnum=lnum+1 where lid=#{lid}")
	public void updatenum(int lid);
	
	@Delete("delete from lesson where lid=#{lid}")
	public void deletelesson(int lid);
	
	@Insert("insert into lesson (mid,lname,lmajor,lteacher,lnum,lstar,lintro,lurl,lpic) values (#{mid},#{lname},#{lmajor},#{lteacher},#{lnum},#{lstar},#{lintro},#{lurl},#{lpic})")
	public void Insertlesson(Lesson lesson);
	
	public void uplesson(Lesson lesson);

}
