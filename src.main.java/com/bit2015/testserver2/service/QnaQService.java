package com.bit2015.testserver2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.testserver2.dao.QnaQDao;
import com.bit2015.testserver2.vo.QnaQVo;

@Service
public class QnaQService {
	@Autowired
	QnaQDao qnaQDao;

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
}
