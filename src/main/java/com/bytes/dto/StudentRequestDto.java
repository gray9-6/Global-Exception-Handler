package com.bytes.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
public class StudentRequestDto {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Student ID cannot be null")
    @NotBlank(message = "Student ID cannot be blank")
    private String studentId;

    private String address;

    @NotNull(message = "Admission date cannot be null")
    private LocalDate admissionDate;

    @NotNull(message = "Class In cannot be null")
    @Min(value = 1, message = "Class In must be greater than or equal to 1")
    @Max(value = 12, message = "Class In must be less than or equal to 12")
    private Integer classIn;
}
