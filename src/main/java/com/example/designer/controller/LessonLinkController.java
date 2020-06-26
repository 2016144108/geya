package com.example.designer.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.pojo.Lesson;
import com.example.designer.pojo.LessonLink;
import com.example.designer.pojo.Result;
import com.example.designer.service.LessonLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class LessonLinkController {
	
	@Resource(name="lessonLinkService")
	LessonLinkService lessonLinkService;
	public LessonLinkService getLessonLinkService() {
		return lessonLinkService;
	}
	public void setLessonLinkService(LessonLinkService lessonLinkService) {
		this.lessonLinkService = lessonLinkService;
	}
	
	ArrayList<LessonLink>lessonlinks=null;
	@RequestMapping("thelessonlink")
	public String thelessonlink(Lesson lesson) {
		try {
			lessonlinks=lessonLinkService.queryMylessonlink(lesson);
			return "redirect:/manage/lessonlink.html";
		}catch (Exception e) {
			System.out.println(e);
			return "redirect:/manage/lessonlink.html";
		}
	}
	
	@RequestMapping("showlessonlink")
	@ResponseBody
	public JSONObject showlessonlink(@RequestParam("uid")int uid) {
		Result result=new Result();
		if(lessonlinks==null) {
			try {
				lessonlinks=lessonLinkService.selectAllLessonLink(uid);
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(lessonlinks);
				JSONObject json=JSONObject.fromObject(result);
				lessonlinks=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				lessonlinks=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(lessonlinks);
			JSONObject json=JSONObject.fromObject(result);
			lessonlinks=null;
			return json;
		}
	}
	
	@RequestMapping("deletelessonlink")
	@ResponseBody
	public JSONObject deletelessonlink(@RequestParam("leid") int leid) {
		Result result=new Result();
		try {
			lessonLinkService.deletelessonlink(leid);
			result.setCode(200);
			result.setMsg("删除成功");
			result.setData(leid);
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
	
	@RequestMapping("deleteapplessonlink")
	@ResponseBody
	public JSONObject deletelessonlink(LessonLink lessonLink) {
		Result result=new Result();
		try {
			LessonLink lessonLink2=lessonLinkService.selectALessonLink(lessonLink);
			if(lessonLink2==null) {
				result.setCode(400);
				result.setMsg("你还没有加入该课程");
				result.setData(lessonLink2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				lessonLinkService.deletelessonlink(lessonLink2.getLeid());
				result.setCode(200);
				result.setMsg("删除成功");
				result.setData(lessonLink2.getLeid());
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			return json;
		}
	}
	
	@RequestMapping("joinmylesson")
	@ResponseBody
	public JSONObject joinmylesson(LessonLink lessonLink) {
		Result result=new Result();
		try {
			LessonLink lessonLink2=lessonLinkService.selectALessonLink(lessonLink);
			if(lessonLink2!=null) {
				result.setCode(400);
				result.setMsg("已加入该课程");
				result.setData(lessonLink2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				lessonLinkService.Insertlessonlink(lessonLink);
				lessonLinkService.updatenum(lessonLink.getLid());
				result.setCode(200);
				result.setMsg("加入成功");
				result.setData("");
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			return json;
		}
	}

}
