package com.app.controller.study.quiz.quiz04;

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
@RequestMapping("/quiz04")
public class Quiz04Controller {

	
//	1. /quiz04/request1-x?category=100&product=4000 요청 시, 값들 출력 케이스
//	 Console창에 println 으로 출력 (사용자 요청을 서버가 읽어서 확인 가능한지)
//	   1) request 활용 (/request1-1)
	
	@GetMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		
		return "quiz/quiz04/req";
	}
	
//	   2) RequestParam 활용 (/request1-2)
	@GetMapping("/request1-2")
	public String request1_2(@RequestParam String category,
							@RequestParam String product) {
		System.out.println(category);
		System.out.println(product);
		
		return "quiz/quiz04/req";
	}
	
//	   3) Dto 객체 활용 (/request1-3)	
	@GetMapping("/request1-3")
	public String request1_3(@ModelAttribute Product product) {
		System.out.println(product); //.toString()
		
		return "quiz/quiz04/req";
	}
	
//		4) Map 활용 (/request1-4)
	@GetMapping("/request1-4")
	public String request1_4(@RequestParam Map<String,String> paramMap  ){
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));
		
		return "quiz/quiz04/req";
	}
	
	
//	2. /quiz04/viewData1-x요청시 화면(view .jsp)에 값 출력
//	* 화면 전달된 값은 아래와 같이 작성시 출력되어야 함
//	*전달되는 값은 임의로 작성 "넘어간 값"
//
//		1) request 활용  ( /viewData1-1)
		@GetMapping("/viewData1-1")
		public String viewData1_1(HttpServletRequest request) {
			request.setAttribute("response001", "001값");
			request.setAttribute("response099", "099값");
			
			return "quiz/quiz04/viewData";
		}
	
//		2) Model 활용    /viewData1-2
		@GetMapping("/viewData1-2")
		public String viewData1_2(Model model) {
			model.addAttribute("response001", "model001값");
			model.addAttribute("response099", "model099값");
			
			return "quiz/quiz04/viewData";
		}
		
//		3) ModelAndView 활용   /viewData1-3
		@GetMapping("/viewData1-3")
		public ModelAndView viewData1_3() {
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("quiz/quiz04/viewData");
			
			mav.addObject("response001", "mav001값");
			mav.addObject("response099", "mav099값");
			
			return mav;
		}
		
//		4) ModelAttribute 객체 활용    /viewData1-4
		@GetMapping("/viewData1-4")
		public String viewData1_4(Model model) {
			
			model.addAttribute("response001", "model001값");
			model.addAttribute("response099", "model099값");
			
			
			TransferItem transferItem = new TransferItem();
			transferItem.setValue001("value001");
			transferItem.setValue099("value099");
			
			model.addAttribute("transferItem", transferItem);
						
			return "quiz/quiz04/viewData";
		}
		
		
//		ex)
//		${response001}
//		${response099}
//	
//	
//		2-4) 의 경우는 객체에 담아서 보내는 형태로 진행
//		ex)
//		${transferItem.value001}
//		${transferItem.value099}
//
//	이런 방식으로 출력해야합니다.
}

