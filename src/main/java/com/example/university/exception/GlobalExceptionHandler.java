package com.example.university.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponse> handleArgumentValidationException(MethodArgumentNotValidException ex) {

        logger.error("validation exception occurred ", ex);
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach((error) ->  errors.put(error.getField(), error.getDefaultMessage()));

        ValidationExceptionResponse response = new ValidationExceptionResponse(
                "Validation failed",
                errors
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BusinessExceptionResponse> handleBusinessException(BusinessException ex) {
        logger.error("business exception occurred ", ex);
        return new ResponseEntity<>(new BusinessExceptionResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        logger.error("unexpected exception occurred ", ex);
        return new ResponseEntity<>(new ExceptionResponse("unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
