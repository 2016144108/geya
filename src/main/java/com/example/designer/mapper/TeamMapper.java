package com.example.designer.mapper;

import com.example.designer.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

@Mapper
public interface TeamMapper {
	
	public ArrayList<Team> queryAllTeam();
	
	public ArrayList<Team> querySixTeam();

	public ArrayList<Team> querySomeTeam(Team team);
	
	public Team queryTheTeam(int tid);
	
	@Select("select * from user where tid=#{tid}")
	public ArrayList<User> queryUser(int tid);
	
	public ArrayList<Services> queryAllService(int tid);
	
	@Select("select * from story where tid=#{tid}")
	public ArrayList<Story> queryAllStory(int tid);
	
	@Select("select * from user where uid=#{uid}")
	public User queryTheUser(int uid);
	
	@Update("update user set tid=#{tid} where uid=#{uid}")
	public void updatetid(User user);
	
	@Select("select * from team t,user u where t.tid=u.tid and u.uid=${uid}")
	public TeamSci queryTheTeam2(int uid);
	
	@Update("update team set tname=#{tname},tintro=#{tintro} where tid=#{tid}")
	public void updateteam(Team team);
	
	public void InsertTeam(Team team);
	
	public ArrayList<Science> queryAllScience(int tid);

	@Update("update team set tnum=tnum+1 where tid=#{tid}")
	public void updatetnum(int tid);

}
