package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.ServiceLinkMapper;
import com.example.designer.pojo.ServiceLink;
import com.example.designer.pojo.Services;
import org.springframework.stereotype.Service;

@Service("serviceLinkService")
public class ServiceLinkService {
	
	@Resource(name="serviceLinkMapper")
	ServiceLinkMapper serviceLinkMapper;
	public ServiceLinkMapper getServiceLinkMapper() {
		return serviceLinkMapper;
	}
	public void setServiceLinkMapper(ServiceLinkMapper serviceLinkMapper) {
		this.serviceLinkMapper = serviceLinkMapper;
	}

	public ArrayList<ServiceLink>selectAllServiceLink (int uid){
		return serviceLinkMapper.selectAllServiceLink(uid);
	}
	
	public ArrayList<ServiceLink>queryMyServicelink (Services services){
		return serviceLinkMapper.queryMyServicelink(services);
	}
	
	public void deleteservicelink(int seid) {
		serviceLinkMapper.deleteservicelink(seid);
	}
	
	public void Insertservicelink(ServiceLink serviceLink) {
		serviceLinkMapper.Insertservicelink(serviceLink);
	}
	
	public ServiceLink selectTheServiceLink(ServiceLink serviceLink) {
		return serviceLinkMapper.selectTheServiceLink(serviceLink);
	}

}
