package com.example.designer.service;

import com.example.designer.mapper.IndexMapper;
import com.example.designer.pojo.School;
import com.example.designer.pojo.ScienceIndex;
import com.example.designer.pojo.Team;
import com.example.designer.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("indexService")
public class IndexService{

	@Resource(name="indexMapper")
	IndexMapper indexMapper;
	public IndexMapper getIndexMapper() {
		return indexMapper;
	}
	public void setIndexMapper(IndexMapper indexMapper) {
		this.indexMapper = indexMapper;
	}

	public ArrayList<ScienceIndex> selectAllScience() {
		return indexMapper.selectAllScience();
	}

	public ArrayList<Team> selectTheTeam() {
		return indexMapper.selectTheTeam();
	}

	public void insertUser(User user) {
		indexMapper.insertUser(user);
	}
	
	public ArrayList<User> check(User user){
		return indexMapper.check(user);
	}
	
	public User login(User user) {
		return indexMapper.login(user);
	}
	
	public User loginsys(User user) {
		return indexMapper.loginsys(user);
	}
	
	public void updatema(User user) {
		indexMapper.updatema(user);
	}
	
	public User the(int uid) {
		return indexMapper.the(uid);
	}
	
	public ArrayList<School> queryall(){
		return indexMapper.queryall();
	}

}
