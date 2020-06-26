package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.TeamMapper;
import com.example.designer.pojo.*;
import org.springframework.stereotype.Service;

@Service("teamService")
public class TeamService {
	
	@Resource(name="teamMapper")
	TeamMapper teamMapper;
	public TeamMapper getTeamMapper() {
		return teamMapper;
	}
	public void setTeamMapper(TeamMapper teamMapper) {
		this.teamMapper = teamMapper;
	}
	
	public ArrayList<Team> queryAllTeam(){
		return teamMapper.queryAllTeam();
	}
	
	public ArrayList<Team> querySixTeam(){
		return teamMapper.querySixTeam();
	}
	
	public ArrayList<Team> querySomeTeam(Team team){
		return teamMapper.querySomeTeam(team);
	}
	
	public Team queryTheTeam(int tid) {
		return teamMapper.queryTheTeam(tid);
	}
	
	public ArrayList<User> queryUser(int tid){
		return teamMapper.queryUser(tid);
	}
	
	public ArrayList<Services> queryAllService(int tid){
		return teamMapper.queryAllService(tid);
	}

	public ArrayList<Story> queryAllStory(int tid){
		return teamMapper.queryAllStory(tid);
	}
	
	public User queryTheUser(int uid) {
		return teamMapper.queryTheUser(uid);
	}
	
	public void updatetid(User user) {
		teamMapper.updatetid(user);
	}
	
	public TeamSci queryTheTeam2(int uid) {
		return teamMapper.queryTheTeam2(uid);
	}
	
	public void updateteam(Team team) {
		teamMapper.updateteam(team);
	}
	
	public void InsertTeam(Team team) {
		teamMapper.InsertTeam(team);
	}
	
	public ArrayList<Science> queryAllScience(int tid){
		return teamMapper.queryAllScience(tid);
	}
		
}
