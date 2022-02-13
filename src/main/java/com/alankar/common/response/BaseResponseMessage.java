package com.alankar.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alankar.common.constant.ResponseCode;
import com.alankar.model.response.ResponseMessage;

/**
 * @author ankitkhatri
 */

/**
 * Base class Implmentation of Api Response. It handles all the common respons
 * of the API.
 */
public class BaseResponseMessage {

	/** Base Model of Api Response when status is CREATED */
	public static ResponseEntity<?> CREATED(Object data) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(HttpStatus.CREATED);
		response.setData(data);
		response.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseMessage>(response, response.getStatus());
	}

	/** Base Model of Api Response when status is UPDATED */
	public static ResponseEntity<?> UPDATED(Object data) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(HttpStatus.OK);
		response.setData(data);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseMessage>(response, response.getStatus());
	}

	/** Base Model of Api Response when status is DELETED */
	public static ResponseEntity<?> DELETED() {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(HttpStatus.OK);
		response.setMessage("DELETED");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseMessage>(response, response.getStatus());
	}

	/** Base Model of Api Response when status is TO RETURN data */
	public static ResponseEntity<?> RETURN_DATA(Object data) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(HttpStatus.OK);
		response.setData(data);
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseMessage>(response, response.getStatus());
	}

	/**
	 * Base Model of Api Response when status is SUCCESS but not to return any
	 * response.
	 */
	public static ResponseEntity<?> SUCCESS() {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(HttpStatus.OK);
		response.setMessage("SUCCESS");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseMessage>(response, response.getStatus());
	}

	/** Base Model of Api Response when some unknown custom exception is thrown. */
	public static ResponseEntity<?> EXCEPTION(ResponseCode responseCode) {
		ResponseMessage response = new ResponseMessage();
		response.setStatus(responseCode.getStatus());
		response.setMessage(responseCode.getMessage());
		response.setStatusCode(responseCode.getStatus().value());
		return new ResponseEntity<ResponseMessage>(response, response.getStatus());
	}

}
