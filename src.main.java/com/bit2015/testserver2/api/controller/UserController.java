package com.bit2015.testserver2.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.testserver2.service.GroupService;
import com.bit2015.testserver2.service.GroupUserService;
import com.bit2015.testserver2.service.UserService;
import com.bit2015.testserver2.vo.AttendanceVo;
import com.bit2015.testserver2.vo.ClassVo;
import com.bit2015.testserver2.vo.UserVo;


@Controller("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	GroupUserService groupUserService;
	@Autowired
	UserService userService;
	
	
	@ResponseBody
	@RequestMapping(value="/join")
	public Map<String, Object> join(
			@RequestBody UserVo userVo ){
		System.out.println("api controller !! /join");
		HashMap<String, Object>retMap = new HashMap<String, Object>();

		if( userVo == null) {
			
		}else if( (userVo.getUserName() ==null) || 
				  (userVo.getUserId()==null) || 
				  (userVo.getUserPassword()==null) || 
				  (userVo.getUserPhoneId()==null) ){
			//TODO : 모든 값들을 입력하세요
		}
		else{
			if( userService.checkExistUserById(userVo.getUserId()) ){
				//TODO : 아이디 중복 되었을때
			}
			//가입 처리
			userService.insertUser(userVo);
		}	
		retMap.put("result", "success");
		return retMap;
	}
	/*@ResponseBody
	@RequestMapping(value="/check")
	public Map<String,Object> check(@RequestParam(value="latitude", required=false)Long latitude,
									@RequestParam(value="logitude", required=false)Long logitude,
									@RequestParam(value="lesson", required=false)String lesson){
		System.out.println("latitude:"+latitude);
		System.out.println("logitude:"+logitude);
		System.out.println("수업명"+lesson);
		
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		retMap.put("result", "success");
		retMap.put("message", "성공 " );
		
		return retMap;
		
	}*/
	@ResponseBody
	@RequestMapping(value="/login")
	public Map<String, Object> login(
			@RequestBody UserVo userVo ){
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		System.out.println("api controller !! /login");
		System.out.println("userVo : "+userVo);
		
		String resString ="fail";

		boolean loginFlag;
		
		if(userVo== null || userVo.getUserId()==null || userVo.getUserPassword()==null){
			resString = "fail";
			retMap.put("message", "id, password 모두 입력하세요");
		}
		else{
			loginFlag = userService.checkIdAndPassword(userVo);
			if ( loginFlag ==false){
				resString = "fail";
				retMap.put("message", "아이디 비밀번호 오류");
			}
			else{
				resString= "success";
			}
		}
		retMap.put("result", resString);
		return retMap;
	}
	@ResponseBody
	@RequestMapping(value="/check")
	public Map<String, Object> testTestTest(
			@RequestBody ClassVo classVo
			){
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		System.out.println("api controller !! /login");
		System.out.println("classVo : "+ classVo);
		String resString ="fail";
		
		List<String> classList = groupUserService.getClassNameListByUserNo(7L);
		System.out.println(classList);
		if(classVo== null ){
			resString = "fail";
		}
		else{
			resString="success";
			retMap.put("data", classList);
		}
		retMap.put("result", resString);
		return retMap;
	}
	
	/**
	 * @return 완성안됨. 
	 * 동일 아이디가 있으면 idExist ==true
	 * 아니면false 
	 */
	@ResponseBody
	@RequestMapping("/check-id")
	public String checkId ( ) {
		//TODO : 아이디 문법 check
		//TODO : 아이디 중복 check 
		boolean idExist = false;
		String id = "1번아이디";
		idExist = userService.checkExistUserById(id);
		
		return "a";
	}

	
	/**
	 * @param userVo
	 * @return 아이디,비밀번호 일치하면 "true"return 아니면 "false" return 
	 * String으로 return 함. 
	 */
	@ResponseBody
	@RequestMapping("/id-password-check")
	public String checkIdAndPassword(
			@ModelAttribute UserVo userVo) {
		boolean matchIdAndPassword = userService.checkIdAndPassword(userVo);
		return matchIdAndPassword+""; 
	}
	
	/**
	 * @param groupNo
	 * @return 해당수업의 (String)userPhoneId List를 반환
	 * +DB의 Attendance Table에  해당 유저들이 출석체크 중으로 저장 
	 */
	@ResponseBody
	@RequestMapping("/start-class")
	public Map<String, Object> startCallRollAndReturnPhoneIdList(
			@RequestParam(value="groupNo", required=true)Long groupNo){
		Map<String, Object>retMap = new HashMap<String, Object>();
		System.out.println("hello test");

		List<String >userPhoneIdList = userService.startCallRollByGroupNo(groupNo);
		
		retMap.put("result", "success");
		retMap.put("data",userPhoneIdList);
		
		return retMap;
	}
	
	
	/**
	 * @param groupNo
	 * @return 해당 그룹에서 '출석체크중' 인 attendanceVo 의 status 를 '결석'으로 바꿈
	 *   //바꾼 수를 Long 으로 return하던것은 비활성화되어있음
	 */
	@ResponseBody
	@RequestMapping("/end-class")
	public Map<String, Object> endClassByGroupNo( @RequestParam(value="groupNo", required = true) Long groupNo ) {
		Map<String, Object>retMap = new HashMap<String, Object>();

		userService.endClassByGroupNo(groupNo);
		
		retMap.put("result", "success");
		return retMap;
	}
	
	/**
	 * @param attdVo (userNo, groupNo 필수)
	 * @return 
	 */
	@ResponseBody
	@RequestMapping("/update-late-person")
	public Map<String, Object> updateLateByAttdVo( @RequestBody AttendanceVo attdVo) {
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		if(attdVo == null ){
			//TODO
			retMap.put("result", "fail");
			retMap.put("message", "attdVo == null");
		}else if( attdVo.getUserNo()==null || attdVo.getClassNo()==null) {
			//TODO 
			retMap.put("result", "fail");
			retMap.put("message", "attdVo의 userNo or groupNo == null");
			System.out.println("모든 값 입력 안됨");
		}else{
			if( userService.updateToLate(attdVo)==false ){
				//TODO : 실패
				retMap.put("result", "fail");
				retMap.put("message", "무언가 잘못됨 " );
			}
			else
				retMap.put("result", "success");
		}
		return retMap;
	}
	
	@ResponseBody
	@RequestMapping("/update-present-person")
	public Map<String, Object> updatePresentByAttdVo( @RequestBody AttendanceVo attdVo) {
		HashMap<String, Object>retMap = new HashMap<String, Object>();
		if(attdVo == null ){
			//TODO
			retMap.put("result", "fail");
			retMap.put("message", "attdVo == null");
		}else if( attdVo.getUserNo()==null || attdVo.getClassNo()==null) {
			//TODO 
			retMap.put("result", "fail");
			retMap.put("message", "attdVo의 userNo or groupNo == null");
			System.out.println("모든 값 입력 안됨");
		}else{
			if( userService.updateToPresent(attdVo)==false ){
				//TODO : 실패
				retMap.put("result", "fail");
				retMap.put("message", "무언가 잘못됨 " );
			}
			else
				retMap.put("result", "success");
		}
		return retMap;
	}

	/**
	 * user가 가입되어 있는 groupList
	 */
	@ResponseBody
	@RequestMapping("/joined-group-list")
	public Map<String, Object> JoinedGroupList(@RequestParam(value="userNo", required=true)Long userNo,
			Model model) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> groupList = groupUserService.getGroupAndRoleListByUserNo(userNo);
		model.addAttribute("groupList", groupList);
		
		retMap.put("result", "success");
		retMap.put("groupList", groupList);
		return retMap;
	}
	@ResponseBody
	@RequestMapping("/phoneidlist-by-groupno")
	public Map<String, Object> getUserPhoneIdListByGroupNo(
			@RequestParam(value="groupNo", required=false)Long groupNo ) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		List<String> phoneIdList = userService.getUserPhoneIdListByGroupNo(4L);
		
		retMap.put("result", "success");
		retMap.put("data", phoneIdList);
		return retMap;
	}
}
