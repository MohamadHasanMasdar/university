package com.example.university.controller;

import com.example.university.dto.EnrollmentRequestDto;
import com.example.university.dto.EnrollmentResponseDto;
import com.example.university.dto.ProfessorRequestDto;
import com.example.university.dto.ProfessorResponseDto;
import com.example.university.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.ENROLLMENTS)
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> create(@Valid @RequestBody EnrollmentRequestDto enrollmentRequestDto) {
        return new ResponseEntity<>(enrollmentService.create(enrollmentRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<EnrollmentResponseDto>> getAll() {
        return new ResponseEntity<>(enrollmentService.getAll(), HttpStatus.OK);
    }
}
