package ch.fhnw.richards.topic03_Exceptions.tryYourself;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice = -1;
		while (choice != 0) {
			System.out.println("What do you want to do?");
			System.out.println("0 - Exit this program");
			System.out.println("1 - Use an invalid array index");
			System.out.println("2 - Divide-by-zero with int-values");
			System.out.println("3 - Divide-by-zero with float-values");
			System.out.println("4 - Use a null pointer");
			System.out.println("5 - Something else you think should be an exception");
			choice = in.nextInt();
			try {
				System.out.println("Entering 'try'");
				switch (choice) {
				case 0: // Do nothing - quitting
					break;
				case 1: // Use an invalid array index

					break;
				case 2: // Divide by zero using int-values

					break;
				case 3: // Divide by zero using float-values

					break;
				case 4: // Try to use a null pointer

					break;
				case 5: // Something else

					break;
				default:
					System.out.println("Invalid choice, no exception");
				}
			} catch (Exception e) {
				System.out.println("Exception caught: " + e.getClass());
			} finally {
				System.out.println("Executing 'finally'");
			}
		}
		in.close();
	}
}