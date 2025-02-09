package com.bytes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    String name;

    @NotNull(message = "Student ID cannot be null")
    @NotBlank(message = "Student ID cannot be blank")
    String studentId;

    String address;

    @NotNull(message = "Admission date cannot be null")
    LocalDate admissionDate;

    @NotNull(message = "Class In cannot be null")
    @Min(value = 1, message = "Class In must be greater than or equal to 1")
    @Max(value = 12, message = "Class In must be less than or equal to 12")
    Integer classIn;
}
