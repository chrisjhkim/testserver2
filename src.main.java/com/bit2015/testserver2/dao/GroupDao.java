package com.bit2015.testserver2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.testserver2.vo.GroupVo;

@Repository
public class GroupDao {
	@Autowired
	SqlSession sqlSession;
	
	
	/**
	 * @param groupVo (groupName,groupType 필요)
	 */
	public void insertGroup ( GroupVo groupVo ) {
		System.out.println("@GroupDao : groupVo : "+groupVo);
		sqlSession.selectOne("group.insert", groupVo);
	}
	
	/**
	 * @return 모든 groupVo 의 List
	 */
	public List<GroupVo> getGroupListAll ( )  {
		List<GroupVo> retList = null;
		retList = sqlSession.selectList("group.getGroupListAll");
		return retList;
	}

}
