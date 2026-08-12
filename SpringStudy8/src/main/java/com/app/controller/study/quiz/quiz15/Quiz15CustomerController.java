package com.app.controller.study.quiz.quiz15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Quiz15CustomerController {

	@Autowired
	Quiz15CustomerService quiz15CustomerService;
	
	
	@GetMapping("/quiz15/registerCustomer")
	public String registerCustomer() {
		//등록하기위해 입력하는 페이지로 연결
		return "quiz/quiz15/registerCustomer";
	}
	
	@PostMapping("/quiz15/registerCustomer")
	public String registerCustomerAction(@ModelAttribute Quiz15Customer quiz15Customer) {
		//등록페이지 -> 입력정보 -> 파라미터 전달 받음
		// -> DB에 저장
		
		System.out.println("[Controller] registerCustomer");
		
		// Controller -> Service -> DAO -> DB
		//           DTO         DTO    DTO
		
	 	int result = quiz15CustomerService.saveCustomer(quiz15Customer);
	 	if(result > 0 ) {
	 		return "quiz/quiz15/registerCustomer";  //저장성공 이후에 보여줄 경로 이동
	 		//return "redirect:/quiz15/main";
	 	} else {
	 		return "quiz/quiz15/registerCustomer";
	 	}
		
	}
}











