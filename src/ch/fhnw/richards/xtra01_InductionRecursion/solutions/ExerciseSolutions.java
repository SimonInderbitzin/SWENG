package ch.fhnw.richards.xtra01_InductionRecursion.solutions;

public class ExerciseSolutions {

	public static int triangularNumbers(int valIn) {
		if (valIn == 1) { // Base case
			return 1;
		} else { // Inductive case
			return valIn + triangularNumbers(valIn-1);
		}
	}
	
	public static void reverse(int[] arrayIn, int pos) {
		if (pos >= arrayIn.length/2) {
			// Base case - nothing to do
		} else {
			int tmp = arrayIn[pos];
			arrayIn[pos] = arrayIn[arrayIn.length - 1 - pos];
			arrayIn[arrayIn.length - 1 - pos] = tmp;
			reverse(arrayIn, pos+1);
		}
	}
}
