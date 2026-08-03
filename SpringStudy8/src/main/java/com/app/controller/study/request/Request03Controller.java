package com.app.controller.study.request;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.request.Product;
import com.app.dto.study.request.ProductRequestForm;

@Controller
@RequestMapping("/request03")
public class Request03Controller {
	
	
	// localhost:8080/request03/param1?msg=hi&page=1&level=5
	// localhost:8080/request03/param1?msg=hello&page=999&level=1231
	@GetMapping("/param1")
	public String param1(HttpServletRequest request) {
		
		System.out.println("/request03/param1");
		System.out.println( request.getParameter("msg") );
		System.out.println( request.getParameter("page") );
		System.out.println( request.getParameter("level") );
		
		return "req/param/param1";
	}
	
	// localhost:8080/request03/param2?name=abc&count=123 
	@PostMapping("/param2")
	public String param2(HttpServletRequest request) {
		System.out.println("/request03/param2");
		System.out.println( request.getParameter("name") );
		System.out.println( request.getParameter("count") );
		
		return "req/param/param2";
	}
	
	
	
	@GetMapping("/param3")
	public String param3(HttpServletRequest request) {
	
		// localhost:8080/request03/param3?p1=10&p2=20&p3=30
		
		System.out.println("/request03/param3");
		System.out.println(request.getParameter("p1"));
		System.out.println(request.getParameter("p2"));
		System.out.println(request.getParameter("p3"));
		
		
		// localhost:8080/request03/param3?p1=10&p2=20&p3=30&p3=40
		// 여러개의 값을 가진 파라미터
		String[] p3Values = request.getParameterValues("p3"); 
		for(String s: p3Values) {
			System.out.println(s);
		}
		
		return "req/param/param2";
	}
	
	
	@RequestMapping("/param4") //get post
	public String param4(@RequestParam String p1, @RequestParam String p2 ) {
		// localhost:8080/request03/param4?p1=10&p2=20
		
		System.out.println("/request03/param4");
		System.out.println(p1);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	
	
	@RequestMapping("/param5") //get post
	public String param5(@RequestParam String p1, @RequestParam(required = false) String p2 ) {
		// localhost:8080/request03/param5?p1=10&p2=20				//필수X  없어도 됨
		
		System.out.println("/request03/param5");
		System.out.println(p1);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	@RequestMapping("/param6") //get post
	public String param6(@RequestParam String p1,
						@RequestParam(required = false, defaultValue = "p2Default") String p2 ) {
		// localhost:8080/request03/param6?p1=10&p2=20				//필수X  없어도 됨
		
		System.out.println("/request03/param6");
		System.out.println(p1);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	@RequestMapping("/param7")
	public String param7(@RequestParam Map<String, String> paramMap) {
		// 요청에 담겨져서 넘어오는 파라미터 값들...
		// p1=10&p2=20	   key:value
		
		// localhost:8080/request03/param7?p1=10&p2=20&count=9999
		// localhost:8080/request03/param7?p1=1210&p2=202121&count=9999&msg=hihi&time=1237&etc=21fj
		System.out.println("/param7");
		System.out.println(paramMap.get("p1"));
		System.out.println(paramMap.get("p2"));
		System.out.println(paramMap.get("count"));
		
		System.out.println("------");
		for(String key :  paramMap.keySet()) {
			System.out.println(key + " : " + paramMap.get(key));
		}
		
		
		return "req/param/param2";
		
	}
	
	
	// GET 요청		조회/읽기		데이터 조회/단순 화면 전달   -> 요청 파라미터에 따라서 그에 맞는 화면 연결
	// POST 요청 	 	쓰기/저장		데이터 전달 -> 실제 데이터 받아서 로직 처리
	
	@GetMapping("/param8")
	public String param8() {
		
		System.out.println("param8 요청 [GET 요청] -> 화면 전달");
		return "req/param/param8";
	}
	
	@PostMapping("/param8")
	//param8   param8Action  param8Process  param8Proc
//	public String param8(HttpServletRequest request) {
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("price"));
										//DTO 객체
	//public String param8(@ModelAttribute Product product) {
	public String param8(@ModelAttribute ProductRequestForm product) {
		
		//DTO 객체로 전달받기
		System.out.println("param8 POST요청");
		//System.out.println(product.id);
		System.out.println(product.toString());
		
		// (+입력시 입력화면마다 다른 제약조건(유효성검증)으로 인해 많이 사용함)
		// productrequestform 으로 전달 받고
		// product.getType() .... -> 로직 활용하고
		// productrequestform -> product  데이터 이동(복사)
		// product 객체 -> DB 저장
		
		//product dto -> DB 저장 
		
		return "req/param/param8after";
	}
		
	
	//localhost:8080/request03/param8?itemId=1234
	
	//localhost:8080/request03/param8/1234
	@RequestMapping("/param9/{itemId}")
	public String param9(@PathVariable String itemId) {
		
		System.out.println("/request03/param9/{itemId}");
		System.out.println(itemId);
		
		return "req/param/param2";
	}
	
	
}



