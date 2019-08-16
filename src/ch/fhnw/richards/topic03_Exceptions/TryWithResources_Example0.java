package ch.fhnw.richards.topic03_Exceptions;

import java.util.Scanner;

public class TryWithResources_Example0 {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			// Use scanner here
			String woof = in.nextLine();
			System.out.println(woof);
		} catch (Exception e) { // Catch is optional in this case
			System.out.println(e.toString());
		}
		// Scanner is automatically closed at the end of try/catch
	}

}
