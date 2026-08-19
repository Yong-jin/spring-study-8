package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {
	//Generic 타입을 고정하지않고 사용방식 일반화
	
	ApiResponseHeader header; //헤더양식 고정
	T body;
	
//	List<String>
//	List<Menu>
//	List<User>
}
