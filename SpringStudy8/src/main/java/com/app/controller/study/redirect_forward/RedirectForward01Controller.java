package com.app.controller.study.redirect_forward;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/re")
public class RedirectForward01Controller {

	@GetMapping("/re1")
	public String re1() {
		return "re/re1";
	}
	
	@GetMapping("/re2")
	public String re2(HttpServletRequest request) {
		//  /re/re2?msg=abc
		System.out.println("/re2");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2";
	}
	
	@GetMapping("/re3")
	public String re3(HttpServletRequest request) {
		//  /re/re2?msg=abc
		System.out.println("/re3");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2";  //요청 re3 -> 응답 re2 페이지 
	}
	
	
	@GetMapping("/re4")
	public String re4(HttpServletRequest request) {
		
		System.out.println("/re4");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re4";  //요청 re4 -> 응답 re4 페이지   -> (re4 view) 코드 경로이동 -> /re/re2  
	}


	@GetMapping("/re5")
	public String re5(HttpServletRequest request) {
		
		System.out.println("/re5");
		System.out.println(request.getParameter("msg"));
		
		return "redirect:/re/re2";  
		// redirect:요청할이동경로
		// redirect return 이 화면view이름을 나타내는것이 아님!!! 
		
		
		// return view이름     /WEB-INF/views/     re/re2     .jsp
		// return redirect:주소경로           localhost:8080   /re/re2   주소창에 들어갈 값(경로)
		//													인터넷주소창 or GetMapping("경로")
	}
	
	@GetMapping("/re6")
	public String re6(HttpServletRequest request) {
		
		//server 에서 forward 처리
		System.out.println("/re6");
		System.out.println(request.getParameter("msg"));
		
		// forward 서버에서 바로 요청 경로를 이동해서 수행
		return "forward:/re/re2";    
		
		// forward:주소요청경로  GetMapping("경로")
	}
	
	@GetMapping("/re7")
	public String re7(HttpServletRequest request, RedirectAttributes ra) {
		//서버에서 redirect
		
		System.out.println("/re7");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		// parameter
		// attribute         view 전달 -> request 담아서
		
		// redirect 하면 새로운 request 가 발생됨 (기존 request 값 전달X)
		
		// re2 페이지로 redirect 시에 파라미터 값도 포함해서 넘기고 싶으면?
		
		// 1) redirect 경로에 파라미터 표시까지 포함
		//return "redirect:/re/re2?msg=hot";
		//return "redirect:/re/re2?msg=" + request.getParameter("msg");
		
		// 2) RedirectAttributes 활용
		// redirect 시에 attribute 값들을 경로뒤에 파라미터로 추가됨
		//ra.addAttribute("msg", "toohot");
		//ra.addAttribute("stats", "hungry");
		//redirect 요청받은 re2 메소드 측에서도 경로에포함된 parameter 인식
		
		// 3) addFlashAttribute  요청 주소에는 표시X, 주소는 redirect 명시된 주소 그대로
		// 화면에서 (view) 에서 확인할수 있도록 전달  (model 에 저장됨)
		// request.getParamter() 에서는 확인X
		ra.addFlashAttribute("msg", "flashHello");
		
		return "redirect:/re/re2";
	}
}











