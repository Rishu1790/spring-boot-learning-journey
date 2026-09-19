package in.bean.practicecrud.controller;

import in.bean.practicecrud.model.Student;
import in.bean.practicecrud.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

   @PostMapping
    public ResponseEntity<Student> createdStudent(@RequestBody Student newStudent){
        Student createdStudent = studentService.crestedStudentService(newStudent);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newStudent);

   }

   @GetMapping
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
       Student reqStudent = studentService.getStudentService(id);

      if(reqStudent == null){
          return ResponseEntity.notFound().build();
      }
      else{
          return ResponseEntity.ok(reqStudent);
      }

   }

   @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getListOfStudent();

        return ResponseEntity.ok(studentList);

   }

   @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestParam Long id,
                                                 @RequestBody Student toUpdateStudent ){
        Student updatedStudent = studentService.updatedNewStudent(id,toUpdateStudent);

        if(updatedStudent == null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(updatedStudent);
        }

   }
   @PatchMapping
    public ResponseEntity<String> softDelete(@RequestParam Long id){
        Boolean softDeleteId = studentService.softDeleteGiven(id);

        if(softDeleteId == false){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok("Deleted Softly");
        }
   }
   @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Long id){
        Boolean deletedId = studentService.deletePermanent(id);

        if(deletedId == false){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok("Deleted Permanently");
        }
   }

}
