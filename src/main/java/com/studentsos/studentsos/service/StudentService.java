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

    public Student update(Long id, Student updatedStudent) {
        Student existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(updatedStudent.getName());
        existing.setPhoneNumber(updatedStudent.getPhoneNumber());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student getByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}