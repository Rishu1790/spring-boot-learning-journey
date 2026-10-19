package org.spring.practicefiltersinterceptors.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String createStudent() {
        System.out.println("Student Created");
        return "Student Service";
    }
}
