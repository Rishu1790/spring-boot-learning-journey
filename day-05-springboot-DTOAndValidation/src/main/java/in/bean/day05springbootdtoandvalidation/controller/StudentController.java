package in.bean.day05springbootdtoandvalidation.controller;

import in.bean.day05springbootdtoandvalidation.dto.RequestDto;
import in.bean.day05springbootdtoandvalidation.dto.ResponseDto;
import in.bean.day05springbootdtoandvalidation.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;

    }

    // Create
    @PostMapping
    public ResponseEntity<ResponseDto> createStudent(
            @Valid @RequestBody RequestDto reqStudent){

        ResponseDto addStudent = studentService.createStudentService(reqStudent);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addStudent);


    }

    // Get
    @GetMapping
    public ResponseEntity<ResponseDto> getStudent(@RequestParam Long id){
        ResponseDto showStudent = studentService.getStudentById(id);

        return ResponseEntity.ok(showStudent);
    }


    //GetAll
    @GetMapping("/all")
    public ResponseEntity<List<ResponseDto>> getAllStudent(){
        List<ResponseDto> allStudent = studentService.getAllStudentService();

        return ResponseEntity.ok(allStudent);
    }

    //Update

    @PutMapping
    public ResponseEntity<ResponseDto> updateStudent(@RequestParam Long id,
                                                     @RequestBody RequestDto requestDto){
        ResponseDto updatedStudent = studentService.updateStudent(id,requestDto);
        return ResponseEntity.ok(updatedStudent);

    }

    // Soft Delete
    @PatchMapping
    public ResponseEntity<Void> softDeleteStudent(@RequestParam Long id) {
        studentService.softDeleteStudent(id);

        return ResponseEntity.noContent().build(); // 204
    }

    // Hard Delete
    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestParam Long id) {
        studentService.hardDeleteStudent(id);

        return ResponseEntity.noContent().build(); // 204
    }





}
