package com.example.university.exception;

import java.util.Map;

public record ValidationExceptionResponse(
        String message,
        Map<String, String> errors
) {
}
