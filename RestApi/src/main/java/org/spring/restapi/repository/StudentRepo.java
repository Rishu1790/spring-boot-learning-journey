package org.spring.restapi.repository;

import org.spring.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    boolean existsByEmail(String email);

    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findAllByAndDeletedIsFalse();
}
