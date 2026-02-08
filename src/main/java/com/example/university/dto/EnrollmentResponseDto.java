package com.example.university.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record EnrollmentResponseDto(

        Long id,
        StudentResponseDto student,
        CourseOfferingResponseDto courseOffering,
        LocalDate enrollmentDate
) {
}
