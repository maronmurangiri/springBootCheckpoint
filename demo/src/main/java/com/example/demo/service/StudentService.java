package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    Student createNewStudent(Student student);
    Student updateStudent(Student student);
    boolean deleteStudent(Long id);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

}
