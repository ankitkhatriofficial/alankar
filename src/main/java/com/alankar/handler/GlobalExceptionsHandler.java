package com.alankar.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alankar.common.response.BaseResponseMessage;
import com.alankar.handler.exceptions.InvalidDataException;
import com.alankar.handler.model.BaseException;
import com.alankar.model.response.ResponseMessage;

/**
 * @author ankitkhatri
 */

/**
 * Main class (ControllerAdvice) for handling all types of exception thrown or
 * occured inside the project.
 */
@RestControllerAdvice
public class GlobalExceptionsHandler {

	@ExceptionHandler(value = InvalidDataException.class)
	public ResponseEntity<?> handleInvalidDataException(InvalidDataException exception) {
		ResponseMessage response = new ResponseMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		return new ResponseEntity<ResponseMessage>(response, response.getStatus());
	}

	@ExceptionHandler(value = BaseException.class)
	public ResponseEntity<?> handleAllBaseException(BaseException exception) {
		return BaseResponseMessage.EXCEPTION(exception.getResponseCode());
	}

}
