package ch.fhnw.richards.topic03_Exceptions;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DefensiveProgramming {

	public static void main(String[] args) {
		try {
			int age = readUserInput();
			System.out.println("Your age is " + age);
		} catch (Exception e) {
			System.out.println("Failed to read any input");
		}
	}

	/**
	 * Do everything we can to read valid input. The only thing we cannot handle
	 * ourselves is the case where the user closes the system input by
	 * typing Ctrl-D.
	 */
	public static int readUserInput() throws Exception {
		Scanner in = new Scanner(System.in);
		int value = -1;
		boolean goodInput = false;
		while (!goodInput) {
			System.out.println("Please enter your age");
			try {
				String inStr = in.nextLine();
				value = Integer.parseInt(inStr); // may throw NumberFormatException
				if (value < 0 | value > 100) {
					System.out.println("That's not really your age - try again");
				} else {
					goodInput = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("That was not an integer - try again");
			} catch (NoSuchElementException e) {
				throw new Exception("You closed the input");
			}
		}
		in.close();
		return value;
	}
}