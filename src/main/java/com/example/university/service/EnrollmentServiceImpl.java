package com.example.university.service;

import com.example.university.dto.EnrollmentRequestDto;
import com.example.university.dto.EnrollmentResponseDto;
import com.example.university.entity.CourseOffering;
import com.example.university.entity.Enrollment;
import com.example.university.entity.Student;
import com.example.university.enums.BusinessExceptionsEnum;
import com.example.university.exception.BusinessException;
import com.example.university.mapper.EnrollmentMapper;
import com.example.university.repository.CourseOfferingRepository;
import com.example.university.repository.EnrollmentRepository;
import com.example.university.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseOfferingRepository courseOfferingRepository;
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
                                 StudentRepository studentRepository,
                                 CourseOfferingRepository courseOfferingRepository,
                                 EnrollmentMapper enrollmentMapper) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseOfferingRepository = courseOfferingRepository;
        this.enrollmentMapper = enrollmentMapper;
    }

    @Override
    public EnrollmentResponseDto create(EnrollmentRequestDto enrollmentRequestDto) {

        Optional<Student> student = studentRepository.findById(enrollmentRequestDto.studentId());
        if (student.isEmpty())
            throw new BusinessException(BusinessExceptionsEnum.STUDENT_NOT_FOUND.getMessage());

        Optional<CourseOffering> courseOffering = courseOfferingRepository.findById(enrollmentRequestDto.courseOfferingId());
        if (courseOffering.isEmpty())
            throw new BusinessException(BusinessExceptionsEnum.COURSE_OFFERING_NOT_FOUND.getMessage());

        if (enrollmentRepository.existsByStudentIdAndCourseOfferingId(enrollmentRequestDto.studentId(), enrollmentRequestDto.courseOfferingId()))
            throw new BusinessException(BusinessExceptionsEnum.ENROLLMENT_DUPLICATED_BY_STUDENT_AND_COURSE_OFFERING.getMessage());


        Enrollment enrollment = new Enrollment(
                student.get(),
                courseOffering.get(),
                enrollmentRequestDto.enrollmentDate());

        enrollmentRepository.save(enrollment);
        return enrollmentMapper.toResponseDto(enrollment);
    }

    @Override
    public List<EnrollmentResponseDto> getAll() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollmentMapper::toResponseDto)
                .toList();
    }
}
