package com.app.controller.study.rest;

import java.util.List;

import lombok.Data;

@Data
public class ApiDelivery {

	String staffName;  //배송기사 
	String destination;//목적지
	String phone;//연락처
	
	ApiStore apiStore; //매장정보
	List<ApiMenu> menuList; //메뉴목록
}
