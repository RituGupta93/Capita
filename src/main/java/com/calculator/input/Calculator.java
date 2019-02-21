package com.calculator.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import com.calculator.engine.CalculatorEngine;
import com.calculator.exceptions.ValidationException;
import com.calculator.validator.ArithmeticValidator;

/**
 * The class will collect the input from the user and perfrm validation and
 * calculate the expression if valid
 * 
 */
public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> expressions = new ArrayList<>();
		List<String> results = new ArrayList<>();
		System.out.println("Enter number of expressions : ");
		int numberOfExpressions = scanner.nextInt();
		// int consumer to consume the inputs and collect them
		IntConsumer intConsumer = expression -> {
			System.out.println("Enter expression : ");
			expressions.add(scanner.next());
		};

		// Evaluate the expression
		Consumer<String> expressionConsumer = expression -> {
			ArithmeticValidator arithmeticValidator = new ArithmeticValidator();
			CalculatorEngine calculatorEngine = new CalculatorEngine();
			try {
				arithmeticValidator.validateExpression(expression);
				results.add(String.valueOf(calculatorEngine.evaluate(expression.replaceAll("\\s", ""))));
			} catch (ValidationException e) {
				results.add(": Invalid Expression");
			}
		};
		// collect the input
		if (numberOfExpressions == 0 || numberOfExpressions > 100) {
			System.out.println("Wrong input...");
		} else {
			IntStream.range(1, numberOfExpressions + 1).forEach(intConsumer);
		}
		// close the scanner
		scanner.close();
		// evaluate the expressions
		expressions.forEach(expressionConsumer);
		// print the output
		IntStream.range(0, numberOfExpressions).forEach(index -> {
			StringBuilder result = new StringBuilder("Test case #").append(index).append(" :");
			System.out.println(result.append(results.get(index)));
		});
	}

}
