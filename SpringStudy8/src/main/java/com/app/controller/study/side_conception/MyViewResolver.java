package com.app.controller.study.side_conception;

public class MyViewResolver {

	String prefix;
	String suffix;

	public MyViewResolver() {
		prefix = "/WEB-INF/views/";
		suffix = ".jsp";
	}

	public String viewResolve(String viewName) {
		// viewName : mainpage
		// "/WEB-INF/views/" + "mainpage" + ".jsp";
		// /WEB-INF/views/mainpage.jsp

		return prefix + viewName + suffix;
	}
}
