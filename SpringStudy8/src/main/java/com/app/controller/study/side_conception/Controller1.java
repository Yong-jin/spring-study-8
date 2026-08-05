package com.app.controller.study.side_conception;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller1 {

	// /board/faq
	public void process(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/faq.jsp");
		rd.forward(request, response);
	}
}
