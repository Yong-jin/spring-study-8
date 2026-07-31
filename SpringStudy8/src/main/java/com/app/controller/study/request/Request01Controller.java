package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
	컴포넌트 등록 (컨트롤러)
	- 스프링이 내부에 객체를 생성해서 관리
	
	1. @Controller 어노테이션 추가
	2. servlet-context.xml 에 컴포넌트 스캔설정
		base-package 패키지 하위 경로에 존재
		
		base-package="com.app.controller"
	
 */


@Controller  //이 클래스를 컨트롤러 컴포넌트로 등록해달라 : 어노테이션
public class Request01Controller {

	//요청 들어오는 주소별로 담당자 맵핑
	@RequestMapping("/url1") //괄호안에 주소로 요청시 
	public String url1() {   //이 메소드가 담당(연결됨)
		
		return "url1";  //view 파일명 명시
		
		// return 해당 이름을 가진 view 파일로 연결
		// viewResolver 설정
		// /WEB-INF/views/     return한경로    .jsp
	}

	
	@RequestMapping("/url2")
	public String url2() {
		return "home";
	}
	
	@RequestMapping("/url3")
	public String url3() {
		return "url3";  //해당 view 이름 없으면? 오류
	}
	
	@RequestMapping("/url4")
	public String url4() {
		
		//return "url4";
		
		return "req/url4";
		//  /WEB-INF/views/     return한경로    .jsp
		//  /WEB-INF/views/req/url4.jsp
	}
	
	
	// HTTP 통신 
	//    전송방식(Method) GET POST | DELETE PUT PATCH
	
	// 		GET(조회)			POST(저장전달)
	// 		엽서/쪽지			편지/소포(택배)
	//		주소+내용			주소 (내부'body' : 내용)
	
	// 접속 테스트
	// 크롬 브라우저 주소창 -> 주소입력 -> 엔터  접근
	// localhost:8080/url4 -> 요청 (GET) 
	
	// GET POST 요청 method 를 구분해서 처리
	
	//@RequestMapping("/url5")   method 다 요청 받는다
	@RequestMapping(value="/url5", method = RequestMethod.GET)
	public String url5() {
		return "req/url4";
	}
	
	@RequestMapping(value="/url6", method = RequestMethod.POST)
	public String url6() {
		return "req/url4";
	}
	
	@GetMapping("/url7")
	public String url7() {
		return "req/url4";
	}
	
	@PostMapping("/url8")
	public String url8() {
		return "req/url4";
	}
	
	@GetMapping("/req/main")	//요청 경로
	public String main() {
		return "req/main";   //view 경로 
	}
}



















