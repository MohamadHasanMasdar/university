package com.example.university.service;

import com.example.university.dto.StudentResponseDto;
import com.example.university.enums.BusinessExceptionsEnum;
import com.example.university.dto.StudentRequestDto;
import com.example.university.entity.Student;
import com.example.university.exception.BusinessException;
import com.example.university.mapper.StudentMapper;
import com.example.university.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    @Override
    public StudentResponseDto create(StudentRequestDto studentRequestDto) {

        if (studentRepository.existsByNationalCode(studentRequestDto.nationalCode()))
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_DUPLICATED_BY_NATIONAL_CODE.getMessage());

        if (studentRepository.existsByStudentNumber(studentRequestDto.studentNumber()))
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_DUPLICATED_BY_STUDENT_NUMBER.getMessage());

        Student student = new Student(
                studentRequestDto.firstName(),
                studentRequestDto.lastName(),
                studentRequestDto.nationalCode(),
                studentRequestDto.studentNumber()
        );

        studentRepository.save(student);
        return studentMapper.toResponseDto(student);
    }

    @Override
    public StudentResponseDto getByNationalCode(String nationalCode) {
        Student student = studentRepository.findByNationalCode(nationalCode);
        if (student == null)
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_NOT_FOUND.getMessage());

        return studentMapper.toResponseDto(student);
    }

    @Override
    public StudentResponseDto getByStudentNumber(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber);
        if (student == null)
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_NOT_FOUND.getMessage());

        return studentMapper.toResponseDto(student);
    }
}
