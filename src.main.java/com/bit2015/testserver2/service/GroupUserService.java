package com.bit2015.testserver2.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.testserver2.dao.GroupUserDao;
import com.bit2015.testserver2.vo.GroupVo;


@Service
public class GroupUserService {
	@Autowired
	GroupUserDao groupUserDao;
	
	
	/**
	 * @param userNo
	 * @param groupNo
	 * @param role
	 */
	public void joinGroup(Long userNo, Long groupNo , String role ) {
		groupUserDao.joinGroup(userNo, groupNo, role);
	}
	
	
	/**
	 * @param groupNo
	 * @return 
	 * groupNo 에 해당하는 group에 있는 userVo (+정도 조금더 ? ) 의 List
	 */
	public List<HashMap<String, Object>> getUserListOfGroupNo ( Long groupNo ) {
		List<HashMap<String, Object>> retList = null;
		retList = groupUserDao.getUserListOfGroupNo(groupNo);
		return retList	;
	}
	
	/**
	 * @param userNo
	 * @return
	 * userNo에 해당하는 user가 가입되어 있는 groupVo의  List
	 */
	public List<GroupVo> getGroupListByUserNo ( Long userNo ) {
		List<GroupVo> retList = null;
		retList = groupUserDao.getGroupListByUserNo(userNo);
		return retList;
	}
	
	public List<String> getClassNameListByUserNo ( Long userNo ) {
		List<String> retList = null;
		retList = groupUserDao.getClassNameListByUserNo(userNo);
		return retList;
	}
	
	
	/**
	 * @param userNo
	 * @return
	 * userNo에 해당하는 user가 가입되어 있는 groupVo + groupRole 의  List
	 */
	public List<HashMap<String, Object>> getGroupAndRoleListByUserNo ( Long userNo ) {
		List<HashMap<String, Object>> retList = null;
		retList = groupUserDao.getGroupAndRoleListByUserNo(userNo);
		return retList;
	}

}
