package com.example.university.service;

import com.example.university.dto.StudentRequestDto;
import com.example.university.dto.StudentResponseDto;

public interface StudentService {

    StudentResponseDto create(StudentRequestDto studentRequestDto);
    StudentResponseDto getByNationalCode(String nationalCode);
    StudentResponseDto getByStudentNumber(String studentNumber);
}
