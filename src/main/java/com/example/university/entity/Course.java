package com.example.university.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;

    private String description;

    @NotBlank
    private String code;

    @NotNull
    @Column(name = "units", nullable = false)
    private Integer units;


    protected Course() {

    }

    public Course(String title, String description, String code, Integer units) {
        this.title = title;
        this.description = description;
        this.code = code;
        this.units = units;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public Integer getUnits() {
        return units;
    }
}
