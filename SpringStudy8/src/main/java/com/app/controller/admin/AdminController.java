package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.room.Room;
import com.app.dto.room.RoomSearchCondition;
import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;
import com.app.service.room.RoomService;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

@Controller
public class AdminController {
	//관리자 접근 페이지   (전체 관리자) or (판매자측/호텔측 사용자)
	//			운영회사측 전체관리자
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	UserService userService;
	
	private static final Logger log = LogManager.getLogger(AdminController.class);
	
	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		
		System.out.println("println");
		log.info("log level info 기본 사항");
		log.error("심각한 에러 발생 추후 꼭 처리 ");
		log.warn("경고 지금 수행은 문제 없으나 확인해볼것");
		
		log.debug("디버그 레벨 로그");
		
		log.trace("trace level 메시지 1");
		log.trace("trace level 메시지 2");
		log.trace("trace level 메시지 3");
		
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
//	@GetMapping("/admin/rooms")
//	public String rooms(Model model) {
//		
//		//rooms 페이지
//		// T_ROOM 테이블 객실데이터   -> 조회  -> view전달 -> 표시
//		
//		List<Room> roomList = roomService.findRoomList();
//		
//		model.addAttribute("roomList", roomList);
//		
//		return "admin/rooms";		
//	}
	
	@GetMapping("/admin/rooms")
	public String rooms(Model model, RoomSearchCondition roomSearchCondition) {
		
		System.out.println(roomSearchCondition);
		
		//rooms 페이지
		// T_ROOM 테이블 객실데이터   -> 조회  -> view전달 -> 표시
		
		List<Room> roomList = roomService.findRoomListBySearchCondition(roomSearchCondition);
		
		model.addAttribute("roomList", roomList);
		model.addAttribute("roomSearchCondition", roomSearchCondition);
		
		return "admin/rooms";		
	}
	
	
	//객실 개별 상세 페이지 조회
	//@GetMapping("/admin/room?roomId=3")
	@GetMapping("/admin/room/{roomId}")
	public String room( @PathVariable String roomId, Model model ) {
		
		int roomIdPk = Integer.parseInt(roomId);
		
		Room room = roomService.findRoomByRoomId(roomIdPk);
		model.addAttribute("room", room);
		
		if(room == null) { //조회한 room 데이터가 없다 or 문제발생 or roomId가 잘못됐다. 
			// 조회 정보가 없다고 보여주는 페이지
		}
		
		return "admin/room";
	}
	
	
	
	//객실정보 삭제
	// @GetMapping("/admin/removeRoom?roomId=3")
	@GetMapping("/admin/removeRoom")
	public String removeRoom(HttpServletRequest request) {
		String roomId = request.getParameter("roomId");
		
		if( roomId == null ) {
			// 삭제할 아이디 없을때? 
			return "redirect:/admin/rooms"; 
		}
		
		int roomIdPk = Integer.parseInt(roomId);
		int result = roomService.removeRoom(roomIdPk);
		
		if(result > 0){ }
		
		return "redirect:/admin/rooms"; 
	}
	
	
	//  localhost:8080/admin/modifyRoom?roomId=5
	@GetMapping("/admin/modifyRoom")
	public String modifyRoom( HttpServletRequest request ) {
		//수정화면에 진입시, 기존 값들 세팅
		
		String roomId = request.getParameter("roomId");
		
		if( roomId == null ) {
			return "redirect:/admin/rooms";
		}
		
		
		// PK roomId -> 해당 pk를 가진 객실정보 조회  -> view 전달 -> 화면에 세팅
		
		int roomIdPk = Integer.parseInt(roomId);
		Room room = roomService.findRoomByRoomId(roomIdPk);
		
		System.out.println("수정화면진입 기존에 가지고 있는 정보");
		System.out.println(room);
		
		//view 전달
		request.setAttribute("room", room);
		
		return "admin/modifyRoom";
	}
	
	@PostMapping("/admin/modifyRoom")
	public String modifyRoomAction( Room room ) {
		
		System.out.println("수정하려는 객실 정보");
		System.out.println(room);
		
		int result = roomService.modifyRoom(room);
		
		if(result > 0) { //성공
			//수정 성공시 해당 호실 상세페이지
			return "redirect:/admin/room/" + room.getRoomId();
		} else { //수정 실패
			//수정페이지로 다시 진입
			return "redirect:/admin/modifyRoom?roomId=" + room.getRoomId();	
		}
		
		
	}
	
	
	
	
	
	
	
	
	//-------------------------------------------------
	
	
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
		
		
		//********유효성 검증********//
		// 서버측에서 insert 처리전에 값을 확인
		
		// 0) 자바 코드로...
		if(user.getId() == null || user.getId().trim().equals("") ) {
			//id 공백으로 넘어옴. 입력 제대로 안됨. 유효성 검증 필터 
			log.info("아이디 유효성 검증 필터링 처리 {}", user);
			return "admin/addUser";
		}
		
		if(user.getId().length() < 4 || user.getId().length() > 12) {
			log.info("아이디 유효성 검증 아이디 길이 안맞음 {}", user);
			return "admin/addUser";
		}
		
		
		int result = userService.saveCustomerUser(user);
		
		if(result > 0) {
			return "redirect:/admin/users";
		} else {
			return "admin/addUser";
		}
				
	}
	
	
	
	@GetMapping("/admin/users")
	public String users(Model model,  UserSearchCondition userSearchCondition ) {
		//검색조건 
		// 검색조건 O -> 조건 검색 결과
		// 검색조건 X -> 전체 조회
		System.out.println(userSearchCondition);
		
		//List<User> userList = userService.findUserList();
		List<User> userList = userService.findUserListBySearchCondition(userSearchCondition);
		
		model.addAttribute("userList", userList);
		model.addAttribute("userSearchCondition", userSearchCondition);
		
		return "admin/users";
	}
	
	
	
	@GetMapping("/admin/user/{id}")
	public String user(@PathVariable String id, Model model ) {
		
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		
		return "admin/user";
	}
	
	
	@GetMapping("/admin/modifyUser/{id}")
	public String modifyUser(@PathVariable String id, Model model ) {
		
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		
		return "admin/modifyUser";
	}
	
	@PostMapping("/admin/modifyUser")
	public String modifyUserAction(User user) {
		
		System.out.println("modifyUser 에 요청 들어온 값 ");
		System.out.println(user);
		
		//DB 수정 update
		int result = userService.modifyUser(user);
		
		if(result > 0) {  //수정 성공 -> 사용자 상세페이지
			return "redirect:/admin/user/" + user.getId();
		} else {  //수정실패 -> 다시 수정 페이지
			return "redirect:/admin/modifyUser/" + user.getId();
		}
	}
	
	
	//--------------------------------
	
	@GetMapping("/admin/signin")
	public String signin() {
		return "admin/signin";
	}
	
	@PostMapping("/admin/signin")
	public String signinAction(User user, HttpSession session) {
		
		log.info("관리자페이지 로그인 시도");
		log.info(user);
		
		user.setUserType( CommonCode.USER_USERTYPE_ADMIN );
		User loginUser = userService.checkUserLogin(user);
		
		//성공//실패
		if(loginUser == null) { //실패
			System.out.println("로그인실패");
			return "admin/signin";
		} else { //성공 
			log.info("관리자 계정 로그인성공 {}", loginUser);
			
			//로그인 성공 -> 세션에 아이디 저장
			LoginManager.setSessionLoginUserId(session, loginUser.getId());
			
			//return "redirect:/main";
			return "redirect:/admin/users";  //관리자 계정 로그인 성공 후
		}
	}
}

















