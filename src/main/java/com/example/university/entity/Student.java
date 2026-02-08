package com.example.university.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "national_code"),
        @UniqueConstraint(columnNames = "student_number")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;


    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;


    @Column(name = "national_code", nullable = false, length = 10)
    private String nationalCode;


    @Column(name = "student_number", nullable = false, length = 9)
    private String studentNumber;


    protected Student() {

    }


    public Student(String firstName, String lastName, String nationalCode, String studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.studentNumber = studentNumber;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
}
