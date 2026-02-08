package com.example.university.repository;

import com.example.university.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    boolean existsByStudentIdAndCourseOfferingId(Long studentId, Long courseOfferingId);
}
