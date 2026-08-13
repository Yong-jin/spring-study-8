package com.app.dto.user;

import lombok.Data;

@Data
public class User {
	
	String id;
	String pw;
	String name;
	String userType;
	// 사용자 계정종류 구분
	// Customer   Admin
	// CUS		  ADM
}
