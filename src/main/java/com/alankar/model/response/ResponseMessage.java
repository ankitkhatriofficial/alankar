package com.alankar.model.response;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ankitkhatri
 */

/**
 * Response Model class. It is used when some Api wants to return the response
 * which does not exist in BaseResponseMessage class. This ResponseMessage class
 * can be used to return the desired response from the Api.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResponseMessage {

	private int statusCode;
	private HttpStatus status;
	private Object data;
	private String message;
	private Date timestamp = new Date();

	/** Default Constructor (NoArgsConstructor) is included by lombok */

	/** Parametrized Constructor 1 */
	public ResponseMessage(HttpStatus status, Object data, String message) {
		this.statusCode = status.value();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	/** Parametrized Constructor 2 */
	public ResponseMessage(HttpStatus status, String message) {
		this.statusCode = status.value();
		this.message = message;
		this.status = status;
		this.data = new Object();
	}

}
