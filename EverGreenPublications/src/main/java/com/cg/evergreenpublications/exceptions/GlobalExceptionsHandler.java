package com.cg.evergreenpublications.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.evergreenpublications.entity.ExceptionsResponseDTO;

@RestControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler{

	 //todo handle 400 exceptions
	
	@ExceptionHandler(value=NoCustomerFoundException.class)
	public ResponseEntity<Object> handleNoCustomerFoundException(NoCustomerFoundException noCustomerFound)
	{
		ExceptionsResponseDTO exceptionResponse=new ExceptionsResponseDTO(LocalDate.now(),noCustomerFound.getLog(),"Query unsuccessfull");
	   return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=InvalidCredentialsException.class)
	public ResponseEntity<Object> handleInvalidCredentialsException(InvalidCredentialsException invalidCredentialException)
	{
		ExceptionsResponseDTO exceptionResponse=new ExceptionsResponseDTO(LocalDate.now(),invalidCredentialException.getLog(),"Query Unsuccessfull");
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<>("This Request method is not supported",HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}
	
	
}
