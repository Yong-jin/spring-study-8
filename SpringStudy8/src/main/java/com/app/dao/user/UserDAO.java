package com.app.dao.user;

import java.util.List;

import com.app.dto.user.User;

public interface UserDAO {
	public int saveUser(User user);
	
	public List<User> findUserList();
}
