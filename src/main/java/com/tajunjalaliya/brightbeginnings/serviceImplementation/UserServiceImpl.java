package com.tajunjalaliya.brightbeginnings.serviceImplementation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tajunjalaliya.brightbeginnings.entity.Role;
import com.tajunjalaliya.brightbeginnings.entity.User;
import com.tajunjalaliya.brightbeginnings.repository.UserRepository;
import com.tajunjalaliya.brightbeginnings.service.UserService;
import com.tajunjalaliya.brightbeginnings.web.UserRegistrationDto;


@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	//insert registered user as student
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_STUDENT")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),   getAuthorities(user));		
	}
	
	 
	//Returns authorities
	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
	        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
	        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
	        return authorities;
	}


	
}