package com.app.controller.study.jstl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.study.request.Product;

@Controller
public class Jstl01Controller {

	
	@GetMapping("/jstl1")
	public String jstl1(Model model) {
		
		model.addAttribute("msg", "안녕하세요");
		
		Product product = new Product();
		product.setId("pid1");
		product.setName("prodName");
		product.setPrice(1234);
		
		model.addAttribute("product", product);
	
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("id1", "name1", 1));
		productList.add(new Product("id2", "name2", 2));
		productList.add(new Product("id3", "name3", 3));
		productList.add(new Product("id4", "name4", 4));
		productList.add(new Product("id5", "name5", 5));
		
		model.addAttribute("productList", productList);
		
		
		//drinkType  : coffee  tea
		//model.addAttribute("drinkType", "coffee");
		//model.addAttribute("drinkType", "tea");
		model.addAttribute("drinkType", "water");
		
		model.addAttribute("score", 500);
		
		
		//model.addAttribute("userType", "admin");
		model.addAttribute("userType", "user");
		//사용자구분 코드    admin   user   
		
		model.addAttribute("isLogin", false);
		//로그인 상태 여부 
		
		
		return "jstl/jstl1";
	}
	
	
	@GetMapping("/jstl2")
	public String jstl2(Model model) {
		
		model.addAttribute("msg1", "<부등호>");
		model.addAttribute("msg2", "&lt;부등호&gt;"); // less than   greater than 
		
		
		model.addAttribute("msgXml", "<script> alert('경고창!'); </script>");
		
		return "jstl/jstl2";
	}
	
	
}
