package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {

		//--ViewResolver 설정이 없으면
		//return "/WEB-INF/views/home.jsp";
		//return "/WEB-INF/views/mainpage.jsp";

		//--ViewResolver 설정 이후
		return "home";
		//return "mainpage";
		
		//prefix : /WEB-INF/views/
		//suffix : .jsp
		
		
		//   /WEB-INF/views/home.jsp
		
		
		
		
		
	}
}