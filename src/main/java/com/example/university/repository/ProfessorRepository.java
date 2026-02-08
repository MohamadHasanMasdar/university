package com.example.university.repository;

import com.example.university.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

    boolean existsByNationalCode(String nationalCode);

    Professor findByNationalCode(String nationalCode);
}
