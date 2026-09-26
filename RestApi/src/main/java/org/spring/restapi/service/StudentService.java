package org.spring.restapi.service;

import org.spring.restapi.GlobalExceptionHandler.DuplicateResourceFoundException;
import org.spring.restapi.GlobalExceptionHandler.ResourceNotFoundException;
import org.spring.restapi.dto.StudentRequestDto;
import org.spring.restapi.dto.StudentResponseDto;
import org.spring.restapi.entity.Student;
import org.spring.restapi.mapper.Mapper;
import org.spring.restapi.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }




    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        Student student = Mapper.toEntity(studentRequestDto);
        if(EmailExist(student)){
            throw  new DuplicateResourceFoundException("Student with email"+ student.getEmail()+ " already exists");

        }


        return Mapper.toDto(studentRepo.save(student),"Created");



    }

    private boolean EmailExist(Student student) {

        return studentRepo.existsByEmail(student.getEmail());
    }

    public StudentResponseDto getStudentById(Long id) {

       Student getStudnet = studentRepo.findByIdAndDeletedIsFalse(id)
               .orElseThrow(()-> new ResourceNotFoundException("Student With id "+id+" not Found Exception"));


       return Mapper.toDto(getStudnet);
    }

    public List<StudentResponseDto> getAllStudentService() {

        List<Student> getAllStudent = studentRepo.findAllByAndDeletedIsFalse();

        return getAllStudent.stream()
                .map(Mapper::toDto)
                .toList();


    }

    public StudentResponseDto updateStudent(StudentRequestDto reqDto, Long id) {
        Student getStudent =  studentRepo.findByIdAndDeletedIsFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student With id "+id+" not Found Exception"));

        Mapper.update(reqDto,getStudent);
        getStudent.setUpdatedAt(LocalDateTime.now());
        studentRepo.save(getStudent);

        return Mapper.toDto(getStudent,"Updated");


    }

    public void softDeleteStudent(Long id) {
        Student student = studentRepo.findByIdAndDeletedIsFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student With id "+id+" not Found Exception"));

        student.setDeleted(true);
        student.setUpdatedAt(LocalDateTime.now());
        studentRepo.save(student);

    }
    public void hardDeleteStudent(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student With id "+id+" not Found Exception"));

        studentRepo.delete(student);

    }
}
