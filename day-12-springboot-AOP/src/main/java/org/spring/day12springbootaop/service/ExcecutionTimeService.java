package org.spring.day12springbootaop.service;

import org.spring.day12springbootaop.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExcecutionTimeService implements StudentService{
    private LoggingDecorator loggingDecorator;

    public ExcecutionTimeService(LoggingDecorator loggingDecorator){
        this.loggingDecorator=loggingDecorator;
    }

    @Override
    public void createStudent(Student student) {
        long start = System.currentTimeMillis();

        loggingDecorator.createStudent(student);

        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }
}
