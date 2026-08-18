package com.app.service.user;

import java.util.List;

import com.app.dto.user.User;

public interface UserService {

	public int saveUser(User user);
	
	public int saveCustomerUser(User user);
	public int saveAdminUser(User user);
	
	public List<User> findUserList();
	
	public User checkUserLogin(User user);
	public User findUserById(String id);
	
	public int modifyUser(User user);
	
	public int modifyUserPw(User user);
}
