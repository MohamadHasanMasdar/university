package com.example.university.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record EnrollmentRequestDto(

        @NotNull(message = "{enrollment.dto.studentid.null}")
        @Positive(message = "{enrollment.dto.studentid.positive}")
        Long studentId,

        @NotNull(message = "{enrollment.dto.courseofferingid.null}")
        @Positive(message = "{enrollment.dto.courseofferingid.positive}")
        Long courseOfferingId,

        @NotNull(message = "{enrollment.dto.enrollmentdate.null}")
        LocalDate enrollmentDate
) {
}
