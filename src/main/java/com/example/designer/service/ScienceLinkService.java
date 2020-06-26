package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.ScienceLinkMapper;
import com.example.designer.pojo.Science;
import com.example.designer.pojo.ScienceLink;
import org.springframework.stereotype.Service;

@Service("scienceLinkService")
public class ScienceLinkService {
	
	@Resource(name="scienceLinkMapper")
	ScienceLinkMapper scienceLinkMapper;
	public ScienceLinkMapper getScienceLinkMapper() {
		return scienceLinkMapper;
	}
	public void setScienceLinkMapper(ScienceLinkMapper scienceLinkMapper) {
		this.scienceLinkMapper = scienceLinkMapper;
	}
	
	public ArrayList<ScienceLink>selectAllScienceLink (int uid){
		return scienceLinkMapper.selectAllScienceLink(uid);
	}
	
	public ArrayList<ScienceLink>queryMySciencelink (Science science){
		return scienceLinkMapper.queryMySciencelink(science);
	}
	
	public void deletesciencelink(int scid) {
		scienceLinkMapper.deletesciencelink(scid);
	}
	
	public void Insertsciencelink(ScienceLink scienceLink) {
		scienceLinkMapper.Insertsciencelink(scienceLink);
	}
	
	public ScienceLink selectTheScienceLink(ScienceLink scienceLink) {
		return scienceLinkMapper.selectTheScienceLink(scienceLink);
	}

}
