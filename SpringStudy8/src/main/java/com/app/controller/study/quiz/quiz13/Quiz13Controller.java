package com.app.controller.study.quiz.quiz13;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Quiz13Controller {

	
	@GetMapping("/quiz13/hideAd")
	public String hideAd(HttpServletRequest request) {
		
		String hideAd = MyCookieUtil.getCookieValue(request, "hideAd");
		if(hideAd != null) {
			request.setAttribute("hideAd", hideAd);
		}
		
		return "quiz/quiz13/hideAd";
	}
	
	@PostMapping("/quiz13/hideAd")
	public String hideAdAction(HttpServletRequest request, HttpServletResponse response) {
		
		//24시간 체크 여부
		System.out.println( request.getParameter("hideAd") );  
		// null인지 여부
		
		// 체크했으면 -> 쿠키에 값을 저장 (수명 24시간) -> 그 화면 페이지 표시할때, 광고표시여부로 활용
		
		if(request.getParameter("hideAd") != null) {
			Cookie ck = MyCookieUtil.createCookie("hideAd", "hideAd", 60 * 60 * 24);
			response.addCookie(ck);
		}
		
		
		return "redirect:/quiz13/hideAd";
	}
	
	
}


