package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request02")
public class Request02Controller {
	
	//@RequestMapping("/request02/url01")
	@RequestMapping("/url01")
	public String url01() {
		return "url1";
	}
	
	//@RequestMapping("/request02/url02")
	@RequestMapping("/url02")
	public String url02() {
		return "url1";
	}
	
	//@RequestMapping("/request02/url03")
	@RequestMapping("/url03")
	public String url03() {
		return "url1";
	}
}
