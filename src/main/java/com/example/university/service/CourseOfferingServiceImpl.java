package com.example.university.service;

import com.example.university.dto.CourseOfferingRequestDto;
import com.example.university.dto.CourseOfferingResponseDto;
import com.example.university.entity.Course;
import com.example.university.entity.CourseOffering;
import com.example.university.entity.Professor;
import com.example.university.enums.BusinessExceptionsEnum;
import com.example.university.exception.BusinessException;
import com.example.university.mapper.CourseOfferingMapper;
import com.example.university.repository.CourseOfferingRepository;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {

    private final CourseOfferingRepository courseOfferingRepository;
    private final CourseOfferingMapper courseOfferingMapper;
    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;

    public CourseOfferingServiceImpl(CourseOfferingRepository courseOfferingRepository,
                                     CourseOfferingMapper courseOfferingMapper,
                                     ProfessorRepository professorRepository,
                                     CourseRepository courseRepository) {
        this.courseOfferingRepository = courseOfferingRepository;
        this.courseOfferingMapper = courseOfferingMapper;
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseOfferingResponseDto create(CourseOfferingRequestDto courseOfferingRequestDto) {

        Optional<Professor> professor = professorRepository.findById(courseOfferingRequestDto.professorId());
        if (professor.isEmpty())
            throw new BusinessException(BusinessExceptionsEnum.PROFESSOR_NOT_FOUND.getMessage());

        Optional<Course> course = courseRepository.findById(courseOfferingRequestDto.courseId());
        if (course.isEmpty())
            throw new BusinessException(BusinessExceptionsEnum.COURSE_NOT_FOUND.getMessage());


        if (courseOfferingRepository.existsByCourseIdAndProfessorIdAndSemester(
                courseOfferingRequestDto.courseId(),
                courseOfferingRequestDto.professorId(),
                courseOfferingRequestDto.semester()))
            throw new BusinessException(BusinessExceptionsEnum.COURSE_OFFERING_DUPLICATED_BY_COURSE_AND_PROFESSOR_AND_SEMESTER.getMessage());

        CourseOffering courseOffering = new CourseOffering(
                course.get(),
                professor.get(),
                courseOfferingRequestDto.capacity(),
                courseOfferingRequestDto.semester()
        );

        courseOfferingRepository.save(courseOffering);
        return courseOfferingMapper.toResponseDto(courseOffering);
    }

    @Override
    public List<CourseOfferingResponseDto> getAll() {
       return courseOfferingRepository.findAll()
               .stream()
               .map(courseOfferingMapper::toResponseDto)
               .toList();
    }
}
