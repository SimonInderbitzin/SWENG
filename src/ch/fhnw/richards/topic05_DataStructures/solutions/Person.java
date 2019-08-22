package ch.fhnw.richards.topic05_DataStructures.solutions;

import java.util.Objects;

public class Person implements Comparable<Person> {
	private String name;
	private double height;
	private double weight;

	public Person(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public boolean equals(Object o) {
		boolean equal = false;
		if (o != null && this.getClass() == o.getClass()) {
			Person p = (Person) o;
			equal = (this.name.equals(p.name));
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
		return Objects.hashCode(name);
	}

	@Override
	public int compareTo(Person p) {
		return this.name.compareTo(p.name);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
