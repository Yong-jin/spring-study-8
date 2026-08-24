package com.app.dto.user;

import lombok.Data;

@Data
public class UserValidError {
	
	// 유효성 검증 결과 
	// 결과에 오류가 있으면? -> 화면에 표시 (FE 메시지)
	// 값 O -> 검증실패 오류O
	// 값 X(null) -> 검증통과 정상
	
	String id;		//실패시 오류 메시지
	String pw;
	String name;
	String userType;
}
