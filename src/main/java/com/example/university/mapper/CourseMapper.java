package com.example.university.mapper;

import com.example.university.dto.CourseResponseDto;
import com.example.university.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseResponseDto toResponseDto(Course course) {
        return new CourseResponseDto(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getCode(),
                course.getUnits()
        );
    }
}
