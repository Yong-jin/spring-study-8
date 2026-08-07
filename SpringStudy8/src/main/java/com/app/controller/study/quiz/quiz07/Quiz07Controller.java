package com.app.controller.study.quiz.quiz07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz07Controller {

	
	// Quiz07 원본
//	@GetMapping("/quiz07/listTest")
//	public String listTest(@RequestParam String type,
//							Model model) {

	// Quiz09 로 인한 추가변경사항
	@GetMapping("/quiz07/listTest/{type}")
	public String listTest(@PathVariable String type,
							Model model) {
		
		// 1) type 값에 따라 구분해서 별도의 페이지로 연결
		/*
		if(type.equals("str")) {
			
			//str 10줄 반복 처리
			//1) view 안에 고정된 텍스트 (하드코딩)
			//2) view 안에 고정텍스트 반복처리 (하드코딩)
			//3) 출력할 메시지를 전달 -> view 안에서 반복
			model.addAttribute("msg", "스트링 리스트입니다!!!");
			
			//4) 출력 전체 내용을 리스트 형태로 전달 -> view 에서 반복
			List<String> strList = new ArrayList<String>();
			for(int i=1; i<=5; i++) {
				strList.add("List 스트링 리스트입니다!");
			}
			model.addAttribute("strList", strList);
			
			return "quiz/quiz07/str";
		} else { //member
			
			// 
			List<Member> memberList = new ArrayList<Member>();
			for(int i=1; i<=10; i++) {
				memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
			}
			
			model.addAttribute("memberList", memberList);
			
			return "quiz/quiz07/member";
		}
		*/
		
		//if(type.equals("member"))
		
		
		// 2) 동일한 페이지 사용 -> view 내부에서 type 값에 따라 동적으로 화면 구성
		
		
		
		model.addAttribute("type", type);
		
		// 각 type 파라미터 기준으로 구분 -> 필요한 연산작업만 수행 
		
		
		
		if(type.equals("str")) {
			model.addAttribute("msg", "스트링 리스트입니다!!!");	
		} else { //member
			List<Member> memberList = new ArrayList<Member>();
			for(int i=1; i<=5; i++) {
				memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
			}
			
			model.addAttribute("memberList", memberList);	
		}
		
		
		return "quiz/quiz07/listTest";
		
		
		
	}
	
}
