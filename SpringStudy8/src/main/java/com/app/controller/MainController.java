package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //어노테이션 애노테이션
public class MainController {
	
	
	@RequestMapping("/main")  //어떤 주소로 요청이 왔을때
	public String main() {
		
		
		//return 하는 문자열 -> view 자원 이름
		
		return "main";
	}
	

}
