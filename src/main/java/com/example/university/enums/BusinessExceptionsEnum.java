package com.example.university.enums;

public enum BusinessExceptionsEnum {

    STUDENT_DUPLICATED_BY_NATIONAL_CODE("student with this national code registered before"),
    STUDENT_DUPLICATED_BY_STUDENT_NUMBER("student with this student number registered before"),
    STUDENT_NOT_FOUND("student not found"),
    PROFESSOR_DUPLICATED_BY_NATIONAL_CODE("professor with this national code registered before"),
    PROFESSOR_NOT_FOUND("professor not found");

    private final String message;


    BusinessExceptionsEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
