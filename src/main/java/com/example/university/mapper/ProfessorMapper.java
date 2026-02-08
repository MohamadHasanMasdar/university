package com.example.university.mapper;

import com.example.university.dto.ProfessorResponseDto;
import com.example.university.entity.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public ProfessorResponseDto toResponseDto(Professor professor) {
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getFirstName(),
                professor.getLastName(),
                professor.getNationalCode()
        );
    }

}
