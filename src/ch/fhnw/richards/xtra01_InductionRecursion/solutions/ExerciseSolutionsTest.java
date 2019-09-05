package ch.fhnw.richards.xtra01_InductionRecursion.solutions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExerciseSolutionsTest {

	@Test
	void testTriangularNumbers() {
		assertEquals(1, ExerciseSolutions.triangularNumbers(1));
		assertEquals(3, ExerciseSolutions.triangularNumbers(2));
		assertEquals(6, ExerciseSolutions.triangularNumbers(3));
		assertEquals(10, ExerciseSolutions.triangularNumbers(4));
		assertEquals(15, ExerciseSolutions.triangularNumbers(5));
	}

	@Test
	void testReverse() {
		int[] test1 = new int[] {1, 2, 3, 4}; // even length
		ExerciseSolutions.reverse(test1, 0);
		assertEquals(4, test1[0]);
		assertEquals(3, test1[1]);
		assertEquals(2, test1[2]);
		assertEquals(1, test1[3]);

		int[] test2 = new int[] {1, 2, 3, 4, 5}; // odd length
		ExerciseSolutions.reverse(test2, 0);
		assertEquals(5, test2[0]);
		assertEquals(4, test2[1]);
		assertEquals(3, test2[2]);
		assertEquals(2, test2[3]);
		assertEquals(1, test2[4]);
	}
}
