package com.example.crud.exception;

import com.example.crud.dto.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler
	ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException exception) {
		return new ResponseEntity<>(new ApiResponse(exception.status, "Error", exception.getMessage()),
				HttpStatusCode.valueOf(exception.status));
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	ApiResponse exceptionHandler(Exception exception) {
		return new ApiResponse(404, "Error", exception.getMessage());
	}
}
