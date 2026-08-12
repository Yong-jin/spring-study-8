package com.app.controller.study.quiz.quiz15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Quiz15RoomController {

	@Autowired
	Quiz15RoomService quiz15RoomService;
	
	@GetMapping("/quiz15/registerRoom")
	public String registerRoom() {
		//등록하기위해 입력하는 페이지로 연결
		return "quiz/quiz15/registerRoom";
	}
	
	@PostMapping("/quiz15/registerRoom")
	public String registerRoomAction(@ModelAttribute Quiz15Room quiz15Room) {
		//등록페이지 -> 입력정보 -> 파라미터 전달 받음
		// -> DB에 저장
		
		System.out.println("[Controller] registerRoom");
		
		// Controller -> Service -> DAO -> DB
		//           DTO         DTO    DTO
		
	 	int result = quiz15RoomService.saveRoom(quiz15Room);
	 	if(result > 0 ) {
	 		return "quiz/quiz15/registerRoom";  //저장성공 이후에 보여줄 경로 이동
	 		//return "redirect:/quiz15/main";
	 	} else {
	 		return "quiz/quiz15/registerRoom";
	 	}
		
	}
}
