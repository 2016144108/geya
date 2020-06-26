package com.example.designer.mapper;

import com.example.designer.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	
	@Select("select * from user where uid=#{uid}")
	public User queryTheUser(int uid);
	
	@Select("select * from user where utelephone=#{utelephone}")
	public User queryTelUser(User user);
	
	@Select("select * from user where uqq=#{uqq}")
	public User queryQqUser(User user);
	
	public void editeruser(User user);
	
	@Select("select count(*) from lesson")
	public int countlesson();
	
	@Select("select count(*) from teacher")
	public int countteacher();
	
	@Select("select count(*) from team")
	public int countteam();
	
	@Select("select count(*) from service where status=1")
	public int countservice();
	
	@Select("select count(*) from science where status=1")
	public int countscience();
	
	@Select("select * from user where utelephone=#{utelephone} and upassword=#{upassword} and uma=#{uma}")
	public User login(User user);
	
}