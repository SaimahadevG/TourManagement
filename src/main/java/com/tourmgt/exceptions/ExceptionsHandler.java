package com.tourmgt.exceptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tourmgt.exceptions.TourNotFoundException;

@RestControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler(exception = { TourNotFoundException.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, String> handleTourNotFoundExeception(TourNotFoundException ex) {
		HashMap<String, String> errors = new HashMap<String, String>();
		errors.put("error", ex.getMessage());
		return errors;
	}

	@ExceptionHandler(exception = { MethodArgumentNotValidException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		HashMap<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}

	@ExceptionHandler(exception = { IOException.class })
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> handleIoException(IOException e) {
		HashMap<String, String> errors = new HashMap<String, String>();
		errors.put("error", e.getMessage());
		return errors;
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
		HashMap<String, Object> error = new HashMap<String, Object>();
		error.put("error", "Internal Server Error");
		error.put("message", ex.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.put("timestamp", System.currentTimeMillis());
		return new ResponseEntity(error, (HttpStatusCode) HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
