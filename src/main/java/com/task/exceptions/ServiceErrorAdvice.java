package com.task.exceptions;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ServiceErrorAdvice {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserExistException.class)
	public ResponseEntity<Object> exception(UserExistException exception) {
		return new ResponseEntity<>("User Already Exist", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { SQLException.class, NullPointerException.class })
	public ResponseEntity<Object> exception(Exception exception) {
		return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
