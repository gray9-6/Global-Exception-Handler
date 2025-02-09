package com.bytes.controller;

import com.bytes.dto.StudentRequestDto;
import com.bytes.entity.Student;
import com.bytes.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return new ResponseEntity<>(studentService.addStudent(studentRequestDto), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable(name = "id") Long id,@RequestBody StudentRequestDto studentRequestDto){
        return new ResponseEntity<>(studentService.updateStudentById(id,studentRequestDto), HttpStatus.OK);
    }
}
