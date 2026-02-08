package com.example.university.dto;

import jakarta.validation.constraints.*;

public record CourseOfferingRequestDto(

        @NotNull(message = "{courseoffering.dto.courseid.null}")
        @Positive(message = "{courseoffering.dto.courseid.positive}")
        Long courseId,

        @NotNull(message = "{courseoffering.dto.professorid.null}")
        @Positive(message = "{courseoffering.dto.professorid.positive}")
        Long professorId,

        @NotNull(message = "{courseoffering.dto.capacity.null}")
        @Min(value = 1, message = "{courseoffering.dto.capacity.range}")
        @Max(value = 100, message = "{courseoffering.dto.capacity.range}")
        Integer capacity,

        @NotBlank(message = "{courseoffering.dto.semester.null}")
        String semester
) {
}
