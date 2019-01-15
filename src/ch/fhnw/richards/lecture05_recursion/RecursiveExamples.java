package ch.fhnw.richards.lecture05_recursion;

public class RecursiveExamples {

	// --- Factorial ---

	public static int factorial(int value) {
		if (value <= 1)
			return 1;
		else
			return value * factorial(value - 1);
	}

	// --- Find string in unsorted array ---

	public static boolean find(String search, String[] values) {
		return find(search, values.length - 1, values);
	}

	private static boolean find(String search, int index, String[] values) {
		if (index < 0) {
			return false; // Base case 1
		} else if (values[index].equals(search)) {
			return true; // Base case 2
		} else { // recursive case
			return find(search, index - 1, values);
		}
	}
	
	// --- Find string in sorted array (binary search) ---

	public static boolean find2(String search, String[] values) {
		return find2(search, 0, values.length - 1, values);
	}

	private static boolean find2(String search, int start, int end, String[] values) {
		if (start > end) return false; // Base case 1
		
		int middle = (start + end) / 2;
		int compareResult = values[middle].compareTo(search);
		
		if (compareResult == 0) return true; // Base case 2
		
		if (compareResult > 0) { // recursive case 1
			return find2(search, start, middle - 1, values);
		} else { // recursive case 2
			return find2(search, middle + 1, end, values);
		}
	}	

	// --- Count number of positive values in an array, divide-and-conquer ---
	// Note: To deal with empty arrays (zero elements), we would need another base case

	public static int countPositive(int[] values) {
		return countPositive(0, values.length - 1, values);
	}

	private static int countPositive(int start, int end, int[] values) {
		// Base case: one element
		if (start == end) return values[start] > 0 ? 1 : 0;
		
		// Inductive case: multiple elements left
		int middle = (start + end) / 2;
		return countPositive(start, middle, values) +
				countPositive(middle+1, end, values);
	}

	// -----------------------------------

	// We assume A > B. If this cannot be assumed, then we should check
	public static int GCD(int A, int B) {
		if (B == 0) {
			return A;
		} else {
			int C = A % B;
			return GCD(B, C);
		}
	}
}
