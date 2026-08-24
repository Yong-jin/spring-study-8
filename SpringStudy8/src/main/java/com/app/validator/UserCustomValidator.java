package com.app.validator;

import com.app.dto.user.User;
import com.app.dto.user.UserValidError;

public class UserCustomValidator {

	public static boolean validate(User user, UserValidError userValidError) {
		boolean result = true;
		
		// 검증 비교
		if(user.getId() == null || user.getId().trim().equals("") ) {
			//id 공백으로 넘어옴. 입력 제대로 안됨. 유효성 검증 필터 
			userValidError.setId("아이디 입력하셔야하는데...!! msg");
			result = false;
		}
		
		if(user.getId().length() < 4 || user.getId().length() > 12) {
			userValidError.setId("아이디 길이 4 - 12 msg");
			result = false;
		}
		
		if(user.getPw().length() < 8 || user.getPw().length() > 12) {
			userValidError.setPw("비밀번호 비번 8 12 확인 msg");
			result = false;
		}
		
		if(user.getName() == null || user.getName().trim().equals("") ) {
			userValidError.setName("이름 필수에요. 작성 ㄱㄱ msg");
			result = false;
		}
		
		return result;
		
	}
	
	
	public static boolean modifyUserValidate(User user, UserValidError userValidError) {
		
		boolean result = true;
		
		if(user.getUserType() == null || user.getUserType().trim().equals("") ) {
			//id 공백으로 넘어옴. 입력 제대로 안됨. 유효성 검증 필터 
			userValidError.setUserType("수정하려면 userType 필수인데... msg");
			result = false;
		}
		
		return true;
	}
	
	
	
	
}
