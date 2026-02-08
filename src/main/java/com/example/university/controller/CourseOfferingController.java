package com.example.university.controller;

import com.example.university.dto.CourseOfferingRequestDto;
import com.example.university.dto.CourseOfferingResponseDto;
import com.example.university.service.CourseOfferingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.COURSE_OFFERING)
public class CourseOfferingController {

    private final CourseOfferingService courseOfferingService;

    public CourseOfferingController(CourseOfferingService courseOfferingService) {
        this.courseOfferingService = courseOfferingService;
    }

    @PostMapping
    public ResponseEntity<CourseOfferingResponseDto> create(@Valid @RequestBody CourseOfferingRequestDto courseOfferingRequestDto) {
        return new ResponseEntity<>(courseOfferingService.create(courseOfferingRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CourseOfferingResponseDto>> getAll() {
        return new ResponseEntity<>(courseOfferingService.getAll(), HttpStatus.OK);
    }
}
