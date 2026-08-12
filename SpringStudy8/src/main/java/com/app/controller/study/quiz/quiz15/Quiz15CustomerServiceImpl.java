package com.app.controller.study.quiz.quiz15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Quiz15CustomerServiceImpl implements Quiz15CustomerService {

	@Autowired
	Quiz15CustomerDAO quiz15CustomerDAO;
	
	@Override
	public int saveCustomer(Quiz15Customer quiz15Customer) {
		
		System.out.println("[Service] CustomerService");
		//서비스 로직  ~~
		
		// Service -> DAO   저장수행
		int result = quiz15CustomerDAO.saveCustomer(quiz15Customer);

		return result;
	}

}
