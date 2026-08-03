package com.app.controller.study.quiz.quiz02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz02Controller {

	
//	1)
//	localhost:8080/quiz02/req1 경로에 GET 메소드로 요청한 경우
//	"/quiz02/req1 GET 요청" 출력

	//@RequestMapping(value="/quiz02/req1", method = RequestMethod.GET)
	@GetMapping("/quiz02/req1")
	public String req1() {
		
		System.out.println("/quiz02/req1 GET 요청");
		
		return "quiz/quiz02/req";
	}

	
//	2)
//	localhost:8080/quiz02/req2 경로에 POST 메소드로 요청한 경우
//	"/quiz02/req2 POST 요청" 출력
	
	@PostMapping("/quiz02/req2")
	public String req2() {
		
		System.out.println("/quiz02/req2 POST 요청");
		
		return "quiz/quiz02/req";
	}
	
	
//	3) 위 두가지 경우가 실행되도록 요청을 발생시키시요.
//	(선택 : view 코드를 작성하여 요청 or PostMan 활용)
	
	
	
//	4)
//	localhost:8080/quiz02/req3 경로로 요청하면서 data1, data2 라는 파라미터를 전달하시오.
//	- GET 방식 POST 방식 상관 없이 모두 수행가능
//	- 요청시 "/quiz02/req3 요청" 출력
//	- data1과 data2 이름으로 들어온 파라미터 값도 출력
//	- 위 출력이 나타나도록
//	GET방식과 POST방식으로 각각 data1과 data2 파라미터와 함께 요청을 발생시키시요.
//	(선택 : view 코드를 작성하여 요청 or PostMan 활용)
	
	
	@RequestMapping("/quiz02/req3")
	//public String req3(@RequestParam String data1, @RequestParam String data2) {
	public String req3(@RequestParam(required = false) String data1,
						@RequestParam(required = false) String data2) {
		System.out.println(data1);
		System.out.println(data2);
		
		return "quiz/quiz02/req";
	}
	
	//DTO 방식
//	public String req3(@ModelAttribute Data12 data12) {
//	class Data12{
//		String data1;
//		String data2;
//	}
	
//	public String req3(HttpServletRequest request) {
//		System.out.println(request.getParameter("data1"));
//		System.out.println(request.getParameter("data2"));
//		
//		return "quiz/quiz02/req";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
