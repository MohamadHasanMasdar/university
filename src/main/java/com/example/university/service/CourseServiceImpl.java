package com.example.university.service;

import com.example.university.dto.CourseRequestDto;
import com.example.university.dto.CourseResponseDto;
import com.example.university.entity.Course;
import com.example.university.enums.BusinessExceptionsEnum;
import com.example.university.exception.BusinessException;
import com.example.university.mapper.CourseMapper;
import com.example.university.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper  courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository,
                             CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseResponseDto create(CourseRequestDto courseRequestDto) {
        if (courseRepository.existsByCode(courseRequestDto.code()))
            throw new BusinessException(BusinessExceptionsEnum.COURSE_DUPLICATED_BY_CODE.getMessage());

        Course course = new Course(
                courseRequestDto.title(),
                courseRequestDto.description(),
                courseRequestDto.code(),
                courseRequestDto.units()
        );

        courseRepository.save(course);

        return courseMapper.toResponseDto(course);
    }

    @Override
    public CourseResponseDto getByCode(String code) {
        Course course = courseRepository.findByCode(code);
        if (course == null)
            throw new BusinessException(BusinessExceptionsEnum.COURSE_NOT_FOUND.getMessage());

        return courseMapper.toResponseDto(course);
    }

    @Override
    public List<CourseResponseDto> getAll() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponseDto)
                .toList();
    }
}
