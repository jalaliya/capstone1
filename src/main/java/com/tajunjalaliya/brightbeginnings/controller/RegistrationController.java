//handles the registration processs

package com.tajunjalaliya.brightbeginnings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tajunjalaliya.brightbeginnings.service.UserService;
import com.tajunjalaliya.brightbeginnings.web.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	public UserService userService;

	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto regDto(){
		return new UserRegistrationDto();
	}
	

@GetMapping
public String showRegistrationForm()
{
	return "registration";
}
		
		
@PostMapping
public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto regDto)
{
	userService.save(regDto);
	return "redirect:/registration?success";
}






}
