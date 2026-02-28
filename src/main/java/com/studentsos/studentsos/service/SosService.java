package com.studentsos.studentsos.service;

import com.studentsos.studentsos.entity.SosRequest;
import com.studentsos.studentsos.entity.Student;
import com.studentsos.studentsos.repository.SosRepository;
import com.studentsos.studentsos.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SosService {

    private final SosRepository sosRepository;
    private final StudentRepository studentRepository;

    public SosService(SosRepository sosRepository, StudentRepository studentRepository) {
        this.sosRepository = sosRepository;
        this.studentRepository = studentRepository;
    }

    public SosRequest createSos(String phoneNumber) {

        Student student = studentRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        SosRequest sos = new SosRequest();
        sos.setStudent(student);
        sos.setTimestamp(LocalDateTime.now());
        sos.setStatus("PENDING");

        return sosRepository.save(sos);
    }
}