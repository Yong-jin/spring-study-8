package com.app.controller.study.quiz.quiz19;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;

//@RestController
@Controller
public class Quiz19Controller {

	@GetMapping("/quiz19/quiz1")
	public String quiz1() {
		//view html 화면
		return "quiz/quiz19/quiz1";
	}
	
	@ResponseBody
	@GetMapping("/quiz19/quiz2")
	public String quiz2() {
		return "return text quiz2";
	}
	
	@ResponseBody
	@GetMapping("/quiz19/quiz3")
	public User quiz3() {
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("quiz이름");
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER );
		
		return user;
	}
}
