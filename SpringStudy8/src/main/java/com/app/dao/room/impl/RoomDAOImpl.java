package com.app.dao.room.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;

// 데이터소스와 연결/통신하는 역할
// DB연동 -> DAO
// 외부API -> Repository

//DAO Repository
@Repository
public class RoomDAOImpl implements RoomDAO {

	//DB연동 처리할때 필요한 관련된 객체(Bean) 주입
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public List<Room> findRoomList() {
		
		// DB 연동 -> room 테이블 데이터 조회 -> List<Room>
		System.out.println("RoomDAOImpl findRoomList");
		
		List<Room> roomList = sqlSessionTemplate.selectList("room_mapper.findRoomList");
		
		return roomList;
	}

	@Override
	public int saveRoom(Room room) {

		//DB에 room정보 테이블에 room 정보를 저장
								//실행할 쿼리 위치의 식별자, 매개변수
		int result = sqlSessionTemplate.insert("room_mapper.saveRoom", room);
		//수행 적용된 행의 수
		
		return result;
	}
	
}






