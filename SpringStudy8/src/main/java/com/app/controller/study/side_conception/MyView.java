package com.app.controller.study.side_conception;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {

	public String viewName;

	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}
	
	
	public void render(HttpServletRequest request, HttpServletResponse response,
						Map<String, Object> model ) throws ServletException, IOException {
		
		// model에 저장되어 있는 넘기려는 데이터 -> request 객체 옮겨 담기
		for(String key : model.keySet()) {
			//     key :  value   Map에서 value에 접근하기 : model.get(key) 
			
			request.setAttribute(key, model.get(key));
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}
	
}
