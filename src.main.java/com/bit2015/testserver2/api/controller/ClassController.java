package com.bit2015.testserver2.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.testserver2.service.GroupUserService;
import com.bit2015.testserver2.vo.GroupVo;


@Controller("classAPIController")
@RequestMapping("/api/class")
public class ClassController {
	@Autowired
	GroupUserService groupUserService;
	
	
	@ResponseBody
	@RequestMapping(value="/classlist-by-userno")
	public Map<String, Object> login(
			@RequestParam(value="userNo", required=true)Long userNo ){
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		System.out.println("class");
		System.out.println("userNo : "+userNo);
		
		String resString ="fail";
		
		List<GroupVo> groupList = groupUserService.getGroupListByUserNo(userNo);
		if(groupList== null ){
			resString = "fail";
			retMap.put("message", "그룹이 비어있음");
		}
		else{
			resString="success";
			retMap.put("data", groupList);
		}
		retMap.put("result", resString);
		return retMap;
	}
	

}
