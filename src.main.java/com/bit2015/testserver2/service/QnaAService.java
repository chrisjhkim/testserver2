package com.bit2015.testserver2.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.testserver2.dao.QnaADao;
import com.bit2015.testserver2.vo.QnaAVo;

@Service
public class QnaAService {
	@Autowired
	QnaADao qnaADao;
	
	public void createAPerson ( QnaAVo aVo ) {
		qnaADao.createAPerson(aVo);
	}
	
	public List<HashMap<String, Object>> getAListByUserNo (Long userNo ) {
		List<HashMap<String, Object>> retList = null;
		retList = qnaADao.getAListByUserNo(userNo);
		return retList;
	}

	public List<HashMap<String, Object>> getAListByQNo( Long qNo ) {
		List<HashMap<String, Object>> retList = null;
		retList = qnaADao.getAListByQNo(qNo);
		return retList;
	}
}
