package com.example.designer.controller;

import com.example.designer.pojo.Result;
import com.example.designer.pojo.Teacher;
import com.example.designer.service.TeacherService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

@Controller
public class TeacherController {
	
	@Resource(name="teacherService")
	TeacherService teacherService;
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	ArrayList<Teacher> teachers=null;
	ArrayList<Teacher> teacher2s=null;
	
	@RequestMapping("selectteacher")
	public String querythescience(Teacher teacher) {
		try {
			teachers=teacherService.selectTheTeacher(teacher);
			return "redirect:/teacherlist.html";
		}catch (Exception e) {
			return "redirect:/teacherlist.html";
		}
	}
	
	@RequestMapping("selectsometeacher")
	public String querysometeacher(Teacher teacher) {
		try {
			teacher2s=teacherService.selectSomeTeacher(teacher);
			System.out.println(teacher);
			return "redirect:/manage/teacher.html";
		}catch (Exception e) {
			return "redirect:/manage/teacher.html";
		}
	}
	
	@RequestMapping("showteacher")
	@ResponseBody
	public JSONObject queryscience() {
		Result result=new Result();
		if(teachers==null) {
			try {
				teachers=teacherService.queryAllTeacher();
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(teachers);
				JSONObject json=JSONObject.fromObject(result);
				teachers=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("出错");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				teachers=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(teachers);
			JSONObject json=JSONObject.fromObject(result);
			teachers=null;
			return json;
		}
	}
	
	@RequestMapping("sixteacher")
	@ResponseBody
	public JSONObject sixteacher() {
		Result result=new Result();
			try {
				ArrayList<Teacher> teacherss=teacherService.querySixTeacher();
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(teacherss);
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
	
	@RequestMapping("showteacher2")
	@ResponseBody
	public JSONObject queryteacher2() {
		Result result=new Result();
		if(teacher2s==null) {
			try {
				teacher2s=teacherService.queryAllTeacher();
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(teacher2s);
				JSONObject json=JSONObject.fromObject(result);
				teacher2s=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("出错");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				teacher2s=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(teacher2s);
			JSONObject json=JSONObject.fromObject(result);
			teacher2s=null;
			return json;
		}
	}
	
	@RequestMapping("deleteteacher")
	@ResponseBody
	public JSONObject deleteteacher(@RequestParam("tid")int tid) {
		Result result=new Result();
			try {
				teacherService.deleteteacher(tid);
				result.setCode(200);
				result.setMsg("删除成功");
				result.setData(tid);
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
	
	@RequestMapping("showte")
	@ResponseBody
	public JSONObject showte(@RequestParam("tid")int tid) {
		Result result=new Result();
			try {
				Teacher teacher=teacherService.querytheTeacher(tid);
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(teacher);
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
	
	String tpic="";
	@RequestMapping("teacherpic")
	@ResponseBody
	public JSONObject teacherpic(@RequestParam("file") MultipartFile file) {
		Result result=new Result();
		try {
			InputStream input=file.getInputStream();
			String filename=file.getOriginalFilename();
			tpic=filename;
			OutputStream out=new FileOutputStream("E:\\javaweb\\designer\\src\\main\\webapp\\img\\teacher\\"+filename);
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
			System.out.println(e);
			return json;
		}
	}
	
	@RequestMapping("insertteacher")
	@ResponseBody
	public JSONObject insertteacher(Teacher teacher) {
		Result result=new Result();
			try {
				teacher.setTpic(tpic);
				teacherService.Insertteacher(teacher);
				result.setCode(200);
				result.setMsg("新增成功");
				result.setData(teacher);
				JSONObject json=JSONObject.fromObject(result);
				tpic="";
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("出错");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				System.out.println(e);
				tpic="";
				return json;
			}
	}
	
	@RequestMapping("upteacher")
	@ResponseBody
	public JSONObject upteacher(Teacher teacher) {
		Result result=new Result();
			try {
				teacher.setTpic(tpic);
				teacherService.upteacher(teacher);
				result.setCode(200);
				result.setMsg("编辑成功");
				result.setData(teacher);
				JSONObject json=JSONObject.fromObject(result);
				tpic="";
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("出错");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				tpic="";
				return json;
			}
	}


}
