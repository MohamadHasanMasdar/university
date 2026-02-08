package com.example.university.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ProfessorRequestDto(

        @NotBlank
        @Size(min = 2, max = 100, message = "{professor.dto.firstname.length}")
        String firstName,

        @NotBlank
        @Size(min = 2, max = 100 , message = "{professor.dto.lastname.length}")
        String lastName,

        @NotBlank
        @Pattern(regexp = "\\d{10}", message = "{professor.dto.nationalcode.length}")
        String nationalCode
) {
}
