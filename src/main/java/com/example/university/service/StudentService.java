package com.example.university.service;

import com.example.university.dto.StudentDto;

public interface StudentService {

    StudentDto create(StudentDto studentDto);
    StudentDto getByNationalCode(String nationalCode);
    StudentDto getByStudentNumber(String studentNumber);
}
