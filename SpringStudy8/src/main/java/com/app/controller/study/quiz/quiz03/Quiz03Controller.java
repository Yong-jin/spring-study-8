package com.app.controller.study.quiz.quiz03;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/quiz03")
public class Quiz03Controller {

//
//1. /quiz03/request1-x?item=americano&type=coffee 요청 시, 값들 출력 케이스
	//Console창에 println 으로 출력 (사용자 요청을 서버가 읽어서 확인 가능한지)
	
	
//1) request 활용 (/request1-1)
	
	@GetMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		
		System.out.println("/request1-1 ===============");
		System.out.println( request.getParameter("item") );
		System.out.println( request.getParameter("type") );
		
		return "quiz/quiz03/req";
	}
	
//2) RequestParam 활용 (/request1-2)
	
	@GetMapping("/request1-2")
	public String request1_2(@RequestParam(required = false) String item,
							 @RequestParam(required = false) String type) {
		
		System.out.println("/request1-2 ===============");
		System.out.println( item );
		System.out.println( type );
		
		return "quiz/quiz03/req";
	}

	//3) RequestParam Map 활용 (/request1-3)
	@GetMapping("/request1-3")
	public String request1_3(@RequestParam Map<String, String> paramMap) {
		
		System.out.println("/request1-3 ===============");
		System.out.println( paramMap.get("item") );
		System.out.println( paramMap.get("type") );
		
		return "quiz/quiz03/req";
	}
	
	
//	4) 자바 Dto 객체 활용 (/request1-4)
	@GetMapping("/request1-4")
	public String request1_4(@ModelAttribute Beverage beverage) {
		
		System.out.println("/request1-4 ===============");
		System.out.println( beverage.getItem() );
		System.out.println( beverage.getType() );
		
		return "quiz/quiz03/req";
	}
	
	
	
//2. /quiz03/viewData1-x 요청시 화면에 값 출력
//
//1) request 활용 /viewData1-1
	
	
	@GetMapping("/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {
		
		request.setAttribute("name", "싸이버거");
		request.setAttribute("type", "햄버거");
		
		return "quiz/quiz03/viewData";
	}
	
//2) Model 활용 /viewData1-2
	@GetMapping("/viewData1-2")
	public String viewData1_2(Model model) {
		
		model.addAttribute("name", "순대국밥");
		model.addAttribute("type", "한식");
		
		return "quiz/quiz03/viewData";
	}
	
//3) ModelAndView 활용 /viewData1-3
	@GetMapping("/viewData1-3")
	//public ModelAndView viewData1_3(ModelAndView mav) {
	public ModelAndView viewData1_3() {
		
		//ModelAndView mav = new ModelAndView("quiz/quiz03/viewData");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("quiz/quiz03/viewData");
		
		mav.addObject("name", "쌀국수");
		mav.addObject("type", "베트남음식");
		
		return mav;
	}
	
//4) Model에 객체 단위로 전달 활용 /viewData1-4
	@GetMapping("/viewData1-4")
	public String viewData1_4(Model model) {
		
		model.addAttribute("name", "순대국밥");
		model.addAttribute("type", "한식");
		
		DrinkItem drinkItem = new DrinkItem();
		drinkItem.setName("생수");
		drinkItem.setType("물");
		model.addAttribute("drinkItem", drinkItem);
		
		return "quiz/quiz03/viewData";
	}
	
	
//
//* 화면 전달된 값은 아래와 같이 작성시 출력되어야 함
//*전달되는 값은 임의로 작성 "넘어간 값"
//단일 1), 2), 3)
//${name}
//${type}
//
//* 화면에 객체를 표시할때 사용하는 코드
//객체 4)
//${drinkItem.name}
//${drinkItem.type}
	
	@GetMapping("/viewData1-5")
	public String viewData1_5(@ModelAttribute Beverage beverage , Model model) {
		
		
		System.out.println( "request 에 담겨온 파라미터 객체로 받기 ");
		System.out.println( beverage.getItem() );
		System.out.println( beverage.getType() );
		
		//화면에 객체로 전달

		DrinkItem drinkItem = new DrinkItem();
		drinkItem.setName("사이다");
		drinkItem.setType("탄산");
		model.addAttribute("drinkItem", drinkItem);
		
		return "quiz/quiz03/viewData";
	}
	
	
}
