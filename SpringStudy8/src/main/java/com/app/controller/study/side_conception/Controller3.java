package com.app.controller.study.side_conception;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller3 {

	// 3-1)
	public MyModelAndView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Controller3 에서 처리해야하는 비즈니스 로직

		// request.getParameter("key");

		MyModelAndView mav = new MyModelAndView();
		mav.setViewName("/WEB-INF/views/practice03/home.jsp"); // 화면(view) 정보
		// ViewResolver 설정 이전

		mav.addObject("product", "뭐다~"); // view 전달할 데이터 저장
		mav.addObject("itemValue", "abc");

		return mav;
	}

	// 3-2)
	public MyModelAndView process(Map<String, String> paramMap) {

		// paramMap.get("key"); 전달받은 파라미터 확인/활용

		MyModelAndView mav = new MyModelAndView();
		
		mav.setViewName("mainPage/home"); // 화면(view) 정보
		// ViewResolver 설정 이후로 가정

		mav.addObject("product", "뭐다~"); // view 전달할 데이터 저장
		mav.addObject("itemValue", "abc");

		return mav;
	}
}
