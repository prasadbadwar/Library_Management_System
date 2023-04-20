/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 05/04/2023
  * 
  * @Description : This class is created for handling Global Exceptions.
  * ==========================
  * */
package com.hfdc.lms.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<String> handleBookExp(BookNotFound e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<String> handleUserExp(UserNotFound e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundExp.class)
	public ResponseEntity<String> handleBorrowerExp(NotFoundExp e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExp(MethodArgumentNotValidException e){
		List<String> details = new ArrayList<>();
        for(ObjectError error : e.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        String error = details.toString();
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST); 
	}
}
