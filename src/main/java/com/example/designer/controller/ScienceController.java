package com.example.designer.controller;

import com.example.designer.pojo.*;
import com.example.designer.service.ScienceService;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ScienceController {
	
	@Resource(name="scienceService")
	ScienceService scienceService;
	public ScienceService getScienceService() {
		return scienceService;
	}
	public void setScienceService(ScienceService scienceService) {
		this.scienceService = scienceService;
	}
	ArrayList<Science> sciences=new ArrayList<>();
	String retype="随机";
	
	@RequestMapping("sciencechoose")
	public String chooseshow(@RequestParam("type")String type) {
		retype=type;
		try {
			if(type.equals("随机")) {
				sciences=scienceService.selectAllScience();
			}else if(type.equals("服务名")) {
				sciences=scienceService.selectScienceName();
			}else if(type.equals("发布者")) {
				sciences=scienceService.selectScienceTeam();
			}else if(type.equals("人数")) {
				sciences=scienceService.selectScienceNum();
			}else if(type.equals("时间")) {
				sciences=scienceService.selectScienceTime();
			}
			return "redirect:/sciencelist.html";
		}catch (Exception e) {
			return "redirect:/sciencelist.html";
		}
	}
	
	@RequestMapping("queryscience")
	public String chooseshows(Science science) {
		try {
			sciences=scienceService.querySomeScience(science);
			return "redirect:/manage/science.html";
		}catch (Exception e) {
			System.out.println(e);
			return "redirect:/manage/science.html";
		}
	}
	
	@RequestMapping("showscilist")
	@ResponseBody
	public JSONObject queryscience() {
		Result result=new Result();
		if(sciences.isEmpty()) {
			try {
				sciences=scienceService.selectAllScience();
				result.setCode(200);
				result.setMsg(retype);
				result.setData(sciences);
				JSONObject json=JSONObject.fromObject(result);
				System.out.println(json);
				sciences=new ArrayList<>();
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg(retype);
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				sciences=new ArrayList<>();
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg(retype);
			result.setData(sciences);
			JSONObject json=JSONObject.fromObject(result);
			sciences=new ArrayList<>();
			return json;
		}
	}
	
	@RequestMapping("showxscilist")
	@ResponseBody
	public JSONObject showxscilist() {
		Result result=new Result();
			try {
				ArrayList<Science> science2s=scienceService.selectXScience();
				result.setCode(200);
				result.setMsg(retype);
				result.setData(science2s);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg(retype);
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
	}
	
	@RequestMapping("sixscience")
	@ResponseBody
	public JSONObject sixscience() {
		Result result=new Result();
			try {
				ArrayList<Science> sciencess=scienceService.selectSixScience();
				result.setCode(200);
				result.setMsg(retype);
				result.setData(sciencess);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg(retype);
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
	}
	
	@RequestMapping("thescience")
	@ResponseBody
	public JSONObject shows(@RequestParam("sid") int sid) {
		Result result=new Result();
		scienceService.updatenum(sid);
		try {
			ScienceInfo scienceInfo=scienceService.queryTheScience(sid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(scienceInfo);
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
	
	ArrayList<Question> questions=null;
	@RequestMapping("questionstyle")
	public String choosequestion(@RequestParam("style")int style,@RequestParam("sid")int sid) {
		try {
			if(style==0) {
				questions=scienceService.selectScienceQuestion(sid);
			}else if(style==1) {
				questions=scienceService.selectNewQuestion(sid);
			}else if(style==2) {
				questions=scienceService.selectMoreQuestion(sid);
			}
			return "redirect:/scienceinfo.html";
		}catch (Exception e) {
			return "redirect:/scienceinfo.html";
		}
	}
	
	@RequestMapping("question")
	@ResponseBody
	public JSONObject question(@RequestParam("sid") int sid) {
		Result result=new Result();
		if(questions==null) {
			try {
				ArrayList<Question> questions=scienceService.selectScienceQuestion(sid);
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(questions);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("出错");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(questions);
			JSONObject json=JSONObject.fromObject(result);
			return json;
		}
	}
	
	@RequestMapping("allquestion")
	@ResponseBody
	public JSONObject allquestion() {
		Result result=new Result();
			try {
				ArrayList<Question> question2=scienceService.selectAllQuestion();
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(question2);
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
	
	@RequestMapping("appquestion")
	@ResponseBody
	public JSONObject appquestion(@RequestParam("sid") int sid) {
		Result result=new Result();
			try {
				ArrayList<Question> questions=scienceService.selectAppQuestion(sid);
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(questions);
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
	
	int sid;
	@RequestMapping("thequestion")
	@ResponseBody
	public JSONObject aquestion(@RequestParam("qid") int qid) {
		Result result=new Result();
		try {
			Question question=scienceService.selectTheQuestion(qid);
			sid=question.getSid();
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(question);
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
	
	@RequestMapping("commentlist")
	@ResponseBody
	public JSONObject commentlist(@RequestParam("qid") int qid) {
		Result result=new Result();
		try {
			ArrayList<Comment> comments=scienceService.selectQuestionComment(qid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(comments);
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
	
	@RequestMapping("comments")
	@ResponseBody
	public JSONObject commentlists() {
		Result result=new Result();
		try {
			ArrayList<Comment> comments=scienceService.selectAllComment();
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(comments);
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
	
	@RequestMapping("newquestion")
	@ResponseBody
	public JSONObject questions() {
		Result result=new Result();
		try {
			ArrayList<Question> questions=scienceService.selectNewQuestion(sid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(questions);
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
	
	@RequestMapping("newcomment")
	@ResponseBody
	public JSONObject insert(Comment comment) {
		Result result=new Result();
		comment.setCstate("待批准");
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String ctime=simpleDateFormat.format(date);
		comment.setCtime(ctime);
		comment.setUser(new User());
		try {
			scienceService.InsertNewComment(comment);
			scienceService.updatecommons(comment.getQid());
			result.setCode(200);
			result.setMsg("评论成功");
			result.setData(comment);
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
	
	@RequestMapping("createque")
	@ResponseBody
	public JSONObject inserts(Question question) {
		Result result=new Result();
		question.setQbad(0);
		question.setQcommon(0);
		question.setQgood(0);
		question.setQstatus(0);
		Date date=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String qtime=simpleDateFormat.format(date);
		question.setQtime(qtime);
		question.setUser(new User());
		try {
			scienceService.InsertQuestion(question);;
			result.setCode(200);
			result.setMsg("新增成功");
			result.setData(question);
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
	
	ArrayList<Science>science3=null;
	@RequestMapping("mysci")
	public String mysci(Science science) {
		try {
			science3=scienceService.queryMySomeScience(science);
			return "redirect:/manage/science2.html";
		}catch (Exception e) {
			System.out.println(e);
			return "redirect:/manage/science2.html";
		}
	}
	
	@RequestMapping("showmyscience")
	@ResponseBody
	public JSONObject showmyscience(@RequestParam("uid")int uid) {
		Result result=new Result();
		if(science3==null) {
			try {
				science3=scienceService.selectMyScience(uid);
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(science3);
				JSONObject json=JSONObject.fromObject(result);
				science3=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				science3=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(science3);
			JSONObject json=JSONObject.fromObject(result);
			science3=null;
			return json;
		}
	}
	
	ArrayList<Question>question2s=null;
	@RequestMapping("showmyquestion")
	@ResponseBody
	public JSONObject showmyquestion(@RequestParam("uid")int uid) {
		Result result=new Result();
		if(question2s==null) {
			try {
				User user=scienceService.queryTheUser(uid);
				question2s=scienceService.selectMyQuestion(user.getTid());
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(question2s);
				JSONObject json=JSONObject.fromObject(result);
				question2s=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				question2s=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(question2s);
			JSONObject json=JSONObject.fromObject(result);
			question2s=null;
			return json;
		}
	}
	
	@RequestMapping("scienceuser")
	@ResponseBody
	public JSONObject scienceuser(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			ArrayList<User> users=scienceService.queryUser(uid);
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
	
	@RequestMapping("thescienceteam")
	@ResponseBody
	public JSONObject thescienceteam(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			TeamSci team=scienceService.queryTheTeam2(uid);
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
	@RequestMapping("sciencepic")
	@ResponseBody
	public JSONObject sciencepic(@RequestParam("file") MultipartFile file) {
		Result result=new Result();
		try {
			InputStream input=file.getInputStream();
			String filename=file.getOriginalFilename();
			spic=filename;
			OutputStream out=new FileOutputStream("E:\\javaweb\\designer\\src\\main\\webapp\\img\\science\\"+filename);
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
	
	@RequestMapping("createscience")
	@ResponseBody
	public JSONObject createscience(Science science) {
		Result result=new Result();
		try {
			science.setSnum(1);
			science.setSpic(spic);
			science.setSque(0);
			science.setStatus(0);
			Date date=new Date();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String stime=simpleDateFormat.format(date);
			science.setStime(stime);
			science.setTeam(new TeamSci());
			scienceService.InsertScience(science);
			result.setCode(200);
			result.setMsg("新增成功");
			result.setData(science);
			JSONObject json=JSONObject.fromObject(result);
			spic="";
			return json;
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			spic="";
			System.out.println(e);
			return json;
		}
	}
	
	@RequestMapping("deletescience")
	@ResponseBody
	public JSONObject deletescience(@RequestParam("sid") int sid) {
		Result result=new Result();
		try {
			scienceService.deletecomments(sid);
			scienceService.deletequestion(sid);
			scienceService.deleteScience(sid);
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
	
	@RequestMapping("upscience")
	@ResponseBody
	public JSONObject upscience(@RequestParam("sid") int sid) {
		Result result=new Result();
		try {
			scienceService.updatestatus(sid);
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
	
	@RequestMapping("upquestion")
	@ResponseBody
	public JSONObject upquestion(@RequestParam("qid") int qid) {
		Result result=new Result();
		try {
			scienceService.upquestion(qid);
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
	
	@RequestMapping("editerscience")
	@ResponseBody
	public JSONObject editerscience(Science science) {
		Result result=new Result();
		try {
			science.setSpic(spic);
			science.setTeam(new TeamSci());
			scienceService.editerScience(science);
			result.setCode(200);
			result.setMsg("更新成功");
			result.setData(science);
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
	
	@RequestMapping("deletequestion")
	@ResponseBody
	public JSONObject deletequestion(@RequestParam("qid") int qid) {
		Result result=new Result();
		try {
			scienceService.deletecomment(qid);
			scienceService.deleteQuestion(qid);
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
	
	ArrayList<Comment>comments=null;
	@RequestMapping("mycom")
	public String mycom(Comment comment) {
		try {
			User user=scienceService.queryTheUser(comment.getCid());
			comment.setCid(user.getTid());
			comments=scienceService.queryMyTheComment(comment);
			return "redirect:/manage/commons.html";
		}catch (Exception e) {
			return "redirect:/manage/commons.html";
		}
	}
	
	@RequestMapping("showmycomment")
	@ResponseBody
	public JSONObject showmycomment(@RequestParam("uid")int uid) {
		Result result=new Result();
		if(comments==null) {
			try {
				User user=scienceService.queryTheUser(uid);
				comments=scienceService.selectMyComment(user.getTid());
				result.setCode(200);
				result.setMsg("查询成功");
				result.setData(comments);
				JSONObject json=JSONObject.fromObject(result);
				comments=null;
				return json;
			}catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				System.out.println(e);
				JSONObject json=JSONObject.fromObject(result);
				comments=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(comments);
			JSONObject json=JSONObject.fromObject(result);
			comments=null;
			return json;
		}
	}

	@RequestMapping("deletecomment")
	@ResponseBody
	public JSONObject deletecomment(@RequestParam("cid") int cid) {
		Result result=new Result();
		try {
			Comment comment2=scienceService.queryAcomment(cid);
			scienceService.updatecommon(comment2.getQid());
			scienceService.deleteComment(cid);
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
	
	@RequestMapping("setcomment")
	@ResponseBody
	public JSONObject setcomment(Comment comment) {
		Result result=new Result();
		try {
			if(comment.getCstate().contains("拒绝")) {
				comment.setCstate("待批准");
			}else {
				comment.setCstate("已通过");
			}
			scienceService.updatestate(comment);
			result.setCode(200);
			result.setMsg("成功");
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
	
	@RequestMapping("badquestion")
	@ResponseBody
	public JSONObject badquestion(@RequestParam("qid") int qid) {
		Result result=new Result();
			try {
				scienceService.updatebad(qid);
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
	
	@RequestMapping("goodquestion")
	@ResponseBody
	public JSONObject goodquestion(@RequestParam("qid") int qid) {
		Result result=new Result();
			try {
				scienceService.updategood(qid);
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
}
