package com.example.university.service;

import com.example.university.enums.BusinessExceptionsEnum;
import com.example.university.dto.StudentDto;
import com.example.university.entity.Student;
import com.example.university.exception.BusinessException;
import com.example.university.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentDto create(StudentDto studentDto) {

        if (studentRepository.existsByNationalCode(studentDto.nationalCode()))
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_DUPLICATED_BY_NATIONAL_CODE.getMessage());

        if (studentRepository.existsByStudentNumber(studentDto.studentNumber()))
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_DUPLICATED_BY_STUDENT_NUMBER.getMessage());

        Student student = new Student(
                studentDto.firstName(),
                studentDto.lastName(),
                studentDto.nationalCode(),
                studentDto.studentNumber()
        );

        studentRepository.save(student);
        return studentDto;
    }

    @Override
    public StudentDto getByNationalCode(String nationalCode) {
        Student student = studentRepository.findByNationalCode(nationalCode);
        if (student == null)
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_NOT_FOUND.getMessage());

        return new StudentDto(
                student.getFirstName(),
                student.getLastName(),
                student.getNationalCode(),
                student.getStudentNumber()
        );
    }

    @Override
    public StudentDto getByStudentNumber(String studentNumber) {
        Student student = studentRepository.findByStudentNumber(studentNumber);
        if (student == null)
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_NOT_FOUND.getMessage());

        return new StudentDto(
                student.getFirstName(),
                student.getLastName(),
                student.getNationalCode(),
                student.getStudentNumber()
        );
    }
}
