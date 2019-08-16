package ch.fhnw.richards.topic03_Exceptions.tryYourself;

import java.util.Scanner;

public class DemoSolution {
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
					int[] nums = new int[2];
					nums[3] = 13;
					break;
				case 2: // Divide by zero using int-values
					int x = 3;
					int y = 0;
					x = x / y;
					break;
				case 3: // Divide by zero using float-values
					float u = 3;
					float v = 0;
					u = u / v;
					break;
				case 4: // Try to use a null pointer
					Object o = null;
					o.toString();
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