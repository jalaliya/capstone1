package com.tajunjalaliya.brightbeginnings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
//Initial Mapping for all users	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	
//After authenticating,maps to welcome page	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	
	
//After authenticating.admin will map to admin home	
	@GetMapping("/admin/home")
	public String admin() {
		return "admin_home";
	}
	

	//After authenticating faculty will map to faculty home		
	@GetMapping("/faculty/home")
	public String faculty() {
		return "faculty_home";
	}

	
	//After authenticating.student will map to student home	
	@GetMapping("/student/home")
	public String student() {
		return "hello";
	}
}