package com.studentsos.studentsos.dto;

public class StudentDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private Integer karma;

    public StudentDTO(Long id, String name, String phoneNumber, Integer karma) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.karma = karma;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getKarma() {
        return karma;
    }
}