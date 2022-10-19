package com.tajunjalaliya.brightbeginnings.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tajunjalaliya.brightbeginnings.entity.User;


	public interface UserRepository extends JpaRepository<User, Long>{
		User findByEmail(String email);
		
		 
	
		

			//Custom query
			@Query(value = "SELECT u FROM User u ORDER BY first_name")
		List<User> findAllSortedByName();
	}

