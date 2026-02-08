package com.example.university.controller;

import com.example.university.dto.StudentDto;
import com.example.university.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.STUDENTS)
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@Valid @RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.create(studentDto), HttpStatus.CREATED);
    }


    @GetMapping("getByNationalCode/{nationalCode}")
    public ResponseEntity<StudentDto> getByNationalCode(@PathVariable String nationalCode) {
        return new ResponseEntity<>(studentService.getByNationalCode(nationalCode), HttpStatus.OK);
    }

    @GetMapping("getByStudentNumber/{studentNumber}")
    public ResponseEntity<StudentDto> getByStudentNumber(@PathVariable String studentNumber) {
        return new ResponseEntity<>(studentService.getByStudentNumber(studentNumber), HttpStatus.OK);
    }
}
