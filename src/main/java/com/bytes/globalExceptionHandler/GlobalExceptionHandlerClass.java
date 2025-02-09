package com.bytes.globalExceptionHandler;

import com.bytes.exception.StudentAlreadyExists;
import com.bytes.exception.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandlerClass {

    @ExceptionHandler(StudentAlreadyExists.class)
    public ResponseEntity<ErrorResponse> studentAlreadyExistsExceptionHandler(StudentAlreadyExists exception, WebRequest webRequest){

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .errorDetails(webRequest.getDescription(false))
                .errorCode("STUDENT ALREADY EXISTS")
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ErrorResponse> studentNotFoundExceptionHandler(StudentNotFound exception, WebRequest webRequest){

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .errorDetails(webRequest.getDescription(false))
                .errorCode("STUDENT NOT FOUND")
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
