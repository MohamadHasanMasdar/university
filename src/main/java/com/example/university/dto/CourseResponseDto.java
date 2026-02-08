package com.example.university.dto;

import jakarta.validation.constraints.*;

public record CourseResponseDto(
        Long id,
        String title,
        String description,
        String code,
        Integer units
) {
}
