package ch.fhnw.richards.lecture05_recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecursiveExamplesTest {

	@Test
	void testFactorial() {
		assertEquals(RecursiveExamples.factorial(0), 1);
		assertEquals(RecursiveExamples.factorial(1), 1);
		assertEquals(RecursiveExamples.factorial(4), 24);
		assertEquals(RecursiveExamples.factorial(7), 5040);
	}

	@Test
	void testCountPositive() {
		int[] intValues = { -23, 7, 14, 0, 82, -7 };
		assertEquals(RecursiveExamples.countPositive(intValues), 3);
	}

	@Test
	void testFind() {
		String[] names = { "bill", "sue", "ann", "tom", "frank", "cindy" };

		assertTrue(RecursiveExamples.find("ann", names));
		assertFalse(RecursiveExamples.find("sam", names));
	}
	
	@Test
	void testFind2() {
		String[] names = { "ann", "bill", "cindy", "frank", "sue", "tom" };

		assertTrue(RecursiveExamples.find2("ann", names));
		assertFalse(RecursiveExamples.find2("sam", names));
	}
	
	@Test
	void testGCD() {
		assertEquals(RecursiveExamples.GCD(7, 3), 1);
		assertEquals(RecursiveExamples.GCD(110, 42), 2);
		assertEquals(RecursiveExamples.GCD(300, 120), 60);
	}

}
