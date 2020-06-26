package com.example.designer.controller;

import com.example.designer.pojo.Result;
import com.example.designer.pojo.User;
import com.example.designer.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;

@Controller
public class UserController {

	@Resource(name="userService")
	UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("userinfo")
	@ResponseBody
	public JSONObject query(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			User user=userService.queryTheUser(uid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(user);
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
	
	String newupic="";
	@RequestMapping("editerload")
	@ResponseBody
	public JSONObject editerload(@RequestParam("file") MultipartFile file) {
		Result result=new Result();
		try {
			InputStream input=file.getInputStream();
			String filename=file.getOriginalFilename();
			newupic=filename;
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
	
	@RequestMapping("editeruser")
	@ResponseBody
	public JSONObject editeruser(User user) {
		Result result=new Result();
		try {
			user.setUpic(newupic);
			User user2=userService.queryTelUser(user);
			User user3=userService.queryQqUser(user);
			if((user2==null||user2.getUid()==user.getUid())&&(user3==null||user3.getUid()==user.getUid())) {
				userService.editeruser(user);
				result.setCode(200);
				result.setMsg("编辑成功");
				result.setData(user);
				JSONObject json=JSONObject.fromObject(result);
				newupic="";
				return json;
			}else {
				result.setCode(400);
				result.setMsg("用户已存在");
				result.setData(user);
				JSONObject json=JSONObject.fromObject(result);
				newupic="";
				return json;
			}
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			newupic="";
			return json;
		}
	}
	
	@RequestMapping("userlogout")
	@ResponseBody
	public JSONObject userlogout(HttpServletRequest request,HttpServletResponse response) {
		Result result=new Result();
		try {
			Cookie[] cookies=request.getCookies();
			for(Cookie cookie:cookies){
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
			}
			result.setCode(200);
			result.setMsg("用户注销");
			result.setData(cookies);
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
	
	@RequestMapping("outma")
	@ResponseBody
	public JSONObject outma(HttpServletRequest request,HttpServletResponse response) {
		Result result=new Result();
		try {
			Cookie cookie = new Cookie("uma",null);
			cookie.setMaxAge(0);
			cookie.setPath("/");  
			response.addCookie(cookie);
			result.setCode(200);
			result.setMsg("用户注销");
			result.setData(cookie);
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
	
	@RequestMapping("isinfo")
	public String isinfo(@RequestParam("uid")int uid) {
		User user=userService.queryTheUser(uid);
		if(user.getTid()==0) {
			return "redirect:/manage/teamcreate.html";
		}else {
			return "redirect:/manage/information.html";	
		}
	}
	
	@RequestMapping("istedi")
	public String istedi(@RequestParam("uid")int uid) {
		User user=userService.queryTheUser(uid);
		if(user.getTid()==0) {
			return "redirect:/manage/teamcreate.html";
		}else {
			return "redirect:/manage/teamediter.html";	
		}
	}
	
	@RequestMapping("isser")
	public String isser(@RequestParam("uid")int uid) {
		User user=userService.queryTheUser(uid);
		if(user.getTid()==0) {
			return "redirect:/manage/teamcreate.html";
		}else {
			return "redirect:/manage/service.html";	
		}
	}
	
	@RequestMapping("isserc")
	public String isserc(@RequestParam("uid")int uid) {
		User user=userService.queryTheUser(uid);
		if(user.getTid()==0) {
			return "redirect:/manage/teamcreate.html";
		}else {
			return "redirect:/manage/servicecreate.html";	
		}
	}
	
	@RequestMapping("issci")
	public String issci(@RequestParam("uid")int uid) {
		User user=userService.queryTheUser(uid);
		if(user.getTid()==0) {
			return "redirect:/manage/teamcreate.html";
		}else {
			return "redirect:/manage/science2.html";	
		}
	}
	
	@RequestMapping("isscic")
	public String isscic(@RequestParam("uid")int uid) {
		User user=userService.queryTheUser(uid);
		if(user.getTid()==0) {
			return "redirect:/manage/teamcreate.html";
		}else {
			return "redirect:/manage/sciencecreate.html";	
		}
	}
	
	@RequestMapping("isque")
	public String isque(@RequestParam("uid")int uid) {
		User user=userService.queryTheUser(uid);
		if(user.getTid()==0) {
			return "redirect:/manage/teamcreate.html";
		}else {
			return "redirect:/manage/question.html";	
		}
	}
	
	@RequestMapping("iscom")
	public String iscom(@RequestParam("uid")int uid) {
		User user=userService.queryTheUser(uid);
		if(user.getTid()==0) {
			return "redirect:/manage/teamcreate.html";
		}else {
			return "redirect:/manage/commons.html";	
		}
	}
	
	@RequestMapping("appdownload")
	public void download(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ServletOutputStream servletOutputStream=response.getOutputStream();
		String filename="app.zip";
		String realPath=request.getRealPath("img/download/"+filename);
		InputStream inputStream=new FileInputStream(new File(realPath));
		filename=URLEncoder.encode(filename, "UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		byte[] b=new byte[6];
		while(inputStream.read(b)>0) {
			servletOutputStream.write(b);
			b=new byte[6];
		};
		servletOutputStream.flush();
		servletOutputStream.close();
		inputStream.close();
	}
	
	@RequestMapping("showcount")
	@ResponseBody
	public JSONObject showcount() {
		Result result=new Result();
		try {
			ArrayList<Integer> counts=new ArrayList<Integer>();
			int count=userService.countlesson();
			counts.add(count);
			count=userService.countteacher();
			counts.add(count);
			count=userService.countteam();
			counts.add(count);
			count=userService.countservice();
			counts.add(count);
			count=userService.countscience();
			counts.add(count);
			result.setCode(200);
			result.setMsg("成功");
			result.setData(counts);
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
	
	@RequestMapping("loginapp")
	@ResponseBody
	public JSONObject loginapp(User user) {
		Result result=new Result();
		try {
			User user2=userService.login(user);
			if(user2!=null) {
				result.setCode(200);
				result.setMsg("系统登录成功");
				result.setData(user2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else{
				result.setCode(400);
				result.setMsg("用户登录信息错误");
				result.setData(user);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("发生出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			return json;
		}
	}
	
	@RequestMapping("adminlogin")
	@ResponseBody
	public JSONObject adminlogin(@RequestParam("uname")String uname,@RequestParam("upassword")String upassword) {
		Result result=new Result();
		try {
			if(uname.equals("admin")&&upassword.equals("admin")) {
				result.setCode(200);
				result.setMsg("管理员登录成功");
				result.setData("");
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else{
				result.setCode(400);
				result.setMsg("管理员信息或者密码不正确");
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
	
	@RequestMapping("adminout")
	@ResponseBody
	public JSONObject adminout() {
		Result result=new Result();
		try {
			result.setCode(200);
			result.setMsg("管理员注销");
			result.setData("");
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
