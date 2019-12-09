package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SearchParam;

@RestController
@RequestMapping("/api")
public class GetController {
	
	@GetMapping("/getMethod")
	public String getMethod() {
		return "Hi getMethod";
	}
	
	@GetMapping("/getParameter")
	public String getParameter(@RequestParam(name="id") String id, @RequestParam(name="password") String password) {
		System.out.println("id == " + id);
		System.out.println("pw == " + password);
		return id + password;
	}

	@GetMapping("/getMultiParam")
	public SearchParam getMultiParam(SearchParam searchParam) {
		System.out.println(searchParam.toString());
		return searchParam;
	}

}
