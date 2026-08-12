package com.app.service.room.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;
import com.app.service.room.RoomService;

// new RoomServiceImpl()

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired  //자동주입
	RoomDAO roomDAO;
	
	
	//생성자를 통한 의존성 주입
//	public RoomServiceImpl(RoomDAO roomDAO) {
//		this.roomDAO = roomDAO;
//	}
	
	//setter 메소드를 통한 의존성 주입
//	public void setRoomDAO(RoomDAO roomDAO) {
//		this.roomDAO = roomDAO;
//	}
	
	@Override
	public List<Room> findRoomList() {

		System.out.println("RoomServiceImpl findRoomList");
		
		//핵심 비즈니스 로직  | 서비스 로직
		
		//전체호실정보 조회 
		
		// DAO 활용(호출) ->  실제 DB에서 데이터 조회해서 달라!
		List<Room> roomList = roomDAO.findRoomList();
		
		return roomList;
	}


	@Override
	public int saveRoom(Room room) {
		
		//Controller 가 저장할 room 을 매개변수로 전달
		// -> 전달받은 매개변수 room -> DAO 전달 저장해달라! 
		// -> DAO가 DB에저장 -> 저장결과를 return 
		// -> 서비스 입장에서 return 받은 결과를 Controller 에게 return
		
		int result = roomDAO.saveRoom(room);
		
		return result;
	}
	
	
}













	