package com.example.university.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(
        name = "course_offering",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_course_professor_semester",
                        columnNames = {"course_id", "professor_id", "semester"}
                )
        }
)
public class CourseOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;


    @NotNull
    @Column(nullable = false)
    private Integer capacity;


    @NotBlank
    @Column(nullable = false)
    private String semester;


    protected CourseOffering() {

    }


    public CourseOffering(Course course, Professor professor, Integer capacity,  String semester) {
        this.course = course;
        this.professor = professor;
        this.capacity = capacity;
        this.semester = semester;
    }


    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getSemester() {
        return semester;
    }
}
