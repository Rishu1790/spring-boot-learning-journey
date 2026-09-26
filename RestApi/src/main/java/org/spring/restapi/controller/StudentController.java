package org.spring.restapi.controller;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.spring.restapi.dto.StudentRequestDto;
import org.spring.restapi.dto.StudentResponseDto;
import org.spring.restapi.entity.Student;
import org.spring.restapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")

public class StudentController {

    // Dependency Injection
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Create
    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudnet(
            @Valid @RequestBody StudentRequestDto studentRequestDto){
        StudentResponseDto createStudent = studentService.createStudent(studentRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent);

    }
    //Get
    @GetMapping
    public ResponseEntity<StudentResponseDto> getStudent(@RequestParam Long id){
        StudentResponseDto getStudent = studentService.getStudentById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getStudent);

    }


    //GetAll
    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDto>> getAllStudent(){
        List<StudentResponseDto> getAllStudent = studentService.getAllStudentService();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getAllStudent);
    }


    //update
    @PutMapping
    ResponseEntity<StudentResponseDto> updateStudent(@Valid @RequestBody StudentRequestDto reqDto
                                                     ,@RequestParam Long id ){

     StudentResponseDto updated = studentService.updateStudent(reqDto,id);

     return ResponseEntity
             .status(HttpStatus.OK)
             .body(updated);



    }


    //soft-Delete
    @PatchMapping
    public ResponseEntity<String> softDelete(@RequestParam Long id){
        studentService.softDeleteStudent(id);


        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Softly Deleted");
    }



    //Delete
    @DeleteMapping
    public ResponseEntity<String> hardDelete(@RequestParam Long id){
        studentService.softDeleteStudent(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Permanently Deleted");
    }


}
