package com.example.university.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_student_courseoffering",
                        columnNames = {"student_id", "course_offering_id"}
                )
        }
)
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_offering_id", nullable = false)
    private CourseOffering courseOffering;

    @NotNull
    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;



    protected Enrollment() {

    }

    public Enrollment(Student student, CourseOffering courseOffering, LocalDate enrollmentDate) {
        this.student = student;
        this.courseOffering = courseOffering;
        this.enrollmentDate = enrollmentDate;
    }


    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
}
