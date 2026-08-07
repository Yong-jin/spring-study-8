package com.app.controller.study.quiz.quiz09;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.controller.study.quiz.quiz07.Member;

@Controller
public class Quiz09Controller {

//	2-1)
//	http://localhost:8080/quiz09/listTest?type=member 로 요청한 경우에
//	http://localhost:8080/quiz07/listTest/member 요청한 결과와 동일한 결과가 나오도록 하세.
//
//	*단, url 주소는 유지 (최종 브라우저 표시 경로 : /quiz09/listTest?type=member)

	
	
//	2-2)
//	http://localhost:8080/quiz09/listTest?type=str 로 요청한 경우에
//	http://localhost:8080/quiz07/listTest/str 로 요청한 결과와 동일한 결과가 나오도록 하세요.
//	*단, url 주소도 변경 (최종 브라우저 표시 경로 : /quiz07/listTest/str)
	
	@GetMapping("/quiz09/listTest")
	public String listTest(@RequestParam String type) {
		
		if(type.equals("member")) {
			return "forward:/quiz07/listTest/member";
		} else { //str
			return "redirect:/quiz07/listTest/str";
		}
		
		
	}
}
