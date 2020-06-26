package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.ServiceMapper;
import com.example.designer.pojo.*;
import org.springframework.stereotype.Service;

@Service("serviceService")
public class ServiceService {
	
	@Resource(name="serviceMapper")
	ServiceMapper serviceMapper;
	public ServiceMapper getServiceMapper() {
		return serviceMapper;
	}
	public void setServiceMapper(ServiceMapper serviceMapper) {
		this.serviceMapper = serviceMapper;
	}
	
	public ArrayList<Services> queryAllService(){
		return serviceMapper.queryAllService();
	}
	
	public ArrayList<Services> querySixService(){
		return serviceMapper.querySixService();
	}

	public ArrayList<Services> querySnameService(){
		return serviceMapper.querySnameService();
	}

	public ArrayList<Services> queryTnameService(){
		return serviceMapper.queryTnameService();
	}

	public ArrayList<Services> querySnumService(){
		return serviceMapper.querySnumService();
	}

	public ArrayList<Services> querySctimeService(){
		return serviceMapper.querySctimeService();
	}

	public Services queryTheService(int sid) {
		return serviceMapper.queryTheService(sid);
	}
	
	public void updatesave(int sid) {
		serviceMapper.updatesave(sid);
	}

	public void updategood(int sid) {
		serviceMapper.updategood(sid);
	}
	
	public void updatebad(int sid) {
		serviceMapper.updatebad(sid);
	}
	
	public void updateread(int sid) {
		serviceMapper.updateread(sid);
	}

	public void updateservice(int sid) {
		serviceMapper.updateservice(sid);
	}

	public ArrayList<Services> querySomeService(Services services){
		return serviceMapper.querySomeService(services);
	}
	
	public ArrayList<Services> queryAllMyService(int uid){
		return serviceMapper.queryAllMyService(uid);
	}
	
	public ArrayList<Services> querySomeMyService(Services services){
		return serviceMapper.querySomeMyService(services);
	}

	public ServicesMy queryTheMy(int sid) {
		return serviceMapper.queryTheMy(sid);
	}

	public TeamSci queryTheTeam2(int uid) {
		return serviceMapper.queryTheTeam2(uid);
	}
	
	public ArrayList<User> queryUser(int uid){
		return serviceMapper.queryUser(uid);
	}
	
	public void InsertService(Services services) {
		serviceMapper.InsertService(services);
	}
	
	public void deleteService(int sid) {
		serviceMapper.deleteService(sid);
	}

	public void editerservice(Services services) {
		serviceMapper.editerservice(services);
	}
	
	public void updatenum(int sid) {
		serviceMapper.updatenum(sid);
	}
	
	public void Insertservicelink(ServiceLink serviceLink) {
		serviceMapper.Insertservicelink(serviceLink);
	}
	
	public ServiceLink selectTheServiceLink(ServiceLink serviceLink) {
		return serviceMapper.selectTheServiceLink(serviceLink);
	}
	
	public ArrayList<Services> queryXService(){
		return serviceMapper.queryXService();
	}
	
	public void updatestatus(int sid) {
		serviceMapper.updatestatus(sid);
	}
}
