package ch.fhnw.richards.xtra01_InductionRecursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IterativeExamplesTest {

	@Test
	void testFactorial() {
		assertEquals(IterativeExamples.factorial(0), 1);
		assertEquals(IterativeExamples.factorial(1), 1);
		assertEquals(IterativeExamples.factorial(4), 24);
		assertEquals(IterativeExamples.factorial(7), 5040);
	}

	@Test
	void testCountPositive() {
		int[] intValues0 = { };
		int[] intValues1 = { -23, 7, 14, 0, 82, -7 };
		assertEquals(IterativeExamples.countPositive(intValues0), 0);
		assertEquals(IterativeExamples.countPositive(intValues1), 3);
	}

	@Test
	void testFind() {
		String[] names = { "bill", "sue", "ann", "tom", "frank", "cindy" };

		assertTrue(IterativeExamples.find("ann", names));
		assertFalse(IterativeExamples.find("sam", names));
	}
	
	@Test
	void testFind2() {
		String[] names = { "ann", "bill", "cindy", "frank", "sue", "tom" };

		assertTrue(IterativeExamples.find2("ann", names));
		assertFalse(IterativeExamples.find2("sam", names));
	}
	
	@Test
	void testGCD() {
		assertEquals(IterativeExamples.GCD(7, 3), 1);
		assertEquals(IterativeExamples.GCD(110, 42), 2);
		assertEquals(IterativeExamples.GCD(300, 120), 60);
	}
}
