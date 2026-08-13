package com.app.service.user;

import com.app.dto.user.User;

public interface UserService {

	public int saveUser(User user);
	
	public int saveCustomerUser(User user);
	public int saveAdminUser(User user);
}
