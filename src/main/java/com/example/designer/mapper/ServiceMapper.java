package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ServiceMapper {
	
	public ArrayList<Services> queryAllService();
	
	public ArrayList<Services> querySixService();

	public ArrayList<Services> querySnameService();

	public ArrayList<Services> queryTnameService();

	public ArrayList<Services> querySnumService();

	public ArrayList<Services> querySctimeService();
	
	public ArrayList<Services> querySomeService(Services services);
	
	public Services queryTheService(int sid);
	
	@Update("update service set ssave=ssave+1 where sid=#{sid}")
	public void updatesave(int sid);
	
	@Update("update service set sgood=sgood+1 where sid=#{sid}")
	public void updategood(int sid);
	
	@Update("update service set sbad=sbad+1 where sid=#{sid}")
	public void updatebad(int sid);
	
	@Update("update service set sread=sread+1 where sid=#{sid}")
	public void updateread(int sid);

	@Update("update service set sservice=sservice+1 where sid=#{sid}")
	public void updateservice(int sid);

	public ArrayList<Services> queryAllMyService(int uid);
	
	public ArrayList<Services> querySomeMyService(Services services);
	
	@Select("select * from service s,team t,user u where u.uid=s.uid and s.tid=t.tid and s.sid=#{sid}")
	public ServicesMy queryTheMy(int sid);
	
	@Select("select * from team t,user u where t.tid=u.tid and u.uid=${uid}")
	public TeamSci queryTheTeam2(int uid);
	
	@Select("select * from user u,team t where t.tid=u.tid and u.uid=#{uid}")
	public ArrayList<User> queryUser(int uid);
	
	@Insert("insert into service (uid,tid,mid,sname,spic,snum,sintro,smajor,sstime,setime,sctime,"+
	"sread,sservice,sgood,sbad,ssave,stelephone,sfile,sstate,status)"+
	" values (#{uid},#{tid},#{mid},#{sname},#{spic},#{snum},#{sintro},#{smajor},#{sstime},#{setime},"+
	"#{sctime},#{sread},#{sservice},#{sgood},#{sbad},#{ssave},#{stelephone},#{sfile},#{sstate},#{status})")
	public void InsertService(Services services);
	
	@Delete("delete from service where sid=#{sid}")
	public void deleteService(int sid);
	
	public void editerservice(Services services);
	
	@Update("update service set snum=snum+1 where sid=#{sid}")
	public void updatenum(int sid);
	
	@Insert("insert into servicelink (uid,sid) values (#{uid},#{sid})")
	public void Insertservicelink(ServiceLink serviceLink);
	
	public ServiceLink selectTheServiceLink(ServiceLink serviceLink);
	
	public ArrayList<Services> queryXService();
	
	@Update("update service set status=1 where sid=#{sid}")
	public void updatestatus(int sid);
}
