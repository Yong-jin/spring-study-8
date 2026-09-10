package com.app.controller.study.rs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactSpringAPIController {

	
	//API 통신용 컨트롤러 (React <-> Spring)
	
	@GetMapping("/api/getMsg")
	public String getMsg() {
		System.out.println("/api/getMsg");
		return "Spring RESTAPI api getMsg";
	}
	
	@GetMapping("/api/getDrinks")
	public List<DrinkItem> getDrinks(){
		
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		drinkList.add(new DrinkItem("유자차", "차"));
		drinkList.add(new DrinkItem("율무차", "차"));
		drinkList.add(new DrinkItem("생강차", "차"));
		
		// api 통신시 전달할 데이터 수집 -> 객체 -> return -> JSON 전달
		
		// 로직 -> service dao db 
		
		System.out.println("/api/getDrinks");
		
		return drinkList;
	}
	
	@GetMapping("/api/getDrinksDiv")
	public List<DrinkItem> getDrinks(@RequestParam String type){
		
		System.out.println("/api/getDrinksDiv " + type);
		
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		
		if(type.equals("커피")) {
			drinkList.add(new DrinkItem("카페모카", "커피"));
			drinkList.add(new DrinkItem("에스프레소", "커피"));
			drinkList.add(new DrinkItem("콜드브루", "커피"));
		}
		
		if(type.equals("차")) {
			drinkList.add(new DrinkItem("유자차", "차"));
			drinkList.add(new DrinkItem("율무차", "차"));
			drinkList.add(new DrinkItem("생강차", "차"));
		}
		
		return drinkList;
		
	}
	
	
	@PostMapping("/api/getDrinksNum")
	//public List<DrinkItem> getDrinksNum(@RequestBody String num){
	public List<DrinkItem> getDrinksNum(@RequestBody DrinksNum drinksNum){
		
		// api 요청 -> (단순 num) -> @RequestBody String
		// api 요청 -> {jsonformat} -> DTO객체
		
		// 요청 jsonformat 예시   { num:1, type:'jsontext' }
		
		System.out.println("/api/getDrinksNum");
		//System.out.println(num);
		System.out.println(drinksNum);
		
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		drinkList.add(new DrinkItem("name"+drinksNum.getNum(), "type1"+drinksNum.getNum()));
		
		return drinkList;
	}
}
















