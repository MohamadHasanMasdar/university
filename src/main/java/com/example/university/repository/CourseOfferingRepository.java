package com.example.university.repository;

import com.example.university.entity.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long> {

    boolean existsByCourseIdAndProfessorIdAndSemester(Long courseId, Long professorId, String semester);
}
