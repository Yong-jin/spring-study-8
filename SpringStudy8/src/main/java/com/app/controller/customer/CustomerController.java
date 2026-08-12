package com.app.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.service.user.UserService;

@Controller
public class CustomerController {

	//일반 고객 사용자가 접근하는 관련 서비스 
	
	@Autowired
	UserService userService; 
	//사용자 계정정보 관련 서비스 로직
}
