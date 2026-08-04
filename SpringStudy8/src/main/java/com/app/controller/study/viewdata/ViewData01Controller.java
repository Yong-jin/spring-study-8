package com.app.controller.study.viewdata;

import javax.servlet.http.HttpServletRequest;

import com.app.controller.MainController;
import com.app.dto.study.request.Product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewData01Controller {

	private final MainController mainController;

	ViewData01Controller(MainController mainController) {
		this.mainController = mainController;
	}

	/*
	 * (FE 사용자 Client) ---> request (param) -----> (BE 서버 Server) <---> DB
	 * html/css/js 요청 파라미터 확인 비즈니스 로직 return "view자원" (html/css/js) <----
	 * (html/css/js) <-- (jsp) [view 에 필요한/표시할 데이터]
	 */

	@GetMapping("/viewData1")
	public String viewData1(HttpServletRequest request) {
		// 메소드(매개변수)
		// return "data" 객체

		// localhost:8080/viewData1?p1=abc

		System.out.println(request.getParameter("p1"));

		// view 에 데이터 전달
		// request.setAttribute(key, value);
		request.setAttribute("store", "맘스터치");
		request.setAttribute("menu", "싸이버거");

		return "viewData/viewData1";
	}

	@GetMapping("/viewData2")
	public String viewData2(Model model) {

		System.out.println("/viewData2 요청");
		model.addAttribute("store", "달식당");
		model.addAttribute("menu", "달돈까스");

		return "viewData/viewData1";
	}

	@GetMapping("/viewData3")
	public ModelAndView viewData3() {
		System.out.println("/viewData3 요청");

		ModelAndView mav = new ModelAndView();

		mav.setViewName("viewData/viewData1");
		mav.addObject("store", "김밥천국");
		mav.addObject("menu", "참치김밥");

		return mav;
	}

	@GetMapping("/viewData4")
	public ModelAndView viewData4(ModelAndView mav) {
		System.out.println("/viewData4 요청");

		mav.setViewName("viewData/viewData1");
		mav.addObject("store", "김밥천국");
		mav.addObject("menu", "돌솥비빔밥");

		return mav;
	}

	@GetMapping("/viewData5")
	public String viewData5(Model model) {
		System.out.println("/viewData5 요청");

		// 일반 값/변수 전달
		model.addAttribute("store", "달식당");
		model.addAttribute("menu", "김치우동");

		// 객체 전달
		Product product = new Product();
		// product.id = "상품ID";
		product.setId("상품ID");
		product.setName("상품name");
		product.setPrice(11000);

		System.out.println(product);

		model.addAttribute("product", product);

		return "viewData/viewData5";
	}

	@GetMapping("/viewData6") // 요청 파라미터 확인 + view 데이터 전달
	public String viewData6(HttpServletRequest request) {

		// 프로그램 , 함수 , 메소드
		// 요청(매개변수) -> 로직/처리 -> 리턴(반환)

		// localhost:8080/viewData6?search=커피
		// localhost:8080/viewData6?search=음료

		// 요청 들어오는 파라미터
		String search = request.getParameter("search"); // 커피 음료

		request.setAttribute("store", "오늘카페");
		request.setAttribute("menu", "다양한음료");

		if (search.equals("커피")) {
			Product p = new Product();
			p.setId("coffee");
			p.setName("아메리카노");
			p.setPrice(4000);

			request.setAttribute("product", p);

		} else { // 음료

			Product p = new Product();
			p.setId("tea");
			p.setName("아이스티");
			p.setPrice(4800);

			request.setAttribute("product", p);

		}

		return "viewData/viewData5";
	}

	@GetMapping("/viewData7")
	public String viewData7(@RequestParam(required = false) String search, Model model) {

		model.addAttribute("store", "오늘카페");
		model.addAttribute("menu", "다양한음료");

		if (search.equals("커피")) {
			Product p = new Product();
			p.setId("coffee");
			p.setName("카페라떼");
			p.setPrice(5000);

			model.addAttribute("product", p);

		} else { // 음료

			Product p = new Product();
			p.setId("tea");
			p.setName("민트티");
			p.setPrice(5200);

			model.addAttribute("product", p);

		}

		return "viewData/viewData5";
	}

}
