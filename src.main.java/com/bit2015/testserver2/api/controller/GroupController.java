package com.bit2015.testserver2.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.testserver2.service.GroupService;
import com.bit2015.testserver2.vo.GroupVo;

@Controller("groupAPIController")
@RequestMapping("/api/group")
public class GroupController {
	@Autowired
	GroupService groupService;
	
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
	
	

}
