package in.bean.day01springbootcrud.Controller;

import in.bean.day01springbootcrud.Entity.Student;
import in.bean.day01springbootcrud.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
     public StudentController(StudentService studentService){
         this.studentService = studentService;
     }

    // Create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

       Student createdStudent =  studentService.createStudent(student);


       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(createdStudent);

    }
    //Read
    @GetMapping("/get/{id}")
    public  ResponseEntity<Student> getStudent(@PathVariable Long id){
         Student studentResp =studentService.getStudent(id);

         if(studentResp == null){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(studentResp);
    }
    // Read All
    @GetMapping("/getAll")
    public  ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentListResp =studentService.getAllStudent();

        if(studentListResp.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentListResp);
    }

    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student studentReq){

        Student studentResp = studentService.updateStudent(id,studentReq);

         if(studentResp == null){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(studentResp);
    }

    //Delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
         Boolean isDeleted = studentService.deleteStudent(id);

         if(!isDeleted){
             return ResponseEntity.notFound().build();
         }
         else{
             return ResponseEntity.ok("Record Deleted");
         }
    }

}
