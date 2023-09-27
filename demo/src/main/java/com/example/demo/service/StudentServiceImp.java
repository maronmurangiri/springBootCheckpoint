package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
    StudentRepository studentRepository;
    LocalDate localDate = LocalDate.now();
    String pattern = "yyy-MM-dd";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

    LocalDate enrollmentDate = LocalDate.parse((localDate.format(dateTimeFormatter)));

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createNewStudent(Student student) {
        if (student==null){
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (student.getEmail().isBlank() || student.getEmail()==null){
            throw  new IllegalArgumentException("Student email can neither be null nor blank");
        }
        if (student.getFirstName().isBlank() || student.getFirstName()==null){
            throw  new IllegalArgumentException("Student first name can neither be null nor blank");
        }
        if (student.getLastName().isBlank() || student.getLastName()==null){
            throw  new IllegalArgumentException("Student last name can neither be null nor blank");
        }
        if (student.getEnrollmentDate()==null){
            throw new IllegalArgumentException("Enrollment date ca never be null");
        }
        student.setEnrollmentDate(enrollmentDate);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        if (student==null){
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (student.getEmail().isBlank() || student.getEmail()==null){
            throw  new IllegalArgumentException("Student email can neither be null nor blank");
        }
        if (student.getFirstName().isBlank() || student.getFirstName()==null){
            throw  new IllegalArgumentException("Student first name can neither be null nor blank");
        }
        if (student.getLastName().isBlank() || student.getLastName()==null){
            throw  new IllegalArgumentException("Student last name can neither be null nor blank");
        }
        if (student.getEnrollmentDate()==null){
            throw new IllegalArgumentException("Enrollment date ca never be null");
        }
        if (studentRepository.existsById(student.getId())){
        return studentRepository.save(student);
        }
        return null;
    }


    @Override
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return  false;
    }

    @Override
    public Student getStudentById(Long id) {
        if (studentRepository.existsById(id)){
            return studentRepository.getById(id);
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
