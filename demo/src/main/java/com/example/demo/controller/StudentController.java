package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

        StudentServiceImp studentService;

        @Autowired
    public StudentController(StudentServiceImp studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create/student")
    public ResponseEntity<?> createNewStudent(@RequestBody Student student){
        try{
            return  ResponseEntity.ok(studentService.createNewStudent(student));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/update/student")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        try{
            return  ResponseEntity.ok(studentService.updateStudent(student));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        try{
            return  ResponseEntity.ok(studentService.deleteStudent(id));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id){
        try{
            return  ResponseEntity.ok(studentService.getStudentById(id));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/all/students")
    public ResponseEntity<?> getAllStudents(){
        try{
            return  ResponseEntity.ok(studentService.getAllStudents());
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
