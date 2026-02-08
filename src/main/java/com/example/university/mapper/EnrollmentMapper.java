package com.example.university.mapper;

import com.example.university.dto.EnrollmentResponseDto;
import com.example.university.entity.Enrollment;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {

    private final CourseOfferingMapper courseOfferingMapper;
    private final StudentMapper studentMapper;

    public EnrollmentMapper(CourseOfferingMapper courseOfferingMapper,
                            StudentMapper studentMapper) {
        this.courseOfferingMapper = courseOfferingMapper;
        this.studentMapper = studentMapper;
    }

    public EnrollmentResponseDto toResponseDto(Enrollment enrollment) {

        return new EnrollmentResponseDto(
                enrollment.getId(),
                studentMapper.toResponseDto(enrollment.getStudent()),
                courseOfferingMapper.toResponseDto(enrollment.getCourseOffering()),
                enrollment.getEnrollmentDate()
        );
    }
}
