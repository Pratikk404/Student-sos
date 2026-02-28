package com.studentsos.studentsos.service;

import com.studentsos.studentsos.entity.Student;
import com.studentsos.studentsos.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(Student student) {
        return repository.save(student);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}