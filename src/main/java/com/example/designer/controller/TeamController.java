package com.example.designer.controller;

import com.example.designer.pojo.*;
import com.example.designer.service.TeamService;
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
public class TeamController {
	
	@Resource(name="teamService")
	TeamService teamService;
	public TeamService getTeamService() {
		return teamService;
	}
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	
	ArrayList<Team>teams=null;
	
	@RequestMapping("querysome")
	public String querythe(Team team) {
		System.out.println(team);
		try {
			teams=teamService.querySomeTeam(team);
			return "redirect:/teamlist.html";
		}catch (Exception e) {
			return "redirect:/teamlist.html";
		}
	}
	
	@RequestMapping("querysome2")
	public String querythe2(Team team) {
		System.out.println(team);
		try {
			teams=teamService.querySomeTeam(team);
			return "redirect:/manage/team.html";
		}catch (Exception e) {
			return "redirect:/manage/team.html";
		}
	}
	
	@RequestMapping("showteams")
	@ResponseBody
	public JSONObject queryall() {
		Result result=new Result();
		if(teams==null) {
			try {
				teams=teamService.queryAllTeam();
				result.setCode(200);
				result.setMsg("成功");
				result.setData(teams);
				JSONObject json=JSONObject.fromObject(result);
				teams=null;
				return json;
			} catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				teams=null;
				return json;
			}
		}else {
			result.setCode(200);
			result.setMsg("成功");
			result.setData(teams);
			JSONObject json=JSONObject.fromObject(result);
			teams=null;
			return json;
		}
	}
	
	@RequestMapping("sixteams")
	@ResponseBody
	public JSONObject sixteams() {
		Result result=new Result();
			try {
				ArrayList<Team> teamss=teamService.querySixTeam();
				result.setCode(200);
				result.setMsg("成功");
				result.setData(teamss);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			} catch (Exception e) {
				result.setCode(400);
				result.setMsg("错误");
				result.setData(e);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}
	}
	
	@RequestMapping("theteam")
	@ResponseBody
	public JSONObject shows(@RequestParam("tid") int tid) {
		Result result=new Result();
		try {
			Team team=teamService.queryTheTeam(tid);
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
	
	@RequestMapping("teamuser")
	@ResponseBody
	public JSONObject showuser(@RequestParam("tid") int tid) {
		Result result=new Result();
		try {
			ArrayList<User> users=teamService.queryUser(tid);
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
	
	@RequestMapping("teamservice")
	@ResponseBody
	public JSONObject showservice(@RequestParam("tid") int tid) {
		Result result=new Result();
		try {
			ArrayList<Services> services=teamService.queryAllService(tid);
			result.setCode(200);
			result.setMsg("查询成功");
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
	
	@RequestMapping("teamscience")
	@ResponseBody
	public JSONObject teamscience(@RequestParam("tid") int tid) {
		Result result=new Result();
		try {
			ArrayList<Science> sciences=teamService.queryAllScience(tid);
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
	
	@RequestMapping("teamstory")
	@ResponseBody
	public JSONObject showstory(@RequestParam("tid") int tid) {
		Result result=new Result();
		try {
			ArrayList<Story> stories=teamService.queryAllStory(tid);
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(stories);
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
	
	@RequestMapping("jointeaim")
	@ResponseBody
	public JSONObject jointeaim(User user) {
		Result result=new Result();
		try {
			User user2=teamService.queryTheUser(user.getUid());
			if(user2.getTid()==0) {
				teamService.updatetid(user);
				result.setCode(200);
				result.setMsg("加入团队成功");
				result.setData(user2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				result.setCode(400);
				result.setMsg("已拥有团队，无法加入");
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
	
	@RequestMapping("theteam2")
	@ResponseBody
	public JSONObject shows2(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			User user=teamService.queryTheUser(uid);
			Team team=teamService.queryTheTeam(user.getTid());
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
	
	@RequestMapping("teamuser2")
	@ResponseBody
	public JSONObject showuser2(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			User user=teamService.queryTheUser(uid);
			ArrayList<User> users=teamService.queryUser(user.getTid());
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
	
	@RequestMapping("teamservice2")
	@ResponseBody
	public JSONObject showservice2(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			User user=teamService.queryTheUser(uid);
			ArrayList<Services> services=teamService.queryAllService(user.getTid());
			result.setCode(200);
			result.setMsg("查询成功");
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
	
	@RequestMapping("teamstory2")
	@ResponseBody
	public JSONObject showstory2(@RequestParam("uid") int uid) {
		Result result=new Result();
		try {
			User user=teamService.queryTheUser(uid);
			ArrayList<Story> stories=teamService.queryAllStory(user.getTid());
			result.setCode(200);
			result.setMsg("查询成功");
			result.setData(stories);
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
	
	@RequestMapping("deleuser")
	@ResponseBody
	public JSONObject deleuser(@RequestParam("uid") int uid,@RequestParam("id") int id) {
		Result result=new Result();
		try {
			TeamSci team=teamService.queryTheTeam2(id);
			if(team.getUid()!=id) {
				result.setCode(400);
				result.setMsg("没有权限");
				result.setData(team);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				if(team.getUid()==uid) {
					result.setCode(400);
					result.setMsg("负责人无法删除");
					result.setData(team);
					JSONObject json=JSONObject.fromObject(result);
					return json;
				}else {
					User users=new User();
					users.setUid(uid);
					users.setTid(0);
					teamService.updatetid(users);
					result.setCode(200);
					result.setMsg("删除成功");
					result.setData(users);
					JSONObject json=JSONObject.fromObject(result);
					return json;
				}
			}
		}catch (Exception e) {
			result.setCode(400);
			result.setMsg("出错");
			result.setData(e);
			JSONObject json=JSONObject.fromObject(result);
			return json;
		}
	}
	
	@RequestMapping("exitteam")
	@ResponseBody
	public JSONObject exitteam(Team team) {
		Result result=new Result();
		try {
			TeamSci team2=teamService.queryTheTeam2(team.getUid());
			if(team2.getUid()!=team.getUid()) {
				result.setCode(400);
				result.setMsg("没有权限");
				result.setData(team2);
				JSONObject json=JSONObject.fromObject(result);
				return json;
			}else {
				team.setTid(team2.getTid());
				teamService.updateteam(team);
				result.setCode(200);
				result.setMsg("更新成功");
				result.setData(team2);
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
	
	String tpic="";
	@RequestMapping("teamload")
	@ResponseBody
	public JSONObject teamload(@RequestParam("file") MultipartFile file) {
		Result result=new Result();
		try {
			InputStream input=file.getInputStream();
			String filename=file.getOriginalFilename();
			tpic=filename;
			OutputStream out=new FileOutputStream("E:\\javaweb\\designer\\src\\main\\webapp\\img\\team\\"+filename);
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
	
	@RequestMapping("insertteam")
	@ResponseBody
	public JSONObject insertteam(Team team) {
		Result result=new Result();
		try {
			User user2=teamService.queryTheUser(team.getUid());
			team.setTnum(1);
			team.setTpic(tpic);
			team.setTschool(user2.getUschool());
			team.setUser(new User());
			teamService.InsertTeam(team);
			User user=new User();
			user.setTid(team.getTid());
			user.setUid(team.getUid());
			teamService.updatetid(user);
			result.setCode(200);
			result.setMsg("新增成功");
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
}
