package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponseHeader {

	String resultCode; //결과 응답코드
	String resultMessage; //결과 메시지 (설명)
}
