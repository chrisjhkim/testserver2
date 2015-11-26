package com.bit2015.testserver2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.testserver2.dao.GroupDao;
import com.bit2015.testserver2.vo.GroupVo;

@Service
public class GroupService {
	@Autowired
	GroupDao groupDao;
	
	/**
	 * @param groupVo (groupName, groupType 필요)
	 */
	public void createGroup( GroupVo groupVo ) {
		groupDao.insertGroup(groupVo);
		
	}
	
	/**
	 * @return 모든 groupVo 의  List
	 */
	public List<GroupVo> getGroupListAll( ) {
		List<GroupVo> retList = null;
		retList = groupDao.getGroupListAll();
		return retList;
	}

}
