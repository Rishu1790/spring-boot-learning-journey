package in.bean.day06springbootexceptionhandling.service;

import in.bean.day06springbootexceptionhandling.dto.RequestDto;
import in.bean.day06springbootexceptionhandling.dto.ResponseDto;
import in.bean.day06springbootexceptionhandling.mapper.Mapper;
import in.bean.day06springbootexceptionhandling.model.Student;
import in.bean.day06springbootexceptionhandling.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.*;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }


    public ResponseDto createStudentService(RequestDto reqStudent) {
        Student student = Mapper.toEntity(reqStudent);

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setDeleted(false);

        return Mapper.toDto(studentRepo.save(student));


    }

    public ResponseDto getStudentById(Long id) {
        Optional<Student> getStudent = studentRepo.findByIdAndDeletedIsFalse(id);

      return Mapper.toDto(getStudent.get());
}

    public List<ResponseDto> getAllStudentService() {

        List<Student> getAllStudent = studentRepo.findAllByAndDeletedIsFalse();
        return getAllStudent.stream()
                .map(Mapper::toDto)
                .toList();
    }

    public ResponseDto updateStudent(Long id, RequestDto requestDto) {

        Optional<Student> existingStudent = studentRepo.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return null;
        }
        else{
            Student saveStudent =  existingStudent.get();

            Mapper.updateEntity(saveStudent,requestDto);
            saveStudent.setUpdatedAt(LocalDateTime.now());

            return Mapper.toDto(saveStudent);
        }
    }
    /**
     * Soft delete: row DB mein rehta hai, sirf flag set hota hai.
     * Existing pattern (deleted boolean) ke saath consistent hai.
     */
    public boolean softDeleteStudent(Long id) {
        Optional<Student> existingStudent = studentRepo.findByIdAndDeletedIsFalse(id);

        if (existingStudent.isEmpty()) {
            return false; // already deleted ya exist hi nahi karta
        }

        Student student = existingStudent.get();
        student.setDeleted(true);
        student.setUpdatedAt(LocalDateTime.now()); // audit trail update
        studentRepo.save(student);

        return true;
    }

    /**
     * Hard delete: row permanently DB se remove.
     * Note: yaha findById use kiya, findByIdAndDeletedIsFalse nahi —
     * kyunki agar row already soft-deleted hai, use bhi permanently
     * hata sakna chahiye (cleanup use case).
     */
    public boolean hardDeleteStudent(Long id) {
        if (!studentRepo.existsById(id)) {
            return false;
        }
        studentRepo.deleteById(id);
        return true;
    }
}
