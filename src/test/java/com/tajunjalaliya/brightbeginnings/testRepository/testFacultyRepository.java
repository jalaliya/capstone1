package com.tajunjalaliya.brightbeginnings.testRepository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tajunjalaliya.brightbeginnings.entity.Faculty;
import com.tajunjalaliya.brightbeginnings.repository.FacultyRepository;
import com.tajunjalaliya.brightbeginnings.repository.StudentRepository;
import com.tajunjalaliya.brightbeginnings.repository.FacultyRepository;


@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class testFacultyRepository {
	@Autowired
	   private FacultyRepository facultyRepository;
	
	 //test for update Faculty
	   @Test
	   public void testUpdateFaculty(){
		   

		   Faculty Faculty=new Faculty();
	    	 Faculty.setFirstName("pony");
	    	 Faculty.setLastName("mahesh");
	    	 Faculty.setEmail("punni@gmail.com");
	    	 
	    	 facultyRepository.save(Faculty);

		   Faculty savedFaculty =facultyRepository.findById(Faculty.getId()).get();
		   savedFaculty.setFirstName("preethi");
		   Faculty.setEmail("punni@gmail.com");
	       
	      
	      Faculty updatedFaculty= facultyRepository.save(savedFaculty);

	        // then - verify the output
	      
	      Assertions.assertEquals("preethi",updatedFaculty.getFirstName());
	 
	    }

}
