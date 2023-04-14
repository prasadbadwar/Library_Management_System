package com.hfdc.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<String> handleBookExp(BookNotFound e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<String> handleUserExp(UserNotFound e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundExp.class)
	public ResponseEntity<String> handleBorrowerExp(NotFoundExp e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExp(MethodArgumentNotValidException e){
		return new ResponseEntity<String>(e.getBindingResult().getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
	}
}
