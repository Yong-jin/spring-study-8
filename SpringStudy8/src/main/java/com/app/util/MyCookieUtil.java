package com.app.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class MyCookieUtil {

	// getCookie Cookie
	
	//쿠키 기본 세팅 Encode/Decode 간주
	public static String getCookieValue(Cookie[] cookies, String cookieName) {
		
		String value = null;
		
		for( Cookie ck : cookies) {
			if(ck.getName().equals(cookieName)) {
				
				//value = ck.getValue(); //그냥 읽기
				//value decode 처리해서 읽기
				try {
					value = URLDecoder.decode(ck.getValue(), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return value;
	}
	
	//리팩토링 후
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		return getCookieValue(cookies, cookieName);
	}
	
	/*
	 //리팩토링 전
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		
		Cookie[] cookies = request.getCookies();
		String value = null;
		
		for( Cookie ck : cookies) {
			if(ck.getName().equals(cookieName)) {
				
				//value = ck.getValue(); //그냥 읽기
				//value decode 처리해서 읽기
				try {
					value = URLDecoder.decode(ck.getValue(), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return value;
	}
	*/
	
	
	public static Cookie createCookie(String name, String value) {
		Cookie ck = new Cookie(name, encodeValue(value));
		//maxAge 세팅 생략 or maxAge(-1) --> 세션 쿠키 : 해당 브라우저의 세션 단위까지 사용
		return ck;
	}
	
	public static Cookie createCookie(String name, String value, int maxAge) {
		Cookie ck = new Cookie(name, encodeValue(value));
		ck.setMaxAge(maxAge);
		return ck;
	}
	
	public static Cookie createCookieForRemove(String name) {
		Cookie ck = new Cookie(name, "");
		ck.setMaxAge(0);  //수명을 0으로 세팅 후 전달 -> 삭제 기능
		return ck;
	}
	
	public static String encodeValue(String value) {
		String result = null;
		try {
			result = URLEncoder.encode(value, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
