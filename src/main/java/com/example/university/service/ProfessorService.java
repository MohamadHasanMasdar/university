package com.example.university.service;

import com.example.university.dto.ProfessorRequestDto;
import com.example.university.dto.ProfessorResponseDto;

public interface ProfessorService {

    ProfessorResponseDto create(ProfessorRequestDto professorRequestDto);
    ProfessorResponseDto getByNationalCode(String nationalCode);
}
