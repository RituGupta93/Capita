package com.calculator.validator;

import org.junit.Test;

import com.calculator.exceptions.ValidationException;
import com.calculator.validator.ArithmeticValidator;

public class ArithmeticValidatorTest {

	private static final ArithmeticValidator arithmeticValidator = new ArithmeticValidator();

	@Test(expected = ValidationException.class)
	public void testValidateExpression_whenSingleDigit_thenThrowException() throws ValidationException {
		arithmeticValidator.validateExpression("3");
	}

	@Test(expected = ValidationException.class)
	public void testValidateExpression_whenSingleDigitWithBrackets_thenThrowException() throws ValidationException {
		arithmeticValidator.validateExpression("(3)");
	}

	@Test(expected = ValidationException.class)
	public void testValidateExpression_whenSingleDigitWithBracketsAndOperators_thenThrowException()
			throws ValidationException {
		arithmeticValidator.validateExpression("(+3+)");
	}

	@Test(expected = ValidationException.class)
	public void testValidateExpression_whenSingleDigitWithBracketsAndConsecutiveOperators_thenThrowException()
			throws ValidationException {
		arithmeticValidator.validateExpression("(3+7)*/(8-10)");
	}

	@Test(expected = ValidationException.class)
	public void testValidateExpression_whenSingleDigitWithBracketsAndUnbalancedExpression_thenThrowException()
			throws ValidationException {
		arithmeticValidator.validateExpression("7+(67(56*2))");
	}

	@Test
	public void testValidateExpression_whenSingleDigitWithBracketsAndValidExpression_thenThrowException()
			throws ValidationException {
		arithmeticValidator.validateExpression("7+(6*5^2+3-4/2)");
	}

	@Test
	public void testValidateExpression_whenSingleDigitWithBracketsAndValidExpression() throws ValidationException {
		arithmeticValidator.validateExpression("5+6-1*6");
	}

}
