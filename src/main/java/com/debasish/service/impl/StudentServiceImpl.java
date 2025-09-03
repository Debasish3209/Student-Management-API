package com.debasish.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.debasish.exception.StudentNotFoundByIdException;
import com.debasish.model.Student;
import com.debasish.repository.StudentRepo;
import com.debasish.service.StudentService;
import com.debasish.utility.ResponseStructure;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
        Student saved = studentRepo.save(student);

        ResponseStructure<Student> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Student saved successfully");
        response.setData(saved);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents() {
        List<Student> list = studentRepo.findAll();

        ResponseStructure<List<Student>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("All students fetched successfully");
        response.setData(list);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ResponseStructure<Student>> getStudentById(Long id) {
        return studentRepo.findById(id)
                .map(student -> ResponseEntity.ok(
                        new ResponseStructure<Student>()
                                .setStatusCode(HttpStatus.OK.value())
                                .setMessage("Student found successfully")
                                .setData(student)
                ))
                .orElseThrow(() -> new StudentNotFoundByIdException("Student not found with id: " + id));
    }

    @Override
    public ResponseEntity<ResponseStructure<Student>> updateStudent(Long id, Student student) {
        return studentRepo.findById(id)
                .map(existing -> {
                    existing.setName(student.getName());
                    existing.setEmail(student.getEmail());
                    existing.setAge(student.getAge());
                    existing.setDepartment(student.getDepartment());

                    Student updated = studentRepo.save(existing);

                    return ResponseEntity.ok(
                            new ResponseStructure<Student>()
                                    .setStatusCode(HttpStatus.OK.value())
                                    .setMessage("Student updated successfully")
                                    .setData(updated)
                    );
                })
                .orElseThrow(() -> new StudentNotFoundByIdException("Cannot update, student not found with id: " + id));
    }

    @Override
    public ResponseEntity<ResponseStructure<Student>> deleteStudent(Long id) {
        return studentRepo.findById(id)
                .map(student -> {
                    studentRepo.delete(student);
                    return ResponseEntity.ok(
                            new ResponseStructure<Student>()
                                    .setStatusCode(HttpStatus.OK.value())
                                    .setMessage("Student deleted successfully")
                                    .setData(student)
                    );
                })
                .orElseThrow(() -> new StudentNotFoundByIdException("Cannot delete, student not found with id: " + id));
    }
}
