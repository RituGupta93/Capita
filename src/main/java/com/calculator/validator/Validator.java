package com.calculator.validator;

import com.calculator.exceptions.ValidationException;

/**
 * The class will have a validate method which can be implemented in their
 * concrete classes.
 *
 */

@FunctionalInterface
public interface Validator {

	/**
	 * Method is used to validate an arithmetic expression.
	 * 
	 * @param validation
	 * @throws ValidationException
	 */
	public void validateExpression(String validation) throws ValidationException;

}
