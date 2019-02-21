package com.calculator.validator;

/**
 * The class will contain the error codes
 * 
 * @author mitu
 *
 */
public enum ErrorCodes {

	ERR_EXPRESSION_REQUIRED("Valid expression is required."),
	ERR_OPERATOR_REQUIRED("Operator is required."),
	ERR_UNBALANCED_EXPRESSION("Operator is required.");

	private ErrorCodes(String description) {
		this.description = description;
	}

	private String description;

	/**
	 * Get the description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

}
