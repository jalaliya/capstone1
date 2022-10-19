package com.tajunjalaliya.brightbeginnings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tajunjalaliya.brightbeginnings.entity.Faculty;
import com.tajunjalaliya.brightbeginnings.entity.Student;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{

}
