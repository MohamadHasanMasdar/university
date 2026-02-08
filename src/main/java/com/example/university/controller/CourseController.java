package com.example.university.controller;

import com.example.university.dto.CourseRequestDto;
import com.example.university.dto.CourseResponseDto;
import com.example.university.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.COURSES)
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> create(@Valid @RequestBody CourseRequestDto courseRequestDto) {
        return new ResponseEntity<>(courseService.create(courseRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("getByCode/{code}")
    public ResponseEntity<CourseResponseDto> getByCode(@PathVariable String code) {
        return new ResponseEntity<>(courseService.getByCode(code), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CourseResponseDto>> getAll() {
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }
}
