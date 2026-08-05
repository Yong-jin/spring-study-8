package com.app.controller.study.quiz.quiz06;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz06Controller {

	@GetMapping("/quiz06/ask-bmi")
	public String ask_bmi() {
		return "quiz/quiz06/ask-bmi";
	}
	
	@PostMapping("/quiz06/result-bmi")
	public String result_bmi(HttpServletRequest request) {
		// name height weight
		
		
		// 입력 값 확인
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("height"));
		System.out.println(request.getParameter("weight"));
		
		// 값 활용 -> bmi 계산
		//*신체질량지수(BMI) = 체중(kg) / [신장(m)]2
		
		String name = request.getParameter("name");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
		//숫자형으로 변화
		Double heightDb = Double.parseDouble(height);
		Double weightDb = Double.parseDouble(weight);
		
		Double bmi = weightDb / ( (heightDb/100) * (heightDb/100) );
		
		// 화면에 전달해서 출력
		request.setAttribute("name", name);
		request.setAttribute("height", height);
		request.setAttribute("weight", weight);
		
		//printf
		//String.format
		//request.setAttribute("bmi", bmi);
		request.setAttribute("bmi", String.format("%.2f", bmi) );
		
		return "quiz/quiz06/result-bmi";
		
	}
	
	
	@PostMapping("/quiz06/result-bmi2")
	public String result_bmi2(@RequestParam String name,
								@RequestParam String height,
								@RequestParam String weight,
								Model model) {
		// name height weight
		
		
		// 입력 값 확인
		
		// 값 활용 -> bmi 계산
		//*신체질량지수(BMI) = 체중(kg) / [신장(m)]2
		//숫자형으로 변화
		Double heightDb = Double.parseDouble(height);
		Double weightDb = Double.parseDouble(weight);
		
		Double bmi = weightDb / ( (heightDb/100) * (heightDb/100) );
		
		// 화면에 전달해서 출력
		model.addAttribute("name", name);
		model.addAttribute("height", height);
		model.addAttribute("weight", weight);
		
		//printf
		//String.format
		//request.setAttribute("bmi", bmi);
		model.addAttribute("bmi", String.format("%.2f", bmi) );
		
		return "quiz/quiz06/result-bmi";
		
	}
	
	
	@PostMapping("/quiz06/result-bmi3")
	public String result_bmi3(@RequestParam Map<String, String> paramMap,
								Model model) {
		// name height weight
		
		
		// 입력 값 확인
		
		// 값 활용 -> bmi 계산
		//*신체질량지수(BMI) = 체중(kg) / [신장(m)]2
		//숫자형으로 변화
		double heightDb = Double.parseDouble(paramMap.get("height"));
		double weightDb = Double.parseDouble(paramMap.get("weight"));
		
		//Double bmi = weightDb / ( (heightDb/100) * (heightDb/100) );
		double bmi = calculateBmi(heightDb, weightDb);
		
		// 화면에 전달해서 출력
		model.addAttribute("name", paramMap.get("name"));
		model.addAttribute("height", paramMap.get("height"));
		model.addAttribute("weight", paramMap.get("weight"));
		
		//printf
		//String.format
		//request.setAttribute("bmi", bmi);
		model.addAttribute("bmi", String.format("%.2f", bmi) );
		
		return "quiz/quiz06/result-bmi";
		
	}
	
	
	@PostMapping("/quiz06/result-bmi4")
	public String result_bmi4(@ModelAttribute PersonBmi personBmi,
								Model model) {
		// name height weight
		
		
		// 입력 값 확인
		
		// 값 활용 -> bmi 계산
		//*신체질량지수(BMI) = 체중(kg) / [신장(m)]2
		//숫자형으로 변화
//		Double heightDb = Double.parseDouble(personBmi.getHeight());
//		Double weightDb = Double.parseDouble(personBmi.getWeight());
//		
//		Double bmi = weightDb / ( (heightDb/100) * (heightDb/100) );
		
		double bmi = calculateBmi(personBmi.getHeight(), personBmi.getWeight());
		
		personBmi.setBmi(bmi);
		
		// 화면에 전달해서 출력
		model.addAttribute("personBmi", personBmi);
		
		return "quiz/quiz06/result-bmi";
	}
	
	
	//bmi 계산 메소드 
	public double calculateBmi(double height, double weight) {
		//Double bmi = weight / ( (height/100) * (height/100) );
		double bmi = weight / ( Math.pow( (height/100), 2) );  //제곱 pow 함수
		return bmi;
	}
	
	
	public double calculateBmi(String height, String weight) {
		Double heightDb = Double.parseDouble(height);
		Double weightDb = Double.parseDouble(weight);
		return calculateBmi(heightDb, weightDb);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
