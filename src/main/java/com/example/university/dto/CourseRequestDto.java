package com.example.university.dto;

import jakarta.validation.constraints.*;

public record CourseRequestDto(
        @NotBlank
        String title,

        String description,

        @NotBlank
        @Pattern(regexp = "\\d{4}", message = "{course.dto.code.length}")
        String code,

        @NotNull
        @Min(value = 1, message = "{course.dto.units.min}")
        @Max(value = 6, message = "{course.dto.units.max}")
        Integer units
) {
}
