package org.spring.day12springbootaop.service;

import org.spring.day12springbootaop.dto.Student;
import org.springframework.stereotype.Service;

import java.net.InterfaceAddress;

@Service
public interface StudentService {
    void createStudent(Student student);
}
