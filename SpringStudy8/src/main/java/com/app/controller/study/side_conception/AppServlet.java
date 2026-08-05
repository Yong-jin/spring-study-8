package com.app.controller.study.side_conception;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppServlet {
	//Spring
	//건물들어가면 제일 앞에 있는 인포데스크 직원
	//웹에서 요청이 들어왔을때, 흐름/방향 처리
	//DispatcherServlet
	
	//안내시작
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//어떤 주소로 요청을 했지? 주소 확인!
		// /board/faq   /quiz04/A
		
		String requestURI = request.getRequestURI(); //요청 들어온 주소
		
		if(requestURI.equals("/board/faq")) {
			Controller1 con1 = new Controller1();
			con1.process(request, response);
		}
		
		if(requestURI.equals("/member/mypage")) {
			Controller2 con2 = new Controller2();
			// con2 수행
			MyView myView = con2.process(request, response);
			myView.render(request, response);
		}
		
		if(requestURI.equals("/접속경로")) {
			// 3-1) ModelAndView 활용
			Controller3 con3 = new Controller3();
			MyModelAndView mav = con3.process(request, response);
			//  viewName    model : Map<String, Object>
			
			//MyView 객체로 옮겨담기
			MyView myView = new MyView();
			myView.viewName = mav.viewName;  //  mav.viewName 을 MyView viewName 옮겨 담기
			myView.render(request, response, mav.model);
		}
		
		//-------------------------------viewResolver 설정 적용 시점 ---------------------
		
		
		MyViewResolver myViewResolver = new MyViewResolver();
		
		
		if(requestURI.equals("/접속경로")) {
			// 3-2) ModelAndView 활용
			//		+ paramMap 전달 + viewResolver
			
			Controller3 con3 = new Controller3();
			
			//parameter 를 모아서 -> paramMap  Map<String,String> 전달
			
			//request 파라미터 -> Map 옮겨담아서 전달
			
			Enumeration<String> paramNames = request.getParameterNames(); //파라미터 이름(key)들만
			Map<String,String> paramMap = new HashMap<String, String>();
			while(paramNames.hasMoreElements()) {
				//key 획득 (파라미터 이름)
				
				//key value
				String key = paramNames.nextElement();
				paramMap.put(key, request.getParameter(key));
			}
			
									// paramMap 전달
			MyModelAndView mav = con3.process(paramMap);
			// viewName, model 
			
			
			
			//View세팅 -> render
			MyView myView = new MyView();
			// myView.viewName = mav.viewName;  //그냥 옮겨담기
			
			// viewResolver 작동
			myView.viewName =  myViewResolver.viewResolve(mav.viewName);
			
			myView.render(request, response, mav.model);
			
		}
		
		if(requestURI.equals("/접속경로")) {
			//con4
			
			Controller4 con4 = new Controller4();
			
			MyModel myModel = new MyModel();
			//con4.process(myModel);
			
			Enumeration<String> paramNames = request.getParameterNames(); //파라미터 이름(key)들만
			Map<String,String> paramMap = new HashMap<String, String>();
			while(paramNames.hasMoreElements()) {
				//key 획득 (파라미터 이름)
				//key value
				String key = paramNames.nextElement();
				paramMap.put(key, request.getParameter(key));
			}
			
			String viewName = con4.process(myModel, paramMap);
			//mav.viewName
			
			MyView myView = new MyView();
			myView.viewName = myViewResolver.viewResolve(viewName);
			
			myView.render(request, response, myModel.model);
			
		}
	}
}





















