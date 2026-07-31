package hello.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {

	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "/product")
	public String product() {
		return "product";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
}
