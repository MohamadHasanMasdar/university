package com.example.university.service;

import com.example.university.dto.CourseOfferingRequestDto;
import com.example.university.dto.CourseOfferingResponseDto;

import java.util.List;

public interface CourseOfferingService {

    CourseOfferingResponseDto create(CourseOfferingRequestDto courseOfferingRequestDto);
    List<CourseOfferingResponseDto> getAll();
}
