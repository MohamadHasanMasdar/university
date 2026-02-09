package com.example.university.exception;

import java.util.Map;

public class ExceptionResponse {

    protected String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
