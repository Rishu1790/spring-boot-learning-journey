package in.bean.day06springbootexceptionhandling.controller;

import in.bean.day06springbootexceptionhandling.dto.RequestDto;
import in.bean.day06springbootexceptionhandling.dto.ResponseDto;
import in.bean.day06springbootexceptionhandling.mapper.Mapper;
import in.bean.day06springbootexceptionhandling.model.Student;
import in.bean.day06springbootexceptionhandling.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getStudent(@PathVariable Long id){
        ResponseDto showStudent = studentService.getStudentById(id);

        if(showStudent == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(showStudent);
        }
    }


    //GetAll
    @GetMapping
    public ResponseEntity<List<ResponseDto>> getAllStudent(){
        List<ResponseDto> allStudent = studentService.getAllStudentService();

        return ResponseEntity.ok(allStudent);
    }

    //Update

    @PutMapping
    public ResponseEntity<ResponseDto> updateStudent(@RequestParam Long id,
                                                     @RequestBody RequestDto requestDto){
        ResponseDto updatedStudent = studentService.updateStudent(id,requestDto);
        if(updatedStudent == null){
            return ResponseEntity.notFound()
                    .build();

        }else{
            return ResponseEntity.ok(updatedStudent);
        }

    }

    // Soft Delete
    @PatchMapping
    public ResponseEntity<Void> softDeleteStudent(@RequestParam Long id) {
        boolean isDeleted = studentService.softDeleteStudent(id);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build(); // 204
    }

    // Hard Delete
    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestParam Long id) {
        boolean isDeleted = studentService.hardDeleteStudent(id);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build(); // 204
    }





}
