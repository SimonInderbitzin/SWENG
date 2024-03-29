package ch.fhnw.richards.topic07_Lambdas.countrySort_v4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import ch.fhnw.richards.topic07_Lambdas.Country;

public class CountrySorterTest {
	List<Country> countries = new ArrayList<>(Arrays.asList(new Country("Schweiz", 41285),
			new Country("Germany", 357021), new Country("France", 675417), new Country("Italy", 301230),
			new Country("Austria", 83858), new Country("Russia", 17098246), new Country("Luxembourg", 2586),
			new Country("Liechtenstein", 160), new Country("United Kingdom", 244820)));

	@Test
	public void test() {
		Collections.sort(countries, (c1, c2) -> Double.compare(c1.getArea(), c2.getArea()));
		for (int i = 0; i < countries.size() - 1; i++) {
			assertTrue(countries.get(i).getArea() <= countries.get(i + 1).getArea());
		}
	}
}
