package org.spring.day12springbootaop.service;

import org.spring.day12springbootaop.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class LoggingDecorator implements StudentService{
    private StudentServiceImp studentServiceImp;
    public LoggingDecorator(StudentServiceImp studentServiceImp){
        this.studentServiceImp=studentServiceImp;

    }

    @Override
    public void createStudent(Student student) {
        LoggingServiceUtil.logStart("StudentServiceImp","createMethod");

        studentServiceImp.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImp","createMethod");


    }
}
