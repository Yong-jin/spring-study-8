package com.app.dto.user;

import lombok.Data;

@Data
public class UserProfileImage {

	String id;		//T_USER 사용자 id
	String fileName; //FILE_INFO 첨부파일->유니크->파일이름
}
