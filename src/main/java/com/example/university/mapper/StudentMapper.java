package com.example.university.mapper;

import com.example.university.dto.StudentResponseDto;
import com.example.university.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentResponseDto toResponseDto(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getNationalCode(),
                student.getStudentNumber()
        );
    }
}
