package com.calculator.engine;

import org.junit.Test;

public class CalculatorEngineTest {

	private static final CalculatorEngine caclulatorEngine = new CalculatorEngine();

	@Test
	public void testEvaluate() {
		int result = caclulatorEngine.evaluate("3^2");
		org.junit.Assert.assertTrue(result == 9);
	}

}
