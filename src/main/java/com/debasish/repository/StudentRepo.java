package com.debasish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debasish.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
