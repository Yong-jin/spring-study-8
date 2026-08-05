package com.app.controller.study.side_conception;

import java.util.HashMap;
import java.util.Map;

public class MyModelAndView {

	String viewName;
	Map<String, Object> model;
	
	public MyModelAndView() {
		model = new HashMap<String, Object>();
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;		
	}
	
	public void addObject(String key, Object value) {
		model.put(key, value);
	}
}
