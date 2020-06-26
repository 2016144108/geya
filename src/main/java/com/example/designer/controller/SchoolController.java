package com.example.designer.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.pojo.Result;
import com.example.designer.pojo.School;
import com.example.designer.service.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class SchoolController {
	
	@Resource(name="schoolService")
	SchoolService schoolService;
	public SchoolService getSchoolService() {
		return schoolService;
	}
	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@RequestMapping("showschool")
	@ResponseBody
	public JSONObject query() {
		Result result=new Result();
		try {
			ArrayList<School> schools=schoolService.queryall();
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(schools);
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
