package com.bit2015.testserver2.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.testserver2.service.GroupService;
import com.bit2015.testserver2.service.GroupUserService;
import com.bit2015.testserver2.service.QnaAService;
import com.bit2015.testserver2.service.QnaQService;
import com.bit2015.testserver2.service.UserService;
import com.bit2015.testserver2.vo.AttendanceVo;
import com.bit2015.testserver2.vo.GroupVo;
import com.bit2015.testserver2.vo.TempVo;
import com.bit2015.testserver2.vo.UserVo;

@Controller
public class MainController {
	@Autowired
	UserService userService;
	
	@Autowired
	GroupUserService groupUserService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	QnaQService qnaQService;
	
	@Autowired
	QnaAService qnaAService;
			
		
	@ResponseBody
	@RequestMapping("/json-test")
	public String jsonTest( @RequestParam(value="testMap", required=false)Map<String, Object> testMap) {
		System.out.println("jsonTest : "+testMap);
		return "jsonTest!!";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list")
	public Map<String, Object> index(
			@RequestBody TempVo tempVo,
			
			HttpServletRequest request		) {
		
		System.out.println("start--a------------------!");
		System.out.println("tempVo : "+tempVo);
		System.out.println("request : "+ request);
		System.out.println("end----------------------!");
		
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("result", "success");
		//meassage도 보내기
		//retMap.put("data", value)
		
		return  retMap; 
	}
	@ResponseBody
	@RequestMapping("/aa")
	public String recvTest(
			@RequestParam(value="id", required=false)String id,
			@RequestParam(value="param", required=false)String param) {
		System.out.println("start--------------------!");
		System.out.println("id :    " + id);
		System.out.println("param :    " + param);
		System.out.println("end----------------------!");
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		return "hi  [ id :  "+id+" ]"; //thx to spring-servlet.xml view resolver
	}
	@ResponseBody
	@RequestMapping("/json-recv-test")
	public String jsonRecvTest(
			
			@RequestParam(value="id", required=false)String id,
			
			@RequestParam(value="param", required=false)String param
			) {
		
		System.out.println("start--------------------!");
		System.out.println("id :    " + id);
		System.out.println("param :    " + param);
		System.out.println("end----------------------!");
		
		
		return "hi  [ id :  "+id+" ]"; //thx to spring-servlet.xml view resolver
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main/index";
	}
	
	/**	joinform.jsp 로 이동
	 */
	@RequestMapping("/joinform")
	public String joinForm() {
		System.out.println("@Main Controller joinForm()");
		return "user/joinform";
	}
	
	
	/**
	 * user를 group에 가입시키는 form 으로 이동
	 */
	@RequestMapping("/groupjoinform")
	public String groupJoinForm() {
		System.out.println("@Main Controller groupjoinForm()");
		return "group/groupjoinform";
	}
	
	/**
	 * 
	 * @param userVo (id, name, password 필수)
	 * 	새 userVo 를 server_user 에 입력
	 * @return
	 */
	@RequestMapping("/join")
	public String join( @ModelAttribute UserVo userVo ) {
		System.out.println("@Main Controller join()");
		userService.insertUser(userVo);
		return "redirect:/main";
	}
	


	
	/**
	 * 모든 유저 리스트
	 */
	@RequestMapping("/userlist")
	public String userList(Model model) {
		List<UserVo> retUserList = userService.getUserListAll();
		model.addAttribute("userList", retUserList);
		return "user/userlist";
	}
	
	/**
	 * user를 group에 가입시킴
	 */
	@RequestMapping("/join-group")
	public String JoinGroup( @RequestParam(value="groupNo", required=false)Long groupNo,
						@RequestParam(value="userNo", required=false)Long userNo,
						@RequestParam(value="role", required=false)String role ) {
		
		System.out.println("@MainController joingroup");
		System.out.println("groupNo : "+groupNo);
		System.out.println("userNo : "+userNo);
		System.out.println("role : "+role);
		
		groupUserService.joinGroup(userNo, groupNo, role);
		
		
		return "redirect:/main";
	}

	
	/**
	 * get 모든 group List
	 */
	@RequestMapping("/grouplist")
	public String groupList( Model model) {
		List<GroupVo> retGroupList = groupService.getGroupListAll();	
		model.addAttribute("groupList", retGroupList);
		return "group/grouplist";
	}

	
	/**
	 * groupNo에 해당하는 userVo 의 List
	 */
	@RequestMapping("/groupinfo")
	public String GroupInfo(@RequestParam(value="groupNo", required=true)Long groupNo,
			Model model) {
		List<HashMap<String, Object>> retList = null;
		retList = groupUserService.getUserListOfGroupNo(groupNo);
		model.addAttribute("userHashMapList", retList);
		
		List<HashMap<String, Object>>qList = qnaQService.getQListByGroupNo(groupNo);
		model.addAttribute("qList", qList);
		for(HashMap<String,Object> vo : qList ){
			System.out.println(vo);
		}
		return "group/groupinfo";
	}
	
	/**
	 * user가 가입되어 있는 groupList
	 */
	@RequestMapping("/user-info")
	public String JoinedGroupList(@RequestParam(value="userNo", required=false)Long userNo,
			Model model) {
		List<HashMap<String, Object>> retGroupList = groupUserService.getGroupAndRoleListByUserNo(userNo);
		model.addAttribute("groupList", retGroupList);
		
		List<HashMap<String, Object>> aList = qnaAService.getAListByUserNo(userNo);
		model.addAttribute("aList",aList);
		return "user/userinfo";
	}
	
	
	
	/**
	 * @param userNo
	 * 그냥 테스트 할때 마다 쓰는 메소드
	 */
	@ResponseBody
	@RequestMapping("/test")
	public String Test(@RequestParam(value="userNo", required=false)Long userNo,
					   @RequestParam(value="groupNo", required=false)Long groupNo,
					   Model model) {
		System.out.println("Test!! userNo : "+userNo);
		System.out.println("Test!! groupNo : "+groupNo);


		return "TESTER!!";
	}
	
	
	@RequestMapping("/a-list-by-qno")
	public String aListByQNo(
			@RequestParam(value="qNo", required= true)Long qNo,
			Model model ) {
		List<HashMap<String, Object>> aList = qnaAService.getAListByQNo(qNo);
		model.addAttribute("aList", aList);
		
		Map<String, Object> qInfo = qnaQService.getQInfoByQNo(qNo);
		model.addAttribute("qInfo", qInfo);
		return "qna/alist";
	}
	
	
	
	
}

