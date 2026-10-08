package org.spring.day12springbootaop.repository;

import org.spring.day12springbootaop.dto.Student;
import org.spring.day12springbootaop.service.StudentService;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
    public void save(){
        System.out.println("Student Saved");
    }
}
