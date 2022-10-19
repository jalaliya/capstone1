package com.tajunjalaliya.brightbeginnings.service;

import java.util.List;

import com.tajunjalaliya.brightbeginnings.entity.Student;

public interface StudentService {
	
List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);

}
