package com.debasish.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.debasish.model.Student;
import com.debasish.utility.ResponseStructure;

public interface StudentService {

	ResponseEntity<ResponseStructure<Student>>saveStudent(Student student);
	ResponseEntity<ResponseStructure<List<Student>>>getAllStudents();
	ResponseEntity<ResponseStructure<Student>>getStudentById(Long id);
	ResponseEntity<ResponseStructure<Student>>updateStudent(Long id, Student student);
	ResponseEntity<ResponseStructure<Student>>deleteStudent(Long id);
}
