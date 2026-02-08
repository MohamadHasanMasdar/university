package com.example.university.service;

import com.example.university.dto.ProfessorRequestDto;
import com.example.university.dto.ProfessorResponseDto;

import java.util.List;

public interface ProfessorService {

    ProfessorResponseDto create(ProfessorRequestDto professorRequestDto);
    ProfessorResponseDto getByNationalCode(String nationalCode);
    List<ProfessorResponseDto> getAll();
}
