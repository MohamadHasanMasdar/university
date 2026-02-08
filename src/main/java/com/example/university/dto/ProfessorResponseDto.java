package com.example.university.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ProfessorResponseDto(

        Long id,
        String firstName,
        String lastName,
        String nationalCode
) {
}
