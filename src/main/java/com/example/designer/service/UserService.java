package com.example.designer.service;

import com.example.designer.mapper.UserMapper;
import com.example.designer.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService {
	
	@Resource(name="userMapper")
	UserMapper userMapper;
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User queryTheUser(int uid) {
		return userMapper.queryTheUser(uid);
	}
	
	public User queryTelUser(User user) {
		return userMapper.queryTelUser(user);
	}
	
	public User queryQqUser(User user) {
		return userMapper.queryQqUser(user);
	}
	
	public void editeruser(User user) {
		userMapper.editeruser(user);
	}

	public int countlesson() {
		return userMapper.countlesson();
	}
	
	public int countteacher() {
		return userMapper.countteacher();
	}
	
	public int countteam() {
		return userMapper.countteam();
	}
	
	public int countservice() {
		return userMapper.countservice();
	}
	
	public int countscience() {
		return userMapper.countscience();
	}

	public User login(User user) {
		return userMapper.login(user);
	}
}
