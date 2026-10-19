package org.spring.practicefiltersinterceptors.controller;

import org.apache.coyote.Response;
import org.spring.practicefiltersinterceptors.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(){
        String s = studentService.createStudent();

        return ResponseEntity.ok("Created");

    }
}
