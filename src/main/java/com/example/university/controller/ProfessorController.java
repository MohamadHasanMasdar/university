package com.example.university.controller;

import com.example.university.dto.ProfessorRequestDto;
import com.example.university.dto.ProfessorResponseDto;
import com.example.university.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.PROFESSORS)
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> create(@Valid @RequestBody ProfessorRequestDto professorRequestDto) {
        return new ResponseEntity<>(professorService.create(professorRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("getByNationalCode/{nationalCode}")
    public ResponseEntity<ProfessorResponseDto> getByNationalCode(@PathVariable String nationalCode) {
        return new ResponseEntity<>(professorService.getByNationalCode(nationalCode), HttpStatus.CREATED);
    }
}
