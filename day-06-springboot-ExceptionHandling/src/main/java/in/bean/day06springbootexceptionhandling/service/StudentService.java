package in.bean.day06springbootexceptionhandling.service;

import in.bean.day06springbootexceptionhandling.dto.RequestDto;
import in.bean.day06springbootexceptionhandling.dto.ResponseDto;
import in.bean.day06springbootexceptionhandling.globalexceptionhandler.DuplicateResourceException;
import in.bean.day06springbootexceptionhandling.globalexceptionhandler.ResourceNotFoundException;
import in.bean.day06springbootexceptionhandling.mapper.Mapper;
import in.bean.day06springbootexceptionhandling.model.Student;
import in.bean.day06springbootexceptionhandling.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.*;

import static in.bean.day06springbootexceptionhandling.mapper.Mapper.toDto;

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
        if(emailExists(student)){
            throw new DuplicateResourceException("Student with null "+ student.getEmail()
            + " Email Already Exist");
        }

        Student studentResp = studentRepo.save(student);
       return Mapper.toDto(studentResp,"Saved Successfully");

    }



    public ResponseDto getStudentById(Long id) {
       Student studentResp = studentRepo
               .findByIdAndDeletedIsFalse(id)
               .orElseThrow(() ->
                        new ResourceNotFoundException("Student with id "+ id + " not found"));

       return toDto(studentResp);
    }

    public List<ResponseDto> getAllStudentService() {

        List<Student> getAllStudent = studentRepo.findAllByAndDeletedIsFalse();
        return getAllStudent.stream()
                .map(Mapper::toDto)
                .toList();
    }

    public ResponseDto updateStudent(Long id, RequestDto requestDto) {

        Student existingStudent = studentRepo
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+ id + " not found"));


            Mapper.updateEntity(existingStudent,requestDto);
            existingStudent.setUpdatedAt(LocalDateTime.now());
            Student studentResp = studentRepo.save(existingStudent);

            return toDto(studentResp,"Updated Successfully");
        }

    /**
     * Soft delete: row DB mein rehta hai, sirf flag set hota hai.
     * Existing pattern (deleted boolean) ke saath consistent hai.
     */
    public void softDeleteStudent(Long id) {
        Student studentToBeDeleted = studentRepo
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+ id + " not found"));

        studentToBeDeleted.setDeleted(true);
        studentRepo.save(studentToBeDeleted);

    }

    /**
     * Hard delete: row permanently DB se remove.
     * Note: yaha findById use kiya, findByIdAndDeletedIsFalse nahi —
     * kyunki agar row already soft-deleted hai, use bhi permanently
     * hata sakna chahiye (cleanup use case).
     */
    public void hardDeleteStudent(Long id) {
        Student studentToBeDeleted = studentRepo
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student with id "+ id + " not found"));

       studentRepo.delete(studentToBeDeleted);

    }

    private boolean emailExists(Student student) {
        return studentRepo.existsByEmail(student.getEmail());
    }


}
