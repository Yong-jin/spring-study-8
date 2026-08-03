package com.app.controller.study.quiz.quiz01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz01")
public class Quiz01Controller {

	
	//1) 요청 localhost:8080/quiz01/main
	//2) 요청 localhost:8080/quiz01/product/mouse
	//3) 요청 localhost:8080/quiz01/product/keyboard
	
	//@RequestMapping("/quiz01/main")
	@RequestMapping("/main")
	public String main() {
		return "quiz/quiz01/main";
	}
	
	//@RequestMapping("/quiz01/product/mouse")
	@RequestMapping("/product/mouse")
	public String mouse() {
		return "quiz/quiz01/product/mouse";
	}
	
	//@RequestMapping("/quiz01/product/keyboard")
	@RequestMapping("/product/keyboard")
	public String keyboard() {
		return "quiz/quiz01/product/keyboard";
	}
}

