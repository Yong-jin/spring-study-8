package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Controller
public class CustomerController {

	//일반 고객 사용자가 접근하는 관련 서비스 
	
	@Autowired
	UserService userService; 
	//사용자 계정정보 관련 서비스 로직
	
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signupAction(User user) {
		
		System.out.println(user);
		
		//사용자가 회원가입 -> DB 저장
		//사용자타입 CUS 
		
		int result = userService.saveCustomerUser(user);
		if( result > 0 ) {
			return "redirect:/main";
		} else {
			return "customer/signup";	
		}
	}
	
	
	@GetMapping("/customer/signin")
	public String signin() {
		return "customer/signin";
	}
	
	@PostMapping("/customer/signin")
	public String signinAction(User user, HttpSession session) {
		
		//로그인처리로직
		
		System.out.println("로그인시 입력한 값");
		System.out.println(user);
		
		// 사용자가 입력한 id pw -> DB 비교
		
		
		// id pw 맞으면 로그인 성공?
		// userType 
		
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER );
		User loginUser = userService.checkUserLogin(user);
		
		//성공//실패
		
		if(loginUser == null) { //실패
			System.out.println("로그인실패");
			return "customer/signin";
		} else { //성공 
			System.out.println("로그인성공");
			System.out.println(loginUser);
			
			//로그인 성공 -> 세션에 아이디 저장
			session.setAttribute("loginUserId", loginUser.getId());
			
			return "redirect:/main";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
