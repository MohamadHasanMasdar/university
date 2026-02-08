package com.example.university.service;

import com.example.university.dto.CourseRequestDto;
import com.example.university.dto.CourseResponseDto;

public interface CourseService {

    CourseResponseDto create(CourseRequestDto courseRequestDto);
    CourseResponseDto getByCode(String code);
}
