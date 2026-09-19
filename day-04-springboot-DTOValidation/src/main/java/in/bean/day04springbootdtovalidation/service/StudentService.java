package in.bean.practicecrud.service;

import in.bean.practicecrud.model.Student;
import in.bean.practicecrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student crestedStudentService(Student newStudent) {
        newStudent.setDeleted(false);
        Student createdStudent = studentRepository.save(newStudent);
        return createdStudent;
    }

    public Student getStudentService(Long id) {
        Optional<Student> studentById = studentRepository.findByIdAndDeletedIsFalse(id);
        if (studentById.isPresent()) {
            return studentById.get();
        } else {
            return null;
        }


    }

    public List<Student> getListOfStudent() {
        return studentRepository.findAllByDeletedIsFalse();
    }


    public Student updatedNewStudent(Long id, Student toUpdateStudent) {
        Optional<Student> findStudentId = studentRepository.findByIdAndDeletedIsFalse(id);

        if (findStudentId.isEmpty()) {
            return null;
        } else {
            Student existingStudent = findStudentId.get();
            existingStudent.setAge(toUpdateStudent.getAge());
            existingStudent.setEmail(toUpdateStudent.getEmail());
            existingStudent.setName(toUpdateStudent.getName());
            existingStudent.setRollNo(toUpdateStudent.getRollNo());
            existingStudent.setSubject(toUpdateStudent.getSubject());

            return studentRepository.save(existingStudent);

        }

    }

    public Boolean softDeleteGiven(Long id) {
        Optional<Student> softDelete = studentRepository.findByIdAndDeletedIsFalse(id);
        if (softDelete.isEmpty()) {
            return false;
        } else {
            Student toSoft = softDelete.get();
            toSoft.setDeleted(true);
            studentRepository.save(toSoft);
            return true;
        }
    }

    public Boolean deletePermanent(Long id) {
        Optional<Student> deleteStudent = studentRepository.findById(id);

        if(deleteStudent.isEmpty()){
            return false;
        }
        else {
            Student getStudent = deleteStudent.get();

            studentRepository.deleteById(id);
            return true;

        }
    }
}



