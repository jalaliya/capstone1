package com.tajunjalaliya.brightbeginnings.testRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tajunjalaliya.brightbeginnings.entity.Role;
import com.tajunjalaliya.brightbeginnings.entity.User;
import com.tajunjalaliya.brightbeginnings.repository.UserRepository;
import com.tajunjalaliya.brightbeginnings.repository.UserRepository;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class testUserRepository {
	@Autowired
	   private UserRepository userRepository;
	
	//testing custom Query
	
	 @Test
	   public void testFindAllSortedByName() {
		 
		 User user=new User();
		 user.setFirstName("thowfi");
		 user.setLastName("malik");
		 user.setEmail("thow@gmail.com");
		 user.setPassword("Red");

		Role role1=new Role("admin");
		Role role2=new Role("student");
		 List<Role> list=new ArrayList<Role>();
		list.add(role1);
		list.add(role2);
		 user.setRoles(list);
	    
	      
	      List<User> result =userRepository.findAllSortedByName();
	      Assertions.assertEquals("hasna", result.get(0).getFirstName());	     
	   }

}
