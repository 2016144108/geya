package com.example.designer.mapper;

import com.example.designer.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface ScienceMapper {
	
	public ArrayList<Science> selectAllScience();

	public ArrayList<Science> selectXScience();
	
	public ArrayList<Science> selectSixScience();

	public ArrayList<Science> selectScienceName();

	public ArrayList<Science> selectScienceTeam();

	public ArrayList<Science> selectScienceNum();

	public ArrayList<Science> selectScienceTime();

	public ArrayList<Science> querySomeScience(Science science);
	
	@Select("select * from science s,user u,team t where s.uid=u.uid and s.tid=t.tid and s.sid=#{sid}")
	public ScienceInfo queryTheScience(int sid);
	
	public ArrayList<Question> selectScienceQuestion(int sid);
	
	public ArrayList<Question> selectNewQuestion(int sid);

	public ArrayList<Question> selectMoreQuestion(int sid);
	
	public Question selectTheQuestion(int qid);

	public ArrayList<Comment> selectQuestionComment(int qid);
	
	@Insert("insert into comment (uid,qid,ccontent,ctime,cstate) values (#{uid},#{qid},#{ccontent},#{ctime},#{cstate})")
	public void InsertNewComment(Comment comment);

	@Update("update science set snum=snum+1 where sid=#{sid}")
	public void updatenum(int sid);
	
	@Insert("insert into question (uid,sid,qname,qtime,qgood,qbad,qcommon,qcontent,qstatus) values (#{uid},#{sid},#{qname},#{qtime},#{qgood},#{qbad},#{qcommon},#{qcontent},#{qstatus})")
	public void InsertQuestion(Question question);
	
	public ArrayList<Science> selectMyScience(int uid);

	public ArrayList<Science> queryMySomeScience(Science science);
	
	@Select("select * from team t,user u where t.tid=u.tid and u.uid=#{uid}")
	public TeamSci queryTheTeam2(int uid);
	
	@Select("select * from user u,team t where t.tid=u.tid and u.uid=#{uid}")
	public ArrayList<User> queryUser(int uid);
	
	@Insert("insert into science (uid,tid,mid,sname,spic,snum,sintro,smajor,stime,stelephone,status)"+
	" values (#{uid},#{tid},#{mid},#{sname},#{spic},#{snum},#{sintro},#{smajor},#{stime},#{stelephone},#{status})")
	public void InsertScience(Science science);
	
	@Delete("delete from science where sid=#{sid}")
	public void deleteScience(int sid);
	
	public void editerScience(Science science);
	
	public ArrayList<Question> selectMyQuestion(int tid);
	
	@Select("select * from user where uid=#{uid}")
	public User queryTheUser(int uid);
	
	@Delete("delete from question where qid=#{qid}")
	public void deleteQuestion(int qid);

	public ArrayList<Comment> selectMyComment(int tid);

	public ArrayList<Comment> queryMyTheComment(Comment comment);
	
	@Delete("delete from comment where cid=#{cid}")
	public void deleteComment(int cid);
	
	@Update("update comment set cstate=#{cstate} where cid=#{cid}")
	public void updatestate(Comment comment);
	
	@Delete("delete from question where sid=#{sid}")
	public void deletequestion(int sid);
	
	@Delete("delete from comment where qid=#{qid}")
	public void deletecomment(int qid);
	
	@Delete("delete comment from comment,question,science where question.sid=science.sid and comment.qid=question.qid and science.sid=#{sid}")
	public void deletecomments(int sid);
	
	@Update("update question set qcommon=qcommon-1 where qid=#{qid}")
	public void updatecommon(int qid);
	
	@Update("update question set qcommon=qcommon+1 where qid=#{qid}")
	public void updatecommons(int qid);
	
	@Select("select * from comment where cid=#{cid}")
	public Comment queryAcomment(int cid);
	
	@Update("update question set qgood=qgood+1 where qid=#{qid}")
	public void updategood(int qid);
	
	@Update("update question set qbad=qbad+1 where qid=#{qid}")
	public void updatebad(int qid);
	
	public ArrayList<Question> selectAppQuestion(int sid);
	
	public ArrayList<Question> selectAllQuestion();
	
	public ArrayList<Comment> selectAllComment();
	
	@Update("update science set status=1 where sid=#{sid}")
	public void updatestatus(int sid);
	
	@Update("update question set qstatus=1 where qid=#{qid}")
	public void upquestion(int qid);
	
}
