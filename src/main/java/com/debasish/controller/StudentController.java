package com.debasish.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.debasish.model.Student;
import com.debasish.service.StudentService;
import com.debasish.utility.ResponseStructure;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/students")   // plural is better REST practice
public class StudentController {

    private final StudentService studentService;

    // CREATE
    @PostMapping
    public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents() {
        return studentService.getAllStudents();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Student>> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);  // matches service method name
    }
}
