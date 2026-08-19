package com.app.controller.study.rest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// @Controller  //기본 return 이 view 자원 리턴   
//				  @ResponseBody 붙인경우에만 텍스트 리턴
@RestController  //기본 return 이 텍스트 자체 리턴
public class Rest02Controller {

	//Controller 역할 + RESTAPI 형식 통신용 컨트롤러
	//내부 메소드 모두 text 리턴
	
	@GetMapping("/rest/rest04")
	public String rest04() {
		return "rest/rest04"; //text리턴
	}
	
	@GetMapping("/rest/rest05")
	public String rest05() {
		return "rest/rest05 basic text"; //text리턴
	}
	
	//단순 텍스트 -> JSON 포맷
	
	@GetMapping("/rest/rest06")
	public String rest06() {
		
		//json 포맷 리턴
		
		// 직접 json 으로 만들기
		
		
		/*
			{
				"id":"abc",
				"name":"abname",
				"userType":"CUS",
				"pw":"pwpw"
			}
		 */
		
		// 1) 직접 텍스트로 json 포맷 만들기
		
		String result = 	"{\r\n"
				+ "				\"id\":\"abc\",\r\n"
				+ "				\"name\":\"abname\",\r\n"
				+ "				\"userType\":\"CUS\",\r\n"
				+ "				\"pw\":\"pwpw\"\r\n"
				+ "			}";
		
		return result;	
		
	}
	
	
	@GetMapping("/rest/rest07")
	public String rest07() {
		// 2) 라이브러리 활용  json-simple
		
		JSONObject obj = new JSONObject();
		obj.put("id", "abc");
		obj.put("name", "abcname");
		obj.put("pw", "abcabc");
		obj.put("userType", "ADM");
		
		String result = obj.toJSONString();
		return result;
	}
	
	@GetMapping("/rest/rest08")
	public String rest08() {
		// 3) 라이브러리 활용  jackson 
		
		User user = new User();
		user.setId("abc08");
		user.setPw("abc08pw");
		user.setName("abcname");
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER  );
		
		// 객체 -> JSON 포맷 
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			result = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//위에 있는 user 객체를 -> json format 변환한 텍스트
		return result;
	}
	
	@GetMapping("/rest/rest09")
	public User rest09() {
		
		// 4) 전제조건 : jackson 라이브러리 의존성 추가 상태
		// REST API 통신 -> text 반환
		// @ResponseBody   or   @RestController
		
		// 객체를 리턴 -> 객체 구성을 JSON 포맷으로 변환한 후 return 
		// **주의** jackson 라이브러리 존재
		
		User user = new User();
		user.setId("abc09");
		user.setPw("abc09pw");
		user.setName("abcname09");
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER  );
		
		return user; //객체 리턴이 알아서 json format 변형
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
