package ch.fhnw.richards.topic06_Generics;

import java.util.List;

public class BoundedWildcardExamples {
	/**
	 * Sum a list of Integers. We don't care what kind of elements the list
	 * actually contains, as long as they are some kind of Integer
	 */
	public static int sum(List<? extends Integer> nums) {
		Integer sum = 0;
		for (int i = 0; i < nums.size(); i++)
			sum += nums.get(i);
		return sum;
	}

	/**
	 * We want to add an Integer object to the end of the list. What kinds of
	 * lists can accept an Integer element? This will work with lists that
	 * accept Integer, Number, or higher - all the way up to Object.
	 */
	public static void addNumber(List<? super Integer> nums, int newValue) {
		nums.add(newValue);
	}
}
