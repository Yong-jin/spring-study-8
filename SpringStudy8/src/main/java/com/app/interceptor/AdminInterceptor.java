package com.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

public class AdminInterceptor implements HandlerInterceptor {

	@Autowired
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//  /admin 으로 시작하는 경로에 인터셉터를 적용
		
		// 로그인여부 + 관리자 계정여부 (userType ADM)
		
		if(LoginManager.isLogin(request)) { //로그인 O
			
			// 관리자 계정이 맞나?
			
			// 현재 로그인한 계정이 있다.
			// 로그인한 계정 아이디? -> 정보 획득 -> userType ADM 인가?
			
			String userId = LoginManager.getLoginUserId(request);
			User user = userService.findUserById(userId);
			
			//관리자여부 판단
			if(user.getUserType().equals( CommonCode.USER_USERTYPE_ADMIN )) { //관리자 맞다
				//기존 처리대로 그대로 다음과정 순차적으로 진행
				return HandlerInterceptor.super.preHandle(request, response, handler);
			} else { //관리자가 아니다
				//다른 페이지로 
				response.sendRedirect("/main");  //사용자계정이므로 메인페이지로 이동
				return false; //진행 X
			}
		} else {  //로그인 X 상태
			//잘못된 접속
			response.sendRedirect("/error/badAccess");  //잘못된 접근을 나타내는 처리 경로가 있다고 가정
			return false; //진행 X
		}
		
		
		
	}
}
