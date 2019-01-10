package ch.fhnw.richards.lecture05_recursion;

public class IterativeExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	private static int factorial(int value) {
		int result = 1;
		for (int factor = 2; factor <= value; factor++) {
			result *= factor;
		}
		return result;
	}

	// -----------------------------------

	private static int[] values = { -23, 7, 14, 0, 82, -7 };

	private static int countPositive() {
		int result = 0;
		for (int val : values) {
			if (val > 0)
				result++;
		}
		return result;
	}

	// -----------------------------------

	private static String[] strValues = { "bill", "sue", "ann", "tom" };

	private static boolean find(String search) {
		boolean result = false;
		for (String val : strValues) {
			if (val.equals(search)) {
				result = true;
			}
		}
		return result;
	}

	// -----------------------------------

	// We assume A > B. If this cannot be assumed, then we should check
	private static int GCD(int A, int B) {
		int C = -1;
		while (C != 0) {
			C = A % B;
			A = B;
			B = C;
		}
		return A;
	}
}
