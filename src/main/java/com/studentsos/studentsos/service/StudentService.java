package com.studentsos.studentsos.service;

import com.studentsos.studentsos.dto.StudentDTO;
import com.studentsos.studentsos.entity.Student;
import com.studentsos.studentsos.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentDTO create(Student student) {
        Student saved = repository.save(student);
        return mapToDTO(saved);
    }

    public List<StudentDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getByPhoneNumber(String phoneNumber) {

        Student student = repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return mapToDTO(student);
    }

    public List<StudentDTO> getLeaderboard() {
        return repository.findAllByOrderByKarmaDesc()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getPhoneNumber(),
                student.getKarma()
        );
    }
}