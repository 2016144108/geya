package com.example.designer.controller;

import com.example.designer.pojo.Lesson;
import com.example.designer.pojo.LessonLink;
import com.example.designer.pojo.Major;
import com.example.designer.pojo.Result;
import com.example.designer.service.LessonService;
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
public class LessonController {
	
	@Resource(name="lessonService")
	LessonService lessonService;
	public LessonService getLessonService() {
		return lessonService;
	}
	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}
	
	ArrayList<Lesson> lessons=null;
	String remajor="全部";
	
	@RequestMapping("choose")
	@ResponseBody
	public JSONObject choose(@RequestParam(value="lmajor") String lmajor) {
		Result result=new Result();
		remajor=lmajor;
		try {
			if(lmajor.equals("全部")) {
				lmajor="";
			}
			lessons=lessonService.selectTheLesson(lmajor);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(lessons);
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
	String lpic="";
	@RequestMapping("lessonpic")
	@ResponseBody
	public JSONObject lessonpic(@RequestParam("file") MultipartFile file) {
		Result result=new Result();
		try {
			InputStream input=file.getInputStream();
			String filename=file.getOriginalFilename();
			lpic=filename;
			OutputStream out=new FileOutputStream("E:\\javaweb\\designer\\src\\main\\webapp\\img\\lesson\\"+filename);
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
	
	@RequestMapping("insertlesson")
	@ResponseBody
	public JSONObject insertlesson(Lesson lesson) {
		Result result=new Result();
		lesson.setLnum(0);
		lesson.setLpic(lpic);
		System.out.println(lesson);
		try {
			lessonService.Insertlesson(lesson);
			result.setCode(200);
			result.setMsg("新增成功");
			result.setData(lesson);
			JSONObject json=JSONObject.fromObject(result);
			lpic="";
			return json;
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			System.out.println(e);
			lpic="";
			return json;
		}
	}
	
	@RequestMapping("uplesson")
	@ResponseBody
	public JSONObject uplesson(Lesson lesson) {
		Result result=new Result();
		try {
			lesson.setLpic(lpic);
			lessonService.uplesson(lesson);
			result.setCode(200);
			result.setMsg("编辑成功");
			result.setData(lesson);
			JSONObject json=JSONObject.fromObject(result);
			lpic="";
			return json;
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			System.out.println(e);
			lpic="";
			return json;
		}
	}
	
	@RequestMapping("showmajor")
	@ResponseBody
	public JSONObject major() {
		Result result=new Result();
		try {
			ArrayList<Major> majors=lessonService.queryAllMajor();
			result.setCode(200);
			result.setMsg(remajor);
			result.setData(majors);
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
	
	@RequestMapping("deletelesson")
	@ResponseBody
	public JSONObject deletelesson(@RequestParam("lid") int lid) {
		Result result=new Result();
		try {
			lessonService.deletelesson(lid);
			result.setCode(200);
			result.setMsg("删除成功");
			result.setData(lid);
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
	
	@RequestMapping("showlesson")
	@ResponseBody
	public JSONObject query() {
		Result result=new Result();
		if(lessons==null) {
			try {
				lessons=lessonService.queryAllLesson();
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(lessons);
				JSONObject json=JSONObject.fromObject(result);
				lessons=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("出错");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				lessons=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(lessons);
			JSONObject json=JSONObject.fromObject(result);
			lessons=null;
			return json;
		}
	}
	
	@RequestMapping("sixlesson")
	@ResponseBody
	public JSONObject sixlesson() {
		Result result=new Result();
			try {
				ArrayList<Lesson> lessonss=lessonService.querySixLesson();
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(lessonss);
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
	
	@RequestMapping("show")
	@ResponseBody
	public JSONObject chooseshow(@RequestParam("lid")int lid) {
		Result result=new Result();
		try {
			Lesson lesson=lessonService.queryTheLesson(lid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(lesson);
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
	
	@RequestMapping("joinlesson")
	@ResponseBody
	public JSONObject joinlesson(LessonLink lessonLink) {
		Result result=new Result();
		try {
			LessonLink lessonLink2=lessonService.selectALessonLink(lessonLink);
			if(lessonLink2!=null) {
				result.setCode(200);
				result.setMsg("继续学习");
				result.setData(lessonLink2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				lessonService.Insertlessonlink(lessonLink);
				lessonService.updatenum(lessonLink.getLid());
				result.setCode(200);
				result.setMsg("加入课程成功");
				result.setData("");
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			System.out.println(e);
			return json;
		}
	}

}
