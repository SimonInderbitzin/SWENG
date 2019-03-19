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

	public static boolean find(String search, String[] values, int pos) {
		if (pos >= values.length) {
			return false; // Base case 1
		} else if (values[pos].equals(search)) {
			return true; // Base case 2
		} else { // recursive case
			return find(search, values, pos + 1);
		}
	}
	
	// --- Find string in sorted array (binary search) ---

	public static boolean find2(String search, String[] values, int start, int end) {
		if (start > end) return false; // Base case 1
		
		int middle = (start + end) / 2;
		if (values[middle].equals(search)) return true; // Base case 2
		
		if (values[middle].compareTo(search) > 0) { // recursive case 1
			return find2(search, values, start, middle - 1); // on the left
		} else { // recursive case 2
			return find2(search, values, middle + 1, end); // on the right
		}
	}	

	// --- Count number of positive values in an array ---

	public static int countPositive(int[] values, int pos) {
		if (pos >= values.length) {
			return 0; // base case
		} else {
			int thisElt = (values[pos] > 0 ? 1 : 0);
			return thisElt + countPositive(values, pos+1);
		}
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
