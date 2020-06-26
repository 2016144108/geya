package com.example.designer.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.example.designer.mapper.ScienceMapper;
import com.example.designer.pojo.*;
import org.springframework.stereotype.Service;

@Service("scienceService")
public class ScienceService{
	
	@Resource(name="scienceMapper")
	ScienceMapper scienceMapper;
	public ScienceMapper getScienceMapper() {
		return scienceMapper;
	}
	public void setScienceMapper(ScienceMapper scienceMapper) {
		this.scienceMapper = scienceMapper;
	}

	public ArrayList<Science> selectAllScience() {
		return scienceMapper.selectAllScience();
	}
	
	public ArrayList<Science> selectXScience() {
		return scienceMapper.selectXScience();
	}
	
	public ArrayList<Science> selectSixScience() {
		return scienceMapper.selectSixScience();
	}
	
	public ArrayList<Science> selectScienceName(){
		return scienceMapper.selectScienceName();
	}

	public ArrayList<Science> selectScienceTeam(){
		return scienceMapper.selectScienceTeam();
	}

	public ArrayList<Science> selectScienceNum(){
		return scienceMapper.selectScienceNum();
	}

	public ArrayList<Science> selectScienceTime(){
		return scienceMapper.selectScienceTime();
	}
	
	public ScienceInfo queryTheScience(int sid) {
		return scienceMapper.queryTheScience(sid);
	}

	public ArrayList<Question> selectScienceQuestion(int sid){
		return scienceMapper.selectScienceQuestion(sid);
	}
	
	public ArrayList<Question> selectNewQuestion(int sid){
		return scienceMapper.selectNewQuestion(sid);
	}

	public ArrayList<Question> selectMoreQuestion(int sid){
		return scienceMapper.selectMoreQuestion(sid);
	}
	
	public Question selectTheQuestion(int qid) {
		return scienceMapper.selectTheQuestion(qid);
	}

	public ArrayList<Comment> selectQuestionComment(int qid){
		return scienceMapper.selectQuestionComment(qid);
	}
	
	public void InsertNewComment(Comment comment) {
		scienceMapper.InsertNewComment(comment);
	}
	
	public void updatenum(int sid) {
		scienceMapper.updatenum(sid);
	}
	
	public ArrayList<Science> querySomeScience(Science science){
		return scienceMapper.querySomeScience(science);
	}
	
	public void InsertQuestion(Question question) {
		scienceMapper.InsertQuestion(question);
	}

	public ArrayList<Science> selectMyScience(int uid){
		return scienceMapper.selectMyScience(uid);
	}

	public ArrayList<Science> queryMySomeScience(Science science){
		return scienceMapper.queryMySomeScience(science);
	}
	
	public TeamSci queryTheTeam2(int uid) {
		return scienceMapper.queryTheTeam2(uid);
	}
	
	public ArrayList<User> queryUser(int uid){
		return scienceMapper.queryUser(uid);
	}
	
	public void InsertScience(Science science) {
		scienceMapper.InsertScience(science);
	}
	
	public void deleteScience(int sid) {
		scienceMapper.deleteScience(sid);
	}
	
	public void editerScience(Science science) {
		scienceMapper.editerScience(science);
	}
	
	public ArrayList<Question> selectMyQuestion(int tid){
		return scienceMapper.selectMyQuestion(tid);
	}

	public User queryTheUser(int uid) {
		return scienceMapper.queryTheUser(uid);
	}

	public void deleteQuestion(int qid) {
		scienceMapper.deleteQuestion(qid);
	}
	
	public ArrayList<Comment> selectMyComment(int tid){
		return scienceMapper.selectMyComment(tid);
	}

	public ArrayList<Comment> queryMyTheComment(Comment comment){
		return scienceMapper.queryMyTheComment(comment);
	}
	
	public void deleteComment(int cid) {
		scienceMapper.deleteComment(cid);
	}
	
	public void updatestate(Comment comment) {
		scienceMapper.updatestate(comment);
	}
	
	public void deletequestion(int sid) {
		scienceMapper.deletequestion(sid);
	}
	
	public void deletecomment(int qid) {
		scienceMapper.deletecomment(qid);
	}
	
	public void deletecomments(int sid) {
		scienceMapper.deletecomments(sid);
	}
	
	public void updatecommon(int qid) {
		scienceMapper.updatecommon(qid);
	}
	
	public void updatecommons(int qid) {
		scienceMapper.updatecommons(qid);
	}

	public Comment queryAcomment(int cid) {
		return scienceMapper.queryAcomment(cid);
	}
	
	public void updategood(int qid) {
		scienceMapper.updategood(qid);
	}
	
	public void updatebad(int qid) {
		scienceMapper.updatebad(qid);
	}
	
	public ArrayList<Question> selectAppQuestion(int sid) {
		return scienceMapper.selectAppQuestion(sid);
	}

	public ArrayList<Question> selectAllQuestion(){
		return scienceMapper.selectAllQuestion();
	}

	public ArrayList<Comment> selectAllComment(){
		return scienceMapper.selectAllComment();
	}

	public void updatestatus(int sid) {
		scienceMapper.updatestatus(sid);
	}

	public void upquestion(int qid) {
		scienceMapper.upquestion(qid);
	}
}
