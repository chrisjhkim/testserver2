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



import com.bit2015.testserver2.service.ClassService;
import com.bit2015.testserver2.service.GroupUserService;
import com.bit2015.testserver2.vo.GroupVo;
import com.bit2015.testserver2.vo.UserVo;


@Controller("classAPIController")
@RequestMapping("/api/class")
public class ClassController {
	@Autowired
	GroupUserService groupUserService;
	
	@Autowired
	ClassService classService;
	
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
	
	@ResponseBody
	@RequestMapping(value="/classinfo-by-userid")
	public Map<String , Object> getClassInfoViaUserId (
			@RequestBody UserVo userVo ){
//			@RequestParam(value="userId", required=false)String userId){
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		
		System.out.println("ClassController : classinfo by userId / userVo : "+userVo);
		String resString ="fail";

		if(userVo== null){
			retMap.put("message", "userVo is null");
		}
		else {
			List<HashMap<String, Object>> classInfoList = classService.getClassInfoByUserId(userVo.getUserId());
			if(classInfoList== null ){
				resString = "fail";
				retMap.put("message", "group is empty");
			}
			else{
				resString="success";
				retMap.put("data", classInfoList);
			}
		}
		retMap.put("result", resString);
		System.out.println("retMap :"+ retMap);
	
		return retMap;
	}
	

	@ResponseBody
	@RequestMapping(value="/class-name-and-no")
	public Map<String , Object> getClassNameAndNoViaUserId (
			@RequestBody UserVo userVo ){
//			@RequestParam(value="userId", required=false)String userId){
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		
		System.out.println("ClassController : classinfo by userId / userVo : "+userVo);
//		System.out.println("ClassController : classinfo by userId / userId : "+userId);
		
		String resString ="fail";

//		if(userId == null){
		if(userVo== null){
			retMap.put("message", "userVo is null");
		}
		else {
			List<HashMap<String, Object>> classInfoList = classService.getClassNameAndNoByUserId(userVo.getUserId());
//			List<HashMap<String, Object>> classInfoList = classService.getClassNameAndNoByUserId(userId );
			if(classInfoList== null ){
				resString = "fail";
				retMap.put("message", "group is empty");
			}
			else{
				resString="success";
				retMap.put("data", classInfoList);
			}
		}
		retMap.put("result", resString);
		System.out.println("retMap :"+ retMap);
	
		return retMap;
	}
}
