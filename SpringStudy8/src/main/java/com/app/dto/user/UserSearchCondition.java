package com.app.dto.user;

import lombok.Data;

@Data
public class UserSearchCondition {
	
	String id;
	String name;
	String searchKeyword;
	String userType;
}
