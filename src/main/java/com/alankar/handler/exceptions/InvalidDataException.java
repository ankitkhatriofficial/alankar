package com.alankar.handler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ankitkhatri
 */

/**
 * Custom Exception class Model. InvalidDataException is used for when the wrong
 * data received from the user side.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 6915505306192214510L;
	private String message;

}
