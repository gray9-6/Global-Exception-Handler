package com.bytes.dto;

import lombok.*;

import java.time.LocalDate;

@Data
public class StudentRequestDto {

    private String name;

    private String studentId;

    private String address;

    private LocalDate admissionDate;

    private Integer classIn;
}
