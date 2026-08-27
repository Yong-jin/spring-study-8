package com.app.service.user;

import java.util.List;

import com.app.dto.user.User;
import com.app.dto.user.UserProfileImage;
import com.app.dto.user.UserSearchCondition;

public interface UserService {

	public int saveUser(User user);
	
	public int saveCustomerUser(User user);
	public int saveAdminUser(User user);
	
	public List<User> findUserList();
	
	public List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition);
	
	public User checkUserLogin(User user);
	public User findUserById(String id);
	
	public int modifyUser(User user);
	
	public int modifyUserPw(User user);
	
	public boolean isDuplicatedId(String id);
	
	public int saveUserProfileImage(UserProfileImage userProfileImage);
	
	public UserProfileImage findUserProfileImageById(String id);
}
