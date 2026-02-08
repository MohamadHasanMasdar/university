package com.example.university.controller;

import com.example.university.dto.StudentRequestDto;
import com.example.university.dto.StudentResponseDto;
import com.example.university.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.STUDENTS)
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@Valid @RequestBody StudentRequestDto studentRequestDto) {
        return new ResponseEntity<>(studentService.create(studentRequestDto), HttpStatus.CREATED);
    }


    @GetMapping("getByNationalCode/{nationalCode}")
    public ResponseEntity<StudentResponseDto> getByNationalCode(@PathVariable String nationalCode) {
        return new ResponseEntity<>(studentService.getByNationalCode(nationalCode), HttpStatus.OK);
    }

    @GetMapping("getByStudentNumber/{studentNumber}")
    public ResponseEntity<StudentResponseDto> getByStudentNumber(@PathVariable String studentNumber) {
        return new ResponseEntity<>(studentService.getByStudentNumber(studentNumber), HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<StudentResponseDto>> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }
}
