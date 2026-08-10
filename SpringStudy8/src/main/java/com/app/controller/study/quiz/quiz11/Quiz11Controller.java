package com.app.controller.study.quiz.quiz11;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Quiz11Controller {

	
//	2) localhost:8080/quiz11/first 로 접근 했을 때 위 화면에 나타나도록 하세요.
//	accessUrl 은 "/first" 로 지정하세요.
	@GetMapping("/quiz11/first")
	public String first(Model model, HttpSession session) {
		
		
		//session 에 hide3에 들렸다가 왔다? -> /firsthide3 출력
		// 안갔다왔다? -> /first
		
		if(session.getAttribute("accessUrl") == null) {
			//안들렸다가 왔구나  그냥 바로 /first로 접속했구나
			model.addAttribute("accessUrl", "/first");
		} else {
			//firsthide3 들렸다가 왔구나
			//model.addAttribute("accessUrl", "/firsthide3");
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
			
			//session 영역 인식하는데 사용 완료 -> 삭제
			//session.invalidate(); //클리어 초기화
			session.removeAttribute("accessUrl");
		}
		
		
		
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
	
	
	
	
//	********
//	//위 문제에 대한 응용버전 추가
//
//	localhost:8080/quiz11/firsthide3 로 접근했을때, 위 화면이 나타나도록 하세요.
//	accessUrl 은 "/firsthide3" 로 지정하세요.
//	*단, 주소창에 url은 /first 로 변경
//
//	**기존에 /first 로 바로 접속시에 화면에 /first 로 나오는 부분은 유지!!!
	
	@GetMapping("/quiz11/firsthide3")
	public String firsthide3(Model model, HttpSession session,
				RedirectAttributes ra) {
		
		//model.addAttribute("accessUrl", "/firsthide3");
		
		//session 영역에 저장.  나 firsthide3 에 접속했다가 /first 경로로 왔다
		session.setAttribute("accessUrl", "/firsthide3");

		//session.setAttribute("flag", "fromhide3");
		ra.addFlashAttribute("fromhide3", "/firsthide3");
		
		return "redirect:/quiz11/first"; 
	}
	
	
	
	
	
	
	
	
	

}
