package com.app.controller.study.side_conception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller2 {

	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Controller2 에서 처리해야하는 비즈니스 로직

		// View 에 관한 정보를 MyView 객체로 만들어서 전달(반환/return)
		MyView myView = new MyView();
		myView.viewName = "/WEB-INF/views/member/mypage.jsp";

		return myView;

	}
}
