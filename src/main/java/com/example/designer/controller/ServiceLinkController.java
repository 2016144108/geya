package com.example.designer.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.pojo.Result;
import com.example.designer.pojo.ServiceLink;
import com.example.designer.pojo.Services;
import com.example.designer.service.ServiceLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class ServiceLinkController {
	
	@Resource(name="serviceLinkService")
	ServiceLinkService serviceLinkService;
	public ServiceLinkService getServiceLinkService() {
		return serviceLinkService;
	}
	public void setServiceLinkService(ServiceLinkService serviceLinkService) {
		this.serviceLinkService = serviceLinkService;
	}

	ArrayList<ServiceLink>serviceLinks=null;
	@RequestMapping("theservicelink")
	public String theservicelink(Services services) {
		try {
			serviceLinks=serviceLinkService.queryMyServicelink(services);
			return "redirect:/manage/servicelink.html";
		}catch (Exception e) {
			System.out.println(e);
			return "redirect:/manage/servicelink.html";
		}
	}
	
	@RequestMapping("showservicelink")
	@ResponseBody
	public JSONObject showservicelink(@RequestParam("uid")int uid) {
		Result result=new Result();
		if(serviceLinks==null) {
			try {
				serviceLinks=serviceLinkService.selectAllServiceLink(uid);
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(serviceLinks);
				JSONObject json=JSONObject.fromObject(result);
				serviceLinks=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				serviceLinks=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(serviceLinks);
			JSONObject json=JSONObject.fromObject(result);
			serviceLinks=null;
			return json;
		}
	}
	
	@RequestMapping("deleteservicelink")
	@ResponseBody
	public JSONObject deleteservicelink(@RequestParam("seid") int seid) {
		Result result=new Result();
		try {
			serviceLinkService.deleteservicelink(seid);;
			result.setCode(200);
			result.setMsg("删除成功");
			result.setData(seid);
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
	
	@RequestMapping("deleteappservicelink")
	@ResponseBody
	public JSONObject deleteappservicelink(ServiceLink serviceLink) {
		Result result=new Result();
		try {
			ServiceLink serviceLink2=serviceLinkService.selectTheServiceLink(serviceLink);
			if(serviceLink2==null) {
				result.setCode(400);
				result.setMsg("你还没有关注此服务");
				result.setData(serviceLink2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				serviceLinkService.deleteservicelink(serviceLink2.getSeid());
				result.setCode(200);
				result.setMsg("删除成功");
				result.setData(serviceLink2.getSeid());
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
	
	@RequestMapping("joinservice")
	@ResponseBody
	public JSONObject joinservice(ServiceLink serviceLink) {
		Result result=new Result();
		try {
			ServiceLink serviceLink2=serviceLinkService.selectTheServiceLink(serviceLink);
			if(serviceLink2!=null) {
				result.setCode(400);
				result.setMsg("你已关注此服务");
				result.setData(serviceLink2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				serviceLinkService.Insertservicelink(serviceLink);
				result.setCode(200);
				result.setMsg("关注成功");
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
