package com.bit2015.testserver2.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.testserver2.vo.AttendanceVo;
import com.bit2015.testserver2.vo.UserVo;


@Repository
public class UserDao {
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * @param userVo (Id, name, password 필수)
	 * 새 userVo 를 server_user 에 입력
	 */
	public void insertUser( UserVo userVo ) {
		System.out.println(userVo);
		sqlSession.selectOne("user.insert", userVo);
	}
	
	/**
	 * @param String id
	 * @return id가 있는지 확인. 있으면 true return.
	 */
	public UserVo getUserById ( String userId ){
		UserVo retVo = null;
		retVo = sqlSession.selectOne("user.getUserById", userId);
		return retVo;
	}

	/**
	 * @return 모든 userVo 의 List
	 */
	public List<UserVo> getUserListAll( ) {
		List<UserVo> retList = null;
		retList = sqlSession.selectList("user.getUserListAll");
		return retList;
	}
	
	/**
	 * @param userVo
	 * @return 아이디 비번 일치하면 true보냄
	 * 불일치 하면 false
	 */
	public boolean checkIdAndPassword (UserVo userVo ) {
		if ( sqlSession.selectOne("user.getUserVoByIdAndPassword", userVo) == null )
			return false;
		else {
			return true;
		}
	}
	
	public List<String> getPhoneIdListByGroupNo (Long groupNo){
		List retList = null;
		retList = sqlSession.selectList("user.getPhoneIdListByGroupNo" , groupNo);
		
		System.out.println("@@ : "+retList);
		return retList;
	}
	public List<AttendanceVo> getAttdVoListByGroupNo (Long groupNo){
		List<AttendanceVo> retList = null;
		retList= sqlSession.selectList("user.getUserListByGroupNo", groupNo);
		return retList;
	}
	public void startCallRoll(List<AttendanceVo> attdList){
		System.out.println("userDao @ startRollCall");
		for( AttendanceVo attdVo : attdList){
			sqlSession.insert("user.insertAttdVo", attdVo);
		}
	}
	
	/**
	 * @param groupNo
	 * @return 해당 그룹에서 '출석체크중' 인 attendanceVo 의 status 를 '결석'으로 바꿈
	 * 바꾼 수를 Long 으로 return
	 */
	public Long updateToAbsenceByGroupNo( Long groupNo ) {
		Long retLong = 0L;
		retLong = (long)sqlSession.update("user.updateToAbsenceByGroupNo", groupNo);
		return retLong;
	}
	
	public Long updateToLateByGroupNo ( Long groupNo ) {
		Long retLong = 0L;
		
		return retLong;
	}
	
	public boolean updateToLate( AttendanceVo attdVo ) {
		boolean retFlag = false;
		System.out.println("@dao updateToLate attdVo : "+attdVo);
		if(sqlSession.update("user.updateToLateAttdVo", attdVo) ==1){
			retFlag = true;
		}
		return retFlag;
	}
	public boolean updateToPresent( AttendanceVo attdVo ) {
		boolean retFlag = false;
		System.out.println("attdVo @ dao : "+attdVo);
		if( sqlSession.update("user.updateToPresent", attdVo) ==1){
			retFlag =true;
		}
		return retFlag;
	}
	
	public List<String> getPhoneIdListByClassNo ( Long classNo ) {
		List<String> retList = null;
		retList = sqlSession.selectList("user.getPhoneIdListByUserNo", classNo);
		System.out.println();
		return retList;
	}
	
	
	
	
}
