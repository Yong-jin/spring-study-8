package com.app.controller.study.quiz.quiz14;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Quiz14Configuration {

	//Bean 등록 설정
	
	//Coffee
	//Cup
	
	
	//Dessert
	//Plate
	
	// CoffeeBean coffeeBean = new CoffeeBean();

	@Bean
	public CoffeeBean coffeeBean() {
		
		CoffeeBean coffeeBean = new CoffeeBean();
		coffeeBean.setName("민트초코프라페");
		
		return coffeeBean;
	}
	
	// Cup cup = new Cup();
	// cup.setCoffeeBean(coffeeBean);
	
	// Cup cup = new Cup(coffeeBean);
	
	@Bean
	public CupBean cupBean(CoffeeBean coffeeBean) {
		CupBean cupBean = new CupBean();
		cupBean.setCoffeeBean(coffeeBean); //의존성주입
	
		return cupBean;
	}
	
	
	@Bean
	public DessertBean dessertBean() {
		DessertBean dessertBean = new DessertBean();
		dessertBean.setName("당근케이크");
		return dessertBean;
	}
	
	
	@Bean
	public PlateBean plateBean(DessertBean dessertBean) {
		//생성자 통한 의존성 주입
		PlateBean plateBean = new PlateBean(dessertBean);
		return plateBean;
	}
	
	
	
}


















