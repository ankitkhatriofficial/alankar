package com.alankar.common.constant;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * @author ankitkhatri
 */
/** This represents the constant mapping for Response code. */
@Getter
public enum ResponseCode {

	/* BAD REQUEST */
	ID_NOT_FOUND("Provide a valid id..!", HttpStatus.BAD_REQUEST),
	COULD_NOT_DESERIALIZE("Could not Deserialize the data..!", HttpStatus.BAD_REQUEST),

	/* OK BUT LOGICAL ERROR */
	ENTITY_NOT_FOUND("Entity not found..!", HttpStatus.OK),
	INVALID_ID("Invalid id..!", HttpStatus.OK);

	/* ENUM PART */
	private String message;
	private HttpStatus status;

	ResponseCode(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}
}
