package com.app.controller.study.quiz.quiz08;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	String id;
	String pw;
	String name;
	String type;
}
