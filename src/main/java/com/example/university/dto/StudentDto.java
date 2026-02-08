package com.example.university.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record StudentDto(

        @NotBlank
        @Size(min = 2, max = 100, message = "{student.dto.firstname.length}")
        String firstName,

        @NotBlank
        @Size(min = 2, max = 100 , message = "{student.dto.lastname.length}")
        String lastName,

        @NotBlank
        @Pattern(regexp = "\\d{10}", message = "{student.dto.nationalcode.length}")
        String nationalCode,

        @NotBlank
        @Pattern(regexp = "\\d{9}", message = "{student.dto.studentnumber.length}")
        String studentNumber
) { }
