package com.app.controller.study.quiz.quiz11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Quiz11Controller {

	
//	2) localhost:8080/quiz11/first 로 접근 했을 때 위 화면에 나타나도록 하세요.
//	accessUrl 은 "/first" 로 지정하세요.
	@GetMapping("/quiz11/first")
	public String first(Model model) {
		model.addAttribute("accessUrl", "/first");
		
		return "quiz/quiz11/targetPage";
	}
	
//	3) localhost:8080/quiz11/firsthide1 로 접근했을때, 위 화면이 나타나도록 하세요.
//	accessUrl 은 "/firsthide1" 로 지정하세요.
//	*단, 주소창에 url은 /firsthide1로 유지
	@GetMapping("/quiz11/firsthide1")
	public String firsthide1(Model model) {
		model.addAttribute("accessUrl", "/firsthide1");
		
		return "quiz/quiz11/targetPage";
	}
	
//	4) localhost:8080/quiz11/firsthide2 로 접근했을때, 위 화면이 나타나도록 하세요.
//	accessUrl 은 "/first" 로 지정하세요.
//	*단, 주소창에 url은 /first 로 변경
	
	@GetMapping("/quiz11/firsthide2")
	public String firsthide2(Model model) {
		
		// /firsthide2 요청 request에 대해
		model.addAttribute("accessUrl", "/first");
		//필요없음.
		
		
		//redirect 로 새로운 request 발생.
		//return "quiz/quiz11/targetPage";
		return "redirect:/quiz11/first";  //주소로 표기
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
