package com.app.controller.study.quiz.quiz15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Quiz15RoomServiceImpl implements Quiz15RoomService {

	@Autowired
	Quiz15RoomDAO quiz15RoomDAO;
	
	@Override
	public int saveRoom(Quiz15Room quiz15Room) {
		System.out.println("[Service] saveRoom");
		
		int result = quiz15RoomDAO.saveRoom(quiz15Room);
		
		return result;
	}

}
