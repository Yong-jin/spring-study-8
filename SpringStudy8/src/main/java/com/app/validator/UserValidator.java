package com.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.dto.user.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		//유효성 검증 코드
		
		// 타입변환
		User user = (User)target;
		
		//사용자 요청 -> 서버로 전달 insert 처리전에 유효성 검증
		
		
		//검증 -> 문제가 있다? -> errors 객체에 저장
		
		if(user.getId() == null || user.getId().trim().equals("") ) {
			//id 공백으로 넘어옴. 입력 제대로 안됨. 유효성 검증 필터 
			errors.rejectValue("id", "EmptyUserId", "아이디 입력하셔야하는데...");
		}
		
		if(user.getId().length() < 4 || user.getId().length() > 12) {
			errors.rejectValue("id", "LengthUserId", "아이디 길이 체크 요망");
		}
		
		
		if(user.getPw().length() < 8 || user.getPw().length() > 12) {
			errors.rejectValue("pw", "LengthUserPw", "바밀번호 8~12입력하세요~");
		}
		
	}
	
}










