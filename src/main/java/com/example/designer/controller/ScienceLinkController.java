package com.example.designer.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.pojo.Result;
import com.example.designer.pojo.Science;
import com.example.designer.pojo.ScienceLink;
import com.example.designer.service.ScienceLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class ScienceLinkController {
	
	@Resource(name="scienceLinkService")
	ScienceLinkService scienceLinkService;
	public ScienceLinkService getScienceLinkService() {
		return scienceLinkService;
	}
	public void setScienceLinkService(ScienceLinkService scienceLinkService) {
		this.scienceLinkService = scienceLinkService;
	}

	ArrayList<ScienceLink>scienceLinks=null;
	@RequestMapping("thesciencelink")
	public String thesciencelink(Science science) {
		try {
			scienceLinks=scienceLinkService.queryMySciencelink(science);
			return "redirect:/manage/sciencelink.html";
		}catch (Exception e) {
			System.out.println(e);
			return "redirect:/manage/sciencelink.html";
		}
	}
	
	@RequestMapping("showsciencelink")
	@ResponseBody
	public JSONObject showsciencelink(@RequestParam("uid")int uid) {
		Result result=new Result();
		if(scienceLinks==null) {
			try {
				scienceLinks=scienceLinkService.selectAllScienceLink(uid);
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(scienceLinks);
				JSONObject json=JSONObject.fromObject(result);
				scienceLinks=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				scienceLinks=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(scienceLinks);
			JSONObject json=JSONObject.fromObject(result);
			scienceLinks=null;
			return json;
		}
	}
	
	@RequestMapping("deletesciencelink")
	@ResponseBody
	public JSONObject deletesciencelink(@RequestParam("scid") int scid) {
		Result result=new Result();
		try {
			scienceLinkService.deletesciencelink(scid);
			result.setCode(200);
			result.setMsg("删除成功");
			result.setData(scid);
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
	
	@RequestMapping("deleteappsciencelink")
	@ResponseBody
	public JSONObject deleteappsciencelink(ScienceLink scienceLink) {
		Result result=new Result();
		try {
			ScienceLink scienceLink2=scienceLinkService.selectTheScienceLink(scienceLink);
			if(scienceLink2==null) {
				result.setCode(400);
				result.setMsg("你还没有加入此沙龙");
				result.setData(scienceLink2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				scienceLinkService.deletesciencelink(scienceLink2.getScid());
				result.setCode(200);
				result.setMsg("删除成功");
				result.setData(scienceLink2.getScid());
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
	
	@RequestMapping("joinscience")
	@ResponseBody
	public JSONObject joinscience(ScienceLink scienceLink) {
		Result result=new Result();
		try {
			ScienceLink scienceLink2=scienceLinkService.selectTheScienceLink(scienceLink);
			if(scienceLink2!=null) {
				result.setCode(400);
				result.setMsg("你已加入此沙龙");
				result.setData(scienceLink2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				scienceLinkService.Insertsciencelink(scienceLink);
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
