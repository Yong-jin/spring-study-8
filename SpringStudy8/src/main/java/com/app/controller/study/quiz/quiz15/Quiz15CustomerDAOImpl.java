package com.app.controller.study.quiz.quiz15;

import org.springframework.stereotype.Repository;

@Repository
public class Quiz15CustomerDAOImpl implements Quiz15CustomerDAO {

	@Override
	public int saveCustomer(Quiz15Customer quiz15Customer) {

		//DB연결
		//DB 저장해라~
		
		// DB 저장 수행 결과 return
		System.out.println("[DAO] CustomerDAO");
		
		return 0;
	}

}
