package com.app.controller.study.side_conception;

import java.util.Map;

public class Controller4 {

	public String process(MyModel myModel) {

		// 비즈니스 로직 처리 ~~~

		myModel.addAttribute("key1", "value1");
		myModel.addAttribute("key2", "value2");
		myModel.addAttribute("key3", "value3");

		return "product/mouse";
	}

	public String process(MyModel myModel, Map<String, String> paramMap) {

		// paramMap.get("key") -> 파라미터 활용/처리

		// 그냥 이 내부에서만 쓰는 지역변수2
		// MyModel model = new MyModel();
		// model.addAttribute("kkk", "vvv");

		myModel.addAttribute("key1", "value1");
		myModel.addAttribute("key2", "value2");
		myModel.addAttribute("key3", "value3");
		
		return "product/keyboard";
	}
}
