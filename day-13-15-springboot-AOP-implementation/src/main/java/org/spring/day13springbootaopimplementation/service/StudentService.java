package org.spring.day13springbootaopimplementation.service;

import jakarta.websocket.server.ServerEndpoint;
import org.spring.day13springbootaopimplementation.studentdto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student){
        System.out.println("Student saved");

        return student;

//        try {
//           throw new RuntimeException("some exception occured");
//        } catch (RuntimeException e) {}
//        return "Student Saved";

    }

    public String getStudent(String s) {
        return s;
    }
}
