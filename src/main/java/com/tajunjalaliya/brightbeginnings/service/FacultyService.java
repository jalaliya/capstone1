package com.tajunjalaliya.brightbeginnings.service;

import java.util.List;

import com.tajunjalaliya.brightbeginnings.entity.Faculty;

public interface FacultyService {
	
List<Faculty> getAllFacultys();
	
	Faculty saveFaculty(Faculty Faculty);
	
	Faculty getFacultyById(Long id);
	
	Faculty updateFaculty(Faculty Faculty);
	
	void deleteFacultyById(Long id);
}