package com.app.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonCode;
import com.app.controller.study.quiz.quiz14.CoffeeBean;
import com.app.dao.user.UserDAO;
import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;
import com.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final CoffeeBean coffeeBean;

	@Autowired
	UserDAO userDAO;

    UserServiceImpl(CoffeeBean coffeeBean) {
        this.coffeeBean = coffeeBean;
    }

	@Override
	public int saveUser(User user) {

		int result = userDAO.saveUser(user);
		
		return result;
	}

	@Override
	public int saveCustomerUser(User user) {

		//사용자 계정 추가시 사용 메소드
		//고객계정으로 추가!
		//user.setUserType("CUS");
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER );
		
		
		int result = userDAO.saveUser(user);
		
		return result;
	}

	@Override
	public int saveAdminUser(User user) {
		//관리자 계정 추가시 사용 메소드
		//관리자계정으로 추가!
		//user.setUserType("ADM");
		user.setUserType( CommonCode.USER_USERTYPE_ADMIN );
		
		int result = userDAO.saveUser(user);
		
		return result;
	}

	@Override
	public List<User> findUserList() {

		List<User> userList = userDAO.findUserList();
		
		return userList;
	}

	@Override
	public User checkUserLogin(User user) {
		
		// 사용자 id pw  <-->  DB에 있는 계정정보 일치?

		// 해당 id로 DB에서 계정정보를 조회 <-> id pw 비교
		
		
		// 로그인 처리 케이스 1) DB에서 User 정보 조회 -> 서비스 계층에서 상태 비교 수행
		
		/*
		User loginUser = userDAO.findUserById( user.getId()  );
		
		//if( loginUser == null ) //아이디가 없다
		// loginUser != null  -> pw 비교 -> 틀렸다 -> 아이디는 있는데, 비번이 틀렸다
		
		//다 성공일때만 user객체 리턴
		if( loginUser != null  //해당 id로 db에 데이터가 있다
				&& user.getPw().equals( loginUser.getPw() )   //비번이 일치한다
				&& user.getUserType().equals(loginUser.getUserType())  //userType이 일치한다
				) {
			//로그인 성공
			
			return loginUser;
		}
		
		//로그인 실패시
		return null;
		
		// 성공 or 실패시 사유   코드화    1 성공 2 비번틀렸고 3 아이디없고 4 휴면계정 5 정지
		*/
		
		// 로그인 처리 케이스 2) DB 쿼리상에서 정보 일치 여부 비교 수행
		User loginUser = userDAO.checkUserLogin(user);  // 객체 or null
		
		return loginUser;
	}

	@Override
	public User findUserById(String id) {

		User user = userDAO.findUserById(id);
		
		return user;
	}

	@Override
	public int modifyUser(User user) {
		
		int result = userDAO.modifyUser(user);
		
		return result;
	}

	@Override
	public int modifyUserPw(User user) {
		int result = userDAO.modifyUserPw(user);
		
		return result;
		
	}

	@Override
	public List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition) {
		
		List<User> userList = userDAO.findUserListBySearchCondition(userSearchCondition);

		return userList;
	}

	@Override
	public boolean isDuplicatedId(String id) {

		//매개변수 id 
		// DB 에 있나?
		
		// id중복인가?
		// 중복 -> true
		// 중복X -> false
		
		User user = userDAO.findUserById(id);
		
		if(user == null) { //해당 아이디가 없다! -> 중복 X
			return false;
		} else { // 해당 아이디의 User 정보가 있다! -> 중복 O 
			return true;
		}
	}
}










