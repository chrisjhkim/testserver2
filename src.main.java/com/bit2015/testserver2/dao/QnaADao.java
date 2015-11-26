package com.bit2015.testserver2.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.testserver2.vo.QnaAVo;

@Repository
public class QnaADao {
	@Autowired
	SqlSession sqlSession;
	
	public void createAPerson ( QnaAVo aVo ) {
		System.out.println("@dao aVo : "+aVo);
		sqlSession.insert("qna.createAPerson", aVo);
		System.out.println("DONE!");
	}
	
	public List<HashMap<String, Object>> getAListByUserNo( Long userNo ) {
		List<HashMap<String, Object>> retList = null;
		//retList = sqlSession.selectList("qna.getAListByUserNo", userNo);
		return retList;
	}
	
	public List<HashMap<String, Object>> getAListByQNo( Long qNo ) {
		List<HashMap<String, Object>> retList = null;
		retList = sqlSession.selectList("qna.getAListByQNo", qNo );
		return retList;
	}

}
