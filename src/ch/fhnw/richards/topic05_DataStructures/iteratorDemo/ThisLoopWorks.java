package ch.fhnw.richards.topic05_DataStructures.iteratorDemo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A small demo of why iterators are useful.
 */
public class ThisLoopWorks {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <= 9; i++) numbers.add(new Integer(i));
		
		// Remove all numbers from 4 to 8
		Iterator<Integer> i = numbers.iterator();
		while (i.hasNext()) {
			Integer num = i.next();
			if (num >= 4 && num <= 8) i.remove();
		}

		System.out.println("List *should* contain:  0 1 2 3 9");		
		System.out.print("List actually contains: ");
		for (int num : numbers) System.out.print(num + " ");
	}
}