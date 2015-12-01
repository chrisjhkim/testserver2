package com.bit2015.testserver2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2015.testserver2.dao.UserDao;
import com.bit2015.testserver2.vo.AttendanceVo;
import com.bit2015.testserver2.vo.UserVo;


/**
 * @author bit-user
 *
 */
@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	/**
	 * @param userVo (id, name, password 필수)
	 * 새 userVo 를 server_user 에 입력
	 */
	public void insertUser( UserVo userVo ){
		userDao.insertUser(userVo);
		
	}
	
	
	/**
	 * @param String id
	 * @return id가 있는지 확인. 있으면 true return.
	 */
	public boolean checkExistUserById ( String id ){
		boolean retFlag = false;
		if (userDao.getUserById(id) !=null ) {
			retFlag = true;
		}
		return  retFlag;
	}
	
	/**
	 * @return 모든 userVo 의 List
	 */
	public List<UserVo> getUserListAll ( ) {
		List<UserVo> retList = null;
		retList = userDao.getUserListAll();
		return retList;
	}
	
	/**
	@param userVo
	 * @return 아이디 비번 일치하면 true보냄
	 * 불일치 하면 false
	 */
	public boolean checkIdAndPassword(UserVo userVo ) {
		return userDao.checkIdAndPassword(userVo);
	}

	public List<String> startCallRollByGroupNo(Long groupNo){
		List<String> retList= null;
		//그 groupNo의 userPhoneId List
		retList = userDao.getPhoneIdListByGroupNo(groupNo); 
		if(retList ==null){//반에 아무도 없으면 
			return retList;
		}
		
		//TODO : 출석 중. 으로 db 에 저장하기
		List<AttendanceVo>attdList =  userDao.getAttdVoListByGroupNo(groupNo);
		userDao.startCallRoll(attdList);
		
		return retList;
	}
	
	
	/**
	 * @param groupNo
	 * @return 해당 그룹에서 '출석체크중' 인 attendanceVo 의 status 를 '결석'으로 바꿈
	 * 바꾼 수를 Long 으로 return
	 */
	public Long endClassByGroupNo(Long groupNo) {
		Long retLong = userDao.updateToAbsenceByGroupNo(groupNo);
		return retLong;
	}
	
	public boolean updateToLate( AttendanceVo attdVo ) {
		boolean retFlag = false;
		retFlag  = userDao.updateToLate(attdVo);
		return retFlag;
	}
	public boolean updateToPresent( AttendanceVo attdVo ) {
		boolean retFlag = false;
		retFlag = userDao.updateToPresent(attdVo);
		return retFlag;
	}
	
	public List<String> getUserPhoneIdListByGroupNo (Long groupNo) {
		List<String> retList= null;
		retList = userDao.getPhoneIdListByGroupNo(groupNo); 
		return retList;
	}
	
	public Long getUserNoViaUserId ( String userId ) {
		Long retLong = 0L;
		retLong = userDao.getUserNoViaUserId(userId);
		return retLong;
	}
	
	
}
