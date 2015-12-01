package com.bit2015.testserver2.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2015.testserver2.service.BoardService;
import com.bit2015.testserver2.vo.BoardVo;


@Controller("boardAPIController")
@RequestMapping("/api/board")
public class BoardController {
	/*@Autowired 
	BoardService boardService;*/
	
	/*@ResponseBody
	@RequestMapping("/create-board")
	public Map<String, Object> createBoard(
			@RequestParam(value="groupNo", required=true)Long groupNo ,
			@RequestParam(value="boardName", required=false)String boardName) {
		Map<String, Object>retMap = new HashMap<String, Object>();
		BoardVo boardVo = new BoardVo();
		boardVo.setGroupNo(groupNo);
		boardService.createBoard(boardVo);
		return retMap;
	}*/
	
	/*@ResponseBody
	@RequestMapping("/get-board-list")
	public Map<String, Object> getBoardListByGroupNo(
			@RequestParam(value="groupNo", required=true)Long groupNo ) {
		Map<String, Object>retMap = new HashMap<String, Object>();
		List<BoardVo> boardList = boardService.getBoardListByGroupNo(groupNo);
		return retMap;
	}*/
	

}
