package com.example.university.repository;

import com.example.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    boolean existsByNationalCode(String nationalCode);

    boolean existsByStudentNumber(String studentNumber);

    Student findByStudentNumber(String studentNumber);

    Student findByNationalCode(String nationalCode);
}
