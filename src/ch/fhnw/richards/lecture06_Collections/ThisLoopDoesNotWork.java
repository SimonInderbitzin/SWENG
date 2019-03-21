package ch.fhnw.richards.lecture06_Collections;
import java.util.ArrayList;

/**
 * A small demo of why iterators are useful.
 */
public class ThisLoopDoesNotWork {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <= 9; i++) numbers.add(new Integer(i));
		
		// Remove all numbers from 4 to 8
		for (int i = 0; i < numbers.size(); i++) {
			int num = numbers.get(i);
			if (num >= 4 && num <= 8) numbers.remove(i);
		}

		System.out.println("List *should* contain:  0 1 2 3 9");		
		System.out.print("List actually contains: ");
		for (int num : numbers) System.out.print(num + " ");
	}
}
