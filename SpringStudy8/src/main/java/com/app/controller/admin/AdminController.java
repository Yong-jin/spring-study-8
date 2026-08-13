package com.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.room.Room;
import com.app.dto.user.User;
import com.app.service.room.RoomService;
import com.app.service.user.UserService;

@Controller
public class AdminController {
	//관리자 접근 페이지   (전체 관리자) or (판매자측/호텔측 사용자)
	//			운영회사측 전체관리자
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	UserService userService;
	
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
	
	
	
	//관리자가 사용자계정관리 -> 사용자 계정 임의로 추가
	@GetMapping("/admin/users/add")
	public String addUser() {
		return "admin/addUser";
	}
	
	@PostMapping("/admin/users/add")
	//public String addUserAction(@ModelAttribute User user) {
	public String addUserAction(User user) {
		//model.addAttribute("user", user);
		
		//user 정보를 DB에 저장
		System.out.println(user);
		
		//고객의 id와 name 만 보유
		//고객의 계정 -> userType 값이 "CUS" 코드로 저장되어야함.
		
		
		/*
			1) 컨트롤러에서 바로 처리
			user.setUserType("CUS");
			int result = userService.saveUser(user);
			
			2) 서비스 계층/레이어/레벨 에서 사용자를 저장하는 메소드 형태로 사용
			int result = userService.saveCustomerUser(user);
		 */
		
		//Controller  사용자 -> 요청/응답 처리(흐름)
		//Service  업무규칙, 비즈니스로직 핵심 처리
		//DAO(Repository)  데이터 접근 처리 (DB, API ...)
		
		
		int result = userService.saveCustomerUser(user);
		
		if(result > 0) {
			return "redirect:/admin/users";
		} else {
			return "admin/addUser";
		}
				
	}
	
	
	
	@GetMapping("/admin/users")
	public String users(Model model) {
		List<User> userList = userService.findUserList();
		model.addAttribute("userList", userList);
		
		return "admin/users";
	}
	
	
	
	
	
	
	
}

















