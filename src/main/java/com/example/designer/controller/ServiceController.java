package com.example.designer.controller;

import com.example.designer.pojo.*;
import com.example.designer.service.ServiceService;
import net.sf.json.JSONObject;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ServiceController {
	
	@Resource(name="serviceService")
	ServiceService serviceService;
	public ServiceService getServiceService() {
		return serviceService;
	}
	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}
	ArrayList<Services> services=null;
	String stype="随机";
	
	@RequestMapping("servicechoose")
	public String chooseshow(@RequestParam("type")String type) {
		stype=type;
		try {
			if(type.equals("随机")) {
				services=serviceService.queryAllService();
			}else if(type.equals("服务名")) {
				services=serviceService.querySnameService();
			}else if(type.equals("发布者")) {
				services=serviceService.queryTnameService();
			}else if(type.equals("人数")) {
				services=serviceService.querySnumService();
			}else if(type.equals("时间")) {
				services=serviceService.querySctimeService();
			}
			return "redirect:/servicelist.html";
		}catch (Exception e) {
			return "redirect:/servicelist.html";
		}
	}
	
	@RequestMapping("selectser")
	public String chooseser(Services service) {
		try {
			services=serviceService.querySomeService(service);
			return "redirect:/manage/service2.html";
		}catch (Exception e) {
			return "redirect:/manage/service2.html";
		}
	}
	
	@RequestMapping("showservice")
	@ResponseBody
	public JSONObject query() {
		Result result=new Result();
		if(services==null) {
			try {
				services=serviceService.queryAllService();
				result.setCode(200);
				result.setMsg(stype);
				result.setData(services);
				JSONObject json=JSONObject.fromObject(result);
				services=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg(stype);
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				services=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg(stype);
			result.setData(services);
			JSONObject json=JSONObject.fromObject(result);
			services=null;
			return json;
		}
	}
	
	@RequestMapping("showxservice")
	@ResponseBody
	public JSONObject queryx() {
		Result result=new Result();
			try {
				ArrayList<Services> service2=serviceService.queryXService();
				result.setCode(200);
				result.setMsg(stype);
				result.setData(service2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg(stype);
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				services=null;
				return json;
			}
	}
	
	@RequestMapping("sixservice")
	@ResponseBody
	public JSONObject sixservice() {
		Result result=new Result();
			try {
				ArrayList<Services> servicess=serviceService.querySixService();
				result.setCode(200);
				result.setMsg(stype);
				result.setData(servicess);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg(stype);
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
	}
	
	
	@RequestMapping("theservice")
	@ResponseBody
	public JSONObject good(@RequestParam("sid") int sid) {
		Result result=new Result();
		serviceService.updateread(sid);
			try {
				Services ser=serviceService.queryTheService(sid);
				ArrayList<String> scontent = new ArrayList<String>();
				InputStream is = new FileInputStream("E:\\javaweb\\designer\\src\\main\\webapp\\img\\service\\"+ser.getSfile());
		        HWPFDocument doc = new HWPFDocument(is);
		        Range range = doc.getRange();
		        int paraNum = range.numParagraphs();
		        for (int i=0; i<paraNum; i++) {
		        	scontent.add(range.getParagraph(i).text());
		        }
		        ser.setScontent(scontent);
				result.setCode(200);
				result.setMsg("成功");
				result.setData(ser);
				is.close();
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
	
	public static String doc2String(FileInputStream fs) throws IOException {
		StringBuilder result = new StringBuilder();
		WordExtractor re = new WordExtractor(fs);
		result.append(re.getText());
		re.close();
		return result.toString();
	}
 
	public static String getdoc2String(File file) throws IOException {
		return doc2String(new FileInputStream(file));
	}
	
	@RequestMapping("badservice")
	@ResponseBody
	public JSONObject bad(@RequestParam("sid") int sid) {
		Result result=new Result();
			try {
				serviceService.updatebad(sid);
				result.setCode(200);
				result.setMsg("成功");
				result.setData("成功");
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
	
	@RequestMapping("comservice")
	@ResponseBody
	public JSONObject save(ServiceLink serviceLink) {
		Result result=new Result();
			try {
				serviceService.updatesave(serviceLink.getSid());
				serviceService.updateservice(serviceLink.getSid());
				serviceService.updatenum(serviceLink.getSid());
				ServiceLink serviceLink2=serviceService.selectTheServiceLink(serviceLink);
				if(serviceLink2==null) {
					serviceService.Insertservicelink(serviceLink);
				}
				result.setCode(200);
				result.setMsg("成功");
				result.setData("成功");
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
	
	@RequestMapping("goodservice")
	@ResponseBody
	public JSONObject goods(@RequestParam("sid") int sid) {
		Result result=new Result();
			try {
				serviceService.updategood(sid);
				result.setCode(200);
				result.setMsg("成功");
				result.setData("成功");
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
	
	ArrayList<Services> services3=null;
	@RequestMapping("selectmy")
	public String choosesermy(Services service) {
		try {
			services3=serviceService.querySomeMyService(service);
			return "redirect:/manage/service.html";
		}catch (Exception e) {
			return "redirect:/manage/service.html";
		}
	}
	
	@RequestMapping("showmyservice")
	@ResponseBody
	public JSONObject querymy(@RequestParam("uid")int uid) {
		Result result=new Result();
		if(services3==null) {
			try {
				services3=serviceService.queryAllMyService(uid);
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(services3);
				JSONObject json=JSONObject.fromObject(result);
				services3=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				services3=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(services3);
			JSONObject json=JSONObject.fromObject(result);
			services3=null;
			return json;
		}
	}
	
	@RequestMapping("themyservice")
	@ResponseBody
	public JSONObject themyservice(@RequestParam("sid") int sid) {
		Result result=new Result();
			try {
				ServicesMy ser=serviceService.queryTheMy(sid);
				result.setCode(200);
				result.setMsg("成功");
				result.setData(ser);
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
	
	@RequestMapping("serviceuser")
	@ResponseBody
	public JSONObject showuser(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			ArrayList<User> users=serviceService.queryUser(uid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(users);
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
	
	@RequestMapping("themyteam")
	@ResponseBody
	public JSONObject shows(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			TeamSci team=serviceService.queryTheTeam2(uid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(team);
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
	
	String spic="";
	@RequestMapping("servicepic")
	@ResponseBody
	public JSONObject servicepic(@RequestParam("file") MultipartFile file) {
		Result result=new Result();
		try {
			InputStream input=file.getInputStream();
			String filename=file.getOriginalFilename();
			spic=filename;
			OutputStream out=new FileOutputStream("E:\\javaweb\\designer\\src\\main\\webapp\\img\\service\\"+filename);
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
	
	String sfile="";
	@RequestMapping("servicefile")
	@ResponseBody
	public JSONObject servicefile(@RequestParam("file") MultipartFile file) {
		Result result=new Result();
		try {
			InputStream input=file.getInputStream();
			String filename=file.getOriginalFilename();
			sfile=filename;
			OutputStream out=new FileOutputStream("E:\\javaweb\\designer\\src\\main\\webapp\\img\\service\\"+filename);
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
	
	@RequestMapping("newservice")
	@ResponseBody
	public JSONObject newservice(Services services) {
		Result result=new Result();
		try {
			services.setSread(0);
			services.setSsave(1);
			services.setSbad(0);
			services.setSservice(1);
			services.setSgood(0);
			services.setSnum(1);
			services.setStatus(0);
			Date date=new Date();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String sctime=simpleDateFormat.format(date);
			services.setSctime(sctime);
			services.setSpic(spic);
			services.setSfile(sfile);
			services.setSstate("进行中");
			services.setTeam(new TeamSci());
			serviceService.InsertService(services);
			result.setCode(200);
			result.setMsg("新增成功");
			result.setData(services);
			JSONObject json=JSONObject.fromObject(result);
			spic="";
			sfile="";
			return json;
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			spic="";
			sfile="";
			return json;
		}
	}
	
	@RequestMapping("deleteservice")
	@ResponseBody
	public JSONObject deleteservice(@RequestParam("sid") int sid) {
		Result result=new Result();
		try {
			serviceService.deleteService(sid);
			result.setCode(200);
			result.setMsg("删除成功");
			result.setData(sid);
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
	
	@RequestMapping("upservice")
	@ResponseBody
	public JSONObject upservice(@RequestParam("sid") int sid) {
		Result result=new Result();
		try {
			serviceService.updatestatus(sid);
			result.setCode(200);
			result.setMsg("已通过");
			result.setData(sid);
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
	
	@RequestMapping("editerservice")
	@ResponseBody
	public JSONObject editerservice(Services services) {
		Result result=new Result();
		try {
			services.setSfile(sfile);
			services.setSpic(spic);
			services.setTeam(new TeamSci());
			serviceService.editerservice(services);
			result.setCode(200);
			result.setMsg("更新成功");
			result.setData(services);
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
