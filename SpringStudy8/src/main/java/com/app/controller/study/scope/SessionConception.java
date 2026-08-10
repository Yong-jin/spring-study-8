package com.app.controller.study.scope;

import java.util.HashMap;
import java.util.Map;

public class SessionConception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
	
		서버  <---> 사용자
		
		사용자(브라우저) -----> 요청(request) --> 서버
		    쿠키		<----- 응답(response) <--서버
	
		
		쿠키값(JSESSIONID)
		
		사용자 ---> (요청:쿠키값 포함) ---> 서버	
									쿠키값 확인 (key 역할)
									key별(세션구분) 각 세션별로 저장공간영역 ( session.setAttribute )


		Map
		
		Key				Value
		JSESSIONID		저장공간 (key:value  -- SessionStorage)
	
		
		 */
		
		Map<String, SessionStorage> sessionMap = new HashMap<String, SessionStorage>();
		
		// A 사용자가 새로 접근
		
		sessionMap.put("A", new SessionStorage());
		
		
		//다시 request 접근 -> 사용자 A
		SessionStorage session = sessionMap.get("A");
		session.setAttribute("fromB", "FromB Msg");
		session.setAttribute("accessUrl", "A msg");
		
		
		// 다른 B 사용자 접근
		sessionMap.put("B", new SessionStorage());
		
		SessionStorage session2 = sessionMap.get("B");
		
		session2.setAttribute("key1", "value1");
		session2.setAttribute("key2", "value2");
		
		
		
		// 새로운 request A가 다시 접근
		session = sessionMap.get("A");
		System.out.println(session.getAttribute("accessUrl"));
		System.out.println(session.getAttribute("key1")); //B 세션 저장공간에 있는 값 , 접근 불가
	}

}


class SessionStorage {
	
	Map<String, Object> storage;
	
	public SessionStorage() {
		storage = new HashMap<String, Object>();
	}
	
	public Object getAttribute(String key) {
		return storage.get(key);
	}
	
	public void setAttribute(String key, Object value) {
		storage.put(key, value);
	}
	
	public void removeAttribute(String key) {
		storage.remove(key);
	}
	
	public void invalidate() {
		storage.clear();
	}
}



























