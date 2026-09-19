package in.bean.day01springbootcrud.Service;

import in.bean.day01springbootcrud.Entity.Student;
import in.bean.day01springbootcrud.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }
    public Student createStudent(Student studentReq) {
        // Store
        Student studentSaved = studentRepo.save(studentReq);


        return studentSaved;

    }

    public Student getStudent(Long id) {
        Optional<Student> studentRespo = studentRepo.findById(id);
        if(studentRespo.isPresent()){
            return studentRespo.get();

        }else{
            return null;
        }
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    public Student updateStudent(Long id,Student studentReq) {
        Optional<Student> existingStudent = studentRepo.findById(id);

        if (existingStudent.isEmpty()) {
            return null;

        } else {
            Student studentToSave = existingStudent.get();
            studentToSave.setRollno(studentReq.getRollno());
            studentToSave.setSubject(studentReq.getSubject());
            studentToSave.setEmail(studentReq.getEmail());
            studentToSave.setAge(studentReq.getAge());

            return studentRepo.save(studentToSave);

        }



    }

    public Boolean deleteStudent(Long id) {
       Boolean isStudent = studentRepo.existsById(id);

       if(!isStudent) return false;
       studentRepo.deleteById(id);
       return true;
    }
    // 1. End Point Listen (/api/student POST)
    // 2. Buiseness LOgics
    //3.  Interact With DataBase
    // 4. Response BAck to client
}
