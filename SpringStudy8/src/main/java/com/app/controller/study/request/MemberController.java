package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {

	@RequestMapping("/member/signup")
	public String signup() {
		return "member/signup";
	}
}
