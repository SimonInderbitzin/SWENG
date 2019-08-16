package ch.fhnw.richards.topic03_Exceptions;

import java.util.Scanner;

public class ThrowingOwnException {
	
	/**
	 * Define our own exception class for our special situation
	 */
	public static class ValueOutOfRangeException extends Exception {
		public ValueOutOfRangeException(String info) {
			super(info);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your age");
		String inStr = in.nextLine();
		in.close();
		try {
			int age = parseUserInput(inStr);
			System.out.println("Your age is " + age);
		} catch (Exception e) {
			System.out.println("Your input was invalid - bye!");
		}
	}

	public static int parseUserInput(String inStr) throws Exception {
		int value = Integer.parseInt(inStr); // may throw NumberFormatException
		if (value < 0 | value > 100) {
			throw new ValueOutOfRangeException("Value must be 0 to 100");
		}
		return value;
	}
}