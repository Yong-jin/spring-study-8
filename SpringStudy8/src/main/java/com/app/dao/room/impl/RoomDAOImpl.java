package com.app.dao.room.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;

// 데이터소스와 연결/통신하는 역할
// DB연동 -> DAO
// 외부API -> Repository

//DAO Repository
@Repository
public class RoomDAOImpl implements RoomDAO {

	@Override
	public List<Room> findRoomList() {
		
		// DB 연동 -> room 테이블 데이터 조회 -> List<Room>
		System.out.println("RoomDAOImpl findRoomList");
		
		// return
		return null;
	}

	@Override
	public int saveRoom(Room room) {

		//DB에 room정보 테이블에 room 정보를 저장
		
		return 0;
	}
	
}






