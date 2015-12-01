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

import com.bit2015.testserver2.service.QnaAService;
import com.bit2015.testserver2.service.QnaQService;
import com.bit2015.testserver2.service.UserService;
import com.bit2015.testserver2.vo.QnaAVo;
import com.bit2015.testserver2.vo.QnaQVo;
import com.bit2015.testserver2.vo.YjQVo;


@Controller("qnaAPIController")
@RequestMapping("/api/qna")
public class QnaController {
	@Autowired
	QnaQService qnaQService;
	
	@Autowired
	QnaAService qnaAService;

	@Autowired
	UserService userService;
	
	/*@ResponseBody
	@RequestMapping("/create-q")
	public Map<String, Object> createQ(
			@RequestParam(value="classNo", required=true)Long classNo,
			@RequestParam(value="userNo", required=true)Long userNo,
			@RequestParam(value="questionType", required=true)String questionType,
			@RequestParam(value="question", required=true)String question ) {
		Map<String, Object>retMap = new HashMap<String, Object>();
		
		QnaQVo qVo = new QnaQVo();
		qVo.setFromUserNo(userNo);
		qVo.setQuestion(question);
		qVo.setToClassNo(classNo);
		qVo.setQuestionType(questionType);
		if(qVo.getQuestionType() != "주관식"){
			//TODO 객관식 (YES OR NO) or( 객관식  다지선답 ) 고를 경우 에 다르게 해야함.
		}
		
		qnaQService.createQ(qVo);
		
		List<String> phoneIdList = userService.getUserPhoneIdListByGroupNo(classNo);
		// TODO : list 에 질문도 같이 줘야할까? 
		// TODO : App 에서 질문을 던져야 하는데 이걸 다시 받길 기다렸다가 던지게 해야되나? 아니면 이 PhoneIdList 와 question 을 같이 줘서 던지게 해야되나
		// TODO : 시간이 지나면 질문에 대한 대답 그만 받게? 
		retMap.put("phoneIdList", phoneIdList);
		return retMap;
	}*/
	
	@ResponseBody
	@RequestMapping("/create-a-person")
	public Map<String, Object> createAPerson(
			@RequestParam(value="qnaQNo", required=true)Long qnaQNo,
			@RequestParam(value="userNo", required=true)Long userNo,
			@RequestParam(value="answer", required=true)String answer) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		QnaAVo aVo = new QnaAVo();
		aVo.setQnaQNo(qnaQNo);
		aVo.setUserNo(userNo);
		aVo.setAnswer(answer);

		qnaAService.createAPerson(aVo);
		
		
		return retMap;
	}
		
	@ResponseBody
	@RequestMapping("/get-qlist-by-groupno")
	public Map<String, Object> getQListByGroupNo(
			@RequestParam(value="groupNo", required=true)Long groupNo) {
		Map<String, Object> retMap = new HashMap<String, Object>();

		qnaQService.getQListByGroupNo(groupNo);
		
		return retMap;
	}
			
	@ResponseBody
	@RequestMapping("/get-alist-byuserno")
	public Map<String, Object> getAListByUserNo(
			@RequestParam(value="userNo", required=true)Long userNo) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		List<HashMap<String, Object>> aList = qnaAService.getAListByUserNo(userNo);
		retMap.put("aList", aList);
		
		return retMap; 
	}
	
	@ResponseBody
	@RequestMapping("/get-alist-qno")
	public Map<String, Object> getAListByQNo(
			@RequestParam(value="qNo", required=true)Long qNo) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		List<HashMap<String, Object>> aList = qnaAService.getAListByQNo(qNo);
		
		retMap.put("aList", aList);
		return retMap;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/create-q")
	public Map<String, Object> createQ(
			@RequestBody YjQVo preQVo		) {
		Map<String, Object>retMap = new HashMap<String, Object>();
		
		
		
		QnaQVo postQVo = new QnaQVo();
		
		
		System.out.println(preQVo);
		qnaQService.insertQ(preQVo);
		
		//List<String> phoneIdList = userService.getUserPhoneIdListByGroupNo(classNo);
		// TODO : list 에 질문도 같이 줘야할까? 
		// TODO : App 에서 질문을 던져야 하는데 이걸 다시 받길 기다렸다가 던지게 해야되나? 아니면 이 PhoneIdList 와 question 을 같이 줘서 던지게 해야되나
		// TODO : 시간이 지나면 질문에 대한 대답 그만 받게? 
	//	retMap.put("phoneIdList", phoneIdList);
		return retMap;
	}
}
