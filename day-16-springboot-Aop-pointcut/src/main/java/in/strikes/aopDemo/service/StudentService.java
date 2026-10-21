package in.strikes.aopDemo.service;

import in.strikes.aopDemo.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Override
    //@Timestamp
    public Student createStudent(Student student) {
        System.out.println("Student saved");
        return student;
    }

    @Override
    public String getStudent(String s) {
        System.out.println(s);
        return s;
    }

    public int dummyMethod() {
        return 0;
    }
}
