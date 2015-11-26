package com.bit2015.testserver2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.testserver2.dao.BoardDao;
import com.bit2015.testserver2.vo.BoardVo;



@Service
public class BoardService {
	@Autowired
	BoardDao boardDao;
	
	public void createBoard( BoardVo boardVo ) {
		boardDao.createBoard(boardVo);
	}
	
	public List<BoardVo> getBoardListByGroupNo (Long groupNo ) {
		List<BoardVo> retList = null;
		retList = boardDao.getBoardListByGroupNo(groupNo); 
		return retList;
	}

}
