package com.tajunjalaliya.brightbeginnings.testRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tajunjalaliya.brightbeginnings.entity.Student;
import com.tajunjalaliya.brightbeginnings.repository.StudentRepository;




@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class testStudentRepository {

	@Autowired
	   private StudentRepository studentRepository;
	

    @BeforeEach
    public void setup(){
    	 Student student=new Student();
    	 student.setFirstName("pinky");
    	 student.setLastName("agarwal");
    	 student.setEmail("pinky@gmail.com");
    }
	
    //test find all method
	   @Test
	   public void testFindAll() {
		 
		  List<Student> studentList = studentRepository.findAll();

	        // then - verify the output
	       Assertions.assertNotNull(studentList); 
			     
	   }

	   
	   //test for saving student
	   @Test
	   public void testSavestudent()
	   {
		   Student student=new Student();
	    	 student.setFirstName("pinky");
	    	 student.setLastName("agarwal");
	    	 student.setEmail("pinky@gmail.com");
		   
	 studentRepository.save(student);
	 Optional<Student> savedEmployee =studentRepository.findById(student.getId());
	  // then - verify the output
     Assertions.assertNotNull(savedEmployee ); 
	   }
	   
	   //test to find by id
	   
	   @Test
	    public void testFindById(){

		   Student student=new Student();
	    	 student.setFirstName("pony");
	    	 student.setLastName("mahesh");
	    	 student.setEmail("punni@gmail.com");
		   
	 studentRepository.save(student);
	 Optional<Student> savedEmployee =studentRepository.findById(student.getId());
	  // then - verify the output
   Assertions.assertNotNull(savedEmployee ); 
}
	   
	  //test for deleteStudent
	   @Test
	    public void testDeleteStudent(){

		   Student student=new Student();
	    	 student.setFirstName("pony");
	    	 student.setLastName("mahesh");
	    	 student.setEmail("punni@gmail.com");
		   
	        studentRepository.save(student);

	        studentRepository.deleteById(student.getId());
	        Optional<Student> employeeOptional = studentRepository.findById(student.getId());

	        // then - verify the output
	        Assertions.assertTrue(employeeOptional.isEmpty());
	
	    }
	   
	   
	   
	   
	   
}