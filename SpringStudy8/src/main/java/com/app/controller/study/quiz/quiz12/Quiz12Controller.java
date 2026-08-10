package com.app.controller.study.quiz.quiz12;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Quiz12Controller {

	
	 @GetMapping("/quiz12/login")
	 public String login() {
		 return "quiz/quiz12/login";
	 }
	 
	 @PostMapping("/quiz12/login")
	 public String loginAction(HttpServletRequest request) {
		 
		 //로그인 창에서 입력한 id pw 가 post 요청으로 데이터가 잘 수신되었는가?
		 System.out.println(request.getParameter("id")); 
		 System.out.println(request.getParameter("pw"));
		 
		 // id pw 검증 
		 // DB 에 있는 사용자정보와 비교 -> 아이디 비번이 맞으면? -> 로그인 성공

		 // 성공했다고 간주!!
		 // 세션에 해당 ID를 로그인한 아이디로 저장하고~
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("loginId", request.getParameter("id"));
		 session.setAttribute("count", 0);
		 
		 //return "quiz/quiz12/count";  //해당 view 자원으로 연결 X
		 return "redirect:/quiz12/count"; //연결할 주소
	 }
	 
	 
	 @GetMapping("/quiz12/count")
	 public String count(HttpSession session, Model model) {
		 
		 System.out.println( session.getAttribute("loginId") );
		 
		 //model.addAttribute("loginId", session.getAttribute("loginId"));
		 
		 //로그인한 사용자가 있다 -> count 증가
		 //로그인한 사용자가 없으면 -> count 처리 할게 없음
		 
		 // 로그인한 사용자가 있으면 count 값도 초기화or값이존재 
		 
		 if( session.getAttribute("loginId") != null ) {  //사용자가 있다
			 //count++
			 //count = count + 1;
			 session.setAttribute("count",  (Integer)(session.getAttribute("count")) + 1 );
			 
		 } else {  //사용자가 없음.
			 model.addAttribute("count", 0);
		 }
		 
		 
		 return "quiz/quiz12/count";  //해당 view 자원으로 연결
	 }
	 
	 
	 @GetMapping("/quiz12/logout")
	 public String logout(HttpSession session) {
		 //세션에 저장된 기록 삭제 -> 로그인 이력이 없도록 (+count도 삭제)
		 // /quiz12/count 페이지로 이동 시킨다
		 
		 //session.removeAttribute("loginId");
		 //session.removeAttribute("count");
		 session.invalidate(); // 세션 전체 속성 삭제 초기화
		 
		//return "quiz/quiz12/count";  //해당 view 자원으로 연결 X
		return "redirect:/quiz12/count"; //연결할 주소
	 }
}














