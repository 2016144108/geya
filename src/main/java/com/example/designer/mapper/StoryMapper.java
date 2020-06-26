package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.Story;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StoryMapper {
	
	@Select("select * from story")
	public ArrayList<Story> queryAllStory();
	
	@Select("select * from story order by stime desc limit 0,4")
	public ArrayList<Story> queryNewStory();
	
	@Select("select * from story order by sname asc")
	public ArrayList<Story> queryAscStory();
	
	@Select("select * from story order by sname desc")
	public ArrayList<Story> queryDescStory();
	
	@Select("select * from story where sid=#{sid}")
	public Story queryTheStory(int sid);
	
	@Update("update story set sread=sread+1 where sid=#{sid}")
	public void updateread(int sid);

}
