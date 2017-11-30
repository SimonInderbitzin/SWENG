package ch.fhnw.richards.lecture05_Collections.solutions.treeset;

import java.util.Objects;

public class Person implements Comparable<Person> {
	private static int nextID = 0;

	private int ID;
	private String name;
	private double height;
	private double weight;

	private static int getNextID() {
		return nextID++;
	}

	public Person(String name, double height, double weight) {
		this.ID = getNextID();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	/**
	 * Alternate constructor, to create a new object for a person who already
	 * exists
	 */
	public Person(int ID, String name, double height, double weight) {
		this.ID = ID;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public double getBMI() {
		return weight / (height * height);
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getID() {
		return ID;
	}

	@Override
	public boolean equals(Object o) {
		boolean equal = false;
		if (o != null && this.getClass() == o.getClass()) {
			Person p = (Person) o;
			equal = (this.ID == p.ID);
		}
		return equal;
	}

	/**
	 * Must override hashCode if we override equals, referencing exactly the
	 * same attributes. If two objects are equal, they must have the same
	 * hashCode. Java provides a handy implementation in Object.hashCode(...).
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(ID);
	}

	@Override
	public int compareTo(Person p) {
		return this.ID - p.ID;
	}
}
