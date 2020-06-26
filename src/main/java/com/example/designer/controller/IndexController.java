package com.example.designer.controller;

import com.example.designer.pojo.*;
import com.example.designer.service.IndexService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

@Controller
public class IndexController {
	
	@Resource(name="indexService")
	IndexService indexService;
	public IndexService getIndexService() {
		return indexService;
	}
	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}
	
	@RequestMapping("indexscience")
	@ResponseBody
	public JSONObject queryscience() {
		Result result=new Result();
		try {
			ArrayList<ScienceIndex> sciences=indexService.selectAllScience();
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(sciences);
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
	
	@RequestMapping("indexteam")
	@ResponseBody
	public JSONObject queryteam() {
		Result result=new Result();
		try {
			ArrayList<Team> teams=indexService.selectTheTeam();
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(teams);
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
	
	String upic="";
	@RequestMapping("upload")
	@ResponseBody
	public JSONObject upload(@RequestParam("file") MultipartFile file) {
		Result result=new Result();
		try {
			InputStream input=file.getInputStream();
			String filename=file.getOriginalFilename();
			upic=filename;
			OutputStream out=new FileOutputStream("E:\\javaweb\\designer\\src\\main\\webapp\\img\\user\\"+filename);
			byte[] bs=new byte[1024];
			int len=-1;
			while((len=input.read(bs))!=-1) {
				out.write(bs,0,len);
			}
			out.close();
			input.close();
			result.setCode(200);
			result.setMsg("上传成功");
			result.setData(filename);
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
	
	@RequestMapping("register")
	@ResponseBody
	public JSONObject register(User user) {
		Result result=new Result();
		try {
			ArrayList<User> users=indexService.check(user);
			if(users.isEmpty()) {
				user.setUpic(upic);
				user.setUserid("User-"+(int)(Math.random()*(98765-12345+1)+98765));
				user.setTid(0);
				indexService.insertUser(user);
				result.setCode(200);
				result.setMsg("注册成功");
				result.setData(user);
				JSONObject json=JSONObject.fromObject(result);
				upic="";
				return json;
			}else{
				result.setCode(400);
				result.setMsg("用户已存在");
				result.setData(user);
				JSONObject json=JSONObject.fromObject(result);
				upic="";
				return json;
			}
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			upic="";
			return json;
		}
	}
	
	@RequestMapping("login")
	@ResponseBody
	public JSONObject login(HttpServletResponse response,User user) {
		Result result=new Result();
		try {
			User user1=indexService.login(user);
			if(user1!=null) {
				Cookie cookie = new Cookie("utelephone", user1.getUtelephone());
				cookie.setMaxAge(60*60*24);
				cookie.setPath("/");  
				response.addCookie(cookie);
				cookie = new Cookie("uname", user1.getUname());
				cookie.setMaxAge(60*60*24);  
				cookie.setPath("/");
				response.addCookie(cookie);
				cookie = new Cookie("useridss", user1.getUid()+"");
				cookie.setMaxAge(60*60*24);
				cookie.setPath("/");
				response.addCookie(cookie);
				cookie = new Cookie("upic", user1.getUpic());
				cookie.setMaxAge(60*60*24);
				cookie.setPath("/");
				response.addCookie(cookie);
				result.setCode(200);
				result.setMsg("用户登录成功");
				result.setData(user1);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else{
				result.setCode(400);
				result.setMsg("用户信息或者密码不正确");
				result.setData(user);
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
	
	@RequestMapping("regisma")
	@ResponseBody
	public JSONObject regisma(int uid) {
		Result result=new Result();
		try {
			User user2=indexService.the(uid);
			if(user2.getUma()==null||user2.getUma().equals("")) {
				String uma=(int)(Math.random()*(98765-12345+1)+98765)+"";
				user2.setUma(uma);
				indexService.updatema(user2);
				result.setCode(200);
				result.setMsg("通行码注册成功");
				result.setData(user2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else{
				result.setCode(400);
				result.setMsg("已拥有通行码");
				result.setData(user2.getUma());
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
	
	@RequestMapping("loginsys")
	@ResponseBody
	public JSONObject loginsys(HttpServletResponse response,User user) {
		Result result=new Result();
		try {
			User user2=indexService.loginsys(user);
			if(user2!=null) {
				Cookie cookie = new Cookie("uma", user2.getUma());
				cookie.setMaxAge(60*60*24);
				cookie.setPath("/");  
				response.addCookie(cookie);
				result.setCode(200);
				result.setMsg("系统登录成功");
				result.setData(user2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else{
				result.setCode(400);
				result.setMsg("通行码不正确");
				result.setData(user);
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
	
	@RequestMapping("showsch")
	@ResponseBody
	public JSONObject showsch() {
		Result result=new Result();
		try {
			ArrayList<School> schools=indexService.queryall();
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
