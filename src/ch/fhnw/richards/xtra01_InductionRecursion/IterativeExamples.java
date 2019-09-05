package ch.fhnw.richards.xtra01_InductionRecursion;

public class IterativeExamples {

	// --- Factorial ---
	
	public static int factorial(int value) {
		int result = 1;
		for (int factor = 2; factor <= value; factor++) {
			result *= factor;
		}
		return result;
	}

	// --- Find string in unsorted array ---

	public static boolean find(String search, String[] values) {
		for (String val : values) {
			if (val.equals(search)) return true;
		}
		return false;
	}

	// --- Find string in sorted array (binary search) ---
	
	public static boolean find2(String search, String[] values) {
		int start = 0;
		int end = values.length -1;
		while (start < end) {
			int middle = (start + end) / 2;
			int compareResult = search.compareTo(values[middle]);
			if (compareResult == 0) return true;
			else if (compareResult < 0) end = middle-1;
			else start = middle+1;
		}
		return false;
	}

	// --- Count number of positive values in an array - linear ---

	public static int countPositive(int[] values) {
		int result = 0;
		for (int val : values) {
			if (val > 0) result++;
		}
		return result;
	}

	// -----------------------------------

	// We assume A > B. If this cannot be assumed, then we should check
	public static int GCD(int A, int B) {
		int C = -1;
		while (C != 0) {
			C = A % B;
			A = B;
			B = C;
		}
		return A;
	}
}
