package com.example.university.enums;

public enum BusinessExceptionsEnum {

    STUDENT_DUPLICATED_BY_NATIONAL_CODE("student with this national code registered before"),
    STUDENT_DUPLICATED_BY_STUDENT_NUMBER("student with this student number registered before"),
    STUDENT_NOT_FOUND("student not found"),
    PROFESSOR_DUPLICATED_BY_NATIONAL_CODE("professor with this national code registered before"),
    PROFESSOR_NOT_FOUND("professor not found"),
    COURSE_DUPLICATED_BY_CODE("course with this code registered before"),
    COURSE_NOT_FOUND("course not found"),
    COURSE_OFFERING_NOT_FOUND("course offering not found"),
    COURSE_OFFERING_DUPLICATED_BY_COURSE_AND_PROFESSOR_AND_SEMESTER("in this semester, course offering with this course and professor registered before"),
    ENROLLMENT_DUPLICATED_BY_STUDENT_AND_COURSE_OFFERING("enrollment with this student and course offer registered before"),
    COURSE_OFFERING_CAPACITY_IS_FULL("capacity of this course offering is full");


    private final String message;


    BusinessExceptionsEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
