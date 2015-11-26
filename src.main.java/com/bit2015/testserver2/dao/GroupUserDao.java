package com.bit2015.testserver2.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.testserver2.vo.GroupVo;

@Repository
public class GroupUserDao {
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * @param userNo
	 * @param groupNo
	 * @param role
	 */
	public void joinGroup(Long userNo, Long groupNo , String role ) {
		HashMap<String, Object> insertMap = new HashMap<String, Object>();
		insertMap.put("userNo", userNo);
		insertMap.put("groupNo",groupNo);
		insertMap.put("role", role);
		sqlSession.insert("group.joinGroup", insertMap);
	}

	
	
	
	/**
	 * @param groupNo
	 * @return 
	 * groupNo 에 해당하는 group에 있는 userVo (+정도 조금더 ? ) 의 List
	 */
	public List<HashMap<String, Object>> getUserListOfGroupNo ( Long groupNo ) {
		List<HashMap<String, Object>> retList = null;
		retList = sqlSession.selectList("group.getUserListOfGroupNo", groupNo);
		return retList;
	}
	
	/**
	 * @param userNo
	 * @return
	 * userNo에 해당하는 user가 가입되어 있는 groupVo의  List
	 */
	public List<GroupVo> getGroupListByUserNo (Long userNo ) {
		List<GroupVo> retList = null;
		retList = sqlSession.selectList("group.getGroupListByUserNo", userNo);
		return retList;
	}
	
	public List<String> getClassNameListByUserNo ( Long userNo ) {
		List<String> retList = null;
		retList = sqlSession.selectList("group.getClassNameListByUserNo", userNo);
		return retList;
		
	}
	/**
	 * @param userNo
	 * @return
	 * userNo에 해당하는 user가 가입되어 있는 groupVo + groupRole 의  List
	 */
	public List<HashMap<String, Object>> getGroupAndRoleListByUserNo (Long userNo ) {
		List<HashMap<String, Object>> retList = null;
		retList = sqlSession.selectList("group.getGroupAndRoleListByUserNo", userNo);
		return retList;
	}
	
	
}
