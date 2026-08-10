package com.app.controller.study.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Cookie01Controller {

	
	@GetMapping("/saveCookie")
	public String saveCookie(HttpServletResponse response) {
		
		//사용자 -> 요청 -> 서버
		
		//서버에서 쿠키를 생성 -> response 객체 담아서 전달(응답)
		//		-> 사용자 : 응답에 들어있는 쿠키 확인 -> 쿠키? -> 쿠키 저장
		
		// 쿠키생성				name(key) value
		Cookie ck1 = new Cookie("menu", "kimbab");
		//쿠키 유지하는 수명 (초단위)
		ck1.setMaxAge( 60 * 60 * 12 );  //12시간
		
		//응답에 담아주기
		response.addCookie(ck1);
		
		
		Cookie ck2 = new Cookie("today", "sunny");
		ck2.setMaxAge(30);
		response.addCookie(ck2);
		
		
		//쿠키 value 에는 기본으로 띄어쓰기가 불가능
		//   인코딩하여 관리 (URLEncode)
		
		try {
			
			String value = URLEncoder.encode("temp text 12", "UTF-8");
			
			Cookie ck3 = new Cookie("temp", value);
			ck3.setMaxAge(60 * 60 );
			response.addCookie(ck3);
			
			
			Cookie ck4 = new Cookie("status", URLEncoder.encode("상당히 배고프고 졸리고", "UTF-8"));
			ck4.setMaxAge(60 * 60);
			response.addCookie(ck4);
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Util 활용
		Cookie ck5 = MyCookieUtil.createCookie("ck5", "555");
		response.addCookie(ck5);
		
		Cookie ck6 = MyCookieUtil.createCookie("ck6", "666", 60*60);
		response.addCookie(ck6);
		
		
		return "cookie/saveCookie";
		
	}
	
	@GetMapping("/readCookie")
	public String readCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		String menu = null;
		for(Cookie ck : cookies) {
			
			System.out.println(ck.getName() + "  :  " + ck.getValue());
			
			
			//Encode 처리된 쿠키들
			if(ck.getName().equals("temp") || ck.getName().equals("status") ) {
				//decode 처리해서 출력
				
				try {
					
					String value = URLDecoder.decode(ck.getValue(), "UTF-8");
					System.out.println(ck.getName() + "  :  " + value);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(ck.getName().equals("menu")) {
				menu = ck.getValue();
			}
		}
		
		request.setAttribute("menu", menu);
		
		
		
		//util 사용
		//Cookie[] cookies = request.getCookies();
		
		String temp = MyCookieUtil.getCookieValue(cookies, "temp");
		String status = MyCookieUtil.getCookieValue(cookies, "status");
		System.out.println(temp);
		System.out.println(status);
		
		String status2 = MyCookieUtil.getCookieValue(request, "status");
		System.out.println(status2);
		
		System.out.println( MyCookieUtil.getCookieValue(request, "ck5") );
		System.out.println( MyCookieUtil.getCookieValue(request, "ck6") );
		
		return "cookie/readCookie";
	}
	
	
	@GetMapping("/removeCookie")
	public String removeCookie(HttpServletResponse response) {
		//쿠키 삭제하기
		// 쿠키 수명시간 0으로세팅 -> 전달 -> 삭제
		Cookie ck1 =  MyCookieUtil.createCookieForRemove("menu");
		response.addCookie(ck1);
		
		Cookie ck2 = new Cookie("temp", null);
		ck2.setMaxAge(0);
		response.addCookie(ck2);
		
		return "cookie/saveCookie"; //화면만 오류 안나게 연결
		
	}
	
}


















