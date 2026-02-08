package com.example.university.mapper;

import com.example.university.dto.CourseOfferingResponseDto;
import com.example.university.entity.CourseOffering;
import org.springframework.stereotype.Component;

@Component
public class CourseOfferingMapper {

    private final CourseMapper courseMapper;
    private final ProfessorMapper professorMapper;

    public CourseOfferingMapper(CourseMapper courseMapper,
                                ProfessorMapper professorMapper) {
        this.courseMapper = courseMapper;
        this.professorMapper = professorMapper;
    }

    public CourseOfferingResponseDto toResponseDto(CourseOffering courseOffering) {
        return new CourseOfferingResponseDto(
                courseOffering.getId(),
                courseMapper.toResponseDto(courseOffering.getCourse()),
                professorMapper.toResponseDto(courseOffering.getProfessor()),
                courseOffering.getCapacity(),
                courseOffering.getSemester()
        );
    }
}
