package org.spring.day13springbootaopimplementation.controller;

import org.spring.day13springbootaopimplementation.service.StudentService;
import org.spring.day13springbootaopimplementation.studentdto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static jdk.internal.org.jline.utils.Colors.s;

@RestController
@RequestMapping("/api/student")

public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student s = studentService.createStudent(student);
        return ResponseEntity.ok(s);

    }
    @GetMapping
    public ResponseEntity<String> getStudent(){
        String s = "rishu";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
