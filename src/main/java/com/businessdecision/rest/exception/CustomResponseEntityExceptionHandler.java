/**
 * 
 */
package com.businessdecision.rest.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * A custom general exception handler for the REST API.
 * @author bernard.adanlessossi
 *
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handles all instances of {@link Exception}.
	 * @param ex the exception
	 * @param request the request
	 * @return a response entity
	 * @throws Exception when things are wrong
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handles exceptions of type {@link UserNotFoundException}.
	 * @param ex the exception
	 * @param request the web request
	 * @return the response
	 * @throws Exception if things get worse
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserException(UserNotFoundException ex, WebRequest request) throws Exception {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * Handles invalid argument exceptions.
	 */
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation failed!",
				ex.getBindingResult().toString());
		
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
