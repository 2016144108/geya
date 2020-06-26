package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.Science;
import com.example.designer.pojo.ScienceLink;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScienceLinkMapper {

	public ArrayList<ScienceLink>selectAllScienceLink (int uid);
	
	public ArrayList<ScienceLink>queryMySciencelink (Science science);
	
	@Delete("delete from sciencelink where scid=#{scid}")
	public void deletesciencelink(int scid);
	
	@Insert("insert into sciencelink (uid,sid) values (#{uid},#{sid})")
	public void Insertsciencelink(ScienceLink scienceLink);
	
	public ScienceLink selectTheScienceLink(ScienceLink scienceLink);
}
