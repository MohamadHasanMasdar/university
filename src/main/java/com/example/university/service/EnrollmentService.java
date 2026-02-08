package com.example.university.service;

import com.example.university.dto.EnrollmentRequestDto;
import com.example.university.dto.EnrollmentResponseDto;

import java.util.List;

public interface EnrollmentService {

    EnrollmentResponseDto create(EnrollmentRequestDto enrollmentRequestDto);
    List<EnrollmentResponseDto> getAll();
}
