package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper {
	
	@Select("select * from teacher")
	public ArrayList<Teacher> queryAllTeacher();
	
	@Select("select * from teacher order by tid desc limit 0,6")
	public ArrayList<Teacher> querySixTeacher();
	
	public ArrayList<Teacher> selectTheTeacher(Teacher teacher);

	public ArrayList<Teacher> selectSomeTeacher(Teacher teacher);
	
	@Delete("delete from teacher where tid=#{tid}")
	public void deleteteacher(int tid);
	
	@Select("select * from teacher where tid=#{tid}")
	public Teacher querytheTeacher(int tid);
	
	@Insert("insert into teacher (tname,tschool,tstatus,ttelephone,tintro,mid,tmajor,tpic) "
			+ "values (#{tname},#{tschool},#{tstatus},#{ttelephone},#{tintro},#{mid},#{tmajor},#{tpic})")
	public void Insertteacher(Teacher teacher);
	
	public void upteacher(Teacher teacher);

}
