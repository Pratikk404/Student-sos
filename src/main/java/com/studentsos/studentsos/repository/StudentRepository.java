package com.studentsos.studentsos.repository;

import com.studentsos.studentsos.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByPhoneNumber(String phoneNumber);

    List<Student> findAllByOrderByKarmaDesc();
}