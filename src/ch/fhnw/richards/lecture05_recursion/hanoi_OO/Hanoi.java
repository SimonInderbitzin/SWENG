package ch.fhnw.richards.lecture05_recursion.hanoi_OO;

import java.util.Scanner;

public class Hanoi {
	private Post A, B, C;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter desired number of disks: ");
		int num = in.nextInt();
		in.close();
		
		if (num >= 0) {
			new Hanoi(num);
		}
	}

	public Hanoi(int numDisks) {
		A = new Post("A");
		B = new Post("B");
		C = new Post("C");

		Base lastObject = A;
		for (int i = numDisks; i >= 1; i--) {
			Disk s = new Disk(i);
			try {
				lastObject.setOnTop(s);
			} catch (Exception e) {
				System.out.println("Problem setup failed!");
			}
			lastObject = s;
		}

		try {
			System.out.println("Solution steps for " + numDisks + " disks");
			this.solve(A, B, C);
			System.out.println("Finished!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Move all disks from X to Z, with the help of Y
	 */
	public void solve(Base X, Base Y, Base Z) throws Exception {
		if (X.getOnTop() == null) {
			// Base case - zero disks - nothing to do
		} else {
			Base bottomDisk = X.getOnTop();
			solve(bottomDisk, Z, Y);
			movedisk(X, Z);
			solve(Y, X, bottomDisk);
		}
	}

	/**
	 * Move a single disk from X to Y, print the move to system.out
	 */
	public void movedisk(Base X, Base Y) throws Exception {
		// Check for legal move
		if (X.getOnTop() == null || X.getOnTop().getOnTop() != null || Y.getOnTop() != null) {
			throw new Exception("Illegal move!");
		} else {
			Disk s = (Disk) X.getOnTop();
			X.setOnTop(null);
			Y.setOnTop(s);
			System.out.println("Move " + s.toString() + " onto " + Y.toString());
		}
	}
}