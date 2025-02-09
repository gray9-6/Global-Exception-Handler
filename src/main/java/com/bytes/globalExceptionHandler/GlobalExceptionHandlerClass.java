package com.bytes.globalExceptionHandler;

import com.bytes.exception.StudentAlreadyExists;
import com.bytes.exception.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> methodValidationExceptionHandler(MethodArgumentNotValidException exception, WebRequest webRequest){
        List<String> fieldErrors = exception.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();

        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("status",HttpStatus.CONFLICT.value());
        errorMap.put("message",fieldErrors);
        errorMap.put("timeStamp", LocalDateTime.now());
        errorMap.put("errorDetails",webRequest.getDescription(false));

        return new ResponseEntity<>(errorMap, HttpStatus.CONFLICT);
    }
}
