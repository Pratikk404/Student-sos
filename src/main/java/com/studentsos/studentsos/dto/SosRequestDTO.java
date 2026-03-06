package com.studentsos.studentsos.dto;

import java.time.LocalDateTime;

public class SosRequestDTO {

    private Long id;
    private Long studentId;
    private String studentName;
    private LocalDateTime timestamp;

    public SosRequestDTO(Long id, Long studentId, String studentName, LocalDateTime timestamp) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}