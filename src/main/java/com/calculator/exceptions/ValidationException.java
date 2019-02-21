package com.calculator.exceptions;

import com.calculator.validator.ErrorCodes;

/**
 * Validation exception class
 *
 */
public class ValidationException extends Exception {

	private ErrorCodes errorCodes;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(ErrorCodes errorCodes) {
		this.errorCodes = errorCodes;

	}

	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}

}
