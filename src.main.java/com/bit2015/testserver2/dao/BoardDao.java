package com.bit2015.testserver2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.testserver2.vo.BoardVo;


@Repository
public class BoardDao {
	@Autowired
	SqlSession sqlSession;
	
	public void createBoard(BoardVo boardVo ) {
		Long groupNo =boardVo.getGroupNo(); 
		sqlSession.insert("board.insertNewBoard", groupNo );
	}
	
	public List<BoardVo> getBoardListByGroupNo (Long groupNo ) {
		List<BoardVo> retList = null;
		
		retList = sqlSession.selectList("board.getBoardListByGroupNo", groupNo);
		
		return retList;
	}
}
