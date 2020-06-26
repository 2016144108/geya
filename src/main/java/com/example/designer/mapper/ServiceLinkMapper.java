package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.ServiceLink;
import com.example.designer.pojo.Services;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceLinkMapper {

	public ArrayList<ServiceLink>selectAllServiceLink (int uid);
	
	public ArrayList<ServiceLink>queryMyServicelink (Services services);
	
	@Delete("delete from servicelink where seid=#{seid}")
	public void deleteservicelink(int seid);
	
	@Insert("insert into servicelink (uid,sid) values (#{uid},#{sid})")
	public void Insertservicelink(ServiceLink serviceLink);
	
	public ServiceLink selectTheServiceLink(ServiceLink serviceLink);
}
