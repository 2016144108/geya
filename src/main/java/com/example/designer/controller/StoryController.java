package com.example.designer.controller;

import com.example.designer.pojo.Result;
import com.example.designer.pojo.Story;
import com.example.designer.service.StoryService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
public class StoryController {
	
	@Resource(name="storyService")
	StoryService storyService;
	public StoryService getStoryService() {
		return storyService;
	}
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	
	ArrayList<Story> storys=null;
	
	@RequestMapping("choosestory")
	public String chooseshow(@RequestParam("type")String type) {
		try {
			if(type.equals("全部")) {
				storys=storyService.queryAllStory();
			}else if(type.equals("最新")) {
				storys=storyService.queryNewStory();
			}else if(type.equals("升序")) {
				storys=storyService.queryAscStory();
			}else if(type.equals("降序")) {
				storys=storyService.queryDescStory();
			}
			return "redirect:/story.html";
		}catch (Exception e) {
			return "redirect:/story.html";
		}
	}
	
	@RequestMapping("showstory")
	@ResponseBody
	public JSONObject query() {
		Result result=new Result();
		if(storys==null) {
			try {
				storys=storyService.queryAllStory();
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(storys);
				JSONObject json=JSONObject.fromObject(result);
				storys=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("出错");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				storys=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(storys);
			JSONObject json=JSONObject.fromObject(result);
			storys=null;
			return json;
		}
	}
	
	@RequestMapping("thestory")
	@ResponseBody
	public JSONObject shows(@RequestParam("sid") int sid) {
		Result result=new Result();
		storyService.updateread(sid);
		try {
			Story story=storyService.queryTheStory(sid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(story);
			JSONObject json=JSONObject.fromObject(result);
			return json;
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			return json;
		}
	}

}
