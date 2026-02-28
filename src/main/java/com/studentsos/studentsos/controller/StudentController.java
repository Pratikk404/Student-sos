package com.studentsos.studentsos.controller;

import com.studentsos.studentsos.entity.Student;
import com.studentsos.studentsos.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @GetMapping("/phone/{phoneNumber}")
    public Student getByPhone(@PathVariable String phoneNumber) {
        return service.getByPhoneNumber(phoneNumber);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }
}