package com.bit2015.testserver2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.testserver2.dao.ClassDao;
import com.bit2015.testserver2.dao.QnaQDao;
import com.bit2015.testserver2.dao.UserDao;
import com.bit2015.testserver2.vo.QnaQVo;
import com.bit2015.testserver2.vo.YjQVo;

@Service
public class QnaQService {
	@Autowired
	QnaQDao qnaQDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ClassDao classDao;

	public void createQ( QnaQVo qVo ) {
		qnaQDao.createQ(qVo);
	}
	
	public List<HashMap<String, Object>> getQListByGroupNo(Long groupNo ) {
		List<HashMap<String, Object>> retList = null;
		retList = qnaQDao.getQListByGroupNo(groupNo);
		
		return retList;
	}
	
	public Map<String, Object> getQInfoByQNo (Long qNo ) {
		Map<String, Object> retMap= null;
		retMap = qnaQDao.getQInfoByQNo(qNo);
		return retMap;
	}
	
	public boolean insertQ( YjQVo preQVo ) {
		boolean retFlag = false;
		QnaQVo postQVo = new QnaQVo();
		postQVo.setToWhoNo( userDao.getUserNoViaUserId(preQVo.getReceiverId()) );//TODO 이거 다 지우고 따로 빼자
		postQVo.setFromUserNo(userDao.getUserNoViaUserId(preQVo.getSenderId()));
		postQVo.setqMessage(preQVo.getMessage());
		postQVo.setClassNo(classDao.getClassNoViaClassNameTemp(preQVo.getLesson()) );
		postQVo.setqType("StuToTea");
		postQVo.setqRef("-");
		
		System.out.println("@QnaQService : postQVo : "+postQVo);
		retFlag = qnaQDao.insertQ(postQVo);
		
		
		return retFlag;
	}
}
