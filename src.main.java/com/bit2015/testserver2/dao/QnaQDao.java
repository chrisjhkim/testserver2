package com.bit2015.testserver2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.testserver2.vo.QnaQVo;


@Repository
public class QnaQDao {
	@Autowired
	SqlSession sqlSession;

	public void createQ(QnaQVo qVo) {
		sqlSession.insert("qna.createQ", qVo);
	}
	
	/**
	 * @param groupNo
	 * @return groupNo에서 나온 질문들 다 나옴
	 */
	public List<HashMap<String, Object>> getQListByGroupNo(Long groupNo ) {
		List<HashMap<String, Object>> retList = null;
		System.out.println("qnaQ Dao : groupNo : "+groupNo);
		retList = sqlSession.selectList("qna.getQListByGroupNo", groupNo);
		for( HashMap<String, Object> vo : retList) {
			System.out.println(vo);
		}
		System.out.println("DONE!");
		return retList;
	}
	
	public Map<String, Object> getQInfoByQNo ( Long qNo ) {
		Map<String, Object> retMap = null;
		retMap= sqlSession.selectOne("qna.getQInfoByQNo", qNo);
		return retMap;
	}
}
