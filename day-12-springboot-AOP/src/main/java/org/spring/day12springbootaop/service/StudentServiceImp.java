package org.spring.day12springbootaop.service;

import org.spring.day12springbootaop.dto.Student;
import org.spring.day12springbootaop.repository.StudentRepo;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImp implements StudentService{

    private StudentRepo studentRepo;
    public StudentServiceImp(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    @Override
    public void createStudent(Student student) {

        try {
            Thread.sleep(2000);
        }
        catch(Exception e){}


        studentRepo.save();
    }
}
