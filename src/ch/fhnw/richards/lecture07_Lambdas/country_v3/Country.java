package ch.fhnw.richards.lecture07_Lambdas.country_v3;

import java.util.Comparator;

public class Country {
	private final String name;
	private final double area;

	public Country(String name, double area) {
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public double getArea() {
		return area;
	}

	@Override
	public String toString() {
		return String.format("%s (%.2f km2)", name, area);
	}
}