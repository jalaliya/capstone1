package com.tajunjalaliya.brightbeginnings.serviceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tajunjalaliya.brightbeginnings.entity.Faculty;
import com.tajunjalaliya.brightbeginnings.entity.Student;
import com.tajunjalaliya.brightbeginnings.repository.FacultyRepository;
import com.tajunjalaliya.brightbeginnings.repository.StudentRepository;
import com.tajunjalaliya.brightbeginnings.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {
	
private FacultyRepository facultyRepository;
	
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		super();
		this.facultyRepository = facultyRepository;
	}

	@Override
	public List<Faculty> getAllFacultys() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty getFacultyById(Long id) {
		return facultyRepository.findById(id).get();
	}

	@Override
	public Faculty updateFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public void deleteFacultyById(Long id) {
		 facultyRepository.deleteById(id);
		
	}

}
