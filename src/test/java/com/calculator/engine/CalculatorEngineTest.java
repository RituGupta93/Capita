package com.calculator.engine;

import org.junit.Test;

/**
 * The class will test the main calculation api
 *
 */
public class CalculatorEngineTest {

	private static final CalculatorEngine caclulatorEngine = new CalculatorEngine();

	@Test
	public void testEvaluate_Case1() {
		Double result = caclulatorEngine.evaluate("3^2");
		org.junit.Assert.assertTrue(result == 9);
	}

	@Test
	public void testEvaluate_Case2() {
		Double result = caclulatorEngine.evaluate("(5+6*2)^2");
		org.junit.Assert.assertTrue(result == 289);
	}

	@Test
	public void testEvaluate_Case3() {
		Double result = caclulatorEngine.evaluate("(5+6*12)+2");
		org.junit.Assert.assertTrue(result == 79);
	}

	@Test
	public void testEvaluate_case4() {
		Double result = caclulatorEngine.evaluate("7+(6*5^2+3-4/2)");
		org.junit.Assert.assertTrue(result == 158);
	}

	@Test
	public void testEvaluate_case5() {
		Double result = caclulatorEngine.evaluate("(2+3*6)^2");
		org.junit.Assert.assertTrue(result == 400);
	}

	@Test
	public void testEvaluate_case6() {
		Double result = caclulatorEngine.evaluate("(2+3*6)^2");
		org.junit.Assert.assertTrue(result == 400);
	}

	@Test
	public void testEvaluate_case7() {
		Double result = caclulatorEngine.evaluate("(6+3/2*5)/2");
		org.junit.Assert.assertTrue(result == 6.75);
	}

	@Test
	public void testEvaluate_case8() {
		Double result = caclulatorEngine.evaluate("(4/2*6)+5");
		org.junit.Assert.assertTrue(result == 17);
	}

}
