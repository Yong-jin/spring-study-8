package com.app.scheduler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.service.room.RoomService;
import com.app.service.user.UserService;

public class DailySalesScheduler {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoomService roomService;
	
	//UserDAO
	
	//https://docs.spring.io/spring-framework/reference/integration/scheduling.html
	//cron 설정기준
	//https://docs.spring.io/spring-framework/reference/integration/scheduling.html#scheduling-cron-expression
	
	//@Scheduled(cron = "0/5 * * * * *")
	public void test1() {
		System.out.println("DailySalesScheduler test1() " + LocalDateTime.now());
	}
	
	
	//@Scheduled(cron ="0 0 2 * * *")
	//@Scheduled(cron ="0/10 * * * * *")
	public void dailySales() {
		//일일정산
		//매출통계
		//DB 병합
		System.out.println("10초마다 한번 service 확인");
		userService.findUserById("abc");
		roomService.findRoomList();
	}
}








