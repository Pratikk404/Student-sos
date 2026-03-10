package com.studentsos.studentsos.service;

import com.studentsos.studentsos.dto.SosRequestDTO;
import com.studentsos.studentsos.entity.SosRequest;
import com.studentsos.studentsos.entity.Student;
import com.studentsos.studentsos.repository.SosRepository;
import com.studentsos.studentsos.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SosService {

    private final SosRepository sosRepository;
    private final StudentRepository studentRepository;
    private final NotificationService notificationService;

    public SosService(SosRepository sosRepository,
                      StudentRepository studentRepository,
                      NotificationService notificationService) {
        this.sosRepository = sosRepository;
        this.studentRepository = studentRepository;
        this.notificationService = notificationService;
    }

    public SosRequestDTO createSos(String phoneNumber, String item, String location) {

        Student student = studentRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Prevent sending SOS if karma too low
        if (student.getKarma() < 5) {
            throw new RuntimeException("Not enough karma to send SOS");
        }

        // Deduct karma
        student.setKarma(student.getKarma() - 5);
        studentRepository.save(student);

        SosRequest sos = new SosRequest();
        sos.setStudent(student);
        sos.setTimestamp(LocalDateTime.now());

        SosRequest saved = sosRepository.save(sos);

        // Send real-time alert
        notificationService.broadcastSOS(student.getName(), item, location);

        return mapToDTO(saved);
    }

    public List<SosRequestDTO> getAllRequests() {

        return sosRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private SosRequestDTO mapToDTO(SosRequest sos) {
        return new SosRequestDTO(
                sos.getId(),
                sos.getStudent().getId(),
                sos.getStudent().getName(),
                sos.getTimestamp()
        );
    }
}