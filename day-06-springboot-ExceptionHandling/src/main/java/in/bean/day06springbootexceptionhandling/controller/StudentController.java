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

        // Null Handle service se GlobalException class karr raha h
            return ResponseEntity.ok(showStudent);
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

            return ResponseEntity.ok(updatedStudent);


    }

    // Soft Delete
    @PatchMapping
    public ResponseEntity<String> softDeleteStudent(@RequestParam Long id) {
         studentService.softDeleteStudent(id);

        return ResponseEntity.noContent().build(); // 204
    }

    // Hard Delete
    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestParam Long id) {
       studentService.hardDeleteStudent(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204
    }





}
