package com.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Controller
public class AdminController {
	//관리자 접근 페이지   (전체 관리자) or (판매자측/호텔측 사용자)
	//			운영회사측 전체관리자
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		return "admin/registerRoom";
	}
	
	@PostMapping("/admin/registerRoom")
	public String registerRoomAction(@ModelAttribute Room room) {
		
		//화면으로부터 입력한 값이 잘 넘어왔는지 체크
		System.out.println(room); 
		
		int result = roomService.saveRoom(room);
		
		
		// result 값 확인 -> 성공/실패 -> 진행
		System.out.println("insert 처리 결과 리턴받은 적용된 행의 수: " +  result);
		
		if(result > 0) { //저장 성공
			return "redirect:/admin/rooms";	
		} else { //저장 실패
			return "admin/registerRoom";
		}
		
	}
	
	//관리자가 객실관리   전체 객실 목록 조회
	@GetMapping("/admin/rooms")
	public String rooms(Model model) {
		
		//rooms 페이지
		// T_ROOM 테이블 객실데이터   -> 조회  -> view전달 -> 표시
		
		List<Room> roomList = roomService.findRoomList();
		
		model.addAttribute("roomList", roomList);
		
		return "admin/rooms";		
	}
}

















