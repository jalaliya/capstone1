package com.tajunjalaliya.brightbeginnings.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tajunjalaliya.brightbeginnings.entity.User;
import com.tajunjalaliya.brightbeginnings.web.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	
	
	  
}