package com.example.university.exception;

import java.util.Map;

public class ValidationExceptionResponse extends ExceptionResponse {
    private Map<String, String> errors;

    public ValidationExceptionResponse(String message ,Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
