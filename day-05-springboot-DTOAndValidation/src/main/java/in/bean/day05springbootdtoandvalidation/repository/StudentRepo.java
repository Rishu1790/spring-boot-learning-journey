package in.bean.day05springbootdtoandvalidation.repository;

import in.bean.day05springbootdtoandvalidation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {


    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findAllByAndDeletedIsFalse();
}
