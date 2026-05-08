package com.studentsos.studentsos.controller;

import com.studentsos.studentsos.dto.StudentDTO;
import com.studentsos.studentsos.entity.Student;
import com.studentsos.studentsos.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentDTO create(@RequestBody Student student) {
        return service.create(student);
    }

    @GetMapping("/phone/{phoneNumber}")
    public StudentDTO getByPhone(@PathVariable String phoneNumber) {
        return service.getByPhoneNumber(phoneNumber);
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/leaderboard")
    public List<StudentDTO> leaderboard() {
        return service.getLeaderboard();
    }
}