package com.example.university.service;

import com.example.university.dto.StudentRequestDto;
import com.example.university.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    StudentResponseDto create(StudentRequestDto studentRequestDto);
    StudentResponseDto getByNationalCode(String nationalCode);
    StudentResponseDto getByStudentNumber(String studentNumber);
    List<StudentResponseDto> getAll();
}
