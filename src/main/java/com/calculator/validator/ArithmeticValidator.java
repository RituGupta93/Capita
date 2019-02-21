/**
 * 
 */
package com.calculator.validator;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.calculator.exceptions.ValidationException;

/**
 * @author mitu
 *
 */
public class ArithmeticValidator implements Validator {

	private static final Logger LOGGER = Logger.getLogger(ArithmeticValidator.class.getName());

	private static final String regex = "\\d+";

	public static void main(String args[]) {
		ArithmeticValidator aritmeticValidator = new ArithmeticValidator();
		try {
			// 7+(67(56*2))
			// 8*+7
			// (8*5/8)-(3/1)-5
			aritmeticValidator.validateExpression("(7+(67 + (56*2))");
			System.out.println("valid");
		} catch (ValidationException e) {
			System.out.println("invalid");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.calculator.validator.Validator#validateExpression(java.lang.String)
	 */
	@Override
	public void validateExpression(String expression) throws ValidationException {
		if (Objects.isNull(expression) || expression.trim().length() == 0) {
			LOGGER.log(Level.SEVERE, "Expression t be validated cannot be null");
			throw new ValidationException(ErrorCodes.ERR_EXPRESSION_REQUIRED);
		}

		// remove unnecessary whitespaces
		expression = expression.replaceAll("\\s+", "");
		// TEST 1: False if expression starts or ends with an operator
		if (isAnOperator(expression.charAt(0)) || isAnOperator(expression.charAt(expression.length() - 1))) {
			throw new ValidationException(ErrorCodes.ERR_EXPRESSION_REQUIRED);
		}
		int unclosedParenthesis = 0;
		int operators = 0;

		for (int i = 0; i < expression.length(); i++) {
			// System.out.println("For loop count: " + i);
			System.out.println(expression.charAt(i));
			if (expression.charAt(i) == '(') {
				// System.out.println("( found");
				unclosedParenthesis++;

				// SUBTEST: False if expression ends with '('
				if (i == expression.length() - 1) {
					throw new ValidationException(ErrorCodes.ERR_EXPRESSION_REQUIRED);
				}
			} else if (expression.charAt(i) == ')') {
				unclosedParenthesis--;
				// System.out.println(") found");
				// SUBTEST: False if expression starts with ')'
				if (i == 0) {
					throw new ValidationException(ErrorCodes.ERR_EXPRESSION_REQUIRED);
				}

			} else if (isAnOperator(expression.charAt(i))) {
				operators++;
				// System.out.println("Found an Operator");
				// TEST 3: False if operator is preceded by an operator or opening paranthesis
				// or followed by closing paranthesis
				if (expression.charAt(i - 1) == '(' || expression.charAt(i + 1) == ')'
						|| isAnOperator(expression.charAt(i + 1))) {
					// System.out.println("Found wrongly preceding or following parenthesis to
					// operator");
					// System.out.println("or Found an operator following another operator");
					throw new ValidationException(ErrorCodes.ERR_EXPRESSION_REQUIRED);
				}

			} else if (Character.toString(expression.charAt(i)).matches(regex)) {
				if (i != expression.length() - 1 && Character.toString(expression.charAt(i + 1)).equals("(")) {
					throw new ValidationException(ErrorCodes.ERR_EXPRESSION_REQUIRED);
				}
			} else {
				throw new ValidationException(ErrorCodes.ERR_EXPRESSION_REQUIRED);
			}

		}
		if (unclosedParenthesis != 0) {
			throw new ValidationException(ErrorCodes.ERR_EXPRESSION_REQUIRED);
		}

		if (operators == 0) {
			throw new ValidationException(ErrorCodes.ERR_OPERATOR_REQUIRED);
		}

	}

	/**
	 * Utility function to check if a given character is an arithmetic operator
	 * 
	 * @param c
	 * @return true if operator, false if not
	 */
	private boolean isAnOperator(char c) {
		return (c == '*' || c == '/' || c == '+' || c == '-' || c == '^');
	}

}
