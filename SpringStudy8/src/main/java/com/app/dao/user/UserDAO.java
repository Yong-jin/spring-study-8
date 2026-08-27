package com.app.dao.user;

import java.util.List;

import com.app.dto.user.User;
import com.app.dto.user.UserProfileImage;
import com.app.dto.user.UserProfileRequestForm;
import com.app.dto.user.UserSearchCondition;

public interface UserDAO {
	public int saveUser(User user);
	
	public List<User> findUserList();
	
	public List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition);
	
	public User findUserById(String id);
	
	public User checkUserLogin(User user);
	
	public int modifyUser(User user);
	
	public int modifyUserPw(User user);
	
	public int saveUserProfileImage(UserProfileImage userProfileImage);
	
	public UserProfileImage findUserProfileImageById(String id);
}
