package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.StoryMapper;
import com.example.designer.pojo.Story;
import org.springframework.stereotype.Service;

@Service("storyService")
public class StoryService{
	
	@Resource(name="storyMapper")
	StoryMapper storyMapper;
	public StoryMapper getStoryMapper() {
		return storyMapper;
	}
	public void setStoryMapper(StoryMapper storyMapper) {
		this.storyMapper = storyMapper;
	}

	public ArrayList<Story> queryAllStory() {
		return storyMapper.queryAllStory();
	}
	
	public ArrayList<Story> queryNewStory(){
		return storyMapper.queryNewStory();
	}
	
	public ArrayList<Story> queryAscStory(){
		return storyMapper.queryAscStory();
	}
	
	public ArrayList<Story> queryDescStory(){
		return storyMapper.queryDescStory();
	}

	public Story queryTheStory(int sid) {
		return storyMapper.queryTheStory(sid);
	}
	
	public void updateread(int sid) {
		storyMapper.updateread(sid);
	}

}
