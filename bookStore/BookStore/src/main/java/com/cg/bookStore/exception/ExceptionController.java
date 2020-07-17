package com.cg.bookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<String> handleListNotFoundException(UserException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
