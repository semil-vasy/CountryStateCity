package com.example.crud.exception;

import com.example.crud.dto.ApiResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler
    ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(exception.status, "Error", exception.getMessage()), HttpStatusCode.valueOf(exception.status));
    }

    @ExceptionHandler
    ApiResponse exceptionHandler(Exception exception) {
        return new ApiResponse(404, "Error", exception.getMessage());
    }
}
