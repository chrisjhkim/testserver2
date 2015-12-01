package com.bit2015.testserver2.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.testserver2.service.GroupService;
import com.bit2015.testserver2.service.GroupUserService;
import com.bit2015.testserver2.service.UserService;
import com.bit2015.testserver2.vo.ClassVo;
import com.bit2015.testserver2.vo.GroupVo;
import com.bit2015.testserver2.vo.UserVo;

@Controller("groupAPIController")
@RequestMapping("/api/group")
public class GroupController {
	@Autowired
	GroupService groupService;
	@Autowired
	GroupUserService groupUserService;
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping("/insert-group") 
	public String insertGroup( 
			@RequestParam(value="groupName", required=true)String groupName,
			@RequestParam(value="groupType",required=true)String groupType ) {
		GroupVo groupVo = new GroupVo();
		groupVo.setGroupName(groupName);
		groupVo.setGroupType(groupType);
		groupService.createGroup(groupVo);
		return "@APIgroupController /insert-group!!";
	}
	
	@ResponseBody
	@RequestMapping(value="/classlist")
	public Map<String, Object> getClassListByUserId(
//			@RequestParam(value="userId", required=true)String userId
			@RequestBody UserVo userVo
			){
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		
		System.out.println("classList by userId ");
		//System.out.println("userId : "+userVo.getUserId());
		String resString ="fail";
		
		System.out.println("userVo : "+userVo);
		userService.getUserNoViaUserId(  userVo.getUserId()  );
		List<String> groupList = groupUserService.getClassNameListByUserNo( userService.getUserNoViaUserId(  userVo.getUserId()  ) );
		
//		List<String> groupList = groupUserService.getClassNameListByUserNo( userService.getUserNoViaUserId(  userId  ) );
		System.out.println("groupList : "+groupList);
		if(groupList== null ){
			resString = "fail";
		}
		else{
			resString="success";
			retMap.put("data", groupList);
		}
		retMap.put("result", resString);
		return retMap;
	}

}
