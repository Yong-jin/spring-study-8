package com.app.controller.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Controller
public class RoomController {

	@Autowired  //의존성 주입
	RoomService roomService;
	//스프링이 객체를 관리 -> RoomService 객체를 주입받아서 사용
	
	
	// 보유한 모든 호실정보 조회 페이지
	@GetMapping("/rooms")
	public String rooms(Model model) {
		
		System.out.println("[Controller] /rooms 호출");
		
		//호실정보
		//Controller -> Service -> DAO  <-> DB
		
		List<Room> roomList = roomService.findRoomList();
		
		
		
		// view 에 호실목록 전달
		model.addAttribute("roomList", roomList);
		
		return "room/rooms";
	}
}
