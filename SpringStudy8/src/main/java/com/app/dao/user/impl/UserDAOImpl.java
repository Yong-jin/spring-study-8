package com.app.dao.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.user.UserDAO;
import com.app.dto.user.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public int saveUser(User user) {
		//User 객체 -> T_User 테이블에 저장
		int result = sqlSessionTemplate.insert("user_mapper.saveUser", user);
		
		return result;
	}


	@Override
	public List<User> findUserList() {

		List<User> userList = sqlSessionTemplate.selectList("user_mapper.findUserList");
		
		return userList;
	}


	@Override
	public User findUserById(String id) {
		
		User user = sqlSessionTemplate.selectOne("user_mapper.findUserById", id);
		
		return user;
	}


	@Override
	public User checkUserLogin(User user) {
		
		User loginUser = sqlSessionTemplate.selectOne("user_mapper.checkUserLogin", user);
		
		return loginUser;
	}
	
}






