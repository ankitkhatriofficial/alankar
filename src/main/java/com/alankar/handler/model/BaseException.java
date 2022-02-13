package com.alankar.handler.model;

import com.alankar.common.constant.ResponseCode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ankitkhatri
 */

/**
 * BaseException is the base exception model which is used to thrown by any
 * exception in the format of BaseException.
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -836660778374656951L;
	private ResponseCode responseCode;

	public BaseException(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

}
