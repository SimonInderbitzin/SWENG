package ch.fhnw.richards.lecture04_recursion;

public class RecursiveExamples {

	public static void main(String[] args) {
		// System.out.println(find2("ralph"));
	}

	// --- Factorial ---

	private static int factorial(int value) {
		if (value <= 1)
			return 1;
		else
			return value * factorial(value - 1);
	}

	// --- Count positive values in array ---

	private static int[] values = { -23, 7, 14, 0, 82, -7 };

	private static int countPositive() {
		return countPositive(values.length - 1);
	}

	private static int countPositive(int index) {
		if (index < 0) {
			return 0;
		} else {
			int result = 0;
			if (values[index] > 0) result++;
			return result + countPositive(index - 1);
		}
	}

	// --- Find string in unsorted array ---

	private static String[] strValues = { "bill", "sue", "ann", "tom" };

	private static boolean find(String search) {
		return find(search, strValues.length - 1);
	}

	private static boolean find(String search, int index) {
		if (index < 0) {
			return false; // Base case 1
		} else if (strValues[index].equals(search)) {
			return true; // Base case 2
		} else { // recursive case
			return find(search, index - 1);
		}
	}
	
	// --- Find string in sorted array (binary search) ---

	private static String[] strValues2 = { "ann", "bill", "sue", "tom" };

	private static boolean find2(String search) {
		return find2(search, 0, strValues2.length - 1);
	}

	private static boolean find2(String search, int start, int end) {
		if (start > end) {
			return false; // Base case 1
		}
		
		int middle = (start + end) / 2;
		int compareResult = strValues2[middle].compareTo(search);
		
		if (compareResult == 0) {
			return true; // Base case 2
		} else if (compareResult > 0) { // recursive case
			return find2(search, start, middle - 1);
		} else {
			return find2(search, middle + 1, end);
		}
	}	

	// -----------------------------------

	// We assume A > B. If this cannot be assumed, then we should check
	private static int GCD(int A, int B) {
		if (B == 0) {
			return A;
		} else {
			int C = A % B;
			return GCD(B, C);
		}
	}
}
