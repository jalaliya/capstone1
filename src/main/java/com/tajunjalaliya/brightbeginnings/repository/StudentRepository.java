package com.tajunjalaliya.brightbeginnings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tajunjalaliya.brightbeginnings.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
