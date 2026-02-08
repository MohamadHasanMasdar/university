package com.example.university.service;

import com.example.university.dto.ProfessorRequestDto;
import com.example.university.dto.ProfessorResponseDto;
import com.example.university.entity.Professor;
import com.example.university.enums.BusinessExceptionsEnum;
import com.example.university.exception.BusinessException;
import com.example.university.mapper.ProfessorMapper;
import com.example.university.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorServiceImpl(ProfessorRepository professorRepository,
                                ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    @Override
    public ProfessorResponseDto create(ProfessorRequestDto professorRequestDto) {
        if (professorRepository.existsByNationalCode(professorRequestDto.nationalCode()))
            throw new BusinessException(BusinessExceptionsEnum.PROFESSOR_DUPLICATED_BY_NATIONAL_CODE.getMessage());

        Professor professor = new Professor(
                professorRequestDto.firstName(),
                professorRequestDto.lastName(),
                professorRequestDto.nationalCode()
        );

        professorRepository.save(professor);
        return professorMapper.toResponseDto(professor);
    }

    @Override
    public ProfessorResponseDto getByNationalCode(String nationalCode) {
        Professor professor = professorRepository.findByNationalCode(nationalCode);
        if (professor == null)
            throw new BusinessException(BusinessExceptionsEnum.PROFESSOR_NOT_FOUND.getMessage());

        return professorMapper.toResponseDto(professor);
    }

    @Override
    public List<ProfessorResponseDto> getAll() {
        return professorRepository.findAll()
                .stream()
                .map(professorMapper::toResponseDto)
                .toList();
    }
}
