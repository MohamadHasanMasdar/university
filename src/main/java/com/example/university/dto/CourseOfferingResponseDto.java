package com.example.university.dto;

public record CourseOfferingResponseDto(
        Long id,
        CourseResponseDto course,
        ProfessorResponseDto professor,
        Integer capacity,
        String semester
) {
}
