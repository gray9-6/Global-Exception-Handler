package com.bytes.service;

import com.bytes.dto.StudentRequestDto;
import com.bytes.entity.Student;
import com.bytes.exception.StudentAlreadyExists;
import com.bytes.exception.StudentNotFound;
import com.bytes.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Student addStudent(StudentRequestDto studentRequestDto){

        if(studentRepository.findByStudentId(studentRequestDto.getStudentId()).isPresent()){
            throw new StudentAlreadyExists("Student Already Exists !!");
        }

        Student student = convertStudentRequestDtoToStudent(studentRequestDto);

        return studentRepository.save(student);
    }

    private static Student convertStudentRequestDtoToStudent(StudentRequestDto studentRequestDto) {
        return new Student()
                .setName(studentRequestDto.getName())
                .setStudentId(studentRequestDto.getStudentId())
                .setAddress(studentRequestDto.getAddress())
                .setClassIn(studentRequestDto.getClassIn())
                .setAdmissionDate(studentRequestDto.getAdmissionDate());
    }


    public Student updateStudentById(Long id, StudentRequestDto studentRequestDto) {
       Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFound("Student Not Found"));

        student.setName(studentRequestDto.getName());
        student.setStudentId(studentRequestDto.getStudentId());
        student.setAddress(studentRequestDto.getAddress());
        student.setClassIn(studentRequestDto.getClassIn());
        student.setAdmissionDate(studentRequestDto.getAdmissionDate());

        return studentRepository.save(student);
    }
}
