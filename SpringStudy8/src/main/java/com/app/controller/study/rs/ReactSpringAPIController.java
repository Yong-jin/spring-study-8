package com.app.controller.study.rs;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.ApiCommonCode;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.util.LoginManager;

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
	
	// 요청시 body 데이터
	// json format  {id:'adf', pw:'asdf'}
	@PostMapping("/api/login")
	//public String login(@RequestBody APILogin apiLogin, HttpServletRequest request) {
	public ApiResponse<String> login(@RequestBody APILogin apiLogin, HttpServletRequest request) {
		
		System.out.println(apiLogin.getId());
		System.out.println(apiLogin.getPw());
		
		// 입력들어온 id, pw 확인
		// 유효성 검사
		// -> Service -> DAO -> DB T_User 테이블 정보 비교
		
		// 로그인 성공?
		// 로그인 실패?
		
		// 단순텍스트
		// loginOk
		// loginFail  loginNo
		
		
		
		// apiResponse (header, body)
		// resultCode, resultMessage
		
		
		//로그인 성공 유지
		//Session 에 로그인 성공 여부 처리 -> 로그인 사용자 id 세션에 저장
		LoginManager.setSessionLoginUserId(request, apiLogin.getId());
		
		//로그인 성공했다고 치고, 단순 텍스트 형태로 return 
		//return "loginOk";
		
		
		//apiResponse json 포맷 형태로 return
		ApiResponse<String> apiResponse = new ApiResponse<String>();
		
		ApiResponseHeader header = new ApiResponseHeader();
		header.setResultCode(ApiCommonCode.API_LOGIN_SUCCESS);
		header.setResultMessage(ApiCommonCode.API_LOGIN_SUCCESS_MSG);
		
		apiResponse.setHeader(header);
		apiResponse.setBody(apiLogin.getId());
		
		return apiResponse;		
	}
	
	
	@PostMapping("/api/loginCheck")
	public String loginCheck(HttpServletRequest request) {
		
		//로그인 여부 체크
		if(LoginManager.isLogin(request)) {
			String loginId = LoginManager.getLoginUserId(request);
			System.out.println("/api/loginCheck 로그인 인식됨");
			System.out.println(loginId);
			
			return "login user : " + loginId;
		} else {
			return "is not login";
		}
	}
}


















