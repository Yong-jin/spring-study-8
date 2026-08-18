package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

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
			//session.setAttribute("loginUserId", loginUser.getId());
			LoginManager.setSessionLoginUserId(session, loginUser.getId());
			
			//return "redirect:/main";
			return "redirect:/customer/mypage";  //로그인 성공 후 마이페이지로 연결
		}
	}
	
	
	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		//로그인되어있는 사용자의 정보가 표시
		
		//현재 누가 로그인한상태?  -> session 에 있는 "loginUserId" 키값으로 들어있는 아이디 확인
		
		// 아이디를 기반으로 조회
		
		
		//if( session.getAttribute("loginUserId") != null ) { //로그인 상태
		if( LoginManager.isLogin(session) ) {
			
			//String loginUserId = session.getAttribute("loginUserId").toString();
			String loginUserId = LoginManager.getLoginUserId(session);
			
			User user = userService.findUserById(loginUserId);
			
			//view 전달
			model.addAttribute("user", user);
			
			return "customer/mypage";
		}
		
		//로그인이 안되어있으면?? -> 로그인 페이지로 연결
		return "redirect:/customer/signin";
		
	}
	
	
	@GetMapping("/customer/signout")
	public String signout(HttpSession session) {
		
		//세션 초기화
		//session.invalidate();
		LoginManager.logout(session);
		
		return "redirect:/main";
	}
	
	@GetMapping("/customer/modifyPw")
	public String modifyPw(HttpSession session, Model model) {
		
		//로그인상태 -> 마이페이지  
		// -> 비밀번호 변경 페이지로 이동
		
		if( LoginManager.isLogin(session) ) {
			String loginUserId = LoginManager.getLoginUserId(session);
			User user = userService.findUserById(loginUserId);
			model.addAttribute("user", user);
		} else {
			return "redirect:/customer/signin";
		}
		
		
		return "customer/modifyPw";
	}
	
	@PostMapping("/customer/modifyPw")
	public String modifyPwAction(User user) {
		System.out.println(user);
		
		// 비밀번호 변경 
		
		int result = userService.modifyUser(user);
		
		if( result > 0) {
			
			//LoginManager.logout(session);
			//return "redirect:/customer/signin";
			
			return "redirect:/customer/mypage";
		} else {
			return "redirect:/customer/modifyPw";
		}
		
	}
	
	
	@GetMapping("/customer/modifyPw2")
	public String modifyPw2() {
		return "customer/modifyPw2";
	}
	
	@PostMapping("/customer/modifyPw2")
	public String modifyPw2Action(User user, HttpSession session) {
		
		// user 객체에는 사용자가 입력한 바꿀 비번(pw) 데이터 1개만 존재
		// 비번 바꾸려는 사용자 pk  id 필요/세팅
		
		// mypage -> 비번변경 페이지
		// 로그인 O -> session 로그인 사용자 아이디 존재
		
		// set pw = ?
		// where id = ? 
		
		user.setId(  LoginManager.getLoginUserId(session)  );
		
		//user 객체
		//로그인한 id
		//바꿀 pw
		
		System.out.println(user);
		
		int result = userService.modifyUserPw(user);
		
		if( result > 0) {
			return "redirect:/customer/mypage";
		} else {
			return "redirect:/customer/modifyPw";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
