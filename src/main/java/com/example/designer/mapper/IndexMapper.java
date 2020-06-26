package com.example.designer.mapper;

import java.util.ArrayList;

import com.example.designer.pojo.School;
import com.example.designer.pojo.ScienceIndex;
import com.example.designer.pojo.Team;
import com.example.designer.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IndexMapper {
	
	public ArrayList<ScienceIndex> selectAllScience();
	
	public ArrayList<Team> selectTheTeam();
	
	public void insertUser(User user);
	
	@Select("select * from user where utelephone=#{utelephone} or uqq=#{uqq}")
	public ArrayList<User> check(User user);
	
	@Select("select * from user where utelephone=#{utelephone} and upassword=#{upassword}")
	public User login(User user);
	
	@Select("select * from user where utelephone=#{utelephone} and uma=#{uma}")
	public User loginsys(User user);
	
	@Update("update user set uma=#{uma} where uid=#{uid}")
	public void updatema(User user);
	
	@Select("select * from user where uid=#{uid}")
	public User the(int uid);
	
	@Select("select * from school limit 0,5")
	public ArrayList<School> queryall();


}
